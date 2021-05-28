package com.cricketgullygully.console.service;

import com.cricketgullygully.console.dto.*;
import com.cricketgullygully.console.dto.enums.TeamOption;
import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.entity.Team;
import com.cricketgullygully.console.repo.MatchInfoRepository;
import com.cricketgullygully.console.repo.PlayerRepository;
import com.cricketgullygully.console.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class MatchInfoService {

	@Autowired
	private MatchInfoRepository matchInfoRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private PlayerRepository playerRepository;

	private TeamOption getLoser(TeamOption winner) {
		return (TeamOption.TEAMONE == winner) ? TeamOption.TEAMTWO : TeamOption.TEAMTWO;
	}

	public MatchInfo saveMatchInfo(MatchInfo matchInfo) {

		Optional<Team> teamOne = teamRepository.findById(matchInfo.getTeamOne().getId());
		Optional<Team> teamTwo = teamRepository.findById(matchInfo.getTeamTwo().getId());
		if (teamOne.isPresent() && teamTwo.isPresent()) {
			matchInfo.setTeamOne(teamOne.get());
			matchInfo.setTeamTwo(teamTwo.get());

		} else {
			//TODO: Handle exception here.
		}
		return matchInfoRepository.save(matchInfo);
	}

	public MatchInfo findMatchInfoByID(Long id) {
		return matchInfoRepository.findById(id).orElse(null);
	}

	public MatchInfo setTossInfo(Long id, Toss toss) {

		MatchInfo matchInfo = matchInfoRepository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		String tossMessage = String.format("%s won the toss, choose to %s first",
				toss.getWinner() == TeamOption.TEAMONE ? matchInfo.getTeamOne().getName() : matchInfo.getTeamTwo().getName(), toss.isBattingFirst() ? "bat" : "bowl");
		toss.setMessage(tossMessage);
		matchInfo.setToss(toss);
		matchInfo.setCurrentBatting(toss.isBattingFirst() ? toss.getWinner() : getLoser(toss.getWinner()));
		Scoreboard scoreboard = new Scoreboard();
		scoreboard.addInning(matchInfo);
		matchInfo.setScoreboard(scoreboard);
		return matchInfo;
	}

	public MatchInfo setPlayerInfo(Long id, Map<String, List<Long>> payload) {
		MatchInfo matchInfo = matchInfoRepository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		List<PlayerName> teamOnePlaying11 = playerRepository.findByIds(payload.get("teamOnePlaying11"));
		List<PlayerName> teamTwoPlaying11 = playerRepository.findByIds(payload.get("teamTwoPlaying11"));
		matchInfo.setTeamOnePlaying11(teamOnePlaying11);
		matchInfo.setTeamTwoPlaying11(teamTwoPlaying11);
		//matchInfo.setTeamPlayer(playerRepository.findByIdsToMap(payload.get("teamTwoPlaying11")));
		return matchInfo;
	}

	public MatchInfo setOpeningPlayers(Long id, Map<String, String> payload) {
		MatchInfo matchInfo = matchInfoRepository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		PlayerName striker = matchInfo.getPlayerFromPlayerName(payload.get("striker"));
		PlayerName nonStriker = matchInfo.getPlayerFromPlayerName(payload.get("nonStriker"));
		PlayerName bowler = matchInfo.getPlayerFromPlayerName(payload.get("bowler"));
		matchInfo.getScoreboard().getCurrentInning().setCurrentStriker(striker.getName());
		matchInfo.getScoreboard().getCurrentInning().setCurrentNonStriker(nonStriker.getName());
		matchInfo.getScoreboard().getCurrentInning().setCurrentBowler(bowler.getName());
		matchInfo.getScoreboard().getCurrentInning().getBatsmanScores().add(new BatsmanScore(striker));
		matchInfo.getScoreboard().getCurrentInning().getBatsmanScores().add(new BatsmanScore(nonStriker));
		matchInfo.getScoreboard().getCurrentInning().getBowlerScores().add(new BowlerScore(bowler));
		return matchInfo;
	}

	public MatchInfo setPlayerOut(Long id, WicketInfo wicketInfo) {
		MatchInfo matchInfo = matchInfoRepository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		PlayerName batsman = matchInfo.getPlayerFromPlayerName(wicketInfo.getBatsMan());
		PlayerName bowler = matchInfo.getPlayerFromPlayerName(wicketInfo.getBowler());
		PlayerName fielder = matchInfo.getPlayerFromPlayerName(wicketInfo.getFielder());
		matchInfo.getScoreboard().getCurrentInning().setBatsmanOut(batsman,bowler,fielder,wicketInfo);
		matchInfo.getScoreboard().getCurrentInning().addWicketToBowler(bowler.getName());
		return  matchInfo;
	}

	public MatchInfo bowlABall(Long id, BallInfo ballInfo) {
		
		MatchInfo matchInfo = matchInfoRepository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		Inning currentInning= matchInfo.getScoreboard().getCurrentInning();
		currentInning.updateInningDetailsPerBall(ballInfo);
		return matchInfo;
	}

	
}
