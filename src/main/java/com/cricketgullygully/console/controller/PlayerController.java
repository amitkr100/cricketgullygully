package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.Player;
import com.cricketgullygully.console.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/save")
	public Player savePlayer(@RequestBody Player player) {
		System.out.println("Called savePlayer");
		return playerService.savePlayer(player);
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable int id) {
		System.out.println("Called getPlayer");
		return playerService.getPlayerById(id);
	}
}
