package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerName {
	private Long id;
	private String name;
	PlayerName(Player player){
		id = player.getId();
		name = player.getName();
	}
}
