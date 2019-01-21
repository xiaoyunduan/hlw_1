package com.example.demo.controller;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.config.interceptors.LoginInterceptor;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Protectedarea;
import com.example.demo.model.Regionalhead;
import com.example.demo.model.Reportevent;
import com.example.demo.model.Sms;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;
import com.example.demo.service.EmailService;
import com.example.demo.service.HeadService;
import com.example.demo.service.ProtectedAreaService;
import com.example.demo.service.ReportEventService;
import com.example.demo.service.SMSService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserImpl;
import com.example.demo.until.AliyunMessageUtil;
import com.example.demo.until.FileOperatingTool;

@RequestMapping(value="hlw")
@Controller
public class MapController {
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	private ReportEventService rs;
	@Autowired
	private SMSService ss;
	@Autowired
	private ProtectedAreaService pas;
	@Autowired
	private UserService us;
	@Autowired
	private EmailService emailService;
	@Autowired
	private HeadService hs;
	
	@RequestMapping("/mapReport")
    public String login(){
        return "/map";
    }
	
	@RequestMapping("/backstage/reportPoint")
	public void reportPoint(HttpServletRequest request, HttpServletResponse response, User user, Model model) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			// String lng=request.getParameter("lng");
			 //String lat=request.getParameter("lat");
			 //int userId=Integer.parseInt((String) request.getSession().getAttribute("userId"));
			 int areaId=Integer.parseInt(request.getParameter("AreaId"));
			
			 Protectedarea pa=new Protectedarea();
			 pa.setAreaId(areaId);
			 int headId=pas.get_protectedArea(pa).getRegionalHeadId();
			 
			 user=us.get_user(headId, null, null);
			 Regionalhead  r=hs.get_headMsg(headId);
			 String headName=user.getName();
			 String headEmail=user.getEmail();
			 
			 log.info("++++++++++======"+r.getPhoneNum());
			 JSONObject json = new JSONObject();
			 json.put("headName", headName);
			 json.put("headEmail", headEmail);
			 json.put("headPhone", r.getPhoneNum());
			 printWriter.println(json);
			 
//			 Reportevent rep=new Reportevent();
//			 rep.setUserId(userId);
//			 rep.setReportAreaPoint(reportAreaPoint);
//			 rep.setEmailMsg("");
//			 rep.setReportTime(new Date());
//			 rs.add_reportEvent(rep);
//			 
			 
			 
		        
		
	}	
	

	@RequestMapping("/backstage/reportEvent")
	public void reportEventByEmail(HttpServletRequest request, HttpServletResponse response, Reportevent re, Model model) throws IOException, ServletException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			 String lng=request.getParameter("pointlng");
			 String lat=request.getParameter("pointlat");
			 String emailTo=request.getParameter("emailTo");
			
			 String reportMsg=request.getParameter("reportMsg");
			 log.info(emailTo+"---------------"+reportMsg);
			 String title=request.getParameter("subject");
			 int userId= (Integer)request.getSession().getAttribute("userId");
			 //int userId=Integer.parseInt((String) request.getSession().getAttribute("userId"));
			 JSONObject json = new JSONObject();
			 String point="("+lng+","+lat+")";
			 json.put("point", point);
			
//			 String point=json.toJSONString();
//    		 Part file=request.getPart("fileField"); 
    		
			 MultipartFile mfile = ((MultipartRequest) request).getFile("fileField");
			 File file=FileOperatingTool.castMultipartFile2File(request, mfile);
    		 
			 re=new Reportevent();
			 re.setEmailMsg(reportMsg);
			 re.setReportTime(new Date());
			 re.setTitle(title);
			 re.setUserId(userId);
			 re.setEmailMsg(reportMsg);
			 re.setHeadEmail(emailTo);
			 //emailTo="1269997242@qq.com";
			 re.setIsResolve(0);
			 re.setReportAreaPoint(point);

			 emailService.sendAttachmentsEmail(emailTo, title, reportMsg, file,mfile.getOriginalFilename());
			 rs.add_reportEventbySelect(re);
			 printWriter.println("发送成功");
			 
//	
//			 
			 
	}
	
	@RequestMapping("/sms")
    public String SMS(){
        return "/SMS";
    }
	
	@RequestMapping("/backstage/reportEventbySMS")
	public void reportEventBySMS(HttpServletRequest request, HttpServletResponse response, Reportevent re, Model model) throws IOException, ServletException {
		 response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			
			 
			
			 String lng=request.getParameter("pointlng2");
			 String lat=request.getParameter("pointlat2");
			 String headName=request.getParameter("headname2");
			 String SMSmsg=request.getParameter("SMSMsg");
			 String pNTo=request.getParameter("headPhone");
			 String cUser=(String) request.getSession().getAttribute("cUser");
			 Date currentTime = new Date();  
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			 String dateString = formatter.format(currentTime);
			 String title=request.getParameter("subject");
			 int userId= (Integer)request.getSession().getAttribute("userId");
			 //int userId=Integer.parseInt((String) request.getSession().getAttribute("userId"));
			 JSONObject json = new JSONObject();
			 String point="("+lng+","+lat+")";
			 json.put("lng", lng);
			 json.put("lat", lat);
			 json.put("name1", headName);
			 json.put("time", dateString);
			 json.put("name2", cUser);
			 json.put("msg", SMSmsg);
			 String content=json.toJSONString();
			 log.info("++++++++++======"+content+"========"+pNTo);

			 try {
				AliyunMessageUtil.sendMsg(pNTo, content);
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Sms  sms=new Sms();
			 int headId=hs.get_headMsg_2(pNTo).getRegionalHeadId();
			 sms.setHeadId(headId);
			 sms.setContent(SMSmsg);
			 sms.setReportTime(currentTime);
			 sms.setUserId(userId);
			 sms.setReportAreaPoint(point);
			
			 ss.addSMS(sms);
			 
			 printWriter.println("发送成功");
			 
//	
//			 
			 
	}		 
		        
		
		
	
	
}
