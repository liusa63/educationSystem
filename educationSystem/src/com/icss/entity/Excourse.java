package com.icss.entity;

import java.util.HashSet;
import java.util.Set;


public class Excourse {
	private int exId;//ѡ��id
	private String exName;//ѡ�޿γ���
	private int teId;//��ʦ���
	private int exCount;//������
	private String exWeek;//�ܴ�
	private String exDay; //����
	private String exStart;//��ʼʱ��
	private String exEnd;//����ʱ��
	private int roId;//����
	private String exScore;//ѧ��
	private Set<Student> students= new HashSet<Student>();//ѧ������
	
	public int getExId() {
		return exId;
	}
	public void setExId(int exId) {
		this.exId = exId;
	}
	public String getExName() {
		return exName;
	}
	public void setExName(String exName) {
		this.exName = exName;
	}
	
	public int getTeId() {
		return teId;
	}
	public void setTeId(int teId) {
		this.teId = teId;
	}
	public String getExWeek() {
		return exWeek;
	}
	public void setExWeek(String exWeek) {
		this.exWeek = exWeek;
	}
	public String getExDay() {
		return exDay;
	}
	public void setExDay(String exDay) {
		this.exDay = exDay;
	}
	
	
	public String getExStart() {
		return exStart;
	}
	public void setExStart(String exStart) {
		this.exStart = exStart;
	}
	public String getExEnd() {
		return exEnd;
	}
	public void setExEnd(String exEnd) {
		this.exEnd = exEnd;
	}
	public int getRoId() {
		return roId;
	}
	public void setRoId(int roId) {
		this.roId = roId;
	}
	public String getExScore() {
		return exScore;
	}
	public void setExScore(String exScore) {
		this.exScore = exScore;
	}
	public int getExCount() {
		return exCount;
	}
	public void setExCount(int exCount) {
		this.exCount = exCount;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
