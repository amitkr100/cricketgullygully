package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.Player;
import com.cricketgullygully.console.service.PlayerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("init")
public class MainController {

	@Autowired
	private PlayerService playerService;

	@GetMapping
	@RequestMapping("/")
	public String loadAllConfiguration() {
		log.info("Loading all configuration");
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Player>> typeReference = new TypeReference<List<Player>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/players.json");
		try {
			List<Player> players = mapper.readValue(inputStream, typeReference);
			playerService.saveAll(players);
			log.info("Players data saved");
		} catch (IOException e) {
			log.error("Unable to save Players: " + e.getMessage());
		}
		return "Success";
	}
}
