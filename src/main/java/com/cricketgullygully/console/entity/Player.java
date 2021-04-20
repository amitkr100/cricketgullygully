package com.cricketgullygully.console.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String 	name;
	private Integer totalMatchPlayed;
	private Integer totalRun;
	private Integer totalOver;
	private Integer totalWicket;
	private Integer totalOverBowled;

	@ManyToOne
	@JoinColumn
	private Team team;
}
