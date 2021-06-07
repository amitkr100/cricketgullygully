package com.cricketgullygully.console.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricketgullygully.console.entity.OverInfo;

import com.cricketgullygully.console.repo.OverInfoRepository;

@Service
public class OverInfoService {

	@Autowired
	private OverInfoRepository overRepository;

	public OverInfo saveOver(OverInfo over) {
		return overRepository.save(over);
	}

	public OverInfo getOverById(long id) {
		return overRepository.findById(id).get();
	}

}
