package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.Player;
import com.cricketgullygully.console.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping("home")
	public Player homePage()
	{
		System.out.println("Home page Request");
		return playerService.getPlayer();
	}
}
