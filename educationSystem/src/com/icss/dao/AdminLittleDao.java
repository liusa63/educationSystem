/**
 * 
 */
package com.icss.dao;

import java.util.List;
import java.util.Set;

import com.icss.entity.Major;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Student;
import com.icss.util.SclassTeacherVo;

/**
 *<p>Title:AdminLittleDao</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年10月9日下午6:42:24
 */
public interface AdminLittleDao {
	
	//判断专业是否存在
	public String selectMajorIfExist(String maName);
	
	//添加专业
	public void addMajor(Major major);
	
	//更新专业
	public void updateMajor(Major major);
	
	//分页查询专业
	public List<Major> findAllMajor(int beginPage, int max);

	//专业总数
	public int allMajor();

	//专业下的班级VO
	public List<SclassTeacherVo> findSclassByMajor(Major major);
	
	//判断教室是否存在
	public String selectRoomIfExist(String roName);
		
	//添加教室
	public void addRoom(Room room);
	
	//分页查询所有教室
	public List<Room> findAllRoom(int begin,int max) ;
	
	//教室总数
	public int allRoom();
	
	//查询指定教室
	public Room findRoomById(int id);
	
	//更新指定教室
	public void updateRoom(Room room);

	
}
