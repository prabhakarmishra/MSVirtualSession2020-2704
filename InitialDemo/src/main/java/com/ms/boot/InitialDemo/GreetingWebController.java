package com.ms.boot.InitialDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/greeting/web")
public class GreetingWebController {
	
	@RequestMapping(path = "/default",method = RequestMethod.GET)
	public String renderDefaultWebGreeting(Model model)
	{
		model.addAttribute("greeting", "Hola!");
		return "index";
	}

}
