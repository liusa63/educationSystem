/**
 * 
 */
package com.icss.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;












import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.icss.dao.StudentDao;
import com.icss.entity.Course;
import com.icss.entity.CourseVo;
import com.icss.entity.EnCourse;
import com.icss.entity.Evaluation;
import com.icss.entity.Excourse;
import com.icss.entity.ExcourseVo;
import com.icss.entity.Grade;
import com.icss.entity.Major;
import com.icss.entity.Question;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Sroll;
import com.icss.entity.Student;
import com.icss.entity.StudentNowCourseVo;
import com.icss.entity.Teacher;
import com.icss.entity.User;

/**
 *<p>Title:StudentDaoImpl</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月27日上午9:08:01
 */
@Repository(value="studentDao")
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSessionFactory(sessionFactory);
	}

	/* 
	 * 查询学生表中信息
	 */
	public Student findStudent(String stNum) {
		
		String hql = "From Student where stNum=?";	
		
		List<Student> list = this.getHibernateTemplate().find(hql, stNum);
		
		Student student = null;
		
		if(list != null && list.size()>0){
			
			student = list.get(0);
			
		}
		return student;
	}

	/* 
	 * 查询学籍
	 */
	public Sroll findStudentInfo(String stNum) {
		
        String hql = "From Sroll where srNumber=?";	
		
		List<Sroll> list = this.getHibernateTemplate().find(hql, stNum);
		
		Sroll sroll = null;
		
		if(list != null && list.size()>0){
			
			sroll = list.get(0);
			
		}
		
		return sroll;
	}

	/* 
	 * 修改密码
	 */
	public void changeStudentPwd(User user) {
		
		this.getHibernateTemplate().update(user);
		
		
	}
	
	/* 
	 * 查询学生本学期的课程
	 */
	public List<StudentNowCourseVo> findStudentNowCourse(User user) {

	 List<StudentNowCourseVo> list = new ArrayList<StudentNowCourseVo>();

      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
      String time=df.format(new Date());// new Date()为获取当前系统时间
      
      Major major = findMajor(user);
      int maId = major.getMaId();//学生所在专业id
      
      //学生所在班级
      Student student = findStudent(user.getUnumber());
	  Sclass sclass= student.getSclass();
	  int clId=sclass.getClId();//学生所在班级id
      
      String hql ="from Course where maId=? and  coEndTime > ? and coStartTime < ? " ; //查询持久化类
	  Query query = this.getSession().createQuery(hql);
	  query.setInteger(0, maId);
	  query.setString(1, time);
	  query.setString(2, time);
	  List<Course> courses = query.list();
	  
	  if(courses != null && courses.size()>0){
		  for(int i =0;i<courses.size();i++){
			  int coId= courses.get(i).getCoId();//课程id
			  
			  //本学期详细信息
			  List<EnCourse> encourse = findEnCourseByCoidAndClId(coId, clId);
			    for(int j=0;j<encourse.size();j++){
			    	 StudentNowCourseVo vo = new StudentNowCourseVo();
			    	//老师
				    Teacher teacher = findTeacherById(encourse.get(j).getTeId());
				    vo.setTeName(teacher.getTeName());//老师名称
					//教室
				    Room room = findRoomById(encourse.get(j).getRoId());
				    vo.setRoName(room.getRoName());//教室名称
				    vo.setEnDay(encourse.get(j).getEnDay());//星期
					vo.setEnStart(encourse.get(j).getEnStart());//开始时间
					vo.setEnEnd(encourse.get(j).getEnEnd());//结束时间
			    	
					 //大纲信息
					  vo.setCoName(courses.get(i).getCoName());//课程名
					  vo.setCoScore(courses.get(i).getCoScore());//学分
					  vo.setCoStatus(courses.get(i).getCoStatus());//属性
					  vo.setCoWeek(courses.get(i).getCoWeek());//周次
					  vo.setCoStartTime(courses.get(i).getCoStartTime());//学期开始时间
					  vo.setCoEndTime(courses.get(i).getCoEndTime()); //学期结束时间
					  list.add(vo);
			    }
			 
			
		  }
		  
		  return list;
	  }
	  
	  
	  
		return null;
	}

	/* 
	 * 分页查询学生的所有课程（本专业的所有课程）
	 */
	public List<Course> findAllCourse(int begin, int max,Major major) {
		
		String hql ="from Course where maId=? Order by coStartTime asc"; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, major.getMaId());
		
		query.setFirstResult(begin);//起始条数
		query.setMaxResults(max);//每页展示的条数
		
		List<Course> list = query.list();
		
		if(list != null && list.size()>0){
			
			return list;
		}
		
		return null;
		
	}

	/* 
	 * 查询学生所在专业
	 */
	public Major findMajor(User user) {
		
		Student student = findStudent(user.getUnumber());
		
		Major major= student.getSclass().getMajor();
		
		return major;
	}
	
	/* 
	 * 查询学生所在专业的总课程数
	 */
	public int selectCountCourse(int maId){
		
		int count = 0;
		
		String hql="From Course where maId=?";
		
		List<Course> list = this.getHibernateTemplate().find(hql, maId);
		
		if(list != null && list.size()>0){
			
			count = list.size();
			
		}
		
		return count;
	}
	
	/* 
	 * 分页查询已完成的课程
	 */
	public List<CourseVo> finishedCourse(int begin, int max,Major major,String date,User user) {
		
		List<CourseVo> listVo = new ArrayList<CourseVo>();
		
		/**
		 * 查询课程
		 */
		String hql ="from Course where maId=? and  coEndTime < ? Order by coStartTime asc" ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, major.getMaId());
		query.setString(1, date);
		
		query.setFirstResult(begin);//起始条数
		query.setMaxResults(max);//每页展示的条数
		
		List<Course> list = query.list();
		
		if(list !=null && list.size()>0){
			
			for(int i=0;i<list.size();i++){
				
				CourseVo vo = new CourseVo();
				
				String cname = list.get(i).getCoName();//获取课程名
				
				vo.setCoName(cname);//set课程名
				vo.setCoId(list.get(i).getCoId());//set课程ID
				vo.setCoScore(list.get(i).getCoScore());//set课程学分
				vo.setCoStatus(list.get(i).getCoStatus());//set课程属性
				vo.setCoStartTime(list.get(i).getCoStartTime());//set课程起始时间
				vo.setCoEndTime(list.get(i).getCoEndTime());//set课程结束时间
				
				/**
				 * 查询成绩
				 */
				String num = user.getUnumber();//获取学号
				
				Grade grade =findGradeBySnumAndCname(num,cname);
				
				if(grade != null){
					
					vo.setScore(grade.getScore());//set成绩
				}
				
				/**
				 * 查询评估
				 */
				String hql2 ="from Evaluation where coId=? and stNum=?" ; //查询持久化类
				Query query2 = this.getSession().createQuery(hql2);
				query2.setInteger(0, list.get(i).getCoId());//学号
				query2.setString(1, user.getUnumber());//课程号
				
				List<Evaluation> list2 = query2.list();
				if(list2 != null && list2.size()>0){
					vo.setStatus("2");
				}else{
					vo.setStatus("1");
				}
				
				
				listVo.add(vo);
				
			}
			
		}
		
		return listVo;
	}

	/*
	 * 查询指定课程的成绩
	 */
	public Grade findGradeBySnumAndCname(String stNum,String coName){
		
		String hql1 = "from Grade where stNum=? and coName=?";
		
		Query query1 = this.getSession().createQuery(hql1);
		
		query1.setString(0, stNum);
		query1.setString(1, coName);
		
		List<Grade> grade =  query1.list();
		Grade g = null;
		
		if(grade != null && grade.size()>0){
			 
			g = grade.get(0);
			
		}
		
		return g;
	}
	
	/* 
	 *查询已完成的课程总数
	 */
	public int selectFinishedCountCourse(int maId,String date) {
        
		int count = 0;
		String hql ="from Course where maId=? and  coEndTime < ? " ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, maId);
		query.setString(1, date);
		
		List<Course> list = query.list();
		
		if(list != null && list.size()>0){
			
			count = list.size();
			
		}
		
		return count;
	}

	/* 
	 *分页查询未完成的课程
	 */
	public List<Course> undoneCourse(int begin, int max, Major major,String date) {
		
		String hql ="from Course where maId=? and  coEndTime > ? Order by coStartTime asc" ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, major.getMaId());
		query.setString(1, date);
		
		query.setFirstResult(begin);//起始条数
		query.setMaxResults(max);//每页展示的条数
		
		List<Course> list = query.list();
		
		if(list != null && list.size()>0){
			
			return list;
			
		}
		
		return null;
	}

	/*
	 * 查询未完成的课程总数
	 */
	public int selectUndoneCountCourse(int maId, String date) {
		int count = 0;
		String hql ="from Course where maId=? and  coEndTime > ?" ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, maId);
		query.setString(1, date);
		
		List<Course> list = query.list();
		
		if(list != null && list.size()>0){
			
			count = list.size();
			
		}
		
		return count;
	}

	/* 
	 * 分页查询所有选修课
	 */
	public List<ExcourseVo> allExcourse(int begin, int max) {
		
		List<ExcourseVo>  list =new ArrayList<ExcourseVo>();
		
		String hql ="from Excourse "; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		
		query.setFirstResult(begin);//起始条数
		query.setMaxResults(max);//每页展示的条数
		
		List<Excourse>  list1 = query.list();
		
		if(list1 != null && list1.size()>0){
			
            for(int i=0;i<list1.size();i++){
				
            	ExcourseVo vo = new ExcourseVo();
            	
            	vo.setExId(list1.get(i).getExId());
            	vo.setExName(list1.get(i).getExName());
                vo.setTeId(list1.get(i).getTeId());
            	vo.setExCount(list1.get(i).getExCount());
            	vo.setExWeek(list1.get(i).getExWeek());
            	vo.setExDay(list1.get(i).getExDay());
            	vo.setExStart(list1.get(i).getExStart());
            	vo.setExEnd(list1.get(i).getExEnd());
            	vo.setRoId(list1.get(i).getRoId());
            	vo.setExScore(list1.get(i).getExScore());
            	//教室名
            	Room room = findRoomById(list1.get(i).getRoId());
            	vo.setRoName(room.getRoName());
            	//老师名
            	Teacher teacher = findTeacherById(list1.get(i).getTeId());
            	vo.setTeName(teacher.getTeName());
            	
            	list.add(vo);
            	
            }
			
			
			return list;
		}
		
		
		return null;
	}

	/* 
	 * 查询选修课总数
	 */
	public int selectCountExcourse(){
		
		int count = 0;

		String hql="From Excourse ";
		
		List<Excourse> list = this.getHibernateTemplate().find(hql);
		
		if(list != null && list.size()>0){
			
			count = list.size();
			
		}
		
		return count;
		
	}
	
	
	
	/*
	 * 查询指定学生的选修
	 */
	public List<ExcourseVo> findMyExcourseVo(User user){
		
		List<ExcourseVo>  list = new ArrayList<ExcourseVo>();//创建集合
		String stNum = user.getUnumber();//获取学号
		
		String hql ="from Student where stNum=? " ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		query.setString(0, stNum);
		
		List<Student> list1 = query.list();
		
		Student student = null;
		
		if(list1!=null && list1.size()>0){
			student = list1.get(0);//获取学生对象
		}
		//该生的选修课程
		Set<Excourse>  set = student.getExCourses();//选修课集合
		for(Excourse e:set){
			ExcourseVo vo = new ExcourseVo();
    		
        	vo.setExId(e.getExId());
        	vo.setExName(e.getExName());//课程名
        	System.out.println(vo.getExName());
            vo.setTeId(e.getTeId());//老师id
        	vo.setExWeek(e.getExWeek());//周次
        	System.out.println(vo.getExWeek());
        	vo.setExDay(e.getExDay());//星期
        	System.out.println(vo.getExDay());
        	vo.setExStart(e.getExStart());//开始时间
        	System.out.println(vo.getExStart());
        	vo.setExEnd(e.getExEnd());//结束时间
        	System.out.println(vo.getExEnd());
    	    vo.setRoId(e.getRoId());
        	vo.setExScore(e.getExScore());
        	//教室名
        	Room room = findRoomById(e.getRoId());
        	vo.setRoName(room.getRoName());
        	//老师名
        	Teacher teacher = findTeacherById(e.getTeId());
        	vo.setTeName(teacher.getTeName());
        	//成绩
        	Grade grade = findGradeBySnumAndCname(stNum, e.getExName());
        	if(grade != null){
        		
        		vo.setGrade(grade.getScore());
        	}
        	
        	list.add(vo);
			
		}
		
		/*Iterator<Excourse> it = set.iterator();
        while(it.hasNext()){
        	
        	ExcourseVo vo = new ExcourseVo();
        		
	        	vo.setExId(it.next().getExId());
	        	vo.setExName(it.next().getExName());//课程名
	        	System.out.println(vo.getExName());
                vo.setTeId(it.next().getTeId());//老师id
            	vo.setExWeek(it.next().getExWeek());//周次
            	System.out.println(vo.getExWeek());
            	vo.setExDay(it.next().getExDay());//星期
            	System.out.println(vo.getExDay());
            	vo.setExStart(it.next().getExStart());//开始时间
            	System.out.println(vo.getExStart());
            	vo.setExEnd(it.next().getExEnd());//结束时间
            	System.out.println(vo.getExEnd());
        	    vo.setRoId(it.next().getRoId());
            	vo.setExScore(it.next().getExScore());
            	//教室名
            	Room room = findRoomById(it.next().getRoId());
            	vo.setRoName(room.getRoName());
            	//老师名
            	Teacher teacher = findTeacherById(it.next().getTeId());
            	vo.setTeName(teacher.getTeName());
            	//成绩
            	Grade grade = findGradeBySnumAndCname(stNum, it.next().getExName());
            	if(grade != null){
            		
            		vo.setGrade(grade.getScore());
            	}
            	
            	list.add(vo);
        		
        }*/
		
		return list;
	}

	/*
	 *添加我的选修课
	 */
	public void addMyExcourse(User user,int exId) {
		
		//获取到学生对象
		Student student = new Student();
		String uNum = user.getUnumber();
		String hql ="from Student where stNum=? " ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		query.setString(0, uNum);
		List<Student> list = query.list();
		if(list!=null && list.size()>0){
			student = list.get(0);
			
		}
		
		//获取Excourse对象
		Excourse excourse = (Excourse) this.getSession().get(Excourse.class, exId);
		//课余量
		int count = excourse.getExCount();
		   
		   //减一
			count--;
			excourse.setExCount(count);
			Set<Excourse> exCourses = student.getExCourses();
			//向学生中添加Excourse
			exCourses.add(excourse);
			//保存该学生对象
			this.getHibernateTemplate().save(student);
			
		
	}

	/* 
	 * 根据id查询教室
	 */
	public Room findRoomById(int id){
		
		String hql ="from Room where roId=? " ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		
		List<Room> list = query.list();
		
		Room room = list.get(0);
		
		return room;
	}
	
	/*
	 * 根据id查询老师
	 */
	public Teacher findTeacherById(int id){
		
		String hql ="from Teacher where teId=? " ; //查询持久化类
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		
		List<Teacher> list = query.list();
		
		Teacher teacher = list.get(0);
		
		return teacher;
		
	}

	/*
	 * 根据课程id和班级id查询enCourse
	 */
    public List<EnCourse> findEnCourseByCoidAndClId(int coId,int clId){
    	
    	String hql ="from EnCourse where coId=? and  clId=?";
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, coId);
		query.setInteger(1, clId);
		
		List<EnCourse> list = query.list();
		if(list != null && list.size()>0){
			return list;
		}
    	
    	return null;
    }
	
	/*
	 * 查询指定学生的所有成绩
	 */
	public List<Grade> findMyGrade(User user){
		
		String hql="from Grade where stNum=?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, user.getUnumber());
		
		List<Grade> list = query.list();
		
		if(list != null && list.size()>0){
			
			return list;
		}
		
		return null;
		
	}

	/* 
	 *查询评估问题
	 */
	public List<Question> findQuestion() {
		
		List<Question> list = this.getHibernateTemplate().find("From Question");
		
        if(list != null && list.size()>0){
			
			return list;
		}
		
		return null;
	}

	/* 
	 * 获取评估时的老师对象
	 */
	public Teacher findTeacherBycoIdclId(User user, int coId) {
		
		Student student = findStudent(user.getUnumber());
		Sclass sclass = student.getSclass();
		int clId = sclass.getClId();
		
		String hql="from EnCourse where coId=? and clId=?";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, coId);
		query.setInteger(1, clId);
		List<EnCourse> list = query.list();
		int teId=0;
		if(list != null && list.size()>0){
			
			teId=list.get(0).getTeId();
			
		}
		
		Teacher teacher = findTeacherById(teId);
		
		return teacher;
	}
	
	/**
	 * 添加教学评估
	 */
	public void addEvaluation(Evaluation evaluation){
		
		this.getHibernateTemplate().save(evaluation);
		
	}

}
