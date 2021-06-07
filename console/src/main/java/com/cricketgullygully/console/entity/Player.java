package com.cricketgullygully.console.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String 	name;
	private long totalMatchPlayed;
	private long totalRun;
	private long totalOver;
	private long totalWicket;
	private long totalOverBowled;

	@ManyToOne
	@JoinColumn
	private Team team;
}
