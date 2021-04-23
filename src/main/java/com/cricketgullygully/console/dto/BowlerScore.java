package com.cricketgullygully.console.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BowlerScore {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long playerId;
	private String name;
	private Double overBowled = 0.0;
	private Integer wicket = 0;
	private Integer runGiven = 0;

	public BowlerScore(PlayerName player) {
		playerId = player.getId();
		name = player.getName();
	}
}
