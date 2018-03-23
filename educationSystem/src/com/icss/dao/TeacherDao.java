package com.icss.dao;

import java.util.List;
import java.util.Set;

import com.icss.entity.Course;
import com.icss.entity.EnCourseVo;
import com.icss.entity.EvaluationVo;
import com.icss.entity.Excourse;
import com.icss.entity.ExcourseVo;
import com.icss.entity.Grade;
import com.icss.entity.Question;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Student;
import com.icss.entity.Teacher;
import com.icss.entity.TeacherVo;
import com.icss.entity.User;

/**
 * 
 * <p>Title:TeacherDao</p>
 * <P>Description:</p>
 * <p>Company:</p>
 * @author jby
 * @date2017-9-27����3:13:26
 */
public interface TeacherDao {

	//���������Ϣ--��ʦ��¼ϵͳ�󣬿�����Լ��ĸ��˻�����Ϣ����û���޸Ļ�ɾ����Ȩ�ޡ�
	public TeacherVo findTeacher(String teNum);
	
	//�޸�����
	public void updatePwd(User user);
	
	//��ȡ��ʦid
	public Teacher findByNum(String teNum);
	
	//��ѯ�γ�����---��ӵ�List<Course>������
	public Course findCourse(int coId);
	
	//��ȡ�γ���Ϣ
	public Course change(int coId);
	
	//��ҳ��ѯ���б��޿γ�
	public List<EnCourseVo> findPageCourse(int firstResult, int pageSize,int teId);
	
	//��ѯָ����ʦ�γ�����---����EnCourse���޿γ̱�
	public int selectCountCourse(int teId);
	
	//�����������������ӵ�������ı�ͷ��ȡ����1...
	public List<Question> selectQuestion();
	
	//���ݿγ̲鿴��������������ÿ�������ƽ����
	public EvaluationVo selectByCoId(int coId,int teId);

	//��ҳ��ѯ��������
	public List<EvaluationVo> findPageEva(int firstResult, int pageSize,int teId);
	
	//��ѯָ����ʦ��������-----����Envalution
	public int selectCountEva(int coId);
	
	//��ѯָ���γ�id
	public List<Course> findCourseList(int teId); 
	
	//��ѯ�༶---���ݿγ�id�ͽ�ʦid
	public List<Sclass> selectSclassByCoIdAndTeId(int coId,int teId);
	
    //�༶��Ϣ
	public List<Sclass> selectSclassByTeId(int teId);

	//��ȡ�༶�����ѧ��
	public Set<Student> selectByClId(int clId);
	
	//¼��ɼ�
	public void addGrade(Grade grade);
	
	//�ж��Ƿ��Ѿ�¼������޳ɼ�
	public Grade selectByConameAndStnum(String coName, String stNum);
	
	
	
	//��ҳ��ѯ���б��޳ɼ�
	public List<Grade> findPageGrade(int firstResult, int pageSize);
	
	//��ѯ�ɼ�������
	public int selectCountGrade();
	
	//��ҳ��ѯ���гɼ�------���ݿγ̷���
	public List<Grade> selectPageGradeByCourse(int firstResult, int pageSize,String coName);
	
	//��ѯ�ɼ�������------���ݿγ̷���
	public int selectGradeByCourse(String coName);
	
	//��ѯһ���༶�ĳɼ�
	public List<Grade> selectGrades(int coId,String coName);
	
	//��ҳ��ѯ����ѡ�޿γ�
	public List<ExcourseVo> findPageExcourse(int firstResult, int pageSize,int teId);
	
	//���ݽ���Id��ѯ��������
	public Room findRoomByRoid(int roId);
	
	//��ѯ��ʦѡ�޿γ�����---����Excourseѡ�޿γ̱�
	public int selectCountExcourse(int teId);
	
	//��ѯѡ�޿�----���ݽ�ʦid
	public List<Excourse> selectEncourseByTeid(int teId);
	
	//��ѯѡ��ĳ�ſε�ѧ������----����ѡ�޿�����exName
	public Set<Student> selectByExname(int exId);
	
	//��ѯĳѡ�޿�����----���ݸ���ѡ�޿�id
	public Excourse selectExcourseByExname(int exId);
	
	//�ж��Ƿ��Ѿ�¼��ѡ�޳ɼ�------coName ʵ������ exName
	public Grade selectByExnameAndStnum(String coName, String stNum);
	
	//��ѯѡ�޳ɼ�----���ݿγ�����
	public List<Grade> selectExGrades(String coName);
	
}
