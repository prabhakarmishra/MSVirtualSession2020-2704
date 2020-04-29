package com.ms.boot.Productms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.boot.Productms.model.DiscountRequest;
import com.ms.boot.Productms.model.DiscountResponse;
import com.ms.boot.Productms.model.Product;
import com.ms.boot.Productms.model.ProductDTO;
import com.ms.boot.Productms.repo.ProductRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Component
@RibbonClient(name = "discountms")
public class ProductService {
	@Autowired
	private ProductRepository prepo;

	@Autowired

	private DiscoveryClient discoveryClient;

	@Autowired
	LoadBalancerClient lbClient;

	@Bean
	@LoadBalanced
	RestTemplate createRestTemplate() {
		RestTemplateBuilder b = new RestTemplateBuilder();
		return b.build();
	}

	@Autowired
	@Lazy
	RestTemplate lbrestTemplate;
	/*
	 * @Autowired private EurekaClient discoveryClient;
	 */
	
	@Autowired
	Discountserviceproxy discountProxy;

	public Product getProduct(Integer id) {
		Optional<Product> oProduct = prepo.findById(id);
		if (oProduct.isPresent())
			return oProduct.get();
		else
			return null;

	}

	public ProductDTO applyDiscount01(Product p) {
		DiscountRequest dRequest = createDiscountRequest(p);

		List<ServiceInstance> instances = discoveryClient.getInstances("discountms");
		System.out.println("Instances of discountms found =" + instances.size());
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getHost() + ":" + instance.getPort());
		}

		ServiceInstance instance = instances.get(0);
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/caldisc";
		System.out.println("Calling URL :" + url);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<DiscountRequest> discountHttpEntity = new HttpEntity<DiscountRequest>(dRequest);
		ResponseEntity<DiscountResponse> dResponseEntity = restTemplate.exchange(url, HttpMethod.POST,
				discountHttpEntity, DiscountResponse.class);

		DiscountResponse dResponse = dResponseEntity.getBody();
		return ceateProductResponseDTO(dResponse, p);

	}

	public ProductDTO applyDiscount02(Product p) {
		DiscountRequest dRequest = createDiscountRequest(p);
		ServiceInstance instance = lbClient.choose("discountms");
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/caldisc";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<DiscountRequest> discountHttpEntity = new HttpEntity<DiscountRequest>(dRequest);
		ResponseEntity<DiscountResponse> dResponseEntity = restTemplate.exchange(url, HttpMethod.POST,
				discountHttpEntity, DiscountResponse.class);

		DiscountResponse dResponse = dResponseEntity.getBody();
		return ceateProductResponseDTO(dResponse, p);

	}

	public ProductDTO applyDiscount03(Product p) {
		DiscountRequest dRequest = createDiscountRequest(p);

		HttpEntity<DiscountRequest> discountHttpEntity = new HttpEntity<DiscountRequest>(dRequest);

		ResponseEntity<DiscountResponse> dResponseEntity = lbrestTemplate.exchange("http://discountms/caldisc",
				HttpMethod.POST, discountHttpEntity, DiscountResponse.class);

		DiscountResponse dResponse = dResponseEntity.getBody();
		return ceateProductResponseDTO(dResponse, p);

	}

	@HystrixCommand(fallbackMethod = "discountfallback")
	public ProductDTO applyDiscount04(Product p) {
		DiscountRequest dRequest = createDiscountRequest(p);

		HttpEntity<DiscountRequest> discountHttpEntity = new HttpEntity<DiscountRequest>(dRequest);

		ResponseEntity<DiscountResponse> dResponseEntity = lbrestTemplate.exchange("http://discountms/caldisc",
				HttpMethod.POST, discountHttpEntity, DiscountResponse.class);

		DiscountResponse dResponse = dResponseEntity.getBody();
		return ceateProductResponseDTO(dResponse, p);

	}
	
	public ProductDTO applyDiscount05(Product p) {
		DiscountRequest dRequest = createDiscountRequest(p);
		DiscountResponse response = discountProxy.calculateDiscount(dRequest);
		return ceateProductResponseDTO(response, p);
		
		
	}

	/*
	 * public DiscountResponse discountfallback(DiscountRequest request) { return
	 * new DiscountResponse(request.getCategory(), request.getMrp(),
	 * request.getMrp(), 0.0, 0.0); }
	 */

	public ProductDTO discountfallback(Product p) {
		
		ProductDTO pdto = new ProductDTO();
		pdto.setCategory(p.getCategory());
		pdto.setDrp(p.getMrp());
		pdto.setFixedCategoryDiscount(0.0);
		pdto.setOnSpotDiscount(0.0);
		pdto.setId(p.getId());
		pdto.setMrp(p.getMrp());
		pdto.setName(p.getName());
		pdto.setShortDescription(p.getShortDescription());
		pdto.setTags(p.getTags());
		
		return pdto;
	}

	private DiscountRequest createDiscountRequest(Product p) {
		return new DiscountRequest(p.getCategory(), p.getMrp());
	}

	private ProductDTO ceateProductResponseDTO(DiscountResponse discountResponse, Product p) {
		ProductDTO pdto = new ProductDTO();
		pdto.setCategory(p.getCategory());
		pdto.setDrp(discountResponse.getDrp());
		pdto.setFixedCategoryDiscount(discountResponse.getFixedCategoryDiscount());
		pdto.setOnSpotDiscount(discountResponse.getOnSpotDiscount());
		pdto.setId(p.getId());
		pdto.setMrp(p.getMrp());
		pdto.setName(p.getName());
		pdto.setShortDescription(p.getShortDescription());
		pdto.setTags(p.getTags());

		return pdto;
	}
}
