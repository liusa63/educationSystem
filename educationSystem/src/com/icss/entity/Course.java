package com.icss.entity;

import java.util.Date;

public class Course {
	private int coId;//�γ�id
	private String coName;//�γ���
	private String coScore;//ѧ��
	private String coStatus;//����
	private int maId;//רҵ
	private String coWeek;//�ܴ�
	private Date coStartTime;//ѧ�ڿ�ʼʱ��
	private Date coEndTime;//ѧ�ڽ���ʱ��
	public int getCoId() {
		return coId;
	}
	public void setCoId(int coId) {
		this.coId = coId;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoScore() {
		return coScore;
	}
	public void setCoScore(String coScore) {
		this.coScore = coScore;
	}
	public String getCoStatus() {
		return coStatus;
	}
	public void setCoStatus(String coStatus) {
		this.coStatus = coStatus;
	}
	public int getMaId() {
		return maId;
	}
	public void setMaId(int maId) {
		this.maId = maId;
	}
	public String getCoWeek() {
		return coWeek;
	}
	public void setCoWeek(String coWeek) {
		this.coWeek = coWeek;
	}
	public Date getCoStartTime() {
		return coStartTime;
	}
	public void setCoStartTime(Date coStartTime) {
		this.coStartTime = coStartTime;
	}
	public Date getCoEndTime() {
		return coEndTime;
	}
	public void setCoEndTime(Date coEndTime) {
		this.coEndTime = coEndTime;
	}
	

	
	

}
