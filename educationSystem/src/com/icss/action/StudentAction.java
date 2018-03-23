
package com.icss.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.icss.biz.StudentBiz;
import com.icss.entity.Course;
import com.icss.entity.CourseVo;
import com.icss.entity.EnCourse;
import com.icss.entity.Evaluation;
import com.icss.entity.Excourse;
import com.icss.entity.ExcourseVo;
import com.icss.entity.Grade;
import com.icss.entity.Question;
import com.icss.entity.Room;
import com.icss.entity.Sroll;
import com.icss.entity.Student;
import com.icss.entity.StudentNowCourseVo;
import com.icss.entity.Teacher;
import com.icss.entity.User;
import com.icss.util.PageList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *<p>Title:StudentAction</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017��9��27������9:10:57
 */
@Controller(value="studentAction")
public class StudentAction extends ActionSupport implements ModelDriven<Evaluation>{
	
	
	@Autowired
	@Qualifier(value="studentBiz")
	StudentBiz studentBiz;
	/*************              ������װ                   ************************/
	private String upwd;
	
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
     
	//���пγ̷�ҳ
	private PageList<Course> page = new PageList<Course>();
	
	public void setPage(PageList<Course> page) {
		this.page = page;
	}
	
	//����ɿγ̷�ҳ
	private PageList<CourseVo> pageVo = new PageList<CourseVo>();
     
	public void setPageVo(PageList<CourseVo> pageVo) {
		this.pageVo = pageVo;
	}
	
	//δ��ɿγ̷�ҳ
	private PageList<Course> pageUn = new PageList<Course>();
	
	public void setPageUn(PageList<Course> pageUn) {
		this.pageUn = pageUn;
	}
    
	//����ѡ�޿η�ҳ
	private PageList<ExcourseVo> pageEc = new PageList<ExcourseVo>();
	
	public void setPageEc(PageList<ExcourseVo> pageEc) {
		this.pageEc = pageEc;
	}

	//ѡ�޿�ID
	private int exId;

	public void setExId(int exId) {
		this.exId = exId;
	}
    //ajax�ж�ѡ�޿�
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//��ѯ�ɼ� 1-ͨ��   2-δͨ��
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	//�γ̱��--����ʹ��
	private int coid;
	
	public void setCoid(int coid) {
		this.coid = coid;
	}

	//����
	private Evaluation evaluation =  new Evaluation();
	public Evaluation getModel() {
		
		return this.evaluation;
	}
	/*************              ������װ                   ************************/
	
