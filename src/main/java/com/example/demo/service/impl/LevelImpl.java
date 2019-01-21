package com.example.demo.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LevelMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Level;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.LevelService;
import com.example.demo.service.UserService;


@MapperScan("com.example.demo.dao")
@Service
public class LevelImpl implements LevelService{


@Autowired
	private LevelMapper lm;
	
@Override
public Level get_level(Integer i) {
	// TODO Auto-generated method stub
	return lm.selectByPrimaryKey(i);
}
	
}
