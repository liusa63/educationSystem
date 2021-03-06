package com.icss.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.icss.biz.AdminBiz;
import com.icss.entity.Course;

import com.icss.entity.EnCourse;
import com.icss.entity.Excourse;
import com.icss.entity.Grade;
import com.icss.entity.Major;
import com.icss.entity.Question;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Sroll;
import com.icss.entity.Teacher;

import com.icss.util.PageList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * <p>
 * Title:AdminAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author gjh
 * @date2017-9-27上午11:50:32
 */
@Controller(value = "adminAction")
public class AdminAction extends ActionSupport implements ModelDriven<Teacher> {
	@Autowired
	@Qualifier(value = "adminBiz")
	AdminBiz adminBiz;

	private File file;
	private String fileContentType;
	private String fileFileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	// 封装参数--录入教师信息方式
	private String coMethod;

	public void setCoMethod(String coMethod) {
		this.coMethod = coMethod;
	}

	private String teMethod;

	public void setTeMethod(String teMethod) {
		this.teMethod = teMethod;
	}

	private Teacher teacher = new Teacher();

	public Teacher getModel() {
		// TODO Auto-generated method stub
		return this.teacher;
	}

	// 封装班级参数
	private Sclass sclass;

	public void setSclass(Sclass sclass) {
		this.sclass = sclass;
	}

	public Sclass getSclass() {
		return sclass;
	}

	// 封装课程参数
	private Course course;

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	// 封装学籍参数
	private Sroll sroll;

	public void setSroll(Sroll sroll) {
		this.sroll = sroll;
	}

