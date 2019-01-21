package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.impl.client.AIMDBackoffManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.interceptors.LoginInterceptor;
import com.example.demo.model.Addinfo;
import com.example.demo.model.Reportevent;
import com.example.demo.model.Sms;
import com.example.demo.model.User;
import com.example.demo.service.AddInfoService;
import com.example.demo.service.HeadService;
import com.example.demo.service.LevelService;
import com.example.demo.service.ReportEventService;
import com.example.demo.service.SMSService;
import com.example.demo.service.UserService;

@RequestMapping(value = "hlw")
@Controller
public class PersionController {
	
	@Autowired
	private ReportEventService pe;
	@Autowired
	private SMSService ss;
	@Autowired
	private HeadService hs;
	@Autowired
	private UserService us;
	@Autowired
	private LevelService ls;
	@Autowired
	private AddInfoService as;
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	 @RequestMapping(value = "persion")
	    public String text1() {
	      	return"/user";
	      	
	      } 
	    
	    

	    @RequestMapping(value = "/user")
	  public String text2() {
	    	return"/user";
	    	
	    } 
	    @RequestMapping(value = "/table")
	    public String text3() {
	      	return"/table";
	      	
	      } 
	    @RequestMapping(value = "/dashboard")
	    public String text4() {
	      	return"/dashboard";
	      	
	      } 
	    @RequestMapping(value = "/setPwd")
	    public String text5() {
	      	return"/setPwd";
	      	
	      }
	    @RequestMapping(value ="/personManage")
	    public String text6() {
	      	return"/personManage";
	      	
	      }
    
	
	    @RequestMapping("/backstage/getUserMsg")
		public void getUserMsg(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter printWriter = response.getWriter();

		 Integer userId=(Integer)request.getSession().getAttribute("userId");
		 user=us.get_user(userId, null, null);
		 
		 JSONObject jb=new JSONObject();
		 jb.put("userName", user.getName());
		 jb.put("level", ls.get_level(user.getLevel_id()).getLevel_name());
		 jb.put("email", user.getEmail());
		 Addinfo ai=as.query_user(userId);
		 if(ai!=null){
			 jb.put("homeAddress",ai.getAddress() );
			 jb.put("aboutMe", ai.getAboutMe());
//			 jb.put("", user.getEmail());
//			 log.info(ai.getAddress()+"=====");
		 }
		 	
		
		 printWriter.print(jb);
		   	  
}
		   	   
		   	
			 
	    @RequestMapping("/backstage/getAllUser")
		public void getAllUser(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter printWriter = response.getWriter();

//		 Integer userId=(Integer)request.getSession().getAttribute("userId");
		 ArrayList<User> als=(ArrayList<User>) us.get_users();
		 
		 JSONObject jb=null;
		 JSONArray ja=new JSONArray();
		  for(User u:als){
			  jb=new JSONObject();
			  	 jb.put("userId",u.getId() );
				 jb.put("userName", u.getName());
				 jb.put("passWord", u.getPwd());
				 jb.put("email", u.getEmail());
				 ja.add(jb);
				 
		  }
		 
		
		 printWriter.print(ja);
		   	  
}
	    
	    
	    @RequestMapping("/backstage/deleteUser")
		public void deleteUser(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter printWriter = response.getWriter();
		 Integer userId=Integer.parseInt(request.getParameter("Id"));
		 log.info("00000"+userId.toString());
		 us.delete_user(userId);
		 
		 
		
		 printWriter.println("success");
		   	  
}
	   
	    
	    
	    
	    

