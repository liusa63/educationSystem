
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
 * @date: 2017年9月27日上午9:10:57
 */
@Controller(value="studentAction")
public class StudentAction extends ActionSupport implements ModelDriven<Evaluation>{
	
	
	@Autowired
	@Qualifier(value="studentBiz")
	StudentBiz studentBiz;
	/*************              参数封装                   ************************/
	private String upwd;
	
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
     
	//所有课程分页
	private PageList<Course> page = new PageList<Course>();
	
	public void setPage(PageList<Course> page) {
		this.page = page;
	}
	
	//已完成课程分页
	private PageList<CourseVo> pageVo = new PageList<CourseVo>();
     
	public void setPageVo(PageList<CourseVo> pageVo) {
		this.pageVo = pageVo;
	}
	
	//未完成课程分页
	private PageList<Course> pageUn = new PageList<Course>();
	
	public void setPageUn(PageList<Course> pageUn) {
		this.pageUn = pageUn;
	}
    
	//所有选修课分页
	private PageList<ExcourseVo> pageEc = new PageList<ExcourseVo>();
	
	public void setPageEc(PageList<ExcourseVo> pageEc) {
		this.pageEc = pageEc;
	}

	//选修课ID
	private int exId;

	public void setExId(int exId) {
		this.exId = exId;
	}
    //ajax判断选修课
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//查询成绩 1-通过   2-未通过
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	//课程编号--评估使用
	private int coid;
	
	public void setCoid(int coid) {
		this.coid = coid;
	}

	//评估
	private Evaluation evaluation =  new Evaluation();
	public Evaluation getModel() {
		
		return this.evaluation;
	}
	/*************              参数封装                   ************************/
	
	/**
	 * 查询学生表中的信息
	 */
	public String findStudent(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		try {
			
			//调用业务逻辑
			Student student = studentBiz.findStudent(user.getUnumber());
			
			Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			
			//返回给页面
			request.put("student", student);
			
			return "findStudentSuccess";

		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
		
	}
	
	
	/**
	 *查询学籍
	 */
	public String findInfo(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
       try {
			
			//调用业务逻辑
    	   Sroll sroll = studentBiz.findStudentInfo(user.getUnumber());
			
			Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			
			//返回给页面
			request.put("sroll", sroll);
			
			return  "findSrollSuccess";
			
       } catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
		
	}
	
	/**
	 * 修改学生密码
	 */
	public  String  changePwd(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		//修改用户的密码
		user.setUpwd(upwd);
		
		try {
			
			//保存新密码
			studentBiz.changeStudentPwd(user);
			
			//移除session中的User信息
			session.remove(user);
			
			//返回登录页面，重新登录
			return "changePwdSuccess";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
	}
	
	/**
	 * 查询本学期的课程
	 */
	public String findNowCourse(){
		//获取session中的User对象
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
	 * 分页查询所有课程
	 */
	public String AllCourse(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
     
		try {
			
			//设置当前页
			int currentPage=1;
			
			if(page.getCurrentPage()!= 0){
				
				currentPage=page.getCurrentPage();
			}
			
			page.setCurrentPage(currentPage);
			
			//调用业务处理
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
	 * 分页查询已完成课程
	 */
	public String finishedCourse(){
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		     
		try {
			
			//设置当前页
			int currentPage=1;
			
			if(pageVo.getCurrentPage()!= 0){
				
				currentPage=pageVo.getCurrentPage();
			}
			
			pageVo.setCurrentPage(currentPage);
			
			//获取当前日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time=df.format(new Date());// new Date()为获取当前系统时间
			
			//调用业务处理
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
	 * 分页查询未完成的课程
	 */
	public String undoneCourse(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		     
		try {
			
			//设置当前页
			int currentPage=1;
			
			if(pageUn.getCurrentPage()!= 0){
				
				currentPage=pageUn.getCurrentPage();
			}
			
			pageUn.setCurrentPage(currentPage);
			
			//获取当前日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time=df.format(new Date());// new Date()为获取当前系统时间
			
			//调用业务处理
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
	 * 分页查询所有选修课
	 */
	public String elective(){
	
       try {
			
			//设置当前页
			int currentPage=1;
			
			if(pageEc.getCurrentPage()!= 0){
				
				currentPage=pageEc.getCurrentPage();
			}
			
			pageEc.setCurrentPage(currentPage);
			
			//调用业务处理
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
	 * 添加我的选修课
	 */
	public String addMyExcourse(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		try {
				//调用业务逻辑--添加选修
			String test = studentBiz.addMyExcourse(user, exId);
			
			msg="";
			
			if(test.equals("excoursed")){
				
				msg= "已经选修过该门课程";
				
				Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				
				request.put("msg",msg);
				
				return  "testOver";
				
			}else if(test.equals("excourseFull")){
				
				msg="你的选课已达最大限制";
				
                Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				
				request.put("msg", msg);
				
				return  "testOver";
				
			}else{
				
				 msg="选课成功";
				
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
	 * 查询我的选修课
	 */
	public String findMyExcourse(){
		
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		try {
			
			//调用业务逻辑
			List<ExcourseVo> list = studentBiz.findMyExcourseVo(user);
			
			if(list != null && list.size()>0){
				
				 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
					
					request.put("excourseList", list);
				
			}else{
			
            Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			
			request.put("msgnull", "你还没有选修任何课程");
			}
			
			return "myExcourseList";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ERROR;
		}
		
	}
	
	/**
	 * 查询我的成绩
	 */
	public String findMyGrade(){
		//获取session中的User对象
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");	
		
		try {
			List<Grade> list = studentBiz.findMyGrade(user);
			if(list != null && list.size()>0){

				Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
				
				request.put("gradeList", list);
				
				if(type.equals("1")){}
				
				if(type.equals("2")){//通过成绩
					
					return  "myPassGrade";
					
				}
				
				if(type.equals("3")){//未通过成绩
					 
					
					  return "myFailGrade";
				}
			}else{
				
				 Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
					
				request.put("grademsg", "暂时没有任何成绩哦");
				
			}
			return "myGrade";
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	
	/**
	 * 查询评估问题
	 */
	public String findQuestion(){
		
		try {
			//评估问题
			List<Question> list = studentBiz.findQuestion();
			Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
			request.put("questionList", list);//问题集合
			
			//课程和老师
			
			//获取session中的User对象
			Map<String,Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			
			Teacher teacher = studentBiz.findTeacherBycoIdclId(user, coid);
            request.put("coId", coid);//课程编号
			 request.put("teacher", teacher);//老师
			
			return "findQuestionSuccess";
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

	/*
	 * 添加教学评估
	 */
	public String addEvaluation(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		evaluation.setStNum(user.getUnumber());
		
		studentBiz.addEvaluation(evaluation);
		
		
		
		return "addEvaluationSuccess";
	}
	
}
