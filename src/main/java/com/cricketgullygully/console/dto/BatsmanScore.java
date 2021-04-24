package com.cricketgullygully.console.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatsmanScore {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long playerId;
	private String name;
	private Integer ballPlayed = 0;
	private Integer runScored = 0;
	private boolean isOut;
	private OutReason outReason;

	public BatsmanScore(PlayerName player) {
		playerId = player.getId();
		name = player.getName();
	}
}
