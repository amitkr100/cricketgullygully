package com.cricketgullygully.console.service;

import com.cricketgullygully.console.entity.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	public Player getPlayer()
	{
		return new Player("Sumit");
	}
}
