package com.icss.entity;

import java.util.HashSet;
import java.util.Set;



public class Sclass {
	private int clId; //�༶id
	private String clName; //�༶����
	private int clCount; //�༶����
	private int teId;//��ʦid
	private Set<Student> students=new HashSet<Student>();//ѧ������
	private Major major;//�༶��Ӧ��רҵ
	public int getClId() {
		return clId;
	}
	public void setClId(int clId) {
		this.clId = clId;
	}
	public String getClName() {
		return clName;
	}
	public void setClName(String clName) {
		this.clName = clName;
	}
	public int getClCount() {
		return clCount;
	}
	public void setClCount(int clCount) {
		this.clCount = clCount;
	}
	
	public int getTeId() {
		return teId;
	}
	public void setTeId(int teId) {
		this.teId = teId;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	

}