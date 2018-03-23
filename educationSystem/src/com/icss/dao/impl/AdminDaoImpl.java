package com.icss.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

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
import com.icss.entity.Student;
import com.icss.entity.Teacher;
import com.icss.entity.User;

import com.icss.util.PageList;

@Repository(value = "adminDao")
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Autowired
	@Qualifier(value = "sessionFactory")
	public void funSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	// 逐个添加教师信息
	public void addTeacher(Teacher teacher) {
		this.getHibernateTemplate().save(teacher);
		User user = new User();
		user.setUnumber(teacher.getTeNum());
		user.setUrole(2);
		user.setUpwd("123");
		user.setUstatus(1);
		this.getHibernateTemplate().save(user);
	}
	// 逐个添加班级信息
	public void addSclass(Sclass sclass) {
		this.getHibernateTemplate().save(sclass);
	}

	// 逐个添加课程信息
	public void addCourse(Course course) {
		this.getHibernateTemplate().save(course);

	}

	// 添加问题
	public void addQuestion(Question question) {
	
			this.getHibernateTemplate().save(question);

		
		
		
	}
	
	// 查看所有问题

	public List<Question> selectAllQuestion() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Question");
	}


	public List<Teacher> selectListTeacher(PageList<Teacher> page, int pageSize) {
		String hql = "from Teacher";
		Query query = this.getSession().createQuery(hql);
		System.out.println(page.getCurrentPage());
		query.setFirstResult((page.getCurrentPage() - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Teacher> list = query.list();
		return list;

	}

	public int getTotal() {
		List<Teacher> list = this.getHibernateTemplate().find("from Teacher");
		int totalcount = list.size();
		return totalcount;
	}

	// 查询所有专业
	public List<Major> selectAllMajor() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Major");
	}

	// 查询班主任
	public List<Teacher> selectByIdTeacher(String tebehave) {
		String hql = "from Teacher where teBehave=?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, tebehave);
		List<Teacher> list = query.list();
		return list;
	}

	// 根据id查询专业
	public Major selectByIdMajor(int maid) {
		String hql = "from Major where maId=?";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, maid);
		List<Major> list = query.list();
		Major m = null;
		if (list != null && list.size() > 0) {

			m = list.get(0);
		}

		return m;
	}

	// 查询所有选修课
	public List<Course> selectAllCourse(String costatus) {
		String hql = "from Course where coStatus=?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, costatus);
		List<Course> list = query.list();
		return list;

	}

	// 查询所有教室
	public List<Room> selectAjaxRoom() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Room");
	}

	// 录入选修课成绩
	public void addExCourse(Excourse excourse) {
		this.getHibernateTemplate().save(excourse);

	}

	// 根据专业查询必修课程
	public List<Course> selectBasicCourse(String costatus, int maid) {
		String hql = "from Course where coStatus=? and maId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, costatus);
		query.setInteger(1, maid);
		List<Course> clist = query.list();
		return clist;
	}
	public List<Sclass> selectListSclass(PageList<Sclass> page, int pageSize) {
		String hql = "from Sclass";
		Query query = this.getSession().createQuery(hql);
		System.out.println(page.getCurrentPage());
		query.setFirstResult((page.getCurrentPage() - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Sclass> sclist = query.list();
		return sclist;

	}

	public int getTotalSclass() {
		List<Sclass> list = this.getHibernateTemplate().find("from Sclass");
		int totalcount = list.size();
		return totalcount;
	}

	//修改班级
	public void updateSclass(Sclass sclass) {
		this.getHibernateTemplate().update(sclass);
		
	}

	//查询指定id班级
	public Sclass selectByIdSclass(int clid) {
		String hql = "from Sclass where clId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, clid);
		List<Sclass> sc=query.list();
		Sclass s=null;
		if(sc!=null&&sc.size()>0){
			 s=sc.get(0);
		}
		return s;
	}

	//录入学籍信息
	public void addSroll(Sroll sroll,String stbehave,Sclass sclass) {	
	 this.getHibernateTemplate().save(sroll);
	 User user = new User();
		user.setUnumber(sroll.getSrNumber());
		user.setUrole(3);
		user.setUpwd("123");
		user.setUstatus(1);
		this.getHibernateTemplate().save(user);
		Student student=new Student();
		student.setStBehave(stbehave);
		student.setSclass(sclass);
		student.setStNum(sroll.getSrNumber());
		student.setStName(sroll.getSrName());
		this.getHibernateTemplate().save(student);

	}

	//查找指定id教师
	public Teacher selectByIdTeacher(int teid) {
		String hql = "from Teacher where teId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		List<Teacher> te=query.list();
		Teacher t=null;
		if(te!=null&&te.size()>0){
			 t=te.get(0);
		}
		return t;
	}

	//修改教师信息
	public void updateByIdTeacher(Teacher teacher) {
		this.getHibernateTemplate().update(teacher);
	}

	//查询课程，分页展示
	public List<Course> selectListSchoolCourse(PageList<Course> page,
			int pageSize) {
		String hql = "from Course";
		Query query = this.getSession().createQuery(hql);
		System.out.println(page.getCurrentPage());
		query.setFirstResult((page.getCurrentPage()-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Course> clist = query.list();
		return clist;
		
	}

	//获取共有多少条数据
	public int getTotalSchoolCourse() {
		List<Course> list = this.getHibernateTemplate().find("from Course");
		int totalcount = list.size();
		return totalcount;
	}
	
	//根据学号和课程名查看成绩
	public Grade selectGrade(String stnum, String coname) {
		String hql = "from Grade where stNum=? and coName=? ";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, stnum);
		query.setString(1, coname);
		List<Grade> glist = query.list();
		Grade grade=null;
		if(glist!=null&&glist.size()>0){
			 grade=glist.get(0);
		}
		return grade;
	
	}

	//修改成绩
	public void updateGrade(Grade grade) {
		this.getHibernateTemplate().update(grade);
	}

	//根据id查看学号和课程
	public Grade selectById(int grid) {
		String hql = "from Grade where grId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, grid);
		
		List<Grade> glist = query.list();
		Grade grade=null;
		if(glist!=null&&glist.size()>0){
			 grade=glist.get(0);
		}
		return grade;
		
	}
	//获取选课列表
	public List<Excourse> selectListExcourse(PageList<Excourse> page, int pageSize) {
		String hql = "from Excourse";
		Query query = this.getSession().createQuery(hql);
		System.out.println(page.getCurrentPage());
		query.setFirstResult((page.getCurrentPage()-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Excourse> exlist = query.list();
		return exlist;
	}
	//获取有多少条数据
	public int getTotalExcourse() {
		List<Excourse> list = this.getHibernateTemplate().find("from Excourse");
		int totalcount = list.size();
		return totalcount;
	}

	//根据id查看选课
	public Excourse findByIdExcourse(int exid) {
		
		String hql = "from Excourse where exId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, exid);
		
		List<Excourse> exlist = query.list();
		Excourse excourse=null;
		if(exlist!=null&&exlist.size()>0){
			excourse=exlist.get(0);
		}
		return excourse;
	}

	//修改选课
	public void updateExcourse(Excourse excourse) {
		this.getHibernateTemplate().update(excourse);
		
	}
	//根据教师id查询该教师所教选修的课程
	public List<Excourse> selectByTeacherExcourse(int teid) {
		String hql = "from Excourse where teId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		
		List<Excourse> exlist = query.list();
		
		return exlist;
	}
	//根据教师id查询该教师所教必修的课程
	public  List<EnCourse> selectByTeacherEncourse(int teid) {
		String hql = "from EnCourse where teId=? ";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		
		List<EnCourse> enlist = query.list();
		
		return enlist;
	}
	
//教学评估
	public Double selectEvaluation1(int teid, int coid) {
		String hql = "select avg(answer1) from Evaluation where teId=? and coId=?";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		query.setInteger(1, coid);		
		Double avg1 =(Double) query.uniqueResult();				
		return avg1;
	}

	public Double selectEvaluation2(int teid, int coid) {
		String hql = "select avg(answer2) from Evaluation where teId=? and coId=?";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		query.setInteger(1, coid);		
		Double avg2 =(Double) query.uniqueResult();				
		return avg2;
	}

	public Double selectEvaluation3(int teid, int coid) {
		String hql = "select avg(answer3) from Evaluation where teId=? and coId=?";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		query.setInteger(1, coid);		
		Double avg3 =(Double) query.uniqueResult();				
		return avg3;
	}

	public Double selectEvaluation4(int teid, int coid) {
		String hql = "select avg(answer4) from Evaluation where teId=? and coId=?";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		query.setInteger(1, coid);		
		Double avg4 =(Double) query.uniqueResult();				
		return avg4;
	}

	public Double selectEvaluation5(int teid, int coid) {
		String hql = "select avg(answer5) from Evaluation where teId=? and coId=?";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, teid);
		query.setInteger(1, coid);		
		Double avg5 =(Double) query.uniqueResult();				
		return avg5;
	}

	//根据学号查看学籍
	public Sroll selectSroll(String srNum) {
		String hql = "from Sroll where srNumber=?";		
		Query query = this.getSession().createQuery(hql);
		query.setString(0, srNum);
		List<Sroll> list=query.list();
		Sroll sroll=null;
		if(list!=null&&list.size()>0){
			sroll=list.get(0);
		}
		return sroll;
	}
	

	public List<Sclass> ajaxSelectAllSclass() {
		String hql = "from Sclass ";		
		Query query = this.getSession().createQuery(hql);
		List<Sclass> list=query.list();
		return list;
		
	}
	
//根据专业id查询上课老师
	public List<Teacher> selectTeacherByMajor(int maid, String tebehave) {
		String hql = "from Teacher where maId=? and teBehave=?";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, maid);
		query.setString(1, tebehave);
		List<Teacher> list=query.list();
		return list;
		
	}

	//录入必修课程
	public void addBasicCourse(EnCourse encourse) {
		this.getHibernateTemplate().save(encourse);
		
	}
	
	//根据id修改课表
	public Course findByIdSchoolCourse(int coid) {
		
		String hql = "from Course where coId=? ";		
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, coid);
		
		List<Course> list=query.list();
		Course course=null;
		if(list!=null&&list.size()>0){
			 course=list.get(0);
		}
	return course;
	}
	
	public void updateSchoolCourse(Course course) {
		this.getHibernateTemplate().update(course);
		
	}


	//修改学籍
	public void updateStudentSroll(Sroll sroll) {
		this.getHibernateTemplate().update(sroll);
		
	}

	public void addTeachers(Teacher teacher) {
		this.getHibernateTemplate().save(teacher);
		User user = new User();
		user.setUnumber(teacher.getTeNum());
		user.setUrole(2);
		user.setUpwd("123");
		this.getHibernateTemplate().save(user);
		
	}

	public Question selectByIdQuestion(int qqid) {
		String hql = "from Question where qid=?";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, qqid);
		List<Question> list = query.list();
		Question q = null;
		if (list != null && list.size() > 0) {

			q = list.get(0);
		}

		return q;
	}

	public void updateQuestion(Question question) {
		this.getHibernateTemplate().update(question);
	}

	//自动生成学号：最大值+1
	public Integer ajaxUserNumber() {
		String hql = " from User ";
		Query query = this.getSession().createQuery(hql);
		List<User> list = query.list();
		User u = null;
		Integer uNumber=null;
		if (list != null && list.size() > 0) {
			int s=list.size();
			u=list.get(s-1);
			String  stnumber=u.getUnumber();
			 uNumber=Integer.parseInt(stnumber);
		}
		System.out.println(uNumber);
		return uNumber;
	}

	
	

	
	
	

}
