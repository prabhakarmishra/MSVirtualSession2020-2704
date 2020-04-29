package com.ms.boot.Discountms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
 
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "discountdata")
public class DiscountDataMap {

	Map<ProductCategory, Double> discountMap = new HashMap<ProductCategory, Double>();

	public Map<ProductCategory, Double> getDiscountMap() {
		return discountMap;
	}

	public void setDiscountMap(Map<ProductCategory, Double> discountMap) {
		this.discountMap = discountMap;
	}
 
}
