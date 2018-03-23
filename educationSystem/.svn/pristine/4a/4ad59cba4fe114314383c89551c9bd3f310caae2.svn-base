package com.icss.biz;

import java.util.List;
import java.util.Set;

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
 * <p>Title:TeacherBiz</p>
 * <P>Description:</p>
 * <p>Company:</p>
 * @author jby
 * @date2017-9-30上午9:37:33
 */
public interface TeacherBiz {
	
	//浏览个人信息--老师登录系统后，可浏览自己的个人基本信息，但没有修改或删除的权限。
	public TeacherVo findTeacher(String teNum);

	//修改密码
	public void updatePwd(User user);
	
	//获取教师id
	public Teacher findByNum(String teNum);
	
	//获取课程信息
	public Course change(int coId);
	
	//分页查询所有必修课程
	public PageList<EnCourseVo> findPageCourse(PageList<EnCourseVo> page, int pageSize,String teNum);
	
	//遍历问题表，将问题添加到评估表的表头，取代答案1...
	public List<Question> selectQuestion();
	
	//分页查询所有教学评估
	public PageList<EvaluationVo> findPageEva(PageList<EvaluationVo> page, int pageSize,String teNum);
	
	//查询指定课程id
	public List<Course> findCourseList(String teNum); 
	
	//查询班级---根据课程id和教师工号num
	public List<Sclass> selectSclassByCoIdAndTeId(int coId,String teNum);
	
    //班级信息
	public List<Sclass> selectSclassByTeId(String teNum);
	
	//获取班级里面的学生
	public Set<Student> selectByClId(int clId);
	
	//录入成绩
	public void addGrade(Grade grade);
	
	//判断是否已经录入过必修成绩
	public Grade selectByConameAndStnum(String coName, String stNum);
	
	//分页查询所有成绩
	public PageList<Grade> findPageGrade(PageList<Grade> page, int pageSize);
	
	//分页查询所有成绩------根据课程分类
	public PageList<Grade> selectPageGradeByCourse(PageList<Grade> page, int pageSize,String coName,String stNum);
	
	//查看成绩表，根据课程学号
	public List<Grade> selectGrades(String coName, int coId);
	
	
	//分页查询所有选修课程
	public PageList<ExcourseVo> findPageExcourse(PageList<ExcourseVo> page, int pageSize,String teNum);

	//查询选修课----根据教师teNum
	public List<Excourse> selectExcourseByTeid(String teNum);

	//查询选修某门课的学生集合----根据选修课名称exName
	public Set<Student> selectByExname(int exId);
	
	//查询某选修课详情----根据根据选修课名称exName
	public Excourse selectExcourseByExname(int exId);
	
	//判断是否已经录入过选修成绩
	public Grade selectByExnameAndStnum(String coName, String stNum);
	
	//查看成绩表，根据课程学号
	public List<Grade> selectExGrades(String coName);
}
