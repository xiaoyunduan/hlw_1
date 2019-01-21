package com.example.demo.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.UserService;


@MapperScan("com.example.demo.dao")
@Service
public class UserImpl implements UserService{
@Autowired
	private UserMapper um;
	@Override
	public int add_user(User u) {
		// TODO Auto-generated method stub
		um.insert(u);
		return 0;
	}

	@Override
	public int delete_user(Integer id) {
		// TODO Auto-generated method stub
		UserKey uKey=new UserKey();
		uKey.setId(id);
		um.deleteByPrimaryKey(uKey);
		return 0;
	}

	@Override
	public int update_user(User u) {
		// TODO Auto-generated method stub
		um.updateByPrimaryKey(u);
		return 0;
	}

	

	@Override
	public User get_user(Integer id, String name,String email) {
		// TODO Auto-generated method stub
		UserKey uKey=new UserKey();
		uKey.setName(name);
		uKey.setId(id);
		uKey.setEmail(email);
		return um.selectByPrimaryKey(uKey);
	}

	@Override
	public User get_userbyId(Integer i) {
		// TODO Auto-generated method stub
		
		
		return um.selectUserById(i);
	}

	@Override
	public List<User> get_users() {
		// TODO Auto-generated method stub
		return um.selectAllUser();
	}

	@Override
	public Integer get_matchCount(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int no_name_login() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
