package com.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {
	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "home";
	}

}
