/**
 * 
 */
package com.icss.entity;

import java.util.Date;

/**
 *<p>Title:CourseVo</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月28日上午10:18:29
 */
public class CourseVo {
	private int coId;//课程编号
	private String coName;//课程名
	private String coScore;//学分
	private String coStatus;//属性
	private Date coStartTime;//学期开始时间
	private Date coEndTime;//学期结束时间
	private double score;//成绩
	private String status;//评估状态  1--评估    2--已评估 
	
	
	
	
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
