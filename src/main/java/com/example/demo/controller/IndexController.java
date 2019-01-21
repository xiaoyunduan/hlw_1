package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserImpl;

@RequestMapping(value="hlw")
@Controller
public class IndexController {
	
	
	
	@RequestMapping("/index")
    public String login(){
        return "/index";
    }
	
	@RequestMapping("/backstage/index1")
	public void check_User(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
		Integer userId=(Integer)request.getSession().getAttribute("userId");
		 JSONObject json = new JSONObject();
	
    	if(userId != null) {
    		 
    		json.put("yon", 1);
    		printWriter.println(json);
    	}else {
    		json.put("yon", 0);
    		printWriter.println(json);
    	}
    }
	@RequestMapping("/backstage/index2")
	public void c(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
		HttpSession session=(HttpSession)request.getSession();
		session.setAttribute("userId", null);
		session.setAttribute("level_Id", null);
		printWriter.println("success");
		
    }
	
	@RequestMapping("/backstage/index3")
	public void pd(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
		Integer level_Id=(Integer)request.getSession().getAttribute("level_Id");
		 JSONObject json = new JSONObject();
	
    	if(level_Id == 0) {
    		 
    		json.put("levelid", 0);
    		printWriter.println(json);
    	}else {
    		json.put("levelid", 1);
    		printWriter.println(json);
    	}
    }
		
}
