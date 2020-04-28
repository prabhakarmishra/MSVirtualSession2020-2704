package demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import demo.service.SentenceService;



@Controller
public class SentenceController {

	@Autowired SentenceService sentenceService;
	
	
	/**
	 * Display a small list of Sentences to the caller:
	 */
	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		long start = System.currentTimeMillis();
		String output = 
			"<h3>Some Sentences</h3><br/>" +	  
			sentenceService.buildSentence() + "<br/><br/>" +
			sentenceService.buildSentence() + "<br/><br/>" +
			sentenceService.buildSentence() + "<br/><br/>" +
			sentenceService.buildSentence() + "<br/><br/>" +
			sentenceService.buildSentence() + "<br/><br/>"
			;
		long end = System.currentTimeMillis();
		return output + "Elapsed time (ms): " + (end - start);
	}
	
	
	@GetMapping("/test")
	@HystrixCommand(fallbackMethod = "myFallbackMethod")
	public @ResponseBody String test() {
		if (new Random().nextBoolean()) {
			// calling a SBI API or any service 
			return "Everything Working Fine";
		} else {
			throw new RuntimeException();
		}
	}
	
	@HystrixCommand(fallbackMethod = "myFallbackMethod2")
	public String myFallbackMethod() {
		//@HystrixProperty(name="" value ="")  // default 20 request and 5 second 
		// calling a ICICI API or any service 
		return "Fallback Enabled";
	}
	
	public String myFallbackMethod2()
	{
		// calling a Citibank API or any service 
		return "Fallbank enable for method 2";
	}
	

}
