package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String test(Model theModel) {
		theModel.addAttribute("key", new java.util.Date());
		return "helloworld";
	}
}
