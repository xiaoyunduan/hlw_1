package com.example.demo.controller;



import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.interceptors.LoginInterceptor;
import com.example.demo.model.Statistics;
import com.example.demo.model.User;
import com.example.demo.service.SMSService;
import com.example.demo.service.StaticService;
import com.mysql.fabric.xmlrpc.base.Array;

@RequestMapping(value="hlw")
@Controller
public class StatisticsController {
	@Autowired
	private StaticService ss;
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	
	
	@RequestMapping("/backstage/statistics")
	public void statistics(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		ArrayList<Statistics> elist=ss.queryEmail();
		ArrayList<Statistics> slist=ss.querySMS();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//	    String dateString =null;
	    ArrayList<String>d=new ArrayList<String>();
	    ArrayList<Integer>sum=new ArrayList<Integer>();
	    float []Proportion1=new float[5];
	    ArrayList<String>Proportion2=new ArrayList<String>();
	    Integer[][] areasData=new Integer[5][7];
	    
	    Collections.reverse(elist);
	    Collections.reverse(slist);
	    Iterator iter1 = elist.iterator();
	    Iterator iter2 = slist.iterator();
	    int[] a={0,0,0,0,0};
	    int i=0;
	    while(iter1.hasNext()&&iter2.hasNext()){

	       Statistics s1 =(Statistics) iter1.next();
	       Statistics s2 =(Statistics) iter2.next();
	       d.add(formatter.format(s1.getD()));
			sum.add(s1.getCount()+s2.getCount());
			areasData[0][i]= s1.getArea_1()+s2.getArea_1();
			areasData[1][i]= s1.getArea_2()+s2.getArea_2();
			areasData[2][i]= s1.getArea_3()+s2.getArea_3();
			areasData[3][i]= s1.getArea_4()+s2.getArea_4();
			areasData[4][i]= s1.getArea_5()+s2.getArea_5();			
			a[0]+=areasData[0][i];
			a[1]+=areasData[1][i];
			a[2]+=areasData[2][i];
			a[3]+=areasData[3][i];
			a[4]+=areasData[4][i];
//			log.info(Integer.toString(s2.getArea_2()));
			i++;
	    }
	    int t=a[0]+a[1]+a[2]+a[3]+a[4];
	    NumberFormat numberFormat = NumberFormat.getInstance();
	    
		// 设置精确到小数点后2位
 
		numberFormat.setMaximumFractionDigits(2);
		JSONObject json = new JSONObject();
		String r ;
		if(t!=0){
		for(i=0;i<5;i++){		
			r= numberFormat.format((float) a[i] / (float) t * 100);
			Proportion1[i]=Float.parseFloat(r);
			Proportion2.add(r+"%");
		}
		
		JSONArray arry1=(JSONArray) JSONArray.toJSON(sum);
		JSONArray arry2=(JSONArray) JSONArray.toJSON(d);
		JSONArray arry3=(JSONArray) JSONArray.toJSON(areasData);
		json.put("sum", arry1);
		json.put("dates", arry2);
		json.put("areasData", arry3);
		json.put("p1", Proportion1);
		json.put("p2", Proportion2);
		printWriter.println(json);
	
		}else{
			json.put("err", "近七天无数据");
			printWriter.println(json);
			log.info(json.toJSONString());
			
		}
		
		
		
		
		
	}
	
	
	}
