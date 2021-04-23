package com.cricketgullygully.console.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketgullygully.console.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {


}
