package com.example.demo.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.interceptors.LoginInterceptor;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserImpl;
import com.example.demo.until.StrJudgeTool;

@RequestMapping(value="hlw")
@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	private UserService us;
	private final static int success=1;
	@RequestMapping("/login")
    public String login(){
        return "/login";
    }
	
	
	
	@SuppressWarnings("unused")
	@RequestMapping("/backstage/check")
	public void check_User(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
	 response.setContentType("text/html;charset=UTF-8");
	PrintWriter printWriter = response.getWriter();
	 String pwd=request.getParameter("password");
	 String account=request.getParameter("user");
      user=us.get_user(null,account,account);
     
     if(user==null){
    	printWriter.println("用户不存在");
//    	return null;
     }else if(!user.getPwd().equals(pwd)){
    	 printWriter.println("密码错误");
//    	 return null;
     }else{
    	 request.getSession().setAttribute("userId", user.getId());
    	 request.getSession().setAttribute("cUser", user.getName());
    	 printWriter.println(success);
    	 
//    	 ModelAndView modelAndView = new ModelAndView();
//         modelAndView.setViewName("index");
//         modelAndView.addObject("useId", user.getId());
//    	return modelAndView;
//    	  return "redirect:index";
     }
         
  }
	
	
	 @RequestMapping("/backstage/register")
	 public void register(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter printWriter = response.getWriter();
		 String name=request.getParameter("username");
		 String pwd=request.getParameter("password");
		 String email=request.getParameter("email");
		 String surepwd=request.getParameter("surepassword");
		 
		 String returnMsg="";
		 	if(us.get_user(null, name,null)!=null){
		 		String warn="用户名已存在";
		 		returnMsg+=warn;
		 	}else if(us.get_user(null, null,name)!=null){
		 		String warn="邮箱已注册";
		 		returnMsg+=warn;
		 	}else if(!StrJudgeTool.isEmail(email)){
		 		String warn="邮箱格式不合法";
		 		returnMsg+=warn;
		 	}
		 	else if(!pwd.equals(surepwd)){
		 		String warn="两次输入密码不一致";
		 		returnMsg+=warn;
		 	}else if(!StrJudgeTool.isLetterDigitOrChinese(pwd)){
		 		String warn="密码必须是字符和数字组合,长度要在6^12位之间";
		 		returnMsg+=warn;
		 	}
		 	else {
		 		user=new User();
		 		user.setName(name);
		 		user.setPwd(pwd);
		 		user.setEmail(email);
		 		user.setLevel_id(1);
		 		us.add_user(user);
		 		
		 		returnMsg="true";
		 	}
		 	 printWriter.println(returnMsg);
	 
	 }
	 
	 @RequestMapping("/newpwdset")
	    public String newpwdset(){
	        return "/newpwdset";
	    }
	 
	 @RequestMapping("/backstage/setNewPwd")
		public void setNewPwd(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			 String newpwd=request.getParameter("newPwd");
			 String surePwd=request.getParameter("surePwd");
			 String email=request.getParameter("email");
			 if(!newpwd.equals(surePwd)){
				 printWriter.println("两次密码输入不一致");
			 }else{
				 user=new User();
				 user.setEmail(email);
				 user.setPwd(newpwd);
			     us.update_user(user);
			     printWriter.println("修改成功");
			 }
			 
	 }
	 
	 @RequestMapping("/backstage/judge")
		public void c(HttpServletRequest request, HttpServletResponse response) throws IOException {
			 response.setContentType("text/html;charset=UTF-8");
				PrintWriter printWriter = response.getWriter();
				int id=(Integer)request.getSession().getAttribute("userId");
				 JSONObject json = new JSONObject();
				
				
				int level_id=us.get_user(id,null,null).getLevel_id();
				json.put("level_id", level_id);
				log.info(json.toString());
			printWriter.println(json);
			
	    }
}
