package com.icss.entity;

import java.util.HashSet;
import java.util.Set;
public class Major {
	private int maId;//专业id
	private String maName;//专业名称
	private Set<Sclass> sclasses=new HashSet<Sclass>();//专业中的班级集合
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
	public Set<Sclass> getSclasses() {
		return sclasses;
	}
	public void setSclasses(Set<Sclass> sclasses) {
		this.sclasses = sclasses;
	}
	
	

}
