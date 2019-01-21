package com.example.demo.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddinfoMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Addinfo;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.AddInfoService;
import com.example.demo.service.UserService;


@MapperScan("com.example.demo.dao")
@Service
public class AddInfoImpl implements AddInfoService{
@Autowired
	private AddinfoMapper am;

@Override
public int add_user(Addinfo ai) {
	// TODO Auto-generated method stub
	am.insert(ai);
	return 1;
}

@Override
public int delete_user(Integer id) {
	// TODO Auto-generated method stub
	am.deleteByPrimaryKey(id);
	return 1;
}

@Override
public int update_user(Addinfo ai) {
	// TODO Auto-generated method stub
	am.updateByPrimaryKey(ai);
	return 1;
}

@Override
public Addinfo query_user(Integer id) {
	// TODO Auto-generated method stub
	return am.selectByPrimaryKey(id);
}

	
	
}
