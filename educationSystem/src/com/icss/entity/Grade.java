package com.icss.entity;

/**
 *<p>Title:Grade</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月28日下午2:14:57
 */
public class Grade {
	private int grId;//主键
	private String stNum;//学号
	private String coName;//课程名
	private Double score;//分数
	
	
	public int getGrId() {
		return grId;
	}
	public void setGrId(int grId) {
		this.grId = grId;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	
	
	

}
