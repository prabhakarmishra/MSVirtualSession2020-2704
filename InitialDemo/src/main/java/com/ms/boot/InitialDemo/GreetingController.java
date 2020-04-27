package com.ms.boot.InitialDemo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Value("${greetprop}")
	private String greetProp;

	@RequestMapping(path = "/default", method = RequestMethod.GET)
	public String getDefaultMessage() {
		return "Hello World!";
	}

	@RequestMapping(path = "/config/{name}", method = RequestMethod.GET)
	public String getDefaultConfigMessage(@PathVariable String name) {
		return greetProp + ", " + name;
	}

	@RequestMapping(path = "/detail", method = RequestMethod.GET)
	public Greeting getDetailMessage() {
		return new Greeting("Hello", "Miss MicroS", new Date());
	}

}
