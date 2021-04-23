package com.cricketgullygully.console.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

}
