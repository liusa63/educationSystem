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
 * @date2017-9-30����9:37:33
 */
public interface TeacherBiz {
	
	//���������Ϣ--��ʦ��¼ϵͳ�󣬿�����Լ��ĸ��˻�����Ϣ����û���޸Ļ�ɾ����Ȩ�ޡ�
	public TeacherVo findTeacher(String teNum);

	//�޸�����
	public void updatePwd(User user);
	
	//��ȡ��ʦid
	public Teacher findByNum(String teNum);
	
	//��ȡ�γ���Ϣ
	public Course change(int coId);
	
	//��ҳ��ѯ���б��޿γ�
	public PageList<EnCourseVo> findPageCourse(PageList<EnCourseVo> page, int pageSize,String teNum);
	
	//�����������������ӵ�������ı�ͷ��ȡ����1...
	public List<Question> selectQuestion();
	
	//��ҳ��ѯ���н�ѧ����
	public PageList<EvaluationVo> findPageEva(PageList<EvaluationVo> page, int pageSize,String teNum);
	
	//��ѯָ���γ�id
	public List<Course> findCourseList(String teNum); 
	
	//��ѯ�༶---���ݿγ�id�ͽ�ʦ����num
	public List<Sclass> selectSclassByCoIdAndTeId(int coId,String teNum);
	
    //�༶��Ϣ
	public List<Sclass> selectSclassByTeId(String teNum);
	
	//��ȡ�༶�����ѧ��
	public Set<Student> selectByClId(int clId);
	
	//¼��ɼ�
	public void addGrade(Grade grade);
	
	//�ж��Ƿ��Ѿ�¼������޳ɼ�
	public Grade selectByConameAndStnum(String coName, String stNum);
	
	//��ҳ��ѯ���гɼ�
	public PageList<Grade> findPageGrade(PageList<Grade> page, int pageSize);
	
	//��ҳ��ѯ���гɼ�------���ݿγ̷���
	public PageList<Grade> selectPageGradeByCourse(PageList<Grade> page, int pageSize,String coName,String stNum);
	
	//�鿴�ɼ������ݿγ�ѧ��
	public List<Grade> selectGrades(String coName, int coId);
	
	
	//��ҳ��ѯ����ѡ�޿γ�
	public PageList<ExcourseVo> findPageExcourse(PageList<ExcourseVo> page, int pageSize,String teNum);

	//��ѯѡ�޿�----���ݽ�ʦteNum
	public List<Excourse> selectExcourseByTeid(String teNum);

	//��ѯѡ��ĳ�ſε�ѧ������----����ѡ�޿�����exName
	public Set<Student> selectByExname(int exId);
	
	//��ѯĳѡ�޿�����----���ݸ���ѡ�޿�����exName
	public Excourse selectExcourseByExname(int exId);
	
	//�ж��Ƿ��Ѿ�¼���ѡ�޳ɼ�
	public Grade selectByExnameAndStnum(String coName, String stNum);
	
	//�鿴�ɼ������ݿγ�ѧ��
	public List<Grade> selectExGrades(String coName);
}
