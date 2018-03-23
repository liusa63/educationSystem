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
	public void addTeacher(Teacher teacher);//������ӽ�ʦ��Ϣ
	public void addTeachers(Teacher teacher);	//����¼����ʦ��Ϣ
	public void addSclass(Sclass sclass);//������Ӱ༶��Ϣ
	public void addCourse(Course course);//¼��γ���Ϣ
	public void addQuestion(Question question);//¼������
	public List<Question> selectAllQuestion( );//�鿴��������
	public void selectListTeacher(PageList<Teacher> page,int pageSize);//�鿴���н�ʦ��Ϣ
	public List<Major> selectAllMajor( );//�鿴����רҵ
	public List<Teacher> selectByIdTeacher(String tebehave);//�鿴���а�����
	public Major selectByIdMajor(int maid);//ͨ��id��ѯרҵ
	public List<Course> selectAllCourse(String costatus);//��ѯ����ѡ�޿�
	public List<Room> selectAjaxRoom();//�鿴���н���
	public void addExCourse( Excourse excourse);//¼��ѡ�޿γ�
	public List<Course> selectBasicCourse(String costatus,int maid);  //����רҵ��ѯ���б��޿γ�
	public void selectAllSclass(PageList<Sclass> page,int pageSize);//��ѯ���а༶��ҳ
	public void updateSclass(Sclass sclass); //�޸İ༶
	public Sclass selectByIdSclass(int clid);//��ѯָ��id�༶
	public void addSroll(Sroll sroll,String stbehave,Sclass sclass);//¼��ѧ����Ϣ
	public Teacher selectByIdTeacher(int teid);//����ָ��id�Ľ�ʦ
	public  void updateByIdTeacher(Teacher teacher);//�޸�ָ��id�Ľ�ʦ
	public void selectAllSchoolCourse(PageList<Course> page,int pageSize);//��ѯ���пγ̷�ҳ
	public Grade selectGrade(String stnum,String coname);//����ѧ�źͿγ����鿴�ɼ�
	public void updateGrade(Grade grade);//�޸ĳɼ�
	public Grade selectById(int grid);//����id�鿴
	public void selectAllExcourse(PageList<Excourse> page,int pageSize);//��ѯ����ѡ�Σ���ҳչʾ
	public Excourse findByIdExcourse(int exid);//����id�鿴ѡ��
	public void updateExcourse(Excourse excourse);//�޸ĳɼ�//�޸�ѡ��
	public  List<Excourse> selectByTeacherExcourse(int teid);//���ݽ�ʦid��ѯ�ý�ʦ���̵Ŀγ�
	public  List<EnCourse> selectByTeacherEncourse(int teid);//���ݽ�ʦid��ѯ�ý�ʦ���̵Ŀγ�	
	public Double  selectEvaluation1(int teid,int coid);//���ݿγ�id�ͽ�ʦid�鿴�������
	public Double  selectEvaluation2(int teid,int coid);//���ݿγ�id�ͽ�ʦid�鿴�������
	public Double  selectEvaluation3(int teid,int coid);//���ݿγ�id�ͽ�ʦid�鿴�������
	public Double  selectEvaluation4(int teid,int coid);//���ݿγ�id�ͽ�ʦid�鿴�������
	public Double  selectEvaluation5(int teid,int coid);//���ݿγ�id�ͽ�ʦid�鿴�������
	public Sroll selectSroll(String srNum);//����ѧ�Ų鿴ѧ��
	public List<Sclass>  ajaxSelectAllSclass();//�鿴���а༶
	public List<Teacher> selectTeacherByMajor(int maid,String tebehave);//����ָ��רҵ�鿴�Ͽ���ʦ
	public void addBasicCourse(EnCourse encourse);//¼����޿�
	//����id�޸Ŀα�
	public Course findByIdSchoolCourse(int coid);
	public void updateSchoolCourse(Course course);
	public void updateStudentSroll(Sroll sroll); //�޸�ѧ��
	//�޸�����
	public Question selectByIdQuestion(int qqid);
	public void updateQuestion(Question question);
	//�Զ�����ѧ�ţ����ֵ+1
	public Integer ajaxUserNumber();
	
	}