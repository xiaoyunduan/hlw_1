package com.example.demo.service.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProtectedareaMapper;
import com.example.demo.model.Protectedarea;
import com.example.demo.service.ProtectedAreaService;

@MapperScan("com.example.demo.dao")
@Service
public class ProtectedAreaImpl implements ProtectedAreaService{

	 @Autowired
	    private ProtectedareaMapper pam;
	 
	@Override
	public int add_protectedArea(Protectedarea pa) {
		// TODO Auto-generated method stub
	   pam.insert(pa);
		return 1;
	}

	@Override
	public int delete_protectedArea(Protectedarea pa) {
		// TODO Auto-generated method stub
		pam.deleteByPrimaryKey(pa.getAreaId());
		return 1;
	}

	@Override
	public int update_protectedArea(Protectedarea pa) {
		// TODO Auto-generated method stub
		pam.updateByPrimaryKey(pa);
		return 1;
	}

	@Override
	public Protectedarea get_protectedArea(Protectedarea pa) {
		// TODO Auto-generated method stub
		return pam.selectByPrimaryKey(pa.getAreaId());
		
	}

}
