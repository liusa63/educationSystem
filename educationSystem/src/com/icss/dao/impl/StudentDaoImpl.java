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
 * @date: 2017��9��27������9:08:01
 */
@Repository(value="studentDao")
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSessionFactory(sessionFactory);
	}

	/* 
	 * ��ѯѧ��������Ϣ
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
	 * ��ѯѧ��
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
	 * �޸�����
	 */
	public void changeStudentPwd(User user) {
		
		this.getHibernateTemplate().update(user);
		
		
	}
	
	/* 
	 * ��ѯѧ����ѧ�ڵĿγ�
	 */
	public List<StudentNowCourseVo> findStudentNowCourse(User user) {

	 List<StudentNowCourseVo> list = new ArrayList<StudentNowCourseVo>();

      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
      String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
      
      Major major = findMajor(user);
      int maId = major.getMaId();//ѧ������רҵid
      
      //ѧ�����ڰ༶
      Student student = findStudent(user.getUnumber());
	  Sclass sclass= student.getSclass();
	  int clId=sclass.getClId();//ѧ�����ڰ༶id
      
      String hql ="from Course where maId=? and  coEndTime > ? and coStartTime < ? " ; //��ѯ�־û���
	  Query query = this.getSession().createQuery(hql);
	  query.setInteger(0, maId);
	  query.setString(1, time);
	  query.setString(2, time);
	  List<Course> courses = query.list();
	  
	  if(courses != null && courses.size()>0){
		  for(int i =0;i<courses.size();i++){
			  int coId= courses.get(i).getCoId();//�γ�id
			  
			  //��ѧ����ϸ��Ϣ
			  List<EnCourse> encourse = findEnCourseByCoidAndClId(coId, clId);
			    for(int j=0;j<encourse.size();j++){
			    	 StudentNowCourseVo vo = new StudentNowCourseVo();
			    	//��ʦ
				    Teacher teacher = findTeacherById(encourse.get(j).getTeId());
				    vo.setTeName(teacher.getTeName());//��ʦ����
					//����
				    Room room = findRoomById(encourse.get(j).getRoId());
				    vo.setRoName(room.getRoName());//��������
				    vo.setEnDay(encourse.get(j).getEnDay());//����
					vo.setEnStart(encourse.get(j).getEnStart());//��ʼʱ��
					vo.setEnEnd(encourse.get(j).getEnEnd());//����ʱ��
			    	
					 //�����Ϣ
					  vo.setCoName(courses.get(i).getCoName());//�γ���
					  vo.setCoScore(courses.get(i).getCoScore());//ѧ��
					  vo.setCoStatus(courses.get(i).getCoStatus());//����
					  vo.setCoWeek(courses.get(i).getCoWeek());//�ܴ�
					  vo.setCoStartTime(courses.get(i).getCoStartTime());//ѧ�ڿ�ʼʱ��
					  vo.setCoEndTime(courses.get(i).getCoEndTime()); //ѧ�ڽ���ʱ��
					  list.add(vo);
			    }
			 
			
		  }
		  
		  return list;
	  }
	  
	  
	  
		return null;
	}

	/* 
	 * ��ҳ��ѯѧ�������пγ̣���רҵ�����пγ̣�
	 */
	public List<Course> findAllCourse(int begin, int max,Major major) {
		
		String hql ="from Course where maId=? Order by coStartTime asc"; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, major.getMaId());
		
		query.setFirstResult(begin);//��ʼ����
		query.setMaxResults(max);//ÿҳչʾ������
		
		List<Course> list = query.list();
		
		if(list != null && list.size()>0){
			
			return list;
		}
		
		return null;
		
	}

	/* 
	 * ��ѯѧ������רҵ
	 */
	public Major findMajor(User user) {
		
		Student student = findStudent(user.getUnumber());
		
		Major major= student.getSclass().getMajor();
		
		return major;
	}
	
	/* 
	 * ��ѯѧ������רҵ���ܿγ���
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
	 * ��ҳ��ѯ����ɵĿγ�
	 */
	public List<CourseVo> finishedCourse(int begin, int max,Major major,String date,User user) {
		
		List<CourseVo> listVo = new ArrayList<CourseVo>();
		
		/**
		 * ��ѯ�γ�
		 */
		String hql ="from Course where maId=? and  coEndTime < ? Order by coStartTime asc" ; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, major.getMaId());
		query.setString(1, date);
		
		query.setFirstResult(begin);//��ʼ����
		query.setMaxResults(max);//ÿҳչʾ������
		
		List<Course> list = query.list();
		
		if(list !=null && list.size()>0){
			
			for(int i=0;i<list.size();i++){
				
				CourseVo vo = new CourseVo();
				
				String cname = list.get(i).getCoName();//��ȡ�γ���
				
				vo.setCoName(cname);//set�γ���
				vo.setCoId(list.get(i).getCoId());//set�γ�ID
				vo.setCoScore(list.get(i).getCoScore());//set�γ�ѧ��
				vo.setCoStatus(list.get(i).getCoStatus());//set�γ�����
				vo.setCoStartTime(list.get(i).getCoStartTime());//set�γ���ʼʱ��
				vo.setCoEndTime(list.get(i).getCoEndTime());//set�γ̽���ʱ��
				
				/**
				 * ��ѯ�ɼ�
				 */
				String num = user.getUnumber();//��ȡѧ��
				
				Grade grade =findGradeBySnumAndCname(num,cname);
				
				if(grade != null){
					
					vo.setScore(grade.getScore());//set�ɼ�
				}
				
				/**
				 * ��ѯ����
				 */
				String hql2 ="from Evaluation where coId=? and stNum=?" ; //��ѯ�־û���
				Query query2 = this.getSession().createQuery(hql2);
				query2.setInteger(0, list.get(i).getCoId());//ѧ��
				query2.setString(1, user.getUnumber());//�γ̺�
				
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
	 * ��ѯָ���γ̵ĳɼ�
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
	 *��ѯ����ɵĿγ�����
	 */
	public int selectFinishedCountCourse(int maId,String date) {
        
		int count = 0;
		String hql ="from Course where maId=? and  coEndTime < ? " ; //��ѯ�־û���
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
	 *��ҳ��ѯδ��ɵĿγ�
	 */
	public List<Course> undoneCourse(int begin, int max, Major major,String date) {
		
		String hql ="from Course where maId=? and  coEndTime > ? Order by coStartTime asc" ; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		
		query.setInteger(0, major.getMaId());
		query.setString(1, date);
		
		query.setFirstResult(begin);//��ʼ����
		query.setMaxResults(max);//ÿҳչʾ������
		
		List<Course> list = query.list();
		
		if(list != null && list.size()>0){
			
			return list;
			
		}
		
		return null;
	}

	/*
	 * ��ѯδ��ɵĿγ�����
	 */
	public int selectUndoneCountCourse(int maId, String date) {
		int count = 0;
		String hql ="from Course where maId=? and  coEndTime > ?" ; //��ѯ�־û���
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
	 * ��ҳ��ѯ����ѡ�޿�
	 */
	public List<ExcourseVo> allExcourse(int begin, int max) {
		
		List<ExcourseVo>  list =new ArrayList<ExcourseVo>();
		
		String hql ="from Excourse "; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		
		query.setFirstResult(begin);//��ʼ����
		query.setMaxResults(max);//ÿҳչʾ������
		
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
            	//������
            	Room room = findRoomById(list1.get(i).getRoId());
            	vo.setRoName(room.getRoName());
            	//��ʦ��
            	Teacher teacher = findTeacherById(list1.get(i).getTeId());
            	vo.setTeName(teacher.getTeName());
            	
            	list.add(vo);
            	
            }
			
			
			return list;
		}
		
		
		return null;
	}

	/* 
	 * ��ѯѡ�޿�����
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
	 * ��ѯָ��ѧ����ѡ��
	 */
	public List<ExcourseVo> findMyExcourseVo(User user){
		
		List<ExcourseVo>  list = new ArrayList<ExcourseVo>();//��������
		String stNum = user.getUnumber();//��ȡѧ��
		
		String hql ="from Student where stNum=? " ; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		query.setString(0, stNum);
		
		List<Student> list1 = query.list();
		
		Student student = null;
		
		if(list1!=null && list1.size()>0){
			student = list1.get(0);//��ȡѧ������
		}
		//������ѡ�޿γ�
		Set<Excourse>  set = student.getExCourses();//ѡ�޿μ���
		for(Excourse e:set){
			ExcourseVo vo = new ExcourseVo();
    		
        	vo.setExId(e.getExId());
        	vo.setExName(e.getExName());//�γ���
        	System.out.println(vo.getExName());
            vo.setTeId(e.getTeId());//��ʦid
        	vo.setExWeek(e.getExWeek());//�ܴ�
        	System.out.println(vo.getExWeek());
        	vo.setExDay(e.getExDay());//����
        	System.out.println(vo.getExDay());
        	vo.setExStart(e.getExStart());//��ʼʱ��
        	System.out.println(vo.getExStart());
        	vo.setExEnd(e.getExEnd());//����ʱ��
        	System.out.println(vo.getExEnd());
    	    vo.setRoId(e.getRoId());
        	vo.setExScore(e.getExScore());
        	//������
        	Room room = findRoomById(e.getRoId());
        	vo.setRoName(room.getRoName());
        	//��ʦ��
        	Teacher teacher = findTeacherById(e.getTeId());
        	vo.setTeName(teacher.getTeName());
        	//�ɼ�
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
	        	vo.setExName(it.next().getExName());//�γ���
	        	System.out.println(vo.getExName());
                vo.setTeId(it.next().getTeId());//��ʦid
            	vo.setExWeek(it.next().getExWeek());//�ܴ�
            	System.out.println(vo.getExWeek());
            	vo.setExDay(it.next().getExDay());//����
            	System.out.println(vo.getExDay());
            	vo.setExStart(it.next().getExStart());//��ʼʱ��
            	System.out.println(vo.getExStart());
            	vo.setExEnd(it.next().getExEnd());//����ʱ��
            	System.out.println(vo.getExEnd());
        	    vo.setRoId(it.next().getRoId());
            	vo.setExScore(it.next().getExScore());
            	//������
            	Room room = findRoomById(it.next().getRoId());
            	vo.setRoName(room.getRoName());
            	//��ʦ��
            	Teacher teacher = findTeacherById(it.next().getTeId());
            	vo.setTeName(teacher.getTeName());
            	//�ɼ�
            	Grade grade = findGradeBySnumAndCname(stNum, it.next().getExName());
            	if(grade != null){
            		
            		vo.setGrade(grade.getScore());
            	}
            	
            	list.add(vo);
        		
        }*/
		
		return list;
	}

	/*
	 *����ҵ�ѡ�޿�
	 */
	public void addMyExcourse(User user,int exId) {
		
		//��ȡ��ѧ������
		Student student = new Student();
		String uNum = user.getUnumber();
		String hql ="from Student where stNum=? " ; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		query.setString(0, uNum);
		List<Student> list = query.list();
		if(list!=null && list.size()>0){
			student = list.get(0);
			
		}
		
		//��ȡExcourse����
		Excourse excourse = (Excourse) this.getSession().get(Excourse.class, exId);
		//������
		int count = excourse.getExCount();
		   
		   //��һ
			count--;
			excourse.setExCount(count);
			Set<Excourse> exCourses = student.getExCourses();
			//��ѧ�������Excourse
			exCourses.add(excourse);
			//�����ѧ������
			this.getHibernateTemplate().save(student);
			
		
	}

	/* 
	 * ����id��ѯ����
	 */
	public Room findRoomById(int id){
		
		String hql ="from Room where roId=? " ; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		
		List<Room> list = query.list();
		
		Room room = list.get(0);
		
		return room;
	}
	
	/*
	 * ����id��ѯ��ʦ
	 */
	public Teacher findTeacherById(int id){
		
		String hql ="from Teacher where teId=? " ; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		
		List<Teacher> list = query.list();
		
		Teacher teacher = list.get(0);
		
		return teacher;
		
	}

	/*
	 * ���ݿγ�id�Ͱ༶id��ѯenCourse
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
	 * ��ѯָ��ѧ�������гɼ�
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
	 *��ѯ��������
	 */
	public List<Question> findQuestion() {
		
		List<Question> list = this.getHibernateTemplate().find("From Question");
		
        if(list != null && list.size()>0){
			
			return list;
		}
		
		return null;
	}

	/* 
	 * ��ȡ����ʱ����ʦ����
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
	 * ��ӽ�ѧ����
	 */
	public void addEvaluation(Evaluation evaluation){
		
		this.getHibernateTemplate().save(evaluation);
		
	}

}
