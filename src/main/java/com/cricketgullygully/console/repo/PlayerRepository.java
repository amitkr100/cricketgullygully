package com.cricketgullygully.console.repo;

import com.cricketgullygully.console.dto.PlayerName;
import com.cricketgullygully.console.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query(value = "SELECT new com.cricketgullygully.console.dto.PlayerName(id, name) FROM Player p where id IN :Ids")
	List<PlayerName> findByIds(@Param("Ids") Collection<Long> Ids);

	//Map<Long, String> findByIdsToMap(List<Long> teamTwoPlaying11);
}
