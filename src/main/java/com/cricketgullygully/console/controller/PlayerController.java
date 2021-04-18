package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.entity.Player;
import com.cricketgullygully.console.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/save")
	public Player savePlayer(@RequestBody Player player) {
		log.debug("Called savePlayer");
		return playerService.savePlayer(player);
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable int id) {
		log.debug("Called getPlayer");
		if(id == 0)
			return new Player();

		return playerService.getPlayerById(id);
	}
}

