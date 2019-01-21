package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RegionalheadMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Regionalhead;
import com.example.demo.service.HeadService;
@Service
public class HeadServiceImpl implements HeadService{
	
	@Autowired
	private RegionalheadMapper rm;
	@Override
	public Regionalhead get_headMsg_2(String phoneNum) {
		// TODO Auto-generated method stub
		return rm.selectByPhoneNum(phoneNum);
		
	}
	@Override
	public Regionalhead get_headMsg(Integer id) {
		// TODO Auto-generated method stub
		return rm.selectByPrimaryKey(id);
	}

}
