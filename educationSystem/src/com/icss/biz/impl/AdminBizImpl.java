package com.icss.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.AdminBiz;
import com.icss.dao.AdminDao;
import com.icss.entity.Course;
import com.icss.entity.EnCourse;
import com.icss.entity.Evaluation;
import com.icss.entity.Excourse;
import com.icss.entity.Grade;
import com.icss.entity.Major;
import com.icss.entity.Question;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Sroll;
import com.icss.entity.Teacher;

import com.icss.util.PageList;

@Service(value = "adminBiz")
public class AdminBizImpl implements AdminBiz {
	@Autowired
	@Qualifier(value = "adminDao")
	AdminDao adminDao;

	// 逐个添加教师信息
	public void addTeacher(Teacher teacher) {
		adminDao.addTeacher(teacher);

	}

	// 逐个添加班级信息
	public void addSclass(Sclass sclass) {
		adminDao.addSclass(sclass);

	}

	public void addCourse(Course course) {
		adminDao.addCourse(course);

	}

	// 添加问题
	public void addQuestion(Question question) {
		adminDao.addQuestion(question);

	}

	// 查看所有问题
	public List<Question> selectAllQuestion() {
		List<Question> qlist = adminDao.selectAllQuestion();
		return qlist;
	}


	public void selectListTeacher(PageList<Teacher> page, int pageSize) {
		List<Teacher> list = adminDao.selectListTeacher(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotal();

		page.setTotalNum(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);

	}

	// 查询所有专业

	public List<Major> selectAllMajor() {
		List<Major> mlist = adminDao.selectAllMajor();
		return mlist;
	}

	// 查询所有班主任

	public List<Teacher> selectByIdTeacher(String tebehave) {
		List<Teacher> tlist = adminDao.selectByIdTeacher(tebehave);
		return tlist;
	}

	// 根据id查询专业
	public Major selectByIdMajor(int maid) {

		return adminDao.selectByIdMajor(maid);

	}

	// 查询所有选修课
	public List<Course> selectAllCourse(String costatus) {
		List<Course> clist = adminDao.selectAllCourse(costatus);
		return clist;
	}

	// 查询所有教室
	public List<Room> selectAjaxRoom() {
		List<Room> rlist = adminDao.selectAjaxRoom();
		return rlist;
	}

	// 录入选修课
	public void addExCourse(Excourse excourse) {
		adminDao.addExCourse(excourse);

	}

	// 根据专业查询必修课程
	public List<Course> selectBasicCourse(String costatus, int maid) {
		List<Course> clist = adminDao.selectBasicCourse(costatus, maid);
		return clist;
	}

	// 分页查询班级
	public void selectAllSclass(PageList<Sclass> page, int pageSize) {
		List<Sclass> list = adminDao.selectListSclass(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotalSclass();

		page.setTotalNum(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);

	}

	public void updateSclass(Sclass sclass) {
		adminDao.updateSclass(sclass);

	}

	public Sclass selectByIdSclass(int clid) {
		Sclass c = adminDao.selectByIdSclass(clid);

		return c;
	}

	//录入学籍信息
	public void addSroll(Sroll sroll,String stbehave,Sclass sclass) {
		adminDao.addSroll(sroll,stbehave, sclass);
		
	}
	//查找指定id教师
	public Teacher selectByIdTeacher(int teid) {
		Teacher t = adminDao.selectByIdTeacher(teid);		
		return t;
	}

	//修改教师信息
	public void updateByIdTeacher(Teacher teacher) {
	adminDao.updateByIdTeacher(teacher);
		
	}

	//分页查询课程
	public void selectAllSchoolCourse(PageList<Course> page, int pageSize) {
		List<Course> list = adminDao.selectListSchoolCourse(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotalSchoolCourse();

		page.setTotalNum(totalCount);//总条数
		int totalPage = 0;//总页数
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);
		
	}

	//根据学号和课程名修改成绩
	public Grade selectGrade(String stnum, String coname) {
		
		Grade grade=adminDao.selectGrade(stnum, coname);
		return grade;
	}

	//修改成绩
	public void updateGrade(Grade grade) {
		adminDao.updateGrade(grade);
		
	}

	public Grade selectById(int grid) {
		Grade g=adminDao.selectById(grid);
		return g;
	}

	public void selectAllExcourse(PageList<Excourse> page, int pageSize) {
		List<Excourse> list = adminDao.selectListExcourse(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotalExcourse();

		page.setTotalNum(totalCount);//总条数
		int totalPage = 0;//总页数
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);
		
	}

	//查询指定id的选课
	public Excourse findByIdExcourse(int exid) {
		
		Excourse excourse=adminDao.findByIdExcourse(exid);
		return excourse;
	}

	//修改选课
	public void updateExcourse(Excourse excourse) {
		adminDao.updateExcourse(excourse);
		
	}

	public List<Excourse> selectByTeacherExcourse(int teid) {
		List<Excourse> excourse=adminDao.selectByTeacherExcourse(teid);
		return excourse;
	}

	public List<EnCourse> selectByTeacherEncourse(int teid) {
		List<EnCourse> enCourse=adminDao.selectByTeacherEncourse(teid);
		return enCourse;
	}

	

	public Double selectEvaluation1(int teid, int coid) {
		Double qa=adminDao.selectEvaluation1(teid, coid);
		return qa;
	}

	public Double selectEvaluation2(int teid, int coid) {
		Double qb=adminDao.selectEvaluation2(teid, coid);
		return qb;
	}

	public Double selectEvaluation3(int teid, int coid) {
		Double qc=adminDao.selectEvaluation3(teid, coid);
		return qc;
	}

	public Double selectEvaluation4(int teid, int coid) {
		Double qd=adminDao.selectEvaluation4(teid, coid);
		return qd;
	}

	public Double selectEvaluation5(int teid, int coid) {
		Double qe=adminDao.selectEvaluation5(teid, coid);
		return qe;
	}

	//根据学号查看学籍
	public Sroll selectSroll(String srNum) {
		Sroll sroll=adminDao.selectSroll(srNum);
		return sroll;
	}

	
 //查看所有班级
	public List<Sclass> ajaxSelectAllSclass() {
		List<Sclass> sclist=adminDao.ajaxSelectAllSclass();
		return sclist;
	}
	//根据专业id查询上课老师
	public List<Teacher> selectTeacherByMajor(int maid, String tebehave) {
		List<Teacher> tlist=adminDao.selectTeacherByMajor(maid, tebehave);
		return tlist;
	}

	//录入必修课
	public void addBasicCourse(EnCourse encourse) {
		adminDao.addBasicCourse(encourse);
		
	}

	//修改课表中的课程
	public Course findByIdSchoolCourse(int coid) {
		Course c=adminDao.findByIdSchoolCourse(coid);
		return c;
	
		
	}
	
	public void updateSchoolCourse(Course course) {
		adminDao.updateSchoolCourse(course);
		
	}

//修改学籍
	public void updateStudentSroll(Sroll sroll) {
		adminDao.updateStudentSroll(sroll);
		
	}

	public void addTeachers(Teacher teacher) {
		adminDao.addTeachers(teacher);
		
	}

	//修改问题
	public Question selectByIdQuestion(int qqid) {
		Question q=	adminDao.selectByIdQuestion(qqid);
		return q;
	}

	public void updateQuestion(Question question) {
		adminDao.updateQuestion(question);
		
	}

	//自动生成学号：最大值+1
	public Integer ajaxUserNumber() {
		Integer stnumber=adminDao.ajaxUserNumber();
		return stnumber;
	}

	
	
	
}
