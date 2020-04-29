package com.ms.boot.Productms.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {
	
	@Value("${greetprop}")
	private String greetProp;

	@RequestMapping(path = "/greeting/config/{name}", method = RequestMethod.GET)
	public String getDefaultConfigMessage(@PathVariable String name) {
		return greetProp + ", " + name;
	}
 

}