	/**
	 * ��ѯѧ�����е���Ϣ
	 */
	public String findStudent(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		try {
			
			//����ҵ���߼�
			Student student = studentBiz.findStudent(user.getUnumber());
			
			Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			
			//���ظ�ҳ��
			request.put("student", student);
			
			return "findStudentSuccess";

		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
		
	}
	
	
	/**
	 *��ѯѧ��
	 */
	public String findInfo(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
       try {
			
			//����ҵ���߼�
    	   Sroll sroll = studentBiz.findStudentInfo(user.getUnumber());
			
			Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			
			//���ظ�ҳ��
			request.put("sroll", sroll);
			
			return  "findSrollSuccess";
			
       } catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
		
	}
	
	/**
	 * �޸�ѧ������
	 */
	public  String  changePwd(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		//�޸��û�������
		user.setUpwd(upwd);
		
		try {
			
			//����������
			studentBiz.changeStudentPwd(user);
			
			//�Ƴ�session�е�User��Ϣ
			session.remove(user);
			
			//���ص�¼ҳ�棬���µ�¼
			return "changePwdSuccess";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
	}
	
	/**
	 * ��ѯ��ѧ�ڵĿγ�
	 */
	public String findNowCourse(){
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		
		try {
			List<StudentNowCourseVo> list = studentBiz.findStudentNowCourse(user);
            Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("nowList", list);
			
			return "nowCourseList";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	
	/**
	 * ��ҳ��ѯ���пγ�
	 */
	public String AllCourse(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
     
		try {
			
			//���õ�ǰҳ
			int currentPage=1;
			
			if(page.getCurrentPage()!= 0){
				
				currentPage=page.getCurrentPage();
			}
			
			page.setCurrentPage(currentPage);
			
			//����ҵ����
			page=(PageList<Course>) studentBiz.findAllCourse(page,5,user);
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			
			request.put("coursePage", page);
			
			return "pageCourseSuccess";
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
		
	}
	
	/**
	 * ��ҳ��ѯ����ɿγ�
	 */
	public String finishedCourse(){
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		     
		try {
			
			//���õ�ǰҳ
			int currentPage=1;
			
			if(pageVo.getCurrentPage()!= 0){
				
				currentPage=pageVo.getCurrentPage();
			}
			
			pageVo.setCurrentPage(currentPage);
			
			//��ȡ��ǰ����
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
			String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			
			//����ҵ����
			pageVo=(PageList<CourseVo>) studentBiz.finishedCourse(pageVo,5,user,time);
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			
			request.put("coursePage", pageVo);
			
			return "finishedCourse";
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
	}
	
	/**
	 * ��ҳ��ѯδ��ɵĿγ�
	 */
	public String undoneCourse(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		     
		try {
			
			//���õ�ǰҳ
			int currentPage=1;
			
			if(pageUn.getCurrentPage()!= 0){
				
				currentPage=pageUn.getCurrentPage();
			}
			
			pageUn.setCurrentPage(currentPage);
			
			//��ȡ��ǰ����
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
			String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			
			//����ҵ����
			pageUn=(PageList<Course>) studentBiz.undoneCourse(pageUn,5,user,time);
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			
			request.put("coursePage", pageUn);
			
			return "undoneCourse";
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
	}
	
	/**
	 * 
	 * ��ҳ��ѯ����ѡ�޿�
	 */
	public String elective(){
	
       try {
			
			//���õ�ǰҳ
			int currentPage=1;
			
			if(pageEc.getCurrentPage()!= 0){
				
				currentPage=pageEc.getCurrentPage();
			}
			
			pageEc.setCurrentPage(currentPage);
			
			//����ҵ����
			pageEc=(PageList<ExcourseVo>) studentBiz.findAllExcourse(pageEc,5);
			 
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			
			
			request.put("coursePage", pageEc);
			
			
			return "electiveList";
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
	}

	/**
	 * 
	 * ����ҵ�ѡ�޿�
	 */
	public String addMyExcourse(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		try {
				//����ҵ���߼�--���ѡ��
			String test = studentBiz.addMyExcourse(user, exId);
			
			msg="";
			
			if(test.equals("excoursed")){
				
				msg= "�Ѿ�ѡ�޹����ſγ�";
				
				Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				
				request.put("msg",msg);
				
				return  "testOver";
				
			}else if(test.equals("excourseFull")){
				
				msg="���ѡ���Ѵ��������";
				
                Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				
				request.put("msg", msg);
				
				return  "testOver";
				
			}else{
				
				 msg="ѡ�γɹ�";
				
				 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
					
				request.put("msg",msg );
				
				
				return "testOver";
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
		
	}
	
	
	
	/**
	 * 
	 * ��ѯ�ҵ�ѡ�޿�
	 */
	public String findMyExcourse(){
		
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		try {
			
			//����ҵ���߼�
			List<ExcourseVo> list = studentBiz.findMyExcourseVo(user);
			
			if(list != null && list.size()>0){
				
				 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
					
					request.put("excourseList", list);
				
			}else{
			
            Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			
			request.put("msgnull", "�㻹û��ѡ���κογ�");
			}
			
			return "myExcourseList";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
	}
	
	/**
	 * ��ѯ�ҵĳɼ�
	 */
	public String findMyGrade(){
		//��ȡsession�е�User����
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");	
		
		try {
			List<Grade> list = studentBiz.findMyGrade(user);
			if(list != null && list.size()>0){

				Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				
				request.put("gradeList", list);
				
				if(type.equals("1")){}
				
				if(type.equals("2")){//ͨ���ɼ�
					
					return  "myPassGrade";
					
				}
				
				if(type.equals("3")){//δͨ���ɼ�
					 
					
					  return "myFailGrade";
				}
			}else{
				
				 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
					
				request.put("grademsg", "��ʱû���κγɼ�Ŷ");
				
			}
			return "myGrade";
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	
	/**
	 * ��ѯ��������
	 */
	public String findQuestion(){
		
		try {
			//��������
			List<Question> list = studentBiz.findQuestion();
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("questionList", list);//���⼯��
			
			//�γ̺���ʦ
			
			//��ȡsession�е�User����
			Map<String,Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			
			Teacher teacher = studentBiz.findTeacherBycoIdclId(user, coid);
            request.put("coId", coid);//�γ̱��
			 request.put("teacher", teacher);//��ʦ
			
			return "findQuestionSuccess";
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

	/*
	 * ��ӽ�ѧ����
	 */
	public String addEvaluation(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		evaluation.setStNum(user.getUnumber());
		
		studentBiz.addEvaluation(evaluation);
		
		
		
		return "addEvaluationSuccess";
	}
	
}
