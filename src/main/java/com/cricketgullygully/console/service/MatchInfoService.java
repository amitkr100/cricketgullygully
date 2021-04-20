package com.cricketgullygully.console.service;

import com.cricketgullygully.console.dto.Scoreboard;
import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.entity.Team;
import com.cricketgullygully.console.repo.MatchInfoRepository;
import com.cricketgullygully.console.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchInfoService {

	@Autowired
	private MatchInfoRepository matchInfoRepository;
	@Autowired
	private TeamRepository teamRepository;

	public MatchInfo saveMatchInfo(MatchInfo matchInfo) {

		Optional<Team> teamOne = teamRepository.findById(matchInfo.getTeamOne());
		Optional<Team> teamTwo = teamRepository.findById(matchInfo.getTeamTwo());
		if (teamOne.isPresent() && teamTwo.isPresent()) {
			Scoreboard scoreboard = new Scoreboard();
			scoreboard.init(teamOne.get(), teamTwo.get(), matchInfo);
			matchInfo.setScoreboard(scoreboard);
		} else {
			//TODO: Handle exception here.
		}
		return matchInfoRepository.save(matchInfo);
	}

	public MatchInfo findMatchInfoByID(Integer id) {
		return matchInfoRepository.getById(id);
	}
}
