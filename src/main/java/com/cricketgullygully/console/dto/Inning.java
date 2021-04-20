package com.cricketgullygully.console.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inning {


	private String teamName;
	private Integer totalOver;
	private List<Integer> Playing11 = new ArrayList<>();
	private List<BatsmanScore> batsmanScores = new ArrayList<>();
	private List<BowlerScore> bowlerScores = new ArrayList<>();

	void init(String teamName, Integer totalOver, List<Integer> playing11) {
		this.teamName = teamName;
		this.Playing11 = playing11;
		this.totalOver = totalOver;
	}
}
