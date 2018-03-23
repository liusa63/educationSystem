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
 * @date2017-9-27����3:00:00
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

	// ��װrepwds���޸�����
	private String repwds;

	public void setRepwds(String repwds) {
		this.repwds = repwds;
	}

	// ��װpage����ҳ��ѯ���б��޿γ�
	private PageList<EnCourseVo> page = new PageList<EnCourseVo>();

	public void setPage(PageList<EnCourseVo> page) {
		this.page = page;
	}

	// ��װpageEva����ҳ��ѯ���пγ�
	private PageList<EvaluationVo> pageEva = new PageList<EvaluationVo>();

	public void setPageEva(PageList<EvaluationVo> pageEva) {
		this.pageEva = pageEva;
	}

	// ��װ�γ̼���coList
	private List<Course> coList;

	public List<Course> getCoList() {
		return coList;
	}

	public void setCoList(List<Course> coList) {
		this.coList = coList;
	}

	// ��װcoid��Ŀ���Ǹ��ݿγ�id��ȡ���༶����
	private int coid;

	public void setCoid(int coid) {
		this.coid = coid;
	}

	// ��װscList���༶����
	private List<Sclass> scList;

	public void setScList(List<Sclass> scList) {
		this.scList = scList;
	}

	public List<Sclass> getScList() {
		return scList;
	}

	// ��װ�༶id
	private int clid;

	public void setClid(int clid) {
		this.clid = clid;
	}

	// ��װѧ������
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	// ��װ����
	private Grade grade;

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	// ��װmsg
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// ��װpageGrade����ҳ��ѯ���пγ�
	private PageList<Grade> pageGrade = new PageList<Grade>();

	public void setPageGrade(PageList<Grade> pageGrade) {
		this.pageGrade = pageGrade;
	}

	// ��װscList���༶����
	private List<Grade> grList;

	public List<Grade> getGrList() {
		return grList;
	}

	public void setGrList(List<Grade> grList) {
		this.grList = grList;
	}

	// ��װpageEx����ҳ��ѯ���б��޿γ�
	private PageList<ExcourseVo> pageEx = new PageList<ExcourseVo>();
	public void setPageEx(PageList<ExcourseVo> pageEx) {
		this.pageEx = pageEx;
	}

	
	//��װѡ�޿γ̼���exList------�첽ˢ����Ҫ����setter() getter()����
	private List<Excourse> exList;
	public List<Excourse> getExList() {
		return exList;
	}

	public void setExList(List<Excourse> exList) {
		this.exList = exList;
	}
	
	//��װѡ��ĳ�ſε�ѧ������stuList
	private Set<Student> stuList;
	public void setStuList(Set<Student> stuList) {
		this.stuList = stuList;
	}
	public Set<Student> getStuList() {
		return stuList;
	}

	//��װ����exname���ڻ�ȡѡ��ĳ�ſε�ѧ������
	private int exid;
	public int getExid() {
		return exid;
	}

	public void setExid(int exid) {
		this.exid = exid;
	}
	
	
	// ��װmsg1
	private String msg1;
	public String getMsg1() {
		return msg1;
	}

	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}

	/**
	 * �鿴��ʦ��Ϣ
	 * 
	 * @return
	 */
	public String findTeacher() {
		// ��ȡsession
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
			return "findHeadmaster";// ��������ҳ
		}

		return "findTeacher";// ��ʦ��ҳ

	}

	public String findTeacherDetail() {
		// ��ȡsession
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
			return "findHeadmasterDetail";// ��������ϸ��Ϣ
		}

		return "findTeacherDetail";// ��ʦ��ϸ��Ϣ

	}

	/**
	 * �޸�����
	 * 
	 * @return
	 */
	public String updatePwd() {

		// ��ȡsession
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		// �޸�����
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
	 * ��ҳ��ʾ��ʦ�����б��޿α�
	 */
	public String pageCourse() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		// ��ȡsession
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		int currentPage = 1;
		if (page.getCurrentPage() != 0) {
			currentPage = page.getCurrentPage();
		}
		page.setCurrentPage(currentPage);

		// ����ҵ���߼�
		try {
			page = teacherBiz.findPageCourse(page, 4, user.getUnumber());
			if(page.getList().size()==0){
				request.put("msg", "��ѧ��û�����ı��޿γ�");
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
	 * ��ҳ��ʾ��ʦ�Ľ�ѧ����
	 */
	public String pageEva() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		List<Question> questions = teacherBiz.selectQuestion();
		// ��ȡsession
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		int currentPage = 1;
		if (pageEva.getCurrentPage() != 0) {
			currentPage = pageEva.getCurrentPage();
		}
		pageEva.setCurrentPage(currentPage);

		// ����ҵ���߼�
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
		request.put("msg", "��ǰ��û�������");
		return "pageEvaFail";
		
		

	}

	/**
	 * ��ʦ���ݿγ�¼����޳ɼ� 
	 *  1.�����ʦ�����γ�
	 *  2.���ݿγ��ҵ��༶ 
	 *  3.���ݰ༶�ҵ�ѧ������
	 *  4.����ѧ���������ӳɼ� 
	 *  5.��ҳ��ʾ�ɼ�
	 * 
	 * @return
	 */
	public String selectAllCourses() {
		// ��ȡsession
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
	 * 2.���ݿγ��ҵ��༶
	 * 
	 * @return
	 */
	public String selectAllSclass() {
		// ��ȡsession
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
	 * 3.���ݰ༶�ҵ�ѧ������
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
	 * 4.����ѧ���������ӳɼ�
	 * 
	 * @return
	 */
	public String saveGrades() {

		System.out.println(grList);
		// ҳ�洫������coNameʵ������coId
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
                	request.put("m", "����ĳɼ�Ӧ����0��100֮��");
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
				
					request.put("m", "�ð༶�Ѿ�¼����ɼ�����ѡ�������༶");
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
	 * 5.��ҳ��ʾ�ɼ�
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

		// ����ҵ���߼�
		try {
			pageGrade = teacherBiz.findPageGrade(pageGrade, 8);
			if(pageGrade.getList().size()==0){//��û��¼��ɼ�
				request.put("msg", "��û��¼��ɼ��");
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
	 * �����β鿴�༶��Ϣ
	 * 
	 * @return
	 */
	public String selectSclass() {
		// ��ȡsession
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
	 * �����β鿴ѧ������
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
	 * ���γ̺Ͱ༶�鿴�ɼ� 1.�γ� 2.���ݿγ��ҵ��༶
	 * 3.�鿴�ɼ�
	 * @return
	 */
	public String selectAllCourses1() {
		// ��ȡsession
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
	 * 2.���ݿγ��ҵ��༶
	 * 
	 * @return
	 */
	public String selectAllSclass1() {
		// ��ȡsession
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
	 * 3�����ݰ༶��ȡ��ѧ���ɼ�����
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
            if(grList!=null && grList.size()>0&& grList.get(0)!=null){//����༶�ĳɼ���û��¼��
            	request.put("grList", grList);
        		return "selectGrades";
            	
            }
		} catch (Exception e) {
			 return ERROR;
		}
		request.put("msg", "����ѯ�İ༶��û��¼��ɼ�");
    	return "selectGradesFail";

	}
	
	public String pageSelectGrades(){
		
		return "pageSelectGrades";
		
	}
	
	/***************************ѡ�޿γ�****************************/
	
	/**
	 * ��ҳ��ʾ��ʦ������ѡ�޿γ�
	 */
	public String pageExcourse() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		// ��ȡsession
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");

		int currentPage = 1;
		if (pageEx.getCurrentPage() != 0) {
			currentPage = pageEx.getCurrentPage();
		}
		pageEx.setCurrentPage(currentPage);

		// ����ҵ���߼�
		try {
			pageEx = teacherBiz.findPageExcourse(pageEx, 4, user.getUnumber());
			if(pageEx.getList().size()==0){
				request.put("msg", "��ѧ��û�����ѡ�޿γ�");
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
	 * ��ʦ���ݿγ�¼ѡ�޳ɼ� 
	 *  1.�����ʦ�����γ�
	 *  2.���ݿγ��ҵ�ѧ������
	 *  3.����ѧ���������ӳɼ� 
	 *  4.��ҳ��ʾ�ɼ�
	 */
	public String selectAllExcourses(){
		// ��ȡsession
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
	 * 2.���ݿγ��ҵ�ѧ������
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
	 * 3.����ѧ���������ӳɼ� 
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
                	request.put("m", "����ĳɼ�Ӧ����0��100֮��");
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
				
					request.put("m", "�ð༶�Ѿ�¼����ɼ�����ѡ�������༶");
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
	 * 4.��ҳ��ʾ�ɼ�
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

		// ����ҵ���߼�
		try {
			pageGrade = teacherBiz.findPageGrade(pageGrade, 8);
			if(pageGrade.getList().size()==0){//��û��¼��ɼ�
				request.put("msg", "��û��¼��ɼ��");
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
	 * ���γ̲鿴�ɼ� 
	 * 1.��ѯ�γ�
	 * 2.�鿴�ɼ�
	 * @return
	 */
	public String selectAllExcourses1(){
		// ��ȡsession
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
	 * 2.�γ�---ѧ��----�鿴�ɼ�
	 */
	public String selectExGrades() {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Excourse excourse = teacherBiz.selectExcourseByExname(exid);
		try {
			grList = teacherBiz.selectExGrades(excourse.getExName());
			System.out.println(grList);
			System.out.println(grList.size());
            if(grList.size()==0){//����༶�ĳɼ���û��¼��
            	request.put("msg1", "����ѯ�İ༶��û��¼��ɼ�");
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