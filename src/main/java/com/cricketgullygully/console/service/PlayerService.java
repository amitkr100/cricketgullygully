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

	public Player getPlayerById(int id) {
		return playerRepository.getById(id);
	}

	public void saveAll(List<Player> players) {
		playerRepository.saveAll(players);
	}

}
