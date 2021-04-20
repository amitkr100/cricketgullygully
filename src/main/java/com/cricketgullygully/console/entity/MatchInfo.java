package com.cricketgullygully.console.entity;

import com.cricketgullygully.console.dto.Scoreboard;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class MatchInfo{

	@Id
	@GeneratedValue
	private Integer id;
	private Integer teamOne;
	private Integer teamTwo;
	private Integer totalOver;
	private Integer outcome;
	private Integer tossWonBy;
	private Integer currentBatting;
	@ElementCollection
	private List<Integer> teamOnePlaying11 = new ArrayList<>();
	@ElementCollection
	private List<Integer> teamTwoPlaying11 = new ArrayList<>();

	@Type(type = "json")
	@Column(columnDefinition = "text")
	private Scoreboard scoreboard;

}
