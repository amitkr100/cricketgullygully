package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scoreboard {

	private Inning inningOne;
	private Inning inningTwo;

	public void init(Team teamOne, Team teamTwo, MatchInfo matchInfo) {
		inningOne = new Inning();
		inningOne.init(teamOne.getName(), matchInfo.getTotalOver(), matchInfo.getTeamOnePlaying11());
		inningTwo = new Inning();
		inningTwo.init(teamTwo.getName(), matchInfo.getTotalOver(), matchInfo.getTeamTwoPlaying11());
	}
}
