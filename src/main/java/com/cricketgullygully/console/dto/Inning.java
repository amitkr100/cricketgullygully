package com.cricketgullygully.console.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inning {


	private String teamName;
	private Double currentOver = 0.0;
	private Double totalOver;
	private String currentStriker;
	private String currentNonStriker;
	private String currentBowler;
	private List<String> Playing11 = new ArrayList<>();
	private List<BatsmanScore> batsmanScores = new ArrayList<>();
	private List<BowlerScore> bowlerScores = new ArrayList<>();

	public void setBatsmanOut(PlayerName batsman, PlayerName bowler, PlayerName fielder, WicketInfo wicketInfo) {
		BatsmanScore batsmanScore = getBatsmanByName(batsman.getName());
		if(batsmanScore != null)
		{
			batsmanScore.setOut(true);
			batsmanScore.setOutReason(new OutReason(wicketInfo.getOutType(),bowler.getName(),fielder.getName()));
		}
	}
	private BatsmanScore getBatsmanByName(String name) {
		for (BatsmanScore batsman : getBatsmanScores())
			if (batsman.getName().equals(name))
				return batsman;
		return null;
	}

	private BowlerScore getBowlerScore(String name) {
		for (BowlerScore bowler : getBowlerScores())
			if (bowler.getName().equals(name))
				return bowler;
		return null;
	}

	public void addWicketToBowler(String bowler) {
		BowlerScore bowlerScore = getBowlerScore(bowler);
		if(bowlerScore!=null)
		{
			bowlerScore.setWicket(bowlerScore.getWicket() + 1);
		}
	}
}
