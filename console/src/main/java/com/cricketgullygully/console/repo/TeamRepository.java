package com.cricketgullygully.console.repo;

import com.cricketgullygully.console.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketgullygully.console.entity.Team;

import java.util.List;
import java.util.stream.DoubleStream;

public interface TeamRepository extends JpaRepository<Team, Long> {


	Team findByShortName(String teamShortName);
}
