package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Reportevent;
import com.example.demo.model.User;
import com.example.demo.service.ReportEventService;

@RequestMapping(value = "test1")
@Controller
public class TestController {
	@Autowired
	private ReportEventService rs;

    @RequestMapping(value = "test")
  public String text() {
    	return"/test1";
    	
    } 
    
    @RequestMapping("/backstage/yyy")
	public void check_User(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter printWriter = response.getWriter();
	 String username=request.getParameter("username");
	 String email=request.getParameter("email");
	 Reportevent res=new Reportevent();
	 res.setUserId(101);
	 Reportevent res2=rs.get_reportEvent(res);
	 
     printWriter.println(res2.getEmailMsg());
	 
    }
    
}
