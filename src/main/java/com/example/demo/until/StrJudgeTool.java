package com.example.demo.until;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StrJudgeTool {
	
	public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }
	//检查一个字符串是否包含字母和数字
	public static boolean isLetterDigitOrChinese(String str) {
		  String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";
		  return str.matches(regex);
		 }
	
	public static boolean isLengthScope(String s){
		int l=s.length();
		if(l>=6&&l<=12){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(isLetterDigitOrChinese("vae0as"));
		
	}
}
