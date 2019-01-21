package com.example.demo.until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileOperatingTool {
	public static String readTxt(String filePath) {
		 
		  try {
		    File file = new File(filePath);
		    if(file.isFile() && file.exists()) {
		      InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		      BufferedReader br = new BufferedReader(isr);
		      String lineTxt = null;
		      StringBuilder sBuilder=new StringBuilder();
		      while ((lineTxt = br.readLine()) != null) {
		        sBuilder.append(lineTxt);
		      }
		      String s=sBuilder.toString();
		      br.close();
		      return s;
		     
		    } else {
		      System.out.println("文件不存在!");
		      return null;
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  }
		 
		  }
	
	
	public static File castMultipartFile2File(HttpServletRequest request,MultipartFile file) {
		File tempFile = null;
        if(!file.isEmpty()) {
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(filePath);
            if(! dir.exists()) {
                dir.mkdir();
            }

            String path = filePath + file.getOriginalFilename();
            
            //save to the /upload path
            try {
                tempFile =  new File(path);
                        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
                

            }catch(Exception e){
            	e.printStackTrace();
              
            }
        }
		return tempFile;
	}
	public static void main(String[] args) {
		
		System.out.println(readTxt("src/main/resources/static/pwdhtml.txt"));
	}
	
		 
}
