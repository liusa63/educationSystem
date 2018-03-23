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
 * @date: 2017��9��27������9:06:48
 */
@Service(value="studentBiz")
public class StudentBizImpl implements StudentBiz {
	
	@Autowired
	@Qualifier(value="studentDao")
	StudentDao studentDao;

	/* 
	 * ��ѯѧ�����е���Ϣ
	 */
	public Student findStudent(String stNum) {
		
		return studentDao.findStudent(stNum);
		
	}

	/* 
	 * ��ѯѧ����Ϣ
	 */
	public Sroll findStudentInfo(String stNum) {
		
		return studentDao.findStudentInfo(stNum);
	}

	/* 
	 * �޸�ѧ������
	 */
	public void changeStudentPwd(User user) {
		
		studentDao.changeStudentPwd(user);
	}


	/* 
	 * ��ѯ��ѧ�ڿα�
	 */
	public List<StudentNowCourseVo> findStudentNowCourse(User user) {
		
		return studentDao.findStudentNowCourse(user);
	}
	
	/* 
	 * ��ҳ��ѯ���пγ�
	 */
	public PageList findAllCourse(PageList<Course> page, int max,User user) {
		
		//��ȡѧ������רҵ
		Major major = studentDao.findMajor(user);
		
		//���㵱ǰҳ
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<Course> course = studentDao.findAllCourse(beginPage, max,major);
		
		page.setList(course);
		
		//��ȡ�γ�������
		int countCourse=studentDao.selectCountCourse(major.getMaId());
		page.setTotalNum(countCourse);
		
		//������ҳ��
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;
	}

	/* 
	 *��ҳ��ѯ����ɿγ�
	 */
	public PageList finishedCourse(PageList<CourseVo> page, int max, User user,String date) {
		
		//��ȡѧ������רҵ
		Major major = studentDao.findMajor(user);
		
		//���㵱ǰҳ
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<CourseVo> course = studentDao.finishedCourse(beginPage, max,major,date,user);
		
		page.setList(course);
		
		//��ȡ������ɳ�������
		int countCourse=studentDao.selectFinishedCountCourse(major.getMaId(),date);
		page.setTotalNum(countCourse);
		
		//������ҳ��
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;
		
		
	}

	/* 
	 * ��ҳ��ѯδ��ɿγ�
	 */
	public PageList undoneCourse(PageList<Course> page, int max, User user,String date) {
		
		//��ȡѧ������רҵ
		Major major = studentDao.findMajor(user);
		
		//���㵱ǰҳ
		int beginPage=(page.getCurrentPage()-1)*max;
	
		List<Course> course = studentDao.undoneCourse(beginPage, max,major,date);
		
		page.setList(course);
		
		//��ȡ��δ��ɳ�������
		int countCourse=studentDao.selectUndoneCountCourse(major.getMaId(),date);
		page.setTotalNum(countCourse);
		
		//������ҳ��
		int countPage = countCourse%max==0?countCourse/max:countCourse/max+1;
		page.setCountPage(countPage);
		
		return page;

		
		
		
	
	}

	/* 
	 * ��ҳ��ѯ����ѡ�޿�
	 */
	public PageList findAllExcourse(PageList<ExcourseVo> page, int max) {
		
		//��ʼ����
		int begin = (page.getCurrentPage()-1)*max;
		
		//��ȡ����
		List<ExcourseVo> list = studentDao.allExcourse(begin, max);
		
		page.setList(list);
		
		//��ȡѡ�޿�������
		int totalNum = studentDao.selectCountExcourse();
		page.setTotalNum(totalNum);
		
		//������ҳ��
		int countPage = totalNum%max==0?totalNum/max:totalNum/max+1;
		page.setCountPage(countPage);
		
		return page;
	}

	/* 
	 *����ҵ�ѡ�޿�
	 */
	public String addMyExcourse(User user,int exId){
		
		List<ExcourseVo> list =studentDao.findMyExcourseVo(user);
		
        int count = list.size();
		
        String judgment="";
        
		if(count<6){//С��6����ѡ��
			
			Iterator<ExcourseVo> it = list.iterator();
			
			while(it.hasNext()){
				
				ExcourseVo excourseVo = it.next();
				
				if(exId==excourseVo.getExId()){//ѡ��
					
					judgment = "excoursed";
					
					return judgment;
					
				}
			}
			
			studentDao.addMyExcourse(user, exId);
			
			judgment ="addMyExcourseSuccess";
			
		}else{//�ﵽ���ѡ������������ѡ��
			
			judgment = "excourseFull";
			
		}
		
		return judgment;

	}



	/* 
	 *��ѯָ��ѧ���ĳɼ�
	 */
	public List<Grade> findMyGrade(User user) {
		return studentDao.findMyGrade(user);
	}

	/* 
	 *��ѯ��������
	 */
	public List<Question> findQuestion() {
	
		return studentDao.findQuestion();
	}

	/* 
	 * ����ʱ��ȡ��ʦ
	 */
	public Teacher findTeacherBycoIdclId(User user, int coId) {
		
		return studentDao.findTeacherBycoIdclId(user, coId);
	}

	/* 
	 *��ӽ�ѧ����
	 */
	public void addEvaluation(Evaluation evaluation) {
		
		studentDao.addEvaluation(evaluation);
	}

	/* 
	 * �ҵ�ѡ��Vo
	 */
	public List<ExcourseVo> findMyExcourseVo(User user) {
		
		return studentDao.findMyExcourseVo(user);
	}



	

}
