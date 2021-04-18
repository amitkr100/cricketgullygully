package com.cricketgullygully.console.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricketgullygully.console.entity.Team;
import com.cricketgullygully.console.repo.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public Team saveTeam(Team team) {
		System.out.println("saveTeam called ");
		return teamRepository.save(team);
	}

	public Team getTeamById(int id) {
		return teamRepository.getById(id);
	}

}
