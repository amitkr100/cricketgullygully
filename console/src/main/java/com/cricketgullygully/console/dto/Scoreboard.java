package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.entity.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scoreboard {


	List<Inning> innings = new ArrayList<>();

	public void addInning(MatchInfo matchInfo) {
		Inning inning = new Inning();
		inning.setTeamName(matchInfo.getTeamBattingNow().getName());
		inning.setPlaying11(matchInfo.getTeamPlaying11BattingNow());
		inning.setTotalOver(matchInfo.getTotalOver());
		innings.add(inning);
	}

	@JsonIgnore
	public Inning getCurrentInning() {
		return innings.get(innings.size() - 1);
	}
}
