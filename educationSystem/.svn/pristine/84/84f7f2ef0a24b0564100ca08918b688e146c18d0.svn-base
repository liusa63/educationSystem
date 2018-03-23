/**
 * 
 */
package com.icss.biz.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.StudentBiz;
import com.icss.dao.StudentDao;
import com.icss.entity.Course;
import com.icss.entity.CourseVo;
import com.icss.entity.Evaluation;
import com.icss.entity.Excourse;
import com.icss.entity.ExcourseVo;
import com.icss.entity.Grade;
import com.icss.entity.Major;
import com.icss.entity.Question;
import com.icss.entity.Room;
import com.icss.entity.Sroll;
import com.icss.entity.Student;
import com.icss.entity.StudentNowCourseVo;
import com.icss.entity.Teacher;
import com.icss.entity.User;
import com.icss.util.PageList;

/**
 *<p>Title:StudentBizImpl</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月27日上午9:06:48
 */
@Service(value="studentBiz")
public class StudentBizImpl implements StudentBiz {
	
	@Autowired
	@Qualifier(value="studentDao")
	StudentDao studentDao;

	/* 
	 * 查询学生表中的信息
	 */
	public Student findStudent(String stNum) {
		
		return studentDao.findStudent(stNum);
		
	}

	/* 
	 * 查询学籍信息
	 */
	public Sroll findStudentInfo(String stNum) {
		
		return studentDao.findStudentInfo(stNum);
	}

	/* 
	 * 修改学生密码
	 */
	public void changeStudentPwd(User user) {
		
		studentDao.changeStudentPwd(user);
	}


	/* 
	 * 查询本学期课表
	 */
	public List<StudentNowCourseVo> findStudentNowCourse(User user) {
		
		return studentDao.findStudentNowCourse(user);
	}
	
	/* 
	 * 分页查询所有课程
	 */
	public PageList findAllCourse(PageList<Course> page, int max,User user) {
		
		//获取学生所在专业
		Major major = studentDao.findMajor(user);
		
		//计算当前页
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<Course> course = studentDao.findAllCourse(beginPage, max,major);
		
		page.setList(course);
		
		//获取课程总条数
		int countCourse=studentDao.selectCountCourse(major.getMaId());
		page.setTotalNum(countCourse);
		
		//计算总页数
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;
	}

	/* 
	 *分页查询已完成课程
	 */
	public PageList finishedCourse(PageList<CourseVo> page, int max, User user,String date) {
		
		//获取学生所在专业
		Major major = studentDao.findMajor(user);
		
		//计算当前页
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<CourseVo> course = studentDao.finishedCourse(beginPage, max,major,date,user);
		
		page.setList(course);
		
		//获取课已完成程总条数
		int countCourse=studentDao.selectFinishedCountCourse(major.getMaId(),date);
		page.setTotalNum(countCourse);
		
		//计算总页数
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;
		
		
	}

	/* 
	 * 分页查询未完成课程
	 */
	public PageList undoneCourse(PageList<Course> page, int max, User user,String date) {
		
		//获取学生所在专业
		Major major = studentDao.findMajor(user);
		
		//计算当前页
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<Course> course = studentDao.undoneCourse(beginPage, max,major,date);
		
		page.setList(course);
		
		//获取课未完成程总条数
		int countCourse=studentDao.selectUndoneCountCourse(major.getMaId(),date);
		page.setTotalNum(countCourse);
		
		//计算总页数
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;

		
		
		
	
	}

	/* 
	 * 分页查询所有选修课
	 */
	public PageList findAllExcourse(PageList<ExcourseVo> page, int max) {
		
		//起始条数
		int begin = (page.getCurrentPage()-1)*max;
		
		//获取集合
		List<ExcourseVo> list = studentDao.allExcourse(begin, max);
		
		page.setList(list);
		
		//获取选修课总条数
		int totalNum = studentDao.selectCountExcourse();
		page.setTotalNum(totalNum);
		
		//计算总页数
		int countPage = totalNum%max==0?totalNum/max:totalNum/max+1;
		page.setCountPage(countPage);
		
		return page;
	}

	/* 
	 *添加我的选修课
	 */
	public String addMyExcourse(User user,int exId){
		
		List<ExcourseVo> list =studentDao.findMyExcourseVo(user);
		
        int count = list.size();
		
        String judgment="";
        
		if(count<6){//小于6允许选课
			
			Iterator<ExcourseVo> it = list.iterator();
			
			while(it.hasNext()){
				
				ExcourseVo excourseVo = it.next();
				
				if(exId==excourseVo.getExId()){//选过
					
					judgment = "excoursed";
					
					return judgment;
					
				}
			}
			
			studentDao.addMyExcourse(user, exId);
			
			judgment ="addMyExcourseSuccess";
			
		}else{//达到最大选课量不允许再选课
			
			judgment = "excourseFull";
			
		}
		
		return judgment;

	}



	/* 
	 *查询指定学生的成绩
	 */
	public List<Grade> findMyGrade(User user) {
		return studentDao.findMyGrade(user);
	}

	/* 
	 *查询评估问题
	 */
	public List<Question> findQuestion() {
	
		return studentDao.findQuestion();
	}

	/* 
	 * 评估时获取老师
	 */
	public Teacher findTeacherBycoIdclId(User user, int coId) {
		
		return studentDao.findTeacherBycoIdclId(user, coId);
	}

	/* 
	 *添加教学评估
	 */
	public void addEvaluation(Evaluation evaluation) {
		
		studentDao.addEvaluation(evaluation);
	}

	/* 
	 * 我的选修Vo
	 */
	public List<ExcourseVo> findMyExcourseVo(User user) {
		
		return studentDao.findMyExcourseVo(user);
	}



	

}
