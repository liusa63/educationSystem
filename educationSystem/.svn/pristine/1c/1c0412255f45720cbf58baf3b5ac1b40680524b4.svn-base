package com.icss.biz.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.TeacherBiz;
import com.icss.dao.TeacherDao;
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

/**
 * 
 * <p>Title:TeacherBizImpl</p>
 * <P>Description:</p>
 * <p>Company:</p>
 * @author jby
 * @date2017-9-30上午9:38:48
 */
@Service(value="teacherBiz")
public class TeacherBizImpl implements TeacherBiz{
	
	@Autowired
	@Qualifier(value="teacherDao")
	TeacherDao teacherDao;

	//浏览个人信息--老师登录系统后，可浏览自己的个人基本信息，但没有修改或删除的权限。
	public TeacherVo findTeacher(String teNum) {
		return teacherDao.findTeacher(teNum);
	}

	//修改密码
	public void updatePwd(User user) {
		teacherDao.updatePwd(user);
	}
	
	//获取教师id
	public Teacher findByNum(String teNum) {
		return teacherDao.findByNum(teNum);
	}
	
	//分页查询所有必修课程
	public PageList<EnCourseVo> findPageCourse(PageList<EnCourseVo> page, int pageSize,
			String teNum) {
		//获取教师的id
		Teacher teacher=teacherDao.findByNum(teNum);
		// 获取当前页
		int firstResult = (page.getCurrentPage() - 1) * pageSize;
		
		// 获取到分页显示的课程的列表
		List<EnCourseVo> list=teacherDao.findPageCourse(firstResult, pageSize, teacher.getTeId());
		page.setList(list);
		
		// 获取课程总条数
		int totalNum = teacherDao.selectCountCourse(teacher.getTeId());
		page.setTotalNum(totalNum);
		
		// 计算总页数
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize +1 ;
		page.setCountPage(countPage);
		
		return page;
	}
	
	//遍历问题表，将问题添加到评估表的表头，取代答案1...
	public List<Question>selectQuestion() {
		return teacherDao.selectQuestion();
	}

	//分页显示教学评估
	public PageList<EvaluationVo> findPageEva(PageList<EvaluationVo> page, int pageSize, String teNum) {
		
		//获取教师id
		Teacher teacher = teacherDao.findByNum(teNum);
		
		// 获取当前页
		int firstResult = (page.getCurrentPage() - 1) * pageSize;
		
		// 获取到分页显示的课程的列表
		List<EvaluationVo> list = teacherDao.findPageEva(firstResult, pageSize, teacher.getTeId());
		page.setList(list);
		
		// 获取课程总条数
		int totalNum = teacherDao.selectCountEva(teacher.getTeId());
		page.setTotalNum(totalNum);
		
		// 计算总页数
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize +1 ;
		page.setCountPage(countPage);

		return page;	
	}

	//查询教师所带的所有课程
	public List<Course> findCourseList(String teNum) {
		//获取教师的id
		Teacher teacher=teacherDao.findByNum(teNum);
		//获取所有课程
		return teacherDao.findCourseList(teacher.getTeId());
	}

	//查询班级---根据课程id和教师工号num
	public List<Sclass> selectSclassByCoIdAndTeId(int coId, String teNum) {
		//获取教师的id
		Teacher teacher=teacherDao.findByNum(teNum);
		//获取班级
		return teacherDao.selectSclassByCoIdAndTeId(coId, teacher.getTeId());
	}

	//班级信息---根据教师工号teNum
	public List<Sclass> selectSclassByTeId(String teNum) {
		//获取教师的id
		Teacher teacher=teacherDao.findByNum(teNum);
		return teacherDao.selectSclassByTeId(teacher.getTeId());
	}

	//获取班级里面的学生
	public Set<Student> selectByClId(int clId) {
		return teacherDao.selectByClId(clId);
	}

	//录入成绩
	public void addGrade(Grade grade) {
		teacherDao.addGrade(grade);
	}

	//课程详情----根据coId
	public Course change(int coId) {
		return teacherDao.change(coId);
	}
	
	//判断是否已经录入过必修成绩
	public Grade selectByConameAndStnum(String coName, String stNum) {
		return teacherDao.selectByConameAndStnum(coName, stNum);
	}

	//分页查询所有成绩
	public PageList<Grade> findPageGrade(PageList<Grade> page, int pageSize) {
		// 获取当前页
		int firstResult = (page.getCurrentPage() - 1) * pageSize;
		
		// 获取到分页显示的课程的列表
		List<Grade> list = teacherDao.findPageGrade(firstResult, pageSize);
		page.setList(list);
		
		// 获取课程总条数
		int totalNum = teacherDao.selectCountGrade();
		page.setTotalNum(totalNum);
		
		// 计算总页数
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize +1 ;
		page.setCountPage(countPage);

		return page;	
	}

	
	//分页查询所有成绩------根据课程分类
	public PageList<Grade> selectPageGradeByCourse(PageList<Grade> page,
			int pageSize, String coName,String stNum) {
		// 获取当前页
		int firstResult = (page.getCurrentPage() - 1) * pageSize;

		// 获取到分页显示的课程的列表
		List<Grade> list = teacherDao.selectPageGradeByCourse(firstResult, pageSize, coName);
		page.setList(list);

		// 获取课程总条数
		int totalNum = teacherDao.selectGradeByCourse(coName);
		page.setTotalNum(totalNum);

		// 计算总页数
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		page.setCountPage(countPage);

		return page;
	}

	//查看成绩表，根据课程学号
	public List<Grade> selectGrades(String coName, int clid) {

		return teacherDao.selectGrades(clid, coName);
	}

	
	//分页查询所有选修课程
	public PageList<ExcourseVo> findPageExcourse(PageList<ExcourseVo> page, int pageSize,
			String teNum) {
		// 获取教师的id
		Teacher teacher = teacherDao.findByNum(teNum);
		// 获取当前页
		int firstResult = (page.getCurrentPage() - 1) * pageSize;

		// 获取到分页显示的课程的列表
		List<ExcourseVo> list = teacherDao.findPageExcourse(firstResult, pageSize, teacher.getTeId());
		page.setList(list);

		// 获取课程总条数
		int totalNum = teacherDao.selectCountExcourse(teacher.getTeId());
		page.setTotalNum(totalNum);

		// 计算总页数
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		page.setCountPage(countPage);

		return page;
	}

	//查询选修课----根据教师teNum
	public List<Excourse> selectExcourseByTeid(String teNum) {
		// 获取教师的id
		Teacher teacher = teacherDao.findByNum(teNum);
		return teacherDao.selectEncourseByTeid(teacher.getTeId());
	}

	//查询选修某门课的学生集合----根据选修课名称exName
	public Set<Student> selectByExname(int exId) {
		return teacherDao.selectByExname(exId);
	}

	//查询某选修课详情----根据根据选修课名称exName
	public Excourse selectExcourseByExname(int exId) {
		return teacherDao.selectExcourseByExname(exId);
	}

	//判断是否已经录入过选修成绩
	public Grade selectByExnameAndStnum(String coName, String stNum) {
		return teacherDao.selectByConameAndStnum(coName, stNum);
	}
	
	//查看成绩表，根据课程学号
	public List<Grade> selectExGrades(String coName) {

		return teacherDao.selectExGrades(coName);
	}
}
