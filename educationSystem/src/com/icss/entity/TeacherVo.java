package com.icss.entity;
/**
 * 
 * <p>Title:TeacherVo</p>
 * <P>Description:</p>
 * <p>Company:</p>
 * @author Administrator
 * @date2017-9-30上午9:17:02
 */
public class TeacherVo {
	// 两表联查显示教师的信息--包括专业名称
	private int teId;// 教师id
	private String teNum;// 教师工号
	private String teName;// 教师名称
	private Double teSalary;// 工资
	private String tePhone;// 电话
	private String teBehave;// 身份
	private String teImg;// 照片
	private int maId;// 专业id
	private String maName;// 专业名称
	
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
	public String getTeImg() {
		return teImg;
	}
	public void setTeImg(String teImg) {
		this.teImg = teImg;
	}
	public int getMaId() {
		return maId;
	}
	public void setMaId(int maId) {
		this.maId = maId;
	}
	public String getMaName() {
		return maName;
	}
	public void setMaName(String maName) {
		this.maName = maName;
	}

	

}
