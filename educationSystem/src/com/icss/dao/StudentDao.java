/**
 * 
 */
package com.icss.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
 *<p>Title:StudentDao</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月27日上午9:07:34
 */
public interface StudentDao {
	
	    //查询学生表的信息
		public Student findStudent(String  stNum);
		
		//查询学籍
		public Sroll findStudentInfo(String stNum);
		
		//修改学生密码
		public void changeStudentPwd(User user);
		
		//查询学生本学期的课程
		public List<StudentNowCourseVo>  findStudentNowCourse(User user);
		
		//查询学生所在专业
		public Major findMajor(User user);
		
		//分页查询本专业所有课程
		public List<Course> findAllCourse(int begin, int max,Major major);

		//查询本专业课程总数
		public int selectCountCourse(int maId);
		
		//分页查询所有完成的课程
		public List<CourseVo> finishedCourse(int beginPage, int max,Major major,String date,User user);

		//查询已完成课程总数
		public int selectFinishedCountCourse(int maId,String date);
		
		//分页查询未完成的课程
		public List<Course> undoneCourse(int beginPage, int max,Major major,String date);

		//查询已完成课程总数
		public int selectUndoneCountCourse(int maId,String date);
		
		//分页查询所有选修课
		public List<ExcourseVo> allExcourse(int begin, int max);
		
		//查询选修课的总数
		public int selectCountExcourse();
		
		//添加我的选修课
		public void addMyExcourse(User user,int exId);
		
		//我的选修
		public List<ExcourseVo> findMyExcourseVo(User user);
		
		//查询指定教室
		public Room findRoomById(int id);
		
		//查询指定学生的成绩
		public List<Grade> findMyGrade(User user);
		
		//查询评估问题
		public List<Question>  findQuestion();
		
		//评估时获取老师对象
		public Teacher  findTeacherBycoIdclId(User user,int coId);
		
		//添加教学评估
		public void addEvaluation(Evaluation evaluation);
}
