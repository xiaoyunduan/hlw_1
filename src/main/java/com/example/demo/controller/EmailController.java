package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserImpl;
import com.example.demo.until.FileOperatingTool;

@RequestMapping(value="hlw")
@Controller
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping("/emailforpwd")
    public String email(){
        return "/email";
    }
	
	@RequestMapping("/backstage/emailSend")
	public void sendHtmlEmail(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException,Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		String emailAddress=request.getParameter("youEmail");
		String content="<html> "+ 
				"<body>"+
		 "<a href='http://localhost:8080/hlw/newpwdset?email="+emailAddress+"'"+">跳转链接</a>"
                +"</body> </html>";
             
	    emailService.sendHtmlEmail(emailAddress,"护林网密码修改",content);
	    printWriter.println("邮件发送成功，请到邮箱验证");
	}
	
		
}
