package com.example.demo.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.interceptors.LoginInterceptor;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserImpl;
import com.mysql.jdbc.log.Log;

@RequestMapping(value="hlw")
@Controller
public class CommentController {
	
	@Autowired
	private UserService us;
	@Autowired
	private CommentService cs;
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@RequestMapping("/comment")
    public String comment(){
        return "/comment_1";
    }
	
	@RequestMapping("/backstage/comment")
	public void sendHtmlEmail(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException,Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
//		String timeset=request.getParameter("timeNow");
		String content=request.getParameter("content");
		Integer userId=(Integer)request.getSession().getAttribute("userId");
		user=us.get_user(userId, null, null);
		Date date=new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		  
	    Comment comment=new Comment();
	    comment.setUserId(userId);
	    comment.setUserName(user.getName());
	    comment.setCommentDate(date);
	    comment.setContent(content);
	  
	    cs.add_comment(comment);
	    
		 JSONObject json = new JSONObject();
		 json.put("userName", user.getName());
		 json.put("userEmail", user.getEmail());
		 json.put("timeNow", sdf.format(date));
		 printWriter.println(json);
	}
	
	
	@RequestMapping("/backstage/getCommentMsg")
	public void getCommentMsg(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException,Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
//		
		ArrayList<Comment> cList=(ArrayList<Comment>) cs.get_comments();
		
		Date date=new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		  
		  JSONObject json = null;
		  JSONArray jsonArray =new JSONArray();
        for(Comment c:cList){
        	json=new JSONObject();
        	json.put("userName",c.getUserName());
   		 json.put("content", c.getContent());
   		 json.put("time", c.getCommentDate().toString()); 
   		 
   		 jsonArray.add(json);
   		 
        }
//        json=new JSONObject();
//        json.put("leng", cList.size()+1);
//        jsonArray.add(json);
        
        log.info("=============="+jsonArray.toJSONString());
        printWriter.println(jsonArray);

	    
		 
		 
		
	}
	
	@RequestMapping("/backstage/getCUser")
	public void getCuser(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException,Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		String cUser=(String)request.getSession().getAttribute("cUser");
		log.info("+++++++++"+cUser);
		JSONObject json = new JSONObject();
		json.put("cUser", cUser);
		printWriter.println(json);
	}	
		
}
