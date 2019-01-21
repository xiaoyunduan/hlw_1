package com.example.demo.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.CountByExampleElementGenerator;

public class Statistics {

	Date d;
	int count;
	int Area_1;
	int Area_2;
	int Area_3;
	int Area_4;
	int Area_5;
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public ArrayList<Integer> statisticalData(){
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(getArea_1());
		l.add(getArea_2());
		l.add(getArea_3());
		l.add(getArea_4());
		l.add(getArea_5());
		return l;
	}
	
	
	public int getArea_1() {
		return Area_1;
	}
	public void setArea_1(int area_1) {
		Area_1 = area_1;
	}
	public int getArea_2() {
		return Area_2;
	}
	public void setArea_2(int area_2) {
		Area_2 = area_2;
	}
	public int getArea_3() {
		return Area_3;
	}
	public void setArea_3(int area_3) {
		Area_3 = area_3;
	}
	public int getArea_4() {
		return Area_4;
	}
	public void setArea_4(int area_4) {
		Area_4 = area_4;
	}
	public int getArea_5() {
		return Area_5;
	}
	public void setArea_5(int area_5) {
		Area_5 = area_5;
	}
	
}
