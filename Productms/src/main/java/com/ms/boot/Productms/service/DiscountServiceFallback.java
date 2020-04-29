package com.ms.boot.Productms.service;

import org.springframework.stereotype.Component;

import com.ms.boot.Productms.model.DiscountRequest;
import com.ms.boot.Productms.model.DiscountResponse;

@Component
public class DiscountServiceFallback implements Discountserviceproxy {

	@Override
	public DiscountResponse calculateDiscount(DiscountRequest dRequest) {

		return new DiscountResponse(dRequest.getCategory(), dRequest.getMrp(), dRequest.getMrp(), 0.0, 0.0);
	}

}
