package com.icss.entity;

public class Teacher {
	private int teId;// 教师id

	private String teNum;// 教师工号
	private String teName;// 教师名称
	private Double teSalary;// 工资
	private String tePhone;// 电话
	private String teBehave;// 身份
	private int maId;// 专业id

	public int getTeId() {
		return teId;
	}

	public void setTeId(int teId) {
		this.teId = teId;
	}

	public String getTeNum() {
		return teNum;
	}

	public void setTeNum(String teNum) {
		this.teNum = teNum;
	}

	public String getTeName() {
		return teName;
	}

	public void setTeName(String teName) {
		this.teName = teName;
	}

	public Double getTeSalary() {
		return teSalary;
	}

	public void setTeSalary(Double teSalary) {
		this.teSalary = teSalary;
	}

	public String getTePhone() {
		return tePhone;
	}

	public void setTePhone(String tePhone) {
		this.tePhone = tePhone;
	}

	public String getTeBehave() {
		return teBehave;
	}

	public void setTeBehave(String teBehave) {
		this.teBehave = teBehave;
	}

	public int getMaId() {
		return maId;
	}

	public void setMaId(int maId) {
		this.maId = maId;
	}

}
