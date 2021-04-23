package com.cricketgullygully.console.service;

import com.cricketgullygully.console.entity.Player;
import com.cricketgullygully.console.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	public Player getPlayerById(long id) {
		return playerRepository.findById(id).get();
	}

	public List<Player> saveAll(List<Player> players) {
		return playerRepository.saveAll(players);
	}

	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
}
