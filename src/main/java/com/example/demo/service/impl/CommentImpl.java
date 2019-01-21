package com.example.demo.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
@MapperScan("com.example.demo.dao")
@Service
public class CommentImpl implements CommentService{

	
	@Autowired
	private CommentMapper cm;
	@Override
	public int add_comment(Comment c) {
		// TODO Auto-generated method stub
		cm.insert(c);
		return 1;
	}

	@Override
	public int delete_comment(Integer id) {
		// TODO Auto-generated method stub
		cm.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public int update_comment(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment get_comment(Integer id) {
		// TODO Auto-generated method stub
		cm.selectByPrimaryKey(id);
		return null;
	}

	@Override
	public List<Comment> get_comments() {
		
		// TODO Auto-generated method stub
		
		return cm.getAllComment();
	}

	@Override
	public int no_name_login() {
		// TODO Auto-generated method stub
		return 0;
	}

}
