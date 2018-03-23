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
 * @date: 2017��9��27������9:07:34
 */
public interface StudentDao {
	
	    //��ѯѧ�������Ϣ
		public Student findStudent(String  stNum);
		
		//��ѯѧ��
		public Sroll findStudentInfo(String stNum);
		
		//�޸�ѧ������
		public void changeStudentPwd(User user);
		
		//��ѯѧ����ѧ�ڵĿγ�
		public List<StudentNowCourseVo>  findStudentNowCourse(User user);
		
		//��ѯѧ������רҵ
		public Major findMajor(User user);
		
		//��ҳ��ѯ��רҵ���пγ�
		public List<Course> findAllCourse(int begin, int max,Major major);

		//��ѯ��רҵ�γ�����
		public int selectCountCourse(int maId);
		
		//��ҳ��ѯ������ɵĿγ�
		public List<CourseVo> finishedCourse(int beginPage, int max,Major major,String date,User user);

		//��ѯ����ɿγ�����
		public int selectFinishedCountCourse(int maId,String date);
		
		//��ҳ��ѯδ��ɵĿγ�
		public List<Course> undoneCourse(int beginPage, int max,Major major,String date);

		//��ѯ����ɿγ�����
		public int selectUndoneCountCourse(int maId,String date);
		
		//��ҳ��ѯ����ѡ�޿�
		public List<ExcourseVo> allExcourse(int begin, int max);
		
		//��ѯѡ�޿ε�����
		public int selectCountExcourse();
		
		//����ҵ�ѡ�޿�
		public void addMyExcourse(User user,int exId);
		
		//�ҵ�ѡ��
		public List<ExcourseVo> findMyExcourseVo(User user);
		
		//��ѯָ������
		public Room findRoomById(int id);
		
		//��ѯָ��ѧ���ĳɼ�
		public List<Grade> findMyGrade(User user);
		
		//��ѯ��������
		public List<Question>  findQuestion();
		
		//����ʱ��ȡ��ʦ����
		public Teacher  findTeacherBycoIdclId(User user,int coId);
		
		//��ӽ�ѧ����
		public void addEvaluation(Evaluation evaluation);
}
