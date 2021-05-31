package com.cricketgullygully.console.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OverInfo {
	
	@Id
	private int id;
	private int ballOne;
	private int ballTwo;
	private int ballThree;
	private int ballFour;
	private int ballFive;
	private int ballSix;

	
	private int bowlerId;

}
