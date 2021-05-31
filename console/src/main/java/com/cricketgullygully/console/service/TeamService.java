package com.cricketgullygully.console.service;

import com.cricketgullygully.console.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricketgullygully.console.entity.Team;
import com.cricketgullygully.console.repo.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public Team saveTeam(Team team) {
		System.out.println("saveTeam called ");
		return teamRepository.save(team);
	}

	public Team getTeamById(long id) {
		return teamRepository.findById(id).get();
	}

	public List<Team> saveManyTeam(List<Team> teams) {
		return teamRepository.saveAll(teams);
	}

	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

	public List<Player> getPlayers(long teamId) {
		Optional<Team> team = teamRepository.findById(teamId);
		//return null;
		return team.map(Team::getPlayers).orElse(null);

	}

	public List<Player> getPlayers(String teamShortName) {
		return teamRepository.findByShortName(teamShortName).getPlayers();
	}
}
