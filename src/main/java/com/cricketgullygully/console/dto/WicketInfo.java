package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.dto.enums.OutType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class WicketInfo {
	private String bowler = "";
	private String batsMan = "";
	private String fielder = "";
	OutType outType;
}
