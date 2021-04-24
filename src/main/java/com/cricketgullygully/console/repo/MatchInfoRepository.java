package com.cricketgullygully.console.repo;

import com.cricketgullygully.console.entity.MatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchInfoRepository extends JpaRepository<MatchInfo, Long> {
}
