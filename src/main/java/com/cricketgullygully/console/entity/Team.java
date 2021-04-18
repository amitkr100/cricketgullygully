package com.cricketgullygully.console.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String shortName;

	@OneToMany(mappedBy = "team")
	@Getter(AccessLevel.NONE)
	private List<Player> players = new ArrayList<>();

	public void addPlayer(Player player)
	{
		this.players.add(player);
		player.setTeam(this);
	}
}
