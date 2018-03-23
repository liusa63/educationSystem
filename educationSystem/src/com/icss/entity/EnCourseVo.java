package com.icss.entity;

import java.util.Date;

public class EnCourseVo {
	
	private String coName;//课程名
	private String coScore;//学分
	private String roName;//教室名称
	private String coWeek;//周次
	private String enDay;//星期
	private String enStart;//开始时间
	private String enEnd;//结束时间
	private Date coStartTime;//学期开始时间
	private Date coEndTime;//学期结束时间
	
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
	public String getRoName() {
		return roName;
	}
	public void setRoName(String roName) {
		this.roName = roName;
	}
	public String getCoWeek() {
		return coWeek;
	}
	public void setCoWeek(String coWeek) {
		this.coWeek = coWeek;
	}
	public String getEnDay() {
		return enDay;
	}
	public void setEnDay(String enDay) {
		this.enDay = enDay;
	}
	public String getEnStart() {
		return enStart;
	}
	public void setEnStart(String enStart) {
		this.enStart = enStart;
	}
	public String getEnEnd() {
		return enEnd;
	}
	public void setEnEnd(String enEnd) {
		this.enEnd = enEnd;
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
