package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.dto.Toss;
import com.cricketgullygully.console.dto.WicketInfo;
import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.service.MatchInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("match")
public class MatchController {

	private final String MATCH_SERVICE = "MATCH_SERVICE";

	@Autowired
	private MatchInfoService matchInfoService;

	@PostMapping("/create")
	public MatchInfo saveMatchInfo(@RequestBody MatchInfo matchInfo) {
		log.debug("Called saveMatchInfo");
		return matchInfoService.saveMatchInfo(matchInfo);
	}

	@GetMapping("/{id}")
	public MatchInfo getMatchInfo(@PathVariable Long id) {
		log.debug("Called getMatchInfo");
		return matchInfoService.findMatchInfoByID(id);
	}
	@PostMapping("/{id}/addPlayers")
	public MatchInfo setPlayersInfo(@PathVariable Long id, @RequestBody Map<String, List<Long>> payload)
	{
		return matchInfoService.setPlayerInfo(id, payload);
	}
	@PostMapping("/{id}/toss")
	public MatchInfo setTossInfo(@PathVariable Long id, @RequestBody Toss toss)
	{
		return matchInfoService.setTossInfo(id, toss);
	}

	@PostMapping("/{id}/openers")
	public MatchInfo setOpeners(@PathVariable Long id, @RequestBody Map<String, String> payload)
	{
		return matchInfoService.setOpeningPlayers(id, payload);
	}

	@PostMapping("/{id}/wicket")
	public MatchInfo setPlayerOut(@PathVariable Long id, @RequestBody WicketInfo wicketInfo)
	{
		return matchInfoService.setPlayerOut(id, wicketInfo);
	}
}