	    @RequestMapping("/backstage/getReportHistory")
		public void getReportHistory(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
	    	response.setContentType("text/html;charset=UTF-8");
			 PrintWriter printWriter = response.getWriter();

	    	Integer userId=(Integer)request.getSession().getAttribute("userId");
			 user=us.get_user(userId, null, null);
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 JSONObject jb=new JSONObject();
			 JSONArray j=new JSONArray();
	    	 ArrayList<Reportevent> a2=(ArrayList<Reportevent>) pe.get_reportEvent_2(userId);
			 if(a2.size()!=0){				 
				 for(Reportevent r:a2) {
					 
					 User u2=us.get_user(null, null, r.getHeadEmail());
					 if(u2!=null){
						 jb=new  JSONObject();
						 jb.put("reportTime", formatter.format(r.getReportTime()));
						 jb.put("headName", u2.getName());
						 jb.put("point", r.getReportAreaPoint());
						 jb.put("reportWay", "邮箱举报");
						 if(r.getIsResolve()==1)
							 jb.put("isResolve", "yes");
						 else
							 jb.put("isResolve", "no");
						 j.add(jb);
					 }
					 
									 		 
				 } 
			 }
			 ArrayList<Sms> a=(ArrayList<Sms>) ss.querySMS_2(userId);
		   	   if(a.size()!=0){		   		  
		   		for(Sms r:a) {
			   		 jb=new  JSONObject();
			   		 jb.put("reportTime", formatter.format(r.getReportTime()));
			   		 jb.put("headName", us.get_userbyId(r.getHeadId()).getName());
			   		 jb.put("point", r.getReportAreaPoint());
			   		 jb.put("reportWay", "短信举报");
			   		if(r.getIsResolve()==1)
						 jb.put("isResolve", "yes");
					 else
						 jb.put("isResolve", "no");
					 j.add(jb);
			   	 }
		   	   }
		   	   printWriter.println(j);
		   	   
	    	
	    }
	    
	    
	    
	    @RequestMapping("/backstage/receivedReportHistory")
		public void receivedReportHistory(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
	    	response.setContentType("text/html;charset=UTF-8");
			 PrintWriter printWriter = response.getWriter();

	    	Integer userId=(Integer)request.getSession().getAttribute("userId");
			 user=us.get_user(userId, null, null);
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 JSONObject jb=new JSONObject();
			 JSONArray j=new JSONArray();
	    	 ArrayList<Reportevent> a2=(ArrayList<Reportevent>) pe.get_reportEvent_3(user.getEmail());
			 if(a2.size()!=0){				 
				 for(Reportevent r:a2) {
					 
					
						 jb=new  JSONObject();
						 jb.put("reportTime", formatter.format(r.getReportTime()));
						 jb.put("userName", us.get_userbyId(r.getUserId()).getName());
						 jb.put("point", r.getReportAreaPoint());
						 jb.put("reportWay", "邮箱举报");
						 if(r.getIsResolve()==1)
							 jb.put("isResolve", "yes");
						 else
							 jb.put("isResolve", "no");
						 j.add(jb);
					 
					 
									 		 
				 } 
			 }
			 ArrayList<Sms> a=(ArrayList<Sms>) ss.querySMS_3(userId);
		   	   if(a.size()!=0){		   		  
		   		for(Sms r:a) {
			   		 jb=new  JSONObject();
			   		 jb.put("reportTime", formatter.format(r.getReportTime()));
			   		 jb.put("userName", us.get_userbyId(r.getUserId()).getName());
			   		 jb.put("point", r.getReportAreaPoint());
			   		 jb.put("reportWay", "短信举报");
			   		if(r.getIsResolve()==1)
						 jb.put("isResolve", "yes");
					 else
						 jb.put("isResolve", "no");
					 j.add(jb);
			   	 }
		   	   }
		   	   printWriter.println(j);
		   	   
	    	
	    }
	    
	    
	    
	    
	    
