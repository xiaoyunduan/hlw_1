package com.example.demo.until;

import org.mybatis.spring.annotation.MapperScan;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserImpl;

@MapperScan("com.example.demo.dao")
public class Test {

	public static void main(String[] args) {		
	
		 String headName="a";
		 String dateString="b";
	     String cUser="c";
	     String point="d";
	     JSONObject json = new JSONObject();
		
		 json.put("point", point);
		 json.put("name1", headName);
		 json.put("time", dateString);
		 json.put("name2", cUser);
		 String content=json.toJSONString();
		 System.out.println(content);
			
		
		
	
	}
}