	public Sroll getSroll() {
		return sroll;
	}
	// 封装成绩参数
	private Grade grade;

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}

	private String start;
	private String end;

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	// 封装问题参数
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	// 封装选课参数
	private EnCourse encourse;

	public EnCourse getEncourse() {
		return encourse;
	}

	public void setEncourse(EnCourse encourse) {
		this.encourse = encourse;
	}

	private Major major;

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	private Excourse excourse;

	public Excourse getExcourse() {
		return excourse;
	}

	public void setExcourse(Excourse excourse) {
		this.excourse = excourse;
	}

	// 封装参数

	private int currentpage;

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	private List<Major> mlist;

	public List<Major> getMlist() {
		return mlist;
	}

	public void setMlist(List<Major> mlist) {
		this.mlist = mlist;
	}

	private Set<Sclass> sclassList;

	public Set<Sclass> getSclassList() {
		return sclassList;
	}

	public void setSclassList(Set<Sclass> sclassList) {
		this.sclassList = sclassList;
	}

	private List<Teacher> tlist;

	public List<Teacher> getTlist() {
		return tlist;
	}

	public void setTlist(List<Teacher> tlist) {
		this.tlist = tlist;
	}

	private List<Course> clist;

	public List<Course> getClist() {
		return clist;
	}

	public void setClist(List<Course> clist) {
		this.clist = clist;
	}

	private List<Room> rlist;

	public List<Room> getRlist() {
		return rlist;
	}

	public void setRlist(List<Room> rlist) {
		this.rlist = rlist;
	}

	private List<Sclass> sclist;

	public List<Sclass> getSclist() {
		return sclist;
	}

	public void setSclist(List<Sclass> sclist) {
		this.sclist = sclist;
	}

	// 封装参数
	private String stbehave;

	public void setStbehave(String stbehave) {
		this.stbehave = stbehave;
	}

	private int clid;

	public void setClid(int clid) {
		this.clid = clid;
	}

	private String srnum;

	public void setSrnum(String srnum) {
		this.srnum = srnum;
	}

	private int coid;

	public void setCoid(int coid) {
		this.coid = coid;
	}

	private int maid;

	public void setMaid(int maid) {
		this.maid = maid;
	}

	private String roname;

	public String getRoname() {
		return roname;
	}

	public void setRoname(String roname) {
		this.roname = roname;
	}

	private int teid;

	public int getTeid() {
		return teid;
	}

	public void setTeid(int teid) {
		this.teid = teid;
	}

	private String tename;

	public void setTename(String tename) {
		this.tename = tename;
	}

	public String getTename() {
		return tename;
	}

	private String maname;

	public void setManame(String maname) {
		this.maname = maname;
	}

	private String tebehave;// 班主任

	public void setTebehave(String tebehave) {
		this.tebehave = tebehave;
	}

	private String costatus;

	public void setCostatus(String costatus) {
		this.costatus = costatus;
	}
	

	private List<Teacher> teachers;

	public List<Teacher> getTeachers() {
			return teachers;
		}
	public void setTeachers(List<Teacher> teachers) {
			this.teachers = teachers;
		}
	
	//自动生成学号
	private Integer stnumber;
	

	
	
	public Integer getStnumber() {
		return stnumber;
	}

	public void setStnumber(Integer stnumber) {
		this.stnumber = stnumber;
	}

	// 判断录入老师：0---老师逐个录入，1---老师批量录入
	public String checkTeacherMethod() {
		if ("0".equals(teMethod)) {
			return "addTeacher";

		}

		return "addTeachers";
	}

	// 逐个录入老师信息
	public String addTeacher() {

		adminBiz.addTeacher(teacher);
		return "addSuccessTeacher";

	}

	//批量录入老师信息
	public String addTeachers(){
		System.out.println(teachers.size());
		for(Teacher t :teachers){

				adminBiz.addTeachers(t);
				
			}
		return "addTeachersSuccess";
		}
		
	
		
		
	
	// 录入班级信息
	public String addSclass() {
		Major m = adminBiz.selectByIdMajor(maid);
		sclass.setMajor(m);
		System.out.println(sclass.getClName());
		adminBiz.addSclass(sclass);
		return "addSclassSuccess";

	}

	// 录入课程信息
	public String addCourse() throws ParseException {
		System.out.println(start);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = df.parse(start);
		Date endTime = df.parse(end);
		course.setCoStartTime(startTime);
		course.setCoEndTime(endTime);
		System.out.println(course.getCoStartTime());
		adminBiz.addCourse(course);
		return "addCourseSuccess";
	}

	// 录入问题表
	public String addQuestion() {
		List<Question> qlist = adminBiz.selectAllQuestion();
		if (qlist.size() < 5) {
			adminBiz.addQuestion(question);
			return "addQuestionSuccess";
		} else {
			Map request = (Map) ActionContext.getContext().get("request");

			request.put("msg", "数据已满,不能录入");
		}
		return "addQuestionfalse";

	}

	// 查看所有的评估问题
	public String selectAllQuestion() {
		List<Question> qlist = adminBiz.selectAllQuestion();
		Map request = (Map) ActionContext.getContext().get("request");

		request.put("qList", qlist);
		return "selectAllQuestion";

	}

	// 分页查看所有教师信息
	public String selectAllTeacher() {
		PageList<Teacher> page = new PageList<Teacher>();
		Map request = (Map) ActionContext.getContext().get("request");

		int pageSize = 5;
		// 获取用户传过来的参数：当前页,并判断是否为空，为空则默认第一页
		if (currentpage != 0) {
			currentpage = currentpage;
		}
		page.setCurrentPage(currentpage);
		List<Major> mlist = null;
		// 获取当前页，及每页显示的条数
		try {
			adminBiz.selectListTeacher(page, pageSize);
			// 查看所有专业
			mlist = adminBiz.selectAllMajor();
		} catch (Exception e) {

			e.printStackTrace();
			return ERROR;
		}
		request.put("page", page);
		request.put("mlist", mlist);
		return "teacher";
	}

	// 查询所有专业
	public String selectAllMajor() {
		mlist = adminBiz.selectAllMajor();
		return "selectMajor";
	}

	// 查询所有班主任或者代课老师
	public String selectByIdTeacher() {
		tlist = adminBiz.selectByIdTeacher(tebehave);
		return "AjaxTeacher";
	}

	// 遍历所有课程
	public String selectAllCourse() {
		clist = adminBiz.selectAllCourse(costatus);
		return "selectSuccessCourse";
	}

	// 遍历所有教室
	public String selectAjaxRoom() {
		rlist = adminBiz.selectAjaxRoom();
		return "AjaxRoom";
	}

	// 判断录入课程种类
	public String checkCourseMethod() {
		if ("0".equals(coMethod)) {
			return "addSchoolCourse";
		}
		return "addCourses";
	}

	// 录入选修课程

	public String addExCourse() {
		excourse.setExStart("7:00");
		excourse.setExEnd("9:00");
		adminBiz.addExCourse(excourse);
		return "addExCourseSuccess";
	}

	// 录入必修课
	public String addBasicCourse() {
		adminBiz.addBasicCourse(encourse);
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		request.put("msg", "录入成功");
		return "selectaddBasicCourseSuccess";
	}

	// 根据专业查询必修课程
	public String selectBasicCourse() {
		clist = adminBiz.selectBasicCourse(costatus, maid);
		return "selectBasicCourse";
	}

	// 遍历所有班级（异步刷新）
	public String ajaxSelectAllSclass() {
		sclist = adminBiz.ajaxSelectAllSclass();
		return "AjaxselectSuccessSclass";
	}
	// 通过专业查询专业下的所有班级
	public String ajaxSelectSclassByMajor() {
		Major major = null;
		try {
			major = adminBiz.selectByIdMajor(maid);

			sclassList = major.getSclasses();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajaxSelectSclassByMajor";
	}
	// 查询所有班级分页展示
	public String selectAllSclass() {
		PageList<Sclass> page = new PageList<Sclass>();
		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		int pageSize = 5;
		// 获取用户传过来的参数：当前页,并判断是否为空，为空则默认第一页
		if (currentpage != 0) {
			currentpage = currentpage;
		}
		page.setCurrentPage(currentpage);
		adminBiz.selectAllSclass(page, pageSize);
		// 查询所有班主任--2
		tlist = adminBiz.selectByIdTeacher("2");

		request.put("page", page);
		return "selectSuccessSclass";

	}

	// 根据指定id查询班级
	public String selectByIdSclass() {
		Sclass sc = adminBiz.selectByIdSclass(sclass.getClId());
		Map<String, Sclass> request = (Map) ActionContext.getContext().get("request");
		request.put("sc", sc);

		// 查询所有班主任
		tlist = adminBiz.selectByIdTeacher("2");
		return "selectSclassSuccess";

	}

	// 通过制定id修改班级
	public String updateSclass() {

		// 查询所有班主任
		String te = "2";
		tlist = adminBiz.selectByIdTeacher(te);
		if (tlist != null && tlist.size() > 0) {
			for (int i = 0; i < tlist.size(); i++) {
				Teacher t = tlist.get(i);

				System.out.println(t.getTeName().equals(tename));
				if (t.getTeName().equals(tename)) {
					sclass.setTeId(t.getTeId());
				}
			}
		}
    //根据id查看专业
		Major m=adminBiz.selectByIdMajor(maid);
		sclass.setMajor(m);
		adminBiz.updateSclass(sclass);
		return "updateSuccess";
	}

	// 录入学籍信息
	public String addSroll() throws IOException {

		File dir = new File("E:/images/static", fileFileName);
		FileUtils.copyFile(file, dir);
		sroll.setSrImg(fileFileName);
		System.out.println("文件类型" + fileContentType);
		System.out.println("文件名" + fileFileName);
		System.out.println(clid);
		Sclass sc = adminBiz.selectByIdSclass(clid);
		System.out.println(stbehave);

		adminBiz.addSroll(sroll, stbehave, sc);
		Sroll s = adminBiz.selectSroll(sroll.getSrNumber());
		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		request.put("sroll", s);
		request.put("msg", "学籍录入成功");
		return "addSrollSuccess";

	}

	// 查找指定id的教师
	public String findByIdTeacher() {
		Teacher te = adminBiz.selectByIdTeacher(teacher.getTeId());
		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		request.put("te", te);
		mlist = adminBiz.selectAllMajor();
		request.put("mlist", mlist);
		return "selectTeacherSuccess";
	}

	// 修改教师
	public String updateTeacher() {
		if ("讲师".equals(tebehave)) {
			teacher.setTeBehave("1");
		} else if ("班主任".equals(tebehave)) {
			teacher.setTeBehave("2");
		}

		adminBiz.updateByIdTeacher(teacher);
		return "updateSucccessTeacher";
	}

	// 查询校课表分页
	public String selectSchoolCourse() {
		PageList<Course> page = new PageList<Course>();
		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		int pageSize = 5;
		// 获取用户传过来的参数：当前页,并判断是否为空，为空则默认第一页
		if (currentpage != 0) {
			currentpage = currentpage;
		}
		page.setCurrentPage(currentpage);
		adminBiz.selectAllSchoolCourse(page, pageSize);
		// 查询所有专业
		mlist = adminBiz.selectAllMajor();
		request.put("page", page);
		request.put("mlist", mlist);
		return "selectSuccessSchoolCourse";

	}

	// 根据学号和课程名查看成绩
	public String selectGrade() {
		System.out.println(grade.getStNum());
		System.out.println(grade.getCoName());
		Grade g = adminBiz.selectGrade(grade.getStNum(), grade.getCoName());

		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		if (g != null) {
			request.put("studentGrade", g);
			return "selectGradeSuccess";
		} else {
			request.put("msg", "输入的学号或者课程号不存在");
		}
		return "selectGradeFalse";

	}

	// 修改成绩
	public String updateGrade() {
		Grade g = adminBiz.selectById(grade.getGrId());
		grade.setCoName(g.getCoName());
		grade.setStNum(g.getStNum());
		
		adminBiz.updateGrade(grade);
		Grade gr = adminBiz.selectGrade(grade.getStNum(), grade.getCoName());
		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		request.put("studentGrade", gr);
		return "updateGradeSuccess";

	}

	// 查询所有选课，分页展示
	public String selectAllExcourse() {
		PageList<Excourse> page = new PageList<Excourse>();
		Map<String, Object> request = (Map) ActionContext.getContext().get(
				"request");
		int pageSize = 5;
		// 获取用户传过来的参数：当前页,并判断是否为空，为空则默认第一页
		if (currentpage != 0) {
			currentpage = currentpage;
		}
		page.setCurrentPage(currentpage);
		adminBiz.selectAllExcourse(page, pageSize);

		// 查询所有教师（上课老师）
		tlist = adminBiz.selectByIdTeacher("1");

		// 查询所有教室
		rlist = adminBiz.selectAjaxRoom();

		request.put("page", page);
		request.put("tlist", tlist);
		request.put("rlist", rlist);

		return "selectSuccessExcourse";

	}

	// 查询指定id
	public String findByIdExcourse() {
		Excourse ex = adminBiz.findByIdExcourse(excourse.getExId());
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		// 查询所有教师（上课老师）
		tlist = adminBiz.selectByIdTeacher("1");
		// 查询所有教室
		rlist = adminBiz.selectAjaxRoom();
		request.put("excourse", ex);
		request.put("tlist", tlist);
		request.put("rlist", rlist);
		return "findByIdExcourse";

	}

	// 根据id修改课表
	public String findByIdSchoolCourse() {
		Course cc=adminBiz.findByIdSchoolCourse(course.getCoId());
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		mlist = adminBiz.selectAllMajor();
		request.put("course", cc);		
		request.put("mlist", mlist);
		return "findByIdSchoolCourseSuccess";

	}
	
	public String updateSchoolCourse() throws ParseException{
		System.out.println(start);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = df.parse(start);
		Date endTime = df.parse(end);
		course.setCoStartTime(startTime);
		course.setCoEndTime(endTime);
		System.out.println(course.getCoStartTime());
		adminBiz.updateSchoolCourse(course);
		return "updateSchoolCourseSuccess";
		
	}

	// 修改选课
	public String updateExCourse() {
		tlist = adminBiz.selectByIdTeacher("1");
		if (tlist != null && tlist.size() > 0) {
			for (int i = 0; i < tlist.size(); i++) {
				Teacher t = tlist.get(i);
				if (t.getTeName().equals(tename)) {
					excourse.setTeId(t.getTeId());
				}
			}
		}
		rlist = adminBiz.selectAjaxRoom();
		if (rlist != null && rlist.size() > 0) {
			for (int i = 0; i < rlist.size(); i++) {
				Room r = rlist.get(i);
				if (r.getRoName().equals(roname)) {
					excourse.setRoId(r.getRoId());
				}
			}
		}
		adminBiz.updateExcourse(excourse);
		return "updateSuccessExCourse";

	}

	// 根据教师id查询该教师所教的课程
	public String selectByTeacherCourse() {
		// 选修
		// List<Excourse> exlist=adminBiz.selectByTeacherExcourse(teid);
		// 必修
		Map<String, Object> session = ActionContext.getContext().getSession();

		session.put("teid", teid);
		List<EnCourse> enlist = adminBiz.selectByTeacherEncourse(teid);
		// 查询所有必修课程
		clist = adminBiz.selectAllCourse("1");
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		// request.put("ex", exlist);
		request.put("en", enlist);
		return "selectSuccessTeacherCourse";

	}

	// 根据课程id和教师id查看评估结果
	public String selectEvaluation() {
		// System.out.println(----------);
		Map<String, Object> session = ActionContext.getContext().getSession();
		int tid = (Integer) session.get("teid");
		// 第一个问题的平均分
		Double q1 = adminBiz.selectEvaluation1(tid, coid);
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		if(q1!=null){
			// 第二个问题的平均分
			Double q2 = adminBiz.selectEvaluation2(tid, coid);
			// 第三个问题的平均分
			Double q3 = adminBiz.selectEvaluation3(tid, coid);
			// 第四个问题的平均分
			Double q4 = adminBiz.selectEvaluation4(tid, coid);
			// 第五个问题的平均分
			Double q5 = adminBiz.selectEvaluation5(tid, coid);
		
			// 查看所有问题
			List<Question> qlist = adminBiz.selectAllQuestion();		
			
			request.put("qList", qlist);
			request.put("q1", q1);
			request.put("q2", q2);
			request.put("q3", q3);
			request.put("q4", q4);
			request.put("q5", q5);
			return "successEvaluation";
		}
		
		
		request.put("msg", "该课程还没有学生进行评估!");
		return "falseEvaluation";
	}

	// 根据学号查看学籍信息：
	public String selectSroll() {
		Sroll s = adminBiz.selectSroll(sroll.getSrNumber());
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		if (s != null) {
			request.put("sroll", s);
			return "selectSrollSuccess";
		} else {
			request.put("msg", "输入的学号错误或者不存在");
		}
		return "selectSrollFalse";

	}

	// 根据学号修改学籍信息：
	public String selectByIdSroll() {
		Sroll s = adminBiz.selectSroll(srnum);
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		request.put("sroll", s);
		return "selectByIdSrollSuccess";

	}

	public String updateStudentSroll() throws IOException {
		
		File dir = new File("E:/images/static", fileFileName);
		FileUtils.copyFile(file, dir);
		sroll.setSrImg(fileFileName);
		
		adminBiz.updateStudentSroll(sroll);	
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		
		Sroll s = adminBiz.selectSroll(sroll.getSrNumber());
		request.put("sroll", s);
		return "selectSrollSuccess";
		

	}

	// 根据专业查看教师
	public String selectTeacherByMajor() {
		tlist = adminBiz.selectTeacherByMajor(maid, tebehave);
		return "selectTeacherByMajor";

	}
	
	//修改问题
	public String selectByIdQuestion(){
	Question q=	adminBiz.selectByIdQuestion(question.getQid());
	Map<String, Object> request = (Map) ActionContext.getContext().get("request");
	request.put("question", q);
	return "selectByIdQuestionSuccess";		
	}
	public String updateQuestion(){
		adminBiz.updateQuestion(question);
		Question q = adminBiz.selectByIdQuestion(question.getQid());
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		request.put("question", q);		
		return "updateQuestionSuccess";
		
	}
	
	//自动生成学号：最大值+1
	public String ajaxUserNumber(){
	 stnumber=	adminBiz.ajaxUserNumber();
	 stnumber++;
		return "ajaxUserNumberSuccess";
		
	}
	

}
