/**
 * 
 */
package com.icss.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.AdminLittleBiz;
import com.icss.dao.AdminDao;
import com.icss.dao.AdminLittleDao;
import com.icss.entity.Major;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Teacher;
import com.icss.util.PageList;
import com.icss.util.SclassTeacherVo;

/**
 *<p>Title:AdminLittleBizImpl</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年10月9日下午6:42:03
 */
@Service(value="adminLittleBiz")
public class AdminLittleBizImpl implements AdminLittleBiz {
	
	@Autowired
	@Qualifier(value = "adminLittleDao")
	AdminLittleDao adminLittleDao;
	
	
	/* 
	 * 判断专业是否已经存在
	 */
	public String selectMajorIfExist(String maName) {
		
		return adminLittleDao.selectMajorIfExist(maName);
	}
	

	/*
	 * 添加专业
	 */
	public void addMajor(Major major) {
		adminLittleDao.addMajor(major);
		
	}
	
	/*
	 * 修改专业
	 */
	public void updateMajor(Major major) {
		
		adminLittleDao.updateMajor(major);
	}
	
	
	//专业下的班级VO
	public List<SclassTeacherVo> findSclassByMajor(Major major){
		
		return adminLittleDao.findSclassByMajor(major);
		
	}

	
	/* 
	 * 判断专业是否已经存在
	 */
	public String selectRoomIfExist(String roName) {
		
		return adminLittleDao.selectRoomIfExist(roName);
	}
	
	/* 
	 * 添加教室
	 */
	public void addRoom(Room room) {
		adminLittleDao.addRoom(room);
		
	}
   
	/* 
	 *分页查询所有专业 
	 */
	public PageList<Major> findAllMajor(PageList<Major> page, int max) {
		//计算当前页
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<Major> rooms = adminLittleDao.findAllMajor(beginPage, max);
		
		page.setList(rooms);
		
		//获取总条数
		int countCourse=adminLittleDao.allMajor();
		page.setTotalNum(countCourse);
		
		//计算总页数
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;
		
	}



	/* 
	 *分页查询所有教室
	 */
	public PageList<Room> findAllRoom(PageList<Room> page, int max) {
		
		//计算当前页
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<Room> rooms = adminLittleDao.findAllRoom(beginPage, max);
		
		page.setList(rooms);
		
		//获取总条数
		int countCourse=adminLittleDao.allRoom();
		page.setTotalNum(countCourse);
		
		//计算总页数
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;
	}

	/* 
	 * 查询指定教室
	 */
	public Room findRoomById(int id) {
		
		return adminLittleDao.findRoomById(id);
	}

	/* 
	 * 更新教室
	 */
	public void updateRoom(Room room) {
		
		adminLittleDao.updateRoom(room);
	}


	

	

	
	
	
	
	
	
		
}
