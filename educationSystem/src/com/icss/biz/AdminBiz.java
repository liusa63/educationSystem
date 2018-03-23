package com.icss.biz;

import java.util.List;

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

public interface AdminBiz {
	public void addTeacher(Teacher teacher);//逐个添加教师信息
	public void addTeachers(Teacher teacher);	//批量录入老师信息
	public void addSclass(Sclass sclass);//逐个添加班级信息
	public void addCourse(Course course);//录入课程信息
	public void addQuestion(Question question);//录入问题
	public List<Question> selectAllQuestion( );//查看所有问题
	public void selectListTeacher(PageList<Teacher> page,int pageSize);//查看所有教师信息
	public List<Major> selectAllMajor( );//查看所有专业
	public List<Teacher> selectByIdTeacher(String tebehave);//查看所有班主任
	public Major selectByIdMajor(int maid);//通过id查询专业
	public List<Course> selectAllCourse(String costatus);//查询所有选修课
	public List<Room> selectAjaxRoom();//查看所有教室
	public void addExCourse( Excourse excourse);//录入选修课程
	public List<Course> selectBasicCourse(String costatus,int maid);  //根据专业查询所有必修课程
	public void selectAllSclass(PageList<Sclass> page,int pageSize);//查询所有班级分页
	public void updateSclass(Sclass sclass); //修改班级
	public Sclass selectByIdSclass(int clid);//查询指定id班级
	public void addSroll(Sroll sroll,String stbehave,Sclass sclass);//录入学籍信息
	public Teacher selectByIdTeacher(int teid);//查找指定id的教师
	public  void updateByIdTeacher(Teacher teacher);//修改指定id的教师
	public void selectAllSchoolCourse(PageList<Course> page,int pageSize);//查询所有课程分页
	public Grade selectGrade(String stnum,String coname);//根据学号和课程名查看成绩
	public void updateGrade(Grade grade);//修改成绩
	public Grade selectById(int grid);//根据id查看
	public void selectAllExcourse(PageList<Excourse> page,int pageSize);//查询所有选课，分页展示
	public Excourse findByIdExcourse(int exid);//根据id查看选课
	public void updateExcourse(Excourse excourse);//修改成绩//修改选课
	public  List<Excourse> selectByTeacherExcourse(int teid);//根据教师id查询该教师所教的课程
	public  List<EnCourse> selectByTeacherEncourse(int teid);//根据教师id查询该教师所教的课程	
	public Double  selectEvaluation1(int teid,int coid);//根据课程id和教师id查看评估结果
	public Double  selectEvaluation2(int teid,int coid);//根据课程id和教师id查看评估结果
	public Double  selectEvaluation3(int teid,int coid);//根据课程id和教师id查看评估结果
	public Double  selectEvaluation4(int teid,int coid);//根据课程id和教师id查看评估结果
	public Double  selectEvaluation5(int teid,int coid);//根据课程id和教师id查看评估结果
	public Sroll selectSroll(String srNum);//根据学号查看学籍
	public List<Sclass>  ajaxSelectAllSclass();//查看所有班级
	public List<Teacher> selectTeacherByMajor(int maid,String tebehave);//根据指定专业查看上课老师
	public void addBasicCourse(EnCourse encourse);//录入必修课
	//根据id修改课表
	public Course findByIdSchoolCourse(int coid);
	public void updateSchoolCourse(Course course);
	public void updateStudentSroll(Sroll sroll); //修改学籍
	//修改问题
	public Question selectByIdQuestion(int qqid);
	public void updateQuestion(Question question);
	//自动生成学号：最大值+1
	public Integer ajaxUserNumber();
	
	}
