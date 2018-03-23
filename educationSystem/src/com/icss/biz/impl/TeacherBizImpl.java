package com.icss.biz.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.TeacherBiz;
import com.icss.dao.TeacherDao;
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
 * <p>Title:TeacherBizImpl</p>
 * <P>Description:</p>
 * <p>Company:</p>
 * @author jby
 * @date2017-9-30����9:38:48
 */
@Service(value="teacherBiz")
public class TeacherBizImpl implements TeacherBiz{
	
	@Autowired
	@Qualifier(value="teacherDao")
	TeacherDao teacherDao;

	//���������Ϣ--��ʦ��¼ϵͳ�󣬿�����Լ��ĸ��˻�����Ϣ����û���޸Ļ�ɾ����Ȩ�ޡ�
	public TeacherVo findTeacher(String teNum) {
		return teacherDao.findTeacher(teNum);
	}

	//�޸�����
	public void updatePwd(User user) {
		teacherDao.updatePwd(user);
	}
	
	//��ȡ��ʦid
	public Teacher findByNum(String teNum) {
		return teacherDao.findByNum(teNum);
	}
	
	//��ҳ��ѯ���б��޿γ�
	public PageList<EnCourseVo> findPageCourse(PageList<EnCourseVo> page, int pageSize,
			String teNum) {
		//��ȡ��ʦ��id
		Teacher teacher=teacherDao.findByNum(teNum);
		// ��ȡ��ǰҳ
		int firstResult = (page.getCurrentPage() - 1) * pageSize;
		
		// ��ȡ����ҳ��ʾ�Ŀγ̵��б�
		List<EnCourseVo> list=teacherDao.findPageCourse(firstResult, pageSize, teacher.getTeId());
		page.setList(list);
		
		// ��ȡ�γ�������
		int totalNum = teacherDao.selectCountCourse(teacher.getTeId());
		page.setTotalNum(totalNum);
		
		// ������ҳ��
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize +1 ;
		page.setCountPage(countPage);
		
		return page;
	}
	
	//�����������������ӵ�������ı�ͷ��ȡ����1...
	public List<Question>selectQuestion() {
		return teacherDao.selectQuestion();
	}

	//��ҳ��ʾ��ѧ����
	public PageList<EvaluationVo> findPageEva(PageList<EvaluationVo> page, int pageSize, String teNum) {
		
		//��ȡ��ʦid
		Teacher teacher = teacherDao.findByNum(teNum);
		
		// ��ȡ��ǰҳ
		int firstResult = (page.getCurrentPage() - 1) * pageSize;
		
		// ��ȡ����ҳ��ʾ�Ŀγ̵��б�
		List<EvaluationVo> list = teacherDao.findPageEva(firstResult, pageSize, teacher.getTeId());
		page.setList(list);
		
		// ��ȡ�γ�������
		int totalNum = teacherDao.selectCountEva(teacher.getTeId());
		page.setTotalNum(totalNum);
		
		// ������ҳ��
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize +1 ;
		page.setCountPage(countPage);

		return page;	
	}

	//��ѯ��ʦ���������пγ�
	public List<Course> findCourseList(String teNum) {
		//��ȡ��ʦ��id
		Teacher teacher=teacherDao.findByNum(teNum);
		//��ȡ���пγ�
		return teacherDao.findCourseList(teacher.getTeId());
	}

	//��ѯ�༶---���ݿγ�id�ͽ�ʦ����num
	public List<Sclass> selectSclassByCoIdAndTeId(int coId, String teNum) {
		//��ȡ��ʦ��id
		Teacher teacher=teacherDao.findByNum(teNum);
		//��ȡ�༶
		return teacherDao.selectSclassByCoIdAndTeId(coId, teacher.getTeId());
	}

	//�༶��Ϣ---���ݽ�ʦ����teNum
	public List<Sclass> selectSclassByTeId(String teNum) {
		//��ȡ��ʦ��id
		Teacher teacher=teacherDao.findByNum(teNum);
		return teacherDao.selectSclassByTeId(teacher.getTeId());
	}

	//��ȡ�༶�����ѧ��
	public Set<Student> selectByClId(int clId) {
		return teacherDao.selectByClId(clId);
	}

