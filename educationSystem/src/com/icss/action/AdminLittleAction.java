/**
 * 
 */
package com.icss.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.icss.biz.AdminBiz;
import com.icss.biz.AdminLittleBiz;
import com.icss.entity.Major;
import com.icss.entity.Room;
import com.icss.util.PageList;
import com.icss.util.SclassTeacherVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *<p>Title:AdminLittleAction</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年10月9日下午6:40:15
 */
@Controller(value="adminLittleAction")
public class AdminLittleAction extends ActionSupport implements ModelDriven<Room>{
	
	@Autowired
	@Qualifier(value="adminLittleBiz")
	AdminLittleBiz adminLittleBiz;
	
	@Autowired
	@Qualifier(value="adminBiz")
	AdminBiz adminBiz;
	/*************              参数封装                   ************************/
	//判断是否存在专业或教室
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	//专业分页
	private PageList<Major> pageRo= new PageList<Major>();
	
	public void setPageRo(PageList<Major> pageRo) {
		this.pageRo = pageRo;
	}

	//专业id
	private int maid;
	
	public void setMaid(int maid) {
		this.maid = maid;
	}
	//专业名称
	private String maname;
	public void setManame(String maname) {
		this.maname = maname;
	}
	
	//批量录入专业
	private String [] maNames;
	public void setMaNames(String[] maNames) {
		this.maNames = maNames;
	}
	//教室名称
	private String roname;
	
	public void setRoname(String roname) {
		this.roname = roname;
	}
	//所有教室分页
	private PageList<Room> page = new PageList<Room>();
	
	public void setPage(PageList<Room> page) {
		this.page = page;
	}
	
	//查询指定教室
	private int roid;
	
	public void setRoid(int roid) {
		this.roid = roid;
	}
	
	private Room room = new Room();
	public Room getModel() {
		return this.room;
	}
	
	/*************               参数封装                   ************************/
	
	
	/***************************************************************************/
	
	
	/*************               专业              ************************/
	//判断专业是否已经存在
	public String selectMajorIfExist(){
		
		 msg = adminLittleBiz.selectMajorIfExist(maname);

		return "ifExistMajor";
	}
	
	//添加专业
	public String addMajor(){
		
		
		//创建对象
		Major major = new Major();
		major.setMaName(maname);//赋值
		
		try {
			//调用业务逻辑
			adminLittleBiz.addMajor(major);
			//返回结果
			return "addMajorSuccess";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//批量添加
	public String addMoreMajor(){
		
		for(int i =0; i<maNames.length;i++){
			
				//创建对象
				Major major = new Major();
				major.setMaName(maNames[i]);//赋值
				try {
					//调用业务逻辑
					adminLittleBiz.addMajor(major);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			
		}
		return "addMoreMajor";
		

	}
	
	//分页查询所有专业
	public String findAllMajor(){
		try {
			
			//设置当前页
			int currentPage=1;
			if(pageRo.getCurrentPage()!= 0){
				currentPage=pageRo.getCurrentPage();
			}
			pageRo.setCurrentPage(currentPage);
			
			//调用业务处理
			pageRo=(PageList<Major>) adminLittleBiz.findAllMajor(pageRo, 9);//每页展示5条信息
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("pageRo", pageRo);
			return "majorList";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
		
	}
	
	//查询指定专业
	public String findMajorById(){
		//调用业务逻辑
		Major major = adminBiz.selectByIdMajor(maid);
		if(major != null){
			
           Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("major", major);
			return  "major";
			
		}
		return  ERROR;
	}
	
	//更新专业
	public String updateMajor(){
		//调用业务逻辑
		Major major = adminBiz.selectByIdMajor(maid);
		//修改名称
		major.setMaName(maname);
		//调用业务逻辑
		adminLittleBiz.updateMajor(major);
		return "updateMajorSuccess";
	}
	
	//查询指定专业的班级
	public String findClassByMajor(){
		//获取专业对象
		Major major = adminBiz.selectByIdMajor(maid);
		//班级集合
		List<SclassTeacherVo> list = adminLittleBiz.findSclassByMajor(major);
		if(list != null && list.size()>0){
			
			 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			 request.put("sclassSet", list);
			 return "sclassSet";
			 
		}else{
			
			 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			 request.put("noClassMsg", "暂无班级信息");
			 return "sclassSet";
		}
		
	
		
	}
	
	/*************       专业              ************************/
	
	
	
	/***************************************************************************/
	
	
	
	
	/*************       教室              ************************/
	//分页查询所有教室
	public String findAllRoom(){
	try {
			
			//设置当前页
			int currentPage=1;
			if(page.getCurrentPage()!= 0){
				currentPage=page.getCurrentPage();
			}
			page.setCurrentPage(currentPage);
			
			//调用业务处理
			page=(PageList<Room>) adminLittleBiz.findAllRoom(page, 5);//每页展示5条信息
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("roomPage", page);
			return "pageRoomSuccess";
			 
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	
    //判断教室是否已经存在
	public String selectRoomIfExist(){
		 msg = adminLittleBiz.selectRoomIfExist(roname);
		return "ifExistRoom";
	}
	
	//添加教室
	public String addRoom(){
		//创建对象
		Room room = new Room();
		room.setRoName(roname);//赋值
		
		try {
			//调用业务逻辑
			adminLittleBiz.addRoom(room);
			return "addRoomSuccess";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//批量添加
	public String addMoreRoom(){
		
		for(int i =0; i<maNames.length;i++){
			
				//创建对象
				Room room = new Room();
				room.setRoName(maNames[i]);//赋值
				try {
					//调用业务逻辑
					adminLittleBiz.addRoom(room);
					
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			
		}
		return "addMoreRoom";

	}

	//查询指定教室
	public String findRoomById(){
		
		 try {
			 
			Room room = adminLittleBiz.findRoomById(roid);
			if(room != null){
				
	            Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				request.put("room", room);
				return "room";
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	 return ERROR;
	}
	
	//更新教室
	public String updateRoom(){
		
		try {
			adminLittleBiz.updateRoom(room);
			return "updateRoomSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
	}

	
	/*************       教室              ************************/

}
