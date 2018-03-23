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
 * @date: 2017��10��9������6:40:15
 */
@Controller(value="adminLittleAction")
public class AdminLittleAction extends ActionSupport implements ModelDriven<Room>{
	
	@Autowired
	@Qualifier(value="adminLittleBiz")
	AdminLittleBiz adminLittleBiz;
	
	@Autowired
	@Qualifier(value="adminBiz")
	AdminBiz adminBiz;
	/*************              ������װ                   ************************/
	//�ж��Ƿ����רҵ�����
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	//רҵ��ҳ
	private PageList<Major> pageRo= new PageList<Major>();
	
	public void setPageRo(PageList<Major> pageRo) {
		this.pageRo = pageRo;
	}

	//רҵid
	private int maid;
	
	public void setMaid(int maid) {
		this.maid = maid;
	}
	//רҵ����
	private String maname;
	public void setManame(String maname) {
		this.maname = maname;
	}
	
	//����¼��רҵ
	private String [] maNames;
	public void setMaNames(String[] maNames) {
		this.maNames = maNames;
	}
	//��������
	private String roname;
	
	public void setRoname(String roname) {
		this.roname = roname;
	}
	//���н��ҷ�ҳ
	private PageList<Room> page = new PageList<Room>();
	
	public void setPage(PageList<Room> page) {
		this.page = page;
	}
	
	//��ѯָ������
	private int roid;
	
	public void setRoid(int roid) {
		this.roid = roid;
	}
	
	private Room room = new Room();
	public Room getModel() {
		return this.room;
	}
	
	/*************               ������װ                   ************************/
	
	
	/***************************************************************************/
	
	
	/*************               רҵ              ************************/
	//�ж�רҵ�Ƿ��Ѿ�����
	public String selectMajorIfExist(){
		
		 msg = adminLittleBiz.selectMajorIfExist(maname);

		return "ifExistMajor";
	}
	
	//���רҵ
	public String addMajor(){
		
		
		//��������
		Major major = new Major();
		major.setMaName(maname);//��ֵ
		
		try {
			//����ҵ���߼�
			adminLittleBiz.addMajor(major);
			//���ؽ��
			return "addMajorSuccess";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//�������
	public String addMoreMajor(){
		
		for(int i =0; i<maNames.length;i++){
			
				//��������
				Major major = new Major();
				major.setMaName(maNames[i]);//��ֵ
				try {
					//����ҵ���߼�
					adminLittleBiz.addMajor(major);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			
		}
		return "addMoreMajor";
		

	}
	
	//��ҳ��ѯ����רҵ
	public String findAllMajor(){
		try {
			
			//���õ�ǰҳ
			int currentPage=1;
			if(pageRo.getCurrentPage()!= 0){
				currentPage=pageRo.getCurrentPage();
			}
			pageRo.setCurrentPage(currentPage);
			
			//����ҵ����
			pageRo=(PageList<Major>) adminLittleBiz.findAllMajor(pageRo, 9);//ÿҳչʾ5����Ϣ
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("pageRo", pageRo);
			return "majorList";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
		
	}
	
	//��ѯָ��רҵ
	public String findMajorById(){
		//����ҵ���߼�
		Major major = adminBiz.selectByIdMajor(maid);
		if(major != null){
			
           Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("major", major);
			return  "major";
			
		}
		return  ERROR;
	}
	
	//����רҵ
	public String updateMajor(){
		//����ҵ���߼�
		Major major = adminBiz.selectByIdMajor(maid);
		//�޸�����
		major.setMaName(maname);
		//����ҵ���߼�
		adminLittleBiz.updateMajor(major);
		return "updateMajorSuccess";
	}
	
	//��ѯָ��רҵ�İ༶
	public String findClassByMajor(){
		//��ȡרҵ����
		Major major = adminBiz.selectByIdMajor(maid);
		//�༶����
		List<SclassTeacherVo> list = adminLittleBiz.findSclassByMajor(major);
		if(list != null && list.size()>0){
			
			 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			 request.put("sclassSet", list);
			 return "sclassSet";
			 
		}else{
			
			 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			 request.put("noClassMsg", "���ް༶��Ϣ");
			 return "sclassSet";
		}
		
	
		
	}
	
	/*************       רҵ              ************************/
	
	
	
	/***************************************************************************/
	
	
	
	
	/*************       ����              ************************/
	//��ҳ��ѯ���н���
	public String findAllRoom(){
	try {
			
			//���õ�ǰҳ
			int currentPage=1;
			if(page.getCurrentPage()!= 0){
				currentPage=page.getCurrentPage();
			}
			page.setCurrentPage(currentPage);
			
			//����ҵ����
			page=(PageList<Room>) adminLittleBiz.findAllRoom(page, 5);//ÿҳչʾ5����Ϣ
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("roomPage", page);
			return "pageRoomSuccess";
			 
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	
    //�жϽ����Ƿ��Ѿ�����
	public String selectRoomIfExist(){
		 msg = adminLittleBiz.selectRoomIfExist(roname);
		return "ifExistRoom";
	}
	
	//��ӽ���
	public String addRoom(){
		//��������
		Room room = new Room();
		room.setRoName(roname);//��ֵ
		
		try {
			//����ҵ���߼�
			adminLittleBiz.addRoom(room);
			return "addRoomSuccess";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//�������
	public String addMoreRoom(){
		
		for(int i =0; i<maNames.length;i++){
			
				//��������
				Room room = new Room();
				room.setRoName(maNames[i]);//��ֵ
				try {
					//����ҵ���߼�
					adminLittleBiz.addRoom(room);
					
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			
		}
		return "addMoreRoom";

	}

	//��ѯָ������
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
	
	//���½���
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

	
	/*************       ����              ************************/

}
