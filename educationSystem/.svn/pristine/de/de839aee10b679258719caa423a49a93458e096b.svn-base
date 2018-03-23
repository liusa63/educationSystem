/**
 * 
 */
package com.icss.biz;

import java.util.List;

import com.icss.entity.Major;
import com.icss.entity.Room;
import com.icss.util.PageList;
import com.icss.util.SclassTeacherVo;

/**
 *<p>Title:AdminLittleBiz</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年10月9日下午6:40:47
 */
public interface AdminLittleBiz {
	
	  //判断专业是否存在
	  public String selectMajorIfExist(String maName);
	
	    //添加专业
		public void addMajor(Major major);
		
		//更新专业
		public void updateMajor(Major major);
		
		//分页查询所有专业
		public PageList<Major> findAllMajor(PageList<Major> pageRo, int i);

		
		//专业下的班级VO
		public List<SclassTeacherVo> findSclassByMajor(Major major);
		
		 //判断教室是否存在
		 public String selectRoomIfExist(String roName);
		
		//添加教室
		public void addRoom(Room room);

		
		//分页查询所有教室
		public PageList<Room> findAllRoom(PageList<Room> page,int max);
		
		//查询指定教室
		public Room findRoomById(int id);
		
		//更新指定教室
		public void updateRoom(Room room);


}
