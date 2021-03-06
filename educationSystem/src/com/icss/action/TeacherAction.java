package com.icss.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Course;
import com.icss.entity.EnCourseVo;
import com.icss.entity.EvaluationVo;
import com.icss.entity.Excourse;
import com.icss.entity.ExcourseVo;
import com.icss.entity.Grade;
import com.icss.entity.Question;
import com.icss.entity.Sclass;
import com.icss.entity.Student;
import com.icss.entity.Teacher;
import com.icss.entity.TeacherVo;
import com.icss.entity.User;
import com.icss.util.PageList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * <p>
 * Title:TeacherAction
 * </p>
 * <P>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author jby
 * @date2017-9-27下午3:00:00
 */
@Controller(value = "teacherAction")
public class TeacherAction extends ActionSupport implements
		ModelDriven<Teacher> {

	@Autowired
	@Qualifier(value = "teacherBiz")
	TeacherBiz teacherBiz;

	private Teacher teacher = new Teacher();

	public Teacher getModel() {
		return this.teacher;
	}

	// 封装repwds，修改密码
	private String repwds;

	public void setRepwds(String repwds) {
		this.repwds = repwds;
	}

	// 封装page，分页查询所有必修课程
	private PageList<EnCourseVo> page = new PageList<EnCourseVo>();

	public void setPage(PageList<EnCourseVo> page) {
		this.page = page;
	}

	// 封装pageEva，分页查询所有课程
	private PageList<EvaluationVo> pageEva = new PageList<EvaluationVo>();

	public void setPageEva(PageList<EvaluationVo> pageEva) {
		this.pageEva = pageEva;
	}

	// 封装课程集合coList
	private List<Course> coList;

	public List<Course> getCoList() {
		return coList;
	}

	public void setCoList(List<Course> coList) {
		this.coList = coList;
	}

	// 封装coid，目的是根据课程id获取到班级集合
	private int coid;

	public void setCoid(int coid) {
		this.coid = coid;
	}

	// 封装scList，班级集合
	private List<Sclass> scList;

	public void setScList(List<Sclass> scList) {
		this.scList = scList;
	}

	public List<Sclass> getScList() {
		return scList;
	}

	// 封装班级id
	private int clid;

	public void setClid(int clid) {
		this.clid = clid;
	}

	// 封装学生集合
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	// 封装分数
	private Grade grade;

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	// 封装msg
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// 封装pageGrade，分页查询所有课程
	private PageList<Grade> pageGrade = new PageList<Grade>();

	public void setPageGrade(PageList<Grade> pageGrade) {
		this.pageGrade = pageGrade;
	}

	// 封装scList，班级集合
	private List<Grade> grList;

	public List<Grade> getGrList() {
		return grList;
	}

	public void setGrList(List<Grade> grList) {
		this.grList = grList;
	}

	// 封装pageEx，分页查询所有必修课程
	private PageList<ExcourseVo> pageEx = new PageList<ExcourseVo>();
	public void setPageEx(PageList<ExcourseVo> pageEx) {
		this.pageEx = pageEx;
	}

	
	//封装选修课程集合exList------异步刷新需要生成setter() getter()方法
	private List<Excourse> exList;
	public List<Excourse> getExList() {
		return exList;
	}

	public void setExList(List<Excourse> exList) {
		this.exList = exList;
	}
	
	//封装选修某门课的学生集合stuList
	private Set<Student> stuList;
	public void setStuList(Set<Student> stuList) {
		this.stuList = stuList;
	}
	public Set<Student> getStuList() {
		return stuList;
	}

	//封装参数exname用于获取选修某门课的学生集合
	private int exid;
	public int getExid() {
		return exid;
	}

	public void setExid(int exid) {
		this.exid = exid;
	}
	
	
	// 封装msg1
	private String msg1;
	public String getMsg1() {
		return msg1;
	}

	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}

	/**
	 * 查看教师信息
	 * 
	 * @return
	 */
	public String findTeacher() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		TeacherVo teacherVo = null;

		try {
			teacherVo = teacherBiz.findTeacher(user.getUnumber());
		} catch (Exception e) {
			e.printStackTrace();
		    return ERROR;
		}

		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("teacherVo", teacherVo);

		if ((teacherVo.getTeBehave().equals("2"))) {
			return "findHeadmaster";// 班主任首页
		}

		return "findTeacher";// 教师首页

	}

	public String findTeacherDetail() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		TeacherVo teacherVo = null;

		try {
			teacherVo = teacherBiz.findTeacher(user.getUnumber());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("teacherVo", teacherVo);

		if ((teacherVo.getTeBehave().equals("2"))) {
			return "findHeadmasterDetail";// 班主任详细信息
		}

		return "findTeacherDetail";// 讲师详细信息

	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	public String updatePwd() {

		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		// 修改密码
		user.setUpwd(repwds);

		try {
			teacherBiz.updatePwd(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "updatePwdSuccess";

	}

	/**
	 * 分页显示教师的所有必修课表
	 */
	public String pageCourse() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		int currentPage = 1;
		if (page.getCurrentPage() != 0) {
			currentPage = page.getCurrentPage();
		}
		page.setCurrentPage(currentPage);

		// 调用业务逻辑
		try {
			page = teacherBiz.findPageCourse(page, 4, user.getUnumber());
			if(page.getList().size()==0){
				request.put("msg", "这学期没有您的必修课程");
				return "pageCourseFail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return ERROR;
		}

	
		request.put("tcPage", page);

		return "pageCourseSuccess";

	}

	/**
	 * 分页显示教师的教学评估
	 */
	public String pageEva() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		List<Question> questions = teacherBiz.selectQuestion();
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		int currentPage = 1;
		if (pageEva.getCurrentPage() != 0) {
			currentPage = pageEva.getCurrentPage();
		}
		pageEva.setCurrentPage(currentPage);

		// 调用业务逻辑
		try {
			pageEva = teacherBiz.findPageEva(pageEva, 4, user.getUnumber());
			if(pageEva.getList()!=null&&pageEva.getList().size()>0 &&pageEva.getList().get(0).getAnswer1()!=null){
				request.put("evaPage", pageEva);
				request.put("questions", questions);

				return "pageEvaSuccess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return ERROR;
		}

		
		request.put("questions", questions);
		request.put("msg", "当前还没有评估喔");
		return "pageEvaFail";
		
		

	}

	/**
	 * 教师根据课程录入必修成绩 
	 *  1.查出教师所带课程
	 *  2.根据课程找到班级 
	 *  3.根据班级找到学生集合
	 *  4.遍历学生集合添加成绩 
	 *  5.分页显示成绩
	 * 
	 * @return
	 */
	public String selectAllCourses() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		try {
			coList = teacherBiz.findCourseList(user.getUnumber());
           
			/*
			 * for(Course s:coList){ System.out.println(s.getCoName()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			 return ERROR;
		}
		return "selectAllCourses";

	}

	/**
	 * 2.根据课程找到班级
	 * 
	 * @return
	 */
	public String selectAllSclass() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		try {
			scList = teacherBiz.selectSclassByCoIdAndTeId(coid,
					user.getUnumber());

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		return "selectAllSclass";

	}

	/**
	 * 3.根据班级找到学生集合
	 * 
	 * @return
	 */
	public String selectAllStudents() {

		try {
			students = teacherBiz.selectByClId(clid);
			// System.out.println(students.size());
			// for(Student s:students){
			// System.out.println(s.getStNum());
			// }
		} catch (Exception e) {
			 return ERROR;
		}

		return "selectAllStudents";

	}

	/**
	 * 4.遍历学生集合添加成绩
	 * 
	 * @return
	 */
	public String saveGrades() {

		System.out.println(grList);
		// 页面传过来的coName实际上是coId
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		int courseId = Integer.parseInt(grList.get(0).getCoName());
		Course course = teacherBiz.change(courseId);
		String coName = course.getCoName();
		try {

			for(int j=0;j<grList.size();j++){
				Double sc = grList.get(j).getScore();
				if(sc!=null && sc<=100){
					
				}else{
                	request.put("m", "输入的成绩应该在0到100之内");
                	return "saveFail";
				}
			}
			
			for (int i = 0; i < grList.size(); i++) {
				Grade gr = grList.get(i);
				gr.setCoName(coName);
				
				
				Grade grade1 = teacherBiz.selectByConameAndStnum(coName,
						gr.getStNum());
				if (grade1 == null) {
                   
                    	teacherBiz.addGrade(gr);
 
				}else{
				
					request.put("m", "该班级已经录入过成绩，请选择其他班级");
					return "saveFail";
				}
			}
			return "saveGrades";

		} catch (Exception e) {
			e.printStackTrace();
		    return ERROR;
		}

	}

	/**
	 * 5.分页显示成绩
	 * 
	 * @return
	 */
	public String pageGrades() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		int currentPage = 1;
		if (pageGrade.getCurrentPage() != 0) {
			currentPage = pageGrade.getCurrentPage();
		}
		pageGrade.setCurrentPage(currentPage);

		// 调用业务逻辑
		try {
			pageGrade = teacherBiz.findPageGrade(pageGrade, 8);
			if(pageGrade.getList().size()==0){//还没有录入成绩
				request.put("msg", "还没有录入成绩喔");
				return "pageGradesFail";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			 return ERROR;
		}
		
		request.put("pageGrade", pageGrade);
		return "pageGrades";

	}

	/**
	 * 班主任查看班级信息
	 * 
	 * @return
	 */
	public String selectSclass() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		List<Sclass> sclasses = null;
		try {
			sclasses = teacherBiz.selectSclassByTeId(user.getUnumber());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("scList", sclasses);
		return "selectSclass";

	}

	/**
	 * 班主任查看学生名单
	 * 
	 * @return
	 */
	public String selectStudents() {

		try {
			students = teacherBiz.selectByClId(clid);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("students", students);
		return "selectStudents";

	}

	/**
	 * 按课程和班级查看成绩 1.课程 2.根据课程找到班级
	 * 3.查看成绩
	 * @return
	 */
	public String selectAllCourses1() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		try {
			coList = teacherBiz.findCourseList(user.getUnumber());

			/*
			 * for(Course s:coList){ System.out.println(s.getCoName()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			 return ERROR;
		}
		return "selectAllCourses1";

	}

	/**
	 * 2.根据课程找到班级
	 * 
	 * @return
	 */
	public String selectAllSclass1() {
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		try {
			scList = teacherBiz.selectSclassByCoIdAndTeId(coid,
					user.getUnumber());

		} catch (Exception e) {
			e.printStackTrace();
			 return ERROR;
		}

		return "selectAllSclass1";

	}

	
	/**
	 * 3、根据班级获取到学生成绩集合
	 * 
	 * @return
	 */
	public String selectGrades() {

		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Course course = teacherBiz.change(coid);
		
		System.out.println(course);
		try {
			grList = teacherBiz.selectGrades(course.getCoName(), clid);
			System.out.println(grList);
			System.out.println(grList.size());
            if(grList!=null && grList.size()>0&& grList.get(0)!=null){//这个班级的成绩还没有录入
            	request.put("grList", grList);
        		return "selectGrades";
            	
            }
		} catch (Exception e) {
			 return ERROR;
		}
		request.put("msg", "您查询的班级还没有录入成绩");
    	return "selectGradesFail";

	}
	
	public String pageSelectGrades(){
		
		return "pageSelectGrades";
		
	}
	
	/***************************选修课程****************************/
	
	/**
	 * 分页显示教师的所有选修课程
	 */
	public String pageExcourse() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		int currentPage = 1;
		if (pageEx.getCurrentPage() != 0) {
			currentPage = pageEx.getCurrentPage();
		}
		pageEx.setCurrentPage(currentPage);

		// 调用业务逻辑
		try {
			pageEx = teacherBiz.findPageExcourse(pageEx, 4, user.getUnumber());
			if(pageEx.getList().size()==0){
				request.put("msg", "这学期没有你的选修课程");
				return "pageExcourseFail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return ERROR;
		}

		request.put("pageEx", pageEx);

		return "pageExcourseSuccess";

	}

	
	/**
	 * 教师根据课程录选修成绩 
	 *  1.查出教师所带课程
	 *  2.根据课程找到学生集合
	 *  3.遍历学生集合添加成绩 
	 *  4.分页显示成绩
	 */
	public String selectAllExcourses(){
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
         
		try {
			exList=teacherBiz.selectExcourseByTeid(user.getUnumber());
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "selectAllExcourses";
		
	}
	
	/**
	 * 2.根据课程找到学生集合
	 * @return
	 */
	public String selectExcourseStudents(){
		try {
			stuList = teacherBiz.selectByExname(exid);
			/*System.out.println(stuList);
			for(Student s:stuList){
				System.out.println(s.getStNum());
				System.out.println(s.getStName());
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "selectExcourseStudents";
		
	}
	
	/**
	 * 3.遍历学生集合添加成绩 
	 * @return
	 */
	public String saveExGrades(){

		System.out.println(grList);
		
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		Excourse excourse = teacherBiz.selectExcourseByExname(exid);
		String exName = excourse.getExName();
		
		try {

			for(int j=0;j<grList.size();j++){
				Double sc = grList.get(j).getScore();
				if(sc!=null && sc<=100){
					
				}else{
                	request.put("m", "输入的成绩应该在0到100之内");
                	return "saveExFail";
				}
			}
			
			for (int i = 0; i < grList.size(); i++) {
				Grade gr = grList.get(i);
				gr.setCoName(exName);
				
				
				Grade grade1 = teacherBiz.selectByExnameAndStnum(exName,gr.getStNum());
				if (grade1 == null) {
                   
                    	teacherBiz.addGrade(gr);
 
				}else{
				
					request.put("m", "该班级已经录入过成绩，请选择其他班级");
					return "saveExFail";
				}
			}
			return "saveExGrades";

		} catch (Exception e) {
			e.printStackTrace();
		    return ERROR;
		}

		
	}
	
	/**
	 * 4.分页显示成绩
	 * 
	 * @return
	 */
	public String pageExGrades() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		int currentPage = 1;
		if (pageGrade.getCurrentPage() != 0) {
			currentPage = pageGrade.getCurrentPage();
		}
		pageGrade.setCurrentPage(currentPage);

		// 调用业务逻辑
		try {
			pageGrade = teacherBiz.findPageGrade(pageGrade, 8);
			if(pageGrade.getList().size()==0){//还没有录入成绩
				request.put("msg", "还没有录入成绩喔");
				return "pageExGradesFail";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			 return ERROR;
		}
		
		request.put("pageGrade", pageGrade);
		return "pageExGrades";

	}
	
	/**
	 * 按课程查看成绩 
	 * 1.查询课程
	 * 2.查看成绩
	 * @return
	 */
	public String selectAllExcourses1(){
		// 获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
         
		try {
			exList=teacherBiz.selectExcourseByTeid(user.getUnumber());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "selectAllExcourses1";
		
	}
	
	/**
	 * 2.课程---学生----查看成绩
	 */
	public String selectExGrades() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Excourse excourse = teacherBiz.selectExcourseByExname(exid);
		try {
			grList = teacherBiz.selectExGrades(excourse.getExName());
			System.out.println(grList);
			System.out.println(grList.size());
            if(grList.size()==0){//这个班级的成绩还没有录入
            	request.put("msg1", "您查询的班级还没有录入成绩");
            	return "selectExGradesFail";
            }else{
            	
            }
		} catch (Exception e) {
			 return ERROR;
		}
		request.put("grList", grList);
		return "selectExGrades";
	}
	
	
}