	    @RequestMapping("/backstage/updateUserMsg")
		public void updateUserMsg(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter printWriter = response.getWriter();

		 Integer userId=(Integer)request.getSession().getAttribute("userId");
		 user=us.get_user(userId, null, null);
		 String homeAddress= request.getParameter("homeAddress");
		 String aboutMe= request.getParameter("aboutMe");
		 
//		 log.info(homeAddress+"===="+aboutMe+"++++++" );
		 
		 Addinfo ai=new Addinfo();
		 ai.setUserId(userId);
		 ai.setAboutMe(aboutMe);
		 ai.setAddress(homeAddress);
		 if(as.query_user(userId)!=null){
			 as.update_user(ai);
			 printWriter.println("更新成功");
			 
	    }else{
	    	as.add_user(ai);
	    	 printWriter.println("更新成功");
	    }
	    }
	  
	    
	    
	    
	    
	    
    @RequestMapping("/backstage/emailRecording")
	public void emailrecord(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter printWriter = response.getWriter();
	 	
	 Integer userId=(Integer)request.getSession().getAttribute("userId");
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   ArrayList<Reportevent> a=(ArrayList<Reportevent>) pe.getAllReport();
	 JSONArray j=new JSONArray();
	 JSONObject jb=null;
	 for(Reportevent r:a) {
		 jb=new  JSONObject();
		 jb.put("reportTime", formatter.format(r.getReportTime()));
	
		 jb.put("point", r.getReportAreaPoint());
		 jb.put("email", r.getHeadEmail());
		 jb.put("userId", r.getUserId());
		 jb.put("userName", us.get_userbyId(r.getUserId()).getName());
		 j.add(jb);
		 		 
	 }
//	log.info("================"+j.toJSONString());

	 
     printWriter.println(j);
	 
    }
    
    @RequestMapping("/backstage/SMSRecording")
   	public void SMSrecord(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
   	 response.setContentType("text/html;charset=UTF-8");
   	 PrintWriter printWriter = response.getWriter();

//   	 Integer userId=(Integer)request.getSession().getAttribute("userId");
   	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
   	   ArrayList<Sms> a=(ArrayList<Sms>) ss.queryALL();
   	 JSONArray j=new JSONArray();
   	 JSONObject jb=null;
   	 for(Sms r:a) {
   		 jb=new  JSONObject();
   		 jb.put("reportTime", formatter.format(r.getReportTime()));
   		
   		 jb.put("point", r.getReportAreaPoint());
   		 jb.put("phone", hs.get_headMsg(r.getHeadId()).getPhoneNum());
   		 jb.put("userId", r.getUserId());
   	
   		 jb.put("userName", us.get_userbyId(r.getUserId()).getName());
   		 j.add(jb);
   		 		 
   	 }
//   	log.info("================"+j.toJSONString());

   	 
        printWriter.println(j);
   	 
       }
    
    
    @RequestMapping("/backstage/setPwd")
    public void check_pwd(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
   	 response.setContentType("text/html;charset=UTF-8");
   	 PrintWriter printWriter = response.getWriter();
   	 Integer userId=(Integer)request.getSession().getAttribute("userId");
//   	log.info("+++=++++++++++++"+userId);
   	String opwd=request.getParameter("oldPwd");
   	String npwd=request.getParameter("newPwd");
   	String apwd=request.getParameter("surePwd");
 	log.info("+++=++++++++++++"+opwd+"  "+npwd+"  "+apwd);

     
     user=us.get_user(userId,null,null);
    if(!user.getPwd().equals(opwd)){
   	 printWriter.println("旧密码错误");
//   	 return null;
    }else if(!npwd.equals(apwd))
    {
   	 printWriter.println("密码不一致");
   	 
       }
    else {
    	user.setPwd(npwd);
        us.update_user(user);
        printWriter.println("修改成功");
    }
    }
    @RequestMapping("/backstage/persion3")
    public void check_out(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
    	HttpSession session = request.getSession(false);//防止创建Session   
    	if(session == null){    
    		response.sendRedirect("/hlw/index.html");    
    		return;   
    		}      
    	session.removeAttribute("userId");   
    	response.sendRedirect("/hlw/index.html");  
    	}
    
}