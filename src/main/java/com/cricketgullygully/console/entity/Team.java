package com.cricketgullygully.console.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String name;
	String shortName;
}
