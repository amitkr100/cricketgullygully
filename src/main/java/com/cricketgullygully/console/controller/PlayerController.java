package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.Player;
import com.cricketgullygully.console.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/create")
	public Player createPlayer(@RequestBody Player player) {
		log.debug("Called savePlayer");
		return playerService.savePlayer(player);
	}
	@PostMapping("/createMany")
	public List<Player> createPlayers(@RequestBody List<Player> player) {
		log.debug("Called createPlayers");
		return playerService.saveAll(player);
	}
	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable long id) {
		log.debug("Called getPlayer");
		return playerService.getPlayerById(id);
	}
	@GetMapping("/")
	public List<Player> getPlayers() {
		log.debug("Called getPlayers");
		return playerService.getPlayers();
	}

}

