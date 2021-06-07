package com.cricketgullygully.console.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Integer ballsBowled = 0;
	private Double currentOver=0.0;
	private Integer wicket = 0;
	private Integer runGiven = 0;

	public BowlerScore(PlayerName player) {
		playerId = player.getId();
		name = player.getName();
		}
	
	
	public void incrementBowlerOver()
	{
		
		ballsBowled+=1;
		int overs= ballsBowled/6;
		int modVal=ballsBowled % 6;
		currentOver= (double)overs+(double)modVal/10;
		
	}
	
	public void incrementWicketTaken()
	{
		wicket+=1;
	}
	
	public void incrementRunGiven(int run)
	{
		runGiven+=run;
	}
		
	}

