package com.cricketgullygully.console;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

	@RequestMapping("/")
	@ResponseBody
	public String homePage()
	{
		System.out.println("Home page Request");
		return "Hello Spring Application";
	}
}
