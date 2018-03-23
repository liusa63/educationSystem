/**
 * 
 */
package com.icss.biz;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.icss.entity.Course;
import com.icss.entity.CourseVo;
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


/**
 *<p>Title:StudentBiz</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月27日上午9:06:26
 */
public interface StudentBiz {
	
	//查询学生表的信息
	public Student findStudent(String  stNum);
	
	//查询学籍信息
	public Sroll findStudentInfo(String  stNum);
	
	//修改学生密码
	public void changeStudentPwd(User user);
	
	//查询本学期课表
	public List<StudentNowCourseVo> findStudentNowCourse(User user);
	
	//分页查询所有课程
	public  PageList findAllCourse(PageList<Course> page, int max,User user); 
	
	//分页查询已完成课程
	public  PageList finishedCourse(PageList<CourseVo> page, int max,User user,String date);
	
	//分页查询未完成课程
	public  PageList undoneCourse(PageList<Course> page, int max,User user,String date);
		
	//分页查询所有选修课
	public  PageList findAllExcourse(PageList<ExcourseVo> page, int max);
	
	//添加我的选修课
	public String addMyExcourse(User user,int exId);
	
	//我的选修
	public List<ExcourseVo> findMyExcourseVo(User user);
	
	//查询指定学生的成绩
	public List<Grade> findMyGrade(User user);
	
	//查询评估问题
	public List<Question>  findQuestion();
	
	//评估时获取老师对象
	public Teacher  findTeacherBycoIdclId(User user,int coId);
	
	//添加教学评估
	public void addEvaluation(Evaluation evaluation);
	

}
