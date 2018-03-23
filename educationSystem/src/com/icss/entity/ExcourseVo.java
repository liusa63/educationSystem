/**
 * 
 */
package com.icss.entity;

/**
 *<p>Title:ExcourseVo</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月29日下午8:41:10
 */
public class ExcourseVo {
	private int exId;//选课id
	private String exName;//选修课程名
	private int teId;//老师外键
	private String teName;//老师名称
	private int exCount;//课余量
	private String exWeek;//周次
	private String exDay; //星期
	private String exStart;//开始时间
	private String exEnd;//结束时间
	private int roId;//教室
	private String roName;//教室名
	private String exScore;//学分
	private double grade;//成绩
	
	
	
	public String getTeName() {
		return teName;
	}
	public void setTeName(String teName) {
		this.teName = teName;
	}
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
	public int getExCount() {
		return exCount;
	}
	public void setExCount(int exCount) {
		this.exCount = exCount;
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
	public String getRoName() {
		return roName;
	}
	public void setRoName(String roName) {
		this.roName = roName;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
	

}
