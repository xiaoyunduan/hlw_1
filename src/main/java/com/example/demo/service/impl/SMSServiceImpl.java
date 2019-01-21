package com.example.demo.service.impl;

import java.util.ArrayList;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SmsMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Sms;
import com.example.demo.service.SMSService;
@MapperScan("com.example.demo.dao")
@Service
public class SMSServiceImpl implements SMSService{

	



	@Autowired
	private SmsMapper sm;
	@Override
	public int addSMS(Sms sms) {
		// TODO Auto-generated method stub
		sm.insert(sms);
		return 1;
	}

	@Override
	public ArrayList<Sms> queryALL() {
		// TODO Auto-generated method stub
		return sm.selectAll();
	}

	@Override
	public int deleteSMS(int SMSId) {
		// TODO Auto-generated method stub
		sm.deleteByPrimaryKey(SMSId);
		return 1;
	}

	

	@Override
	public Sms querySMS_1(int SMSId) {
		// TODO Auto-generated method stub
		
		return sm.selectByPrimaryKey(SMSId);
	}

	@Override
	public ArrayList<Sms> querySMS_2(int userId) {
		// TODO Auto-generated method stub	
		return sm.selectByUserId(userId);
	}

	
	@Override
	public ArrayList<Sms> querySMS_3(int headId) {
		// TODO Ato-generated method stub
		return sm.selectByHeadId(headId);
	}
	
	@Override
	public int updateSMS(Sms sms) {
		// TODO Auto-generated method stub
		sm.updateByPrimaryKey(sms);
		return 1;
	}



	

}
