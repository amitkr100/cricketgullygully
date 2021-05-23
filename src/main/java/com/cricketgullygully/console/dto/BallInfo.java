package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.dto.enums.BallType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BallInfo {
	
	private String striker="";
	private String bowler="";
	private int run;
	private BallType ballType;
	private Double overNo=0.0;
	
	}
