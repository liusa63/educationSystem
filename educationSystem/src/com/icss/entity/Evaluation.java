package com.icss.entity;

public class Evaluation {
	//评估表
	private int id;
	private int answer1;
	private int answer2;
	private int answer3;
	private int answer4;
	private int answer5;
	private int coId;//课程id
	private int teId;//教师id
	private String stNum;//学生id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAnswer1() {
		return answer1;
	}
	public void setAnswer1(int answer1) {
		this.answer1 = answer1;
	}
	public int getAnswer2() {
		return answer2;
	}
	public void setAnswer2(int answer2) {
		this.answer2 = answer2;
	}
	public int getAnswer3() {
		return answer3;
	}
	public void setAnswer3(int answer3) {
		this.answer3 = answer3;
	}
	public int getAnswer4() {
		return answer4;
	}
	public void setAnswer4(int answer4) {
		this.answer4 = answer4;
	}
	public int getAnswer5() {
		return answer5;
	}
	public void setAnswer5(int answer5) {
		this.answer5 = answer5;
	}
	public int getCoId() {
		return coId;
	}
	public void setCoId(int coId) {
		this.coId = coId;
	}
	public int getTeId() {
		return teId;
	}
	public void setTeId(int teId) {
		this.teId = teId;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
    

	
}
