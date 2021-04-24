package com.cricketgullygully.console.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long id;
	private String name;
	@Column(unique = true)
	private String shortName;

	@OneToMany(mappedBy = "team")
	@JsonIgnore
	private List<Player> players = new ArrayList<>();

	public void addPlayer(Player player)
	{
		this.players.add(player);
		player.setTeam(this);
	}

}
