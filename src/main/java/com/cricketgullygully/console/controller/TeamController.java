package com.cricketgullygully.console.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricketgullygully.console.entity.Team;

import com.cricketgullygully.console.service.TeamService;

@RestController
@RequestMapping("team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@PostMapping("/save")
	public Team saveTeam(@RequestBody Team team) {
		System.out.println("called saveTeam");
		return teamService.saveTeam(team);
	}

	@GetMapping("/{id}")
	public Team getTeam(@PathVariable int id) {
		System.out.println("Called getTeam");
		return teamService.getTeamById(id);
	}

}
