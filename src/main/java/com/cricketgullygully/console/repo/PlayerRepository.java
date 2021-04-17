package com.cricketgullygully.console.repo;

import com.cricketgullygully.console.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	Player getById(int id);
}
