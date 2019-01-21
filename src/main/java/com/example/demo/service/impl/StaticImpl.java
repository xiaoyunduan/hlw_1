package com.example.demo.service.impl;

import java.util.ArrayList;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SmsMapper;
import com.example.demo.dao.StatisticsMapper;
import com.example.demo.model.Statistics;
import com.example.demo.service.StaticService;

@MapperScan("com.example.demo.dao")
@Service
public class StaticImpl implements StaticService{
	@Autowired
	private StatisticsMapper sm;
	@Override
	public ArrayList<Statistics> querySMS() {
		
		// TODO Auto-generated method stub
		return sm.StatisticsSMS();
	}

	@Override
	public ArrayList<Statistics> queryEmail() {
		// TODO Auto-generated method stub
		return sm.StatisticsEmail();
	}

}
