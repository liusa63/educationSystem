package com.icss.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.AdminBiz;
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
import com.icss.entity.Teacher;

import com.icss.util.PageList;

@Service(value = "adminBiz")
public class AdminBizImpl implements AdminBiz {
	@Autowired
	@Qualifier(value = "adminDao")
	AdminDao adminDao;

	// ������ӽ�ʦ��Ϣ
	public void addTeacher(Teacher teacher) {
		adminDao.addTeacher(teacher);

	}

	// ������Ӱ༶��Ϣ
	public void addSclass(Sclass sclass) {
		adminDao.addSclass(sclass);

	}

	public void addCourse(Course course) {
		adminDao.addCourse(course);

	}

	// ��������
	public void addQuestion(Question question) {
		adminDao.addQuestion(question);

	}

	// �鿴��������
	public List<Question> selectAllQuestion() {
		List<Question> qlist = adminDao.selectAllQuestion();
		return qlist;
	}


	public void selectListTeacher(PageList<Teacher> page, int pageSize) {
		List<Teacher> list = adminDao.selectListTeacher(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotal();

		page.setTotalNum(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);

	}

	// ��ѯ����רҵ

	public List<Major> selectAllMajor() {
		List<Major> mlist = adminDao.selectAllMajor();
		return mlist;
	}

	// ��ѯ���а�����

	public List<Teacher> selectByIdTeacher(String tebehave) {
		List<Teacher> tlist = adminDao.selectByIdTeacher(tebehave);
		return tlist;
	}

	// ����id��ѯרҵ
	public Major selectByIdMajor(int maid) {

		return adminDao.selectByIdMajor(maid);

	}

	// ��ѯ����ѡ�޿�
	public List<Course> selectAllCourse(String costatus) {
		List<Course> clist = adminDao.selectAllCourse(costatus);
		return clist;
	}

	// ��ѯ���н���
	public List<Room> selectAjaxRoom() {
		List<Room> rlist = adminDao.selectAjaxRoom();
		return rlist;
	}

	// ¼��ѡ�޿�
	public void addExCourse(Excourse excourse) {
		adminDao.addExCourse(excourse);

	}

	// ����רҵ��ѯ���޿γ�
	public List<Course> selectBasicCourse(String costatus, int maid) {
		List<Course> clist = adminDao.selectBasicCourse(costatus, maid);
		return clist;
	}

	// ��ҳ��ѯ�༶
	public void selectAllSclass(PageList<Sclass> page, int pageSize) {
		List<Sclass> list = adminDao.selectListSclass(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotalSclass();

		page.setTotalNum(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);

	}

	public void updateSclass(Sclass sclass) {
		adminDao.updateSclass(sclass);

	}

	public Sclass selectByIdSclass(int clid) {
		Sclass c = adminDao.selectByIdSclass(clid);

		return c;
	}

	//¼��ѧ����Ϣ
	public void addSroll(Sroll sroll,String stbehave,Sclass sclass) {
		adminDao.addSroll(sroll,stbehave, sclass);
		
	}
	//����ָ��id��ʦ
	public Teacher selectByIdTeacher(int teid) {
		Teacher t = adminDao.selectByIdTeacher(teid);		
		return t;
	}

	//�޸Ľ�ʦ��Ϣ
	public void updateByIdTeacher(Teacher teacher) {
	adminDao.updateByIdTeacher(teacher);
		
	}

	//��ҳ��ѯ�γ�
	public void selectAllSchoolCourse(PageList<Course> page, int pageSize) {
		List<Course> list = adminDao.selectListSchoolCourse(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotalSchoolCourse();

		page.setTotalNum(totalCount);//������
		int totalPage = 0;//��ҳ��
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);
		
	}

	//����ѧ�źͿγ����޸ĳɼ�
	public Grade selectGrade(String stnum, String coname) {
		
		Grade grade=adminDao.selectGrade(stnum, coname);
		return grade;
	}

	//�޸ĳɼ�
	public void updateGrade(Grade grade) {
		adminDao.updateGrade(grade);
		
	}

	public Grade selectById(int grid) {
		Grade g=adminDao.selectById(grid);
		return g;
	}

	public void selectAllExcourse(PageList<Excourse> page, int pageSize) {
		List<Excourse> list = adminDao.selectListExcourse(page, pageSize);

		page.setList(list);
		int totalCount = (Integer) adminDao.getTotalExcourse();

		page.setTotalNum(totalCount);//������
		int totalPage = 0;//��ҳ��
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		page.setCountPage(totalPage);
		
	}

	//��ѯָ��id��ѡ��
	public Excourse findByIdExcourse(int exid) {
		
		Excourse excourse=adminDao.findByIdExcourse(exid);
		return excourse;
	}

	//�޸�ѡ��
	public void updateExcourse(Excourse excourse) {
		adminDao.updateExcourse(excourse);
		
	}

	public List<Excourse> selectByTeacherExcourse(int teid) {
		List<Excourse> excourse=adminDao.selectByTeacherExcourse(teid);
		return excourse;
	}

	public List<EnCourse> selectByTeacherEncourse(int teid) {
		List<EnCourse> enCourse=adminDao.selectByTeacherEncourse(teid);
		return enCourse;
	}

	

	public Double selectEvaluation1(int teid, int coid) {
		Double qa=adminDao.selectEvaluation1(teid, coid);
		return qa;
	}

	public Double selectEvaluation2(int teid, int coid) {
		Double qb=adminDao.selectEvaluation2(teid, coid);
		return qb;
	}

	public Double selectEvaluation3(int teid, int coid) {
		Double qc=adminDao.selectEvaluation3(teid, coid);
		return qc;
	}

	public Double selectEvaluation4(int teid, int coid) {
		Double qd=adminDao.selectEvaluation4(teid, coid);
		return qd;
	}

	public Double selectEvaluation5(int teid, int coid) {
		Double qe=adminDao.selectEvaluation5(teid, coid);
		return qe;
	}

	//����ѧ�Ų鿴ѧ��
	public Sroll selectSroll(String srNum) {
		Sroll sroll=adminDao.selectSroll(srNum);
		return sroll;
	}

	
 //�鿴���а༶
	public List<Sclass> ajaxSelectAllSclass() {
		List<Sclass> sclist=adminDao.ajaxSelectAllSclass();
		return sclist;
	}
	//����רҵid��ѯ�Ͽ���ʦ
	public List<Teacher> selectTeacherByMajor(int maid, String tebehave) {
		List<Teacher> tlist=adminDao.selectTeacherByMajor(maid, tebehave);
		return tlist;
	}

	//¼����޿�
	public void addBasicCourse(EnCourse encourse) {
		adminDao.addBasicCourse(encourse);
		
	}

	//�޸Ŀα��еĿγ�
	public Course findByIdSchoolCourse(int coid) {
		Course c=adminDao.findByIdSchoolCourse(coid);
		return c;
	
		
	}
	
	public void updateSchoolCourse(Course course) {
		adminDao.updateSchoolCourse(course);
		
	}

//�޸�ѧ��
	public void updateStudentSroll(Sroll sroll) {
		adminDao.updateStudentSroll(sroll);
		
	}

	public void addTeachers(Teacher teacher) {
		adminDao.addTeachers(teacher);
		
	}

	//�޸�����
	public Question selectByIdQuestion(int qqid) {
		Question q=	adminDao.selectByIdQuestion(qqid);
		return q;
	}

	public void updateQuestion(Question question) {
		adminDao.updateQuestion(question);
		
	}

	//�Զ�����ѧ�ţ����ֵ+1
	public Integer ajaxUserNumber() {
		Integer stnumber=adminDao.ajaxUserNumber();
		return stnumber;
	}

	
	
	
}