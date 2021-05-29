package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.dto.enums.BallType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Integer ballsBowled = 0;
	private Double currentOver = 0.0;
	private Double totalOver;
	private String currentStriker;
	private String currentNonStriker;
	private String currentBowler;
	private List<String> Playing11 = new ArrayList<>();
	private List<BatsmanScore> batsmanScores = new ArrayList<>();
	private List<BowlerScore> bowlerScores = new ArrayList<>();
	private int totalRun;

	public void setBatsmanOut(PlayerName batsman, PlayerName bowler, PlayerName fielder, WicketInfo wicketInfo) {
		BatsmanScore batsmanScore = getBatsmanByName(batsman.getName());
		if (batsmanScore != null) {
			batsmanScore.setOut(true);
			batsmanScore.setOutReason(new OutReason(wicketInfo.getOutType(), bowler.getName(), fielder.getName()));
		}
	}

	private BatsmanScore getBatsmanByName(String name) {
		for (BatsmanScore batsman : getBatsmanScores())
			if (batsman.getName().equals(name))
				return batsman;
		return null;
	}

	private BowlerScore getBowlerByName(String name) {
		for (BowlerScore bowler : getBowlerScores())
			if (bowler.getName().equals(name))
				return bowler;
		return null;
	}

	public void addWicketToBowler(String bowler) {
		BowlerScore bowlerScore = getBowlerByName(bowler);
		if (bowlerScore != null) {
			bowlerScore.setWicket(bowlerScore.getWicket() + 1);
		}
	}

	private void changeStriker() {
		String temp = currentStriker;
		currentStriker = currentNonStriker;
		currentNonStriker = temp;

	}

	public void updateInningDetailsPerBall(BallInfo ballInfo) {

		if (ballInfo.getRun() % 2 != 0)
			changeStriker();

		if (ballInfo.getBallType() != BallType.VALID) {
			totalRun += 1;
			if (ballInfo.getBallType() == BallType.NOBALL) // case of a NO ball
			{
				BatsmanScore currentBatsman = getBatsmanByName(currentStriker);
				currentBatsman.incrementRunScored(ballInfo.getRun());

			}

		} else {

			BatsmanScore currentBatsman = getBatsmanByName(currentStriker);
			currentBatsman.incrementRunScored(ballInfo.getRun());
			currentBatsman.incrementBallPlayed();

			BowlerScore currentBowler = getBowlerByName(getCurrentBowler());
			currentBowler.incrementRunGiven(ballInfo.getRun());
			currentBowler.incrementBowlerOver();
			ballsBowled += 1;
			int overs = ballsBowled / 6;
			int modVal=ballsBowled % 6;
			currentOver = (double)overs+(double)modVal/10;

		}
		totalRun += ballInfo.getRun();
		
		if(ballsBowled%6==0)
		{
			changeStriker();
			//notifyChangeBowler();
		}

	}

}