	//¼��ɼ�
	public void addGrade(Grade grade) {
		teacherDao.addGrade(grade);
	}

	//�γ�����----����coId
	public Course change(int coId) {
		return teacherDao.change(coId);
	}
	
	//�ж��Ƿ��Ѿ�¼������޳ɼ�
	public Grade selectByConameAndStnum(String coName, String stNum) {
		return teacherDao.selectByConameAndStnum(coName, stNum);
	}

	//��ҳ��ѯ���гɼ�
	public PageList<Grade> findPageGrade(PageList<Grade> page, int pageSize) {
		// ��ȡ��ǰҳ
		int firstResult = (page.getCurrentPage() - 1) * pageSize;
		
		// ��ȡ����ҳ��ʾ�Ŀγ̵��б�
		List<Grade> list = teacherDao.findPageGrade(firstResult, pageSize);
		page.setList(list);
		
		// ��ȡ�γ�������
		int totalNum = teacherDao.selectCountGrade();
		page.setTotalNum(totalNum);
		
		// ������ҳ��
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize +1 ;
		page.setCountPage(countPage);

		return page;	
	}

	
	//��ҳ��ѯ���гɼ�------���ݿγ̷���
	public PageList<Grade> selectPageGradeByCourse(PageList<Grade> page,
			int pageSize, String coName,String stNum) {
		// ��ȡ��ǰҳ
		int firstResult = (page.getCurrentPage() - 1) * pageSize;

		// ��ȡ����ҳ��ʾ�Ŀγ̵��б�
		List<Grade> list = teacherDao.selectPageGradeByCourse(firstResult, pageSize, coName);
		page.setList(list);

		// ��ȡ�γ�������
		int totalNum = teacherDao.selectGradeByCourse(coName);
		page.setTotalNum(totalNum);

		// ������ҳ��
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		page.setCountPage(countPage);

		return page;
	}

	//�鿴�ɼ������ݿγ�ѧ��
	public List<Grade> selectGrades(String coName, int clid) {

		return teacherDao.selectGrades(clid, coName);
	}

	
	//��ҳ��ѯ����ѡ�޿γ�
	public PageList<ExcourseVo> findPageExcourse(PageList<ExcourseVo> page, int pageSize,
			String teNum) {
		// ��ȡ��ʦ��id
		Teacher teacher = teacherDao.findByNum(teNum);
		// ��ȡ��ǰҳ
		int firstResult = (page.getCurrentPage() - 1) * pageSize;

		// ��ȡ����ҳ��ʾ�Ŀγ̵��б�
		List<ExcourseVo> list = teacherDao.findPageExcourse(firstResult, pageSize, teacher.getTeId());
		page.setList(list);

		// ��ȡ�γ�������
		int totalNum = teacherDao.selectCountExcourse(teacher.getTeId());
		page.setTotalNum(totalNum);

		// ������ҳ��
		int countPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		page.setCountPage(countPage);

		return page;
	}

	//��ѯѡ�޿�----���ݽ�ʦteNum
	public List<Excourse> selectExcourseByTeid(String teNum) {
		// ��ȡ��ʦ��id
		Teacher teacher = teacherDao.findByNum(teNum);
		return teacherDao.selectEncourseByTeid(teacher.getTeId());
	}

	//��ѯѡ��ĳ�ſε�ѧ������----����ѡ�޿�����exName
	public Set<Student> selectByExname(int exId) {
		return teacherDao.selectByExname(exId);
	}

	//��ѯĳѡ�޿�����----���ݸ���ѡ�޿�����exName
	public Excourse selectExcourseByExname(int exId) {
		return teacherDao.selectExcourseByExname(exId);
	}

	//�ж��Ƿ��Ѿ�¼���ѡ�޳ɼ�
	public Grade selectByExnameAndStnum(String coName, String stNum) {
		return teacherDao.selectByConameAndStnum(coName, stNum);
	}
	
	//�鿴�ɼ������ݿγ�ѧ��
	public List<Grade> selectExGrades(String coName) {

		return teacherDao.selectExGrades(coName);
	}
}
