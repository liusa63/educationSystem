package com.icss.entity;

import java.util.HashSet;
import java.util.Set;
public class Major {
	private int maId;//רҵid
	private String maName;//רҵ����
	private Set<Sclass> sclasses=new HashSet<Sclass>();//רҵ�еİ༶����
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
