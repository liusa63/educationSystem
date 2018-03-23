package com.icss.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Student {
	private int stId; //id
	private String stNum;  //学号
	private String stName; //姓名
	private String stBehave; //身份
	private Sclass sclass;//班级
	private Set<Excourse>  exCourses = new HashSet<Excourse>();//选修课集合
	
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStBehave() {
		return stBehave;
	}
	public void setStBehave(String stBehave) {
		this.stBehave = stBehave;
	}
	public Sclass getSclass() {
		return sclass;
	}
	public void setSclass(Sclass sclass) {
		this.sclass = sclass;
	}
	public Set<Excourse> getExCourses() {
		return exCourses;
	}
	public void setExCourses(Set<Excourse> exCourses) {
		this.exCourses = exCourses;
	}
	
	
	
	
	
	
	

}
