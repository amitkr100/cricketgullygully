package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.MatchInfo;
import com.cricketgullygully.console.repo.MatchInfoRepository;
import com.cricketgullygully.console.service.MatchInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
	public MatchInfo getMatchInfo(@PathVariable int id) {
		log.debug("Called getMatchInfo");
		return matchInfoService.findMatchInfoByID(id);
	}
}
