package com.cricketgullygully.console.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricketgullygully.console.entity.OverInfo;

@Repository
public interface OverInfoRepository extends JpaRepository<OverInfo, Long>  {

}
