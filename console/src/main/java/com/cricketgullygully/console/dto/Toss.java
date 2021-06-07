package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.dto.enums.TeamOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Toss {
	private TeamOption winner;
	private boolean isBattingFirst;
	private String message;

}
