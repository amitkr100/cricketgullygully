package com.cricketgullygully.console.entity;

import com.cricketgullygully.console.dto.PlayerName;
import com.cricketgullygully.console.dto.Scoreboard;
import com.cricketgullygully.console.dto.Toss;
import com.cricketgullygully.console.dto.enums.TeamOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
@JsonInclude(Include.NON_NULL)
public class MatchInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
	private Team teamOne;
	@OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
	private Team teamTwo;
	private Double totalOver;
	@JsonIgnore
	private TeamOption winner = TeamOption.TEAMONE;
	private String winningMessage;
	private TeamOption currentBatting = TeamOption.UNDECIDED;
	@Type(type = "json")
	@Column(columnDefinition = "text")
	private Toss toss;

	@Type(type = "json")
	@Column(columnDefinition = "text")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<PlayerName> teamOnePlaying11 = new ArrayList<>();

	@Type(type = "json")
	@Column(columnDefinition = "text")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<PlayerName> teamTwoPlaying11 = new ArrayList<>();

	@Type(type = "json")
	@Column(columnDefinition = "text")
	private Scoreboard scoreboard;

	public Team teamBattingFirst() {
		if (toss.getWinner() == TeamOption.TEAMONE && toss.isBattingFirst())
			return teamOne;
		else if (toss.getWinner() == TeamOption.TEAMTWO && !toss.isBattingFirst())
			return teamOne;
		else
			return teamTwo;
	}

	public Team teamBattingSecond() {
		if (toss.getWinner() == TeamOption.TEAMONE && toss.isBattingFirst())
			return teamTwo;
		else if (toss.getWinner() == TeamOption.TEAMTWO && !toss.isBattingFirst())
			return teamTwo;
		else
			return teamOne;
	}

	public Team getTeamBattingNow() {
		return (currentBatting == TeamOption.TEAMONE) ? teamOne : teamTwo;
	}

	@JsonIgnore
	public List<String> getTeamPlaying11BattingNow() {
		return (currentBatting == TeamOption.TEAMONE) ? teamOnePlaying11OnlyNames() : teamTwoPlaying11OnlyNames();
	}

	@JsonProperty("teamOnePlaying11")
	public List<String> teamOnePlaying11OnlyNames() {
		List<String> playing11 = new ArrayList<>();
		for (PlayerName playerName : getTeamOnePlaying11())
			playing11.add(playerName.getName());
		return playing11;
	}

	@JsonProperty("teamTwoPlaying11")
	public List<String> teamTwoPlaying11OnlyNames() {
		List<String> playing11 = new ArrayList<>();
		for (PlayerName playerName : getTeamTwoPlaying11())
			playing11.add(playerName.getName());
		return playing11;
	}

	public PlayerName getPlayerFromPlayerId(Long id) {
		for (PlayerName player : teamOnePlaying11)
			if (player.getId().equals(id))
				return player;

		for (PlayerName player : teamTwoPlaying11)
			if (player.getId().equals(id))
				return player;

		return null;
	}
	public PlayerName getPlayerFromPlayerName(String name) {
		for (PlayerName player : teamOnePlaying11)
			if (player.getName().equals(name))
				return player;

		for (PlayerName player : teamTwoPlaying11)
			if (player.getName().equals(name))
				return player;

		return null;
	}


}

