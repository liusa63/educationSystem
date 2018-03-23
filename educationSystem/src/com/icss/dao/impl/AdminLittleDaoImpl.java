/**
 * 
 */
package com.icss.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.icss.dao.AdminDao;
import com.icss.dao.AdminLittleDao;
import com.icss.entity.Major;
import com.icss.entity.Room;
import com.icss.entity.Sclass;
import com.icss.entity.Student;
import com.icss.entity.Teacher;
import com.icss.util.SclassTeacherVo;

/**
 *<p>Title:AdminLittleDaoImpl</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017��10��9������6:42:49
 */
@Repository(value = "adminLittleDao")
public class AdminLittleDaoImpl extends HibernateDaoSupport implements AdminLittleDao {
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	public void funSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Autowired
	@Qualifier(value = "adminDao")
	AdminDao adminDao;
	
	/* 
	 * �������Ʋ�ѯרҵ
	 */
	public String selectMajorIfExist(String maName) {
		
		String hql="from Major where maName=?";
		
		Query query = this.getSession().createQuery(hql);
		query.setString(0, maName);
		List<Major> list = query.list();
		if(list != null && list.size()>0){
			return "no";
		}else{
		return "yes";
		}
		
	}

	/* 
	 *����רҵ
	 */
	public void addMajor(Major major) {
		this.getHibernateTemplate().save(major);
		
	}
	
	/* 
	 *�޸�רҵ
	 */
	public void updateMajor(Major major) {
		this.getHibernateTemplate().update(major);
		
	}

	//רҵ�µİ༶VO
	public List<SclassTeacherVo> findSclassByMajor(Major major){
		List<SclassTeacherVo> list = new ArrayList<SclassTeacherVo>();
		Set<Sclass> sclass = major.getSclasses();
		if(sclass != null && sclass.size()>0){
			
			for(Sclass s:sclass){
				SclassTeacherVo vo = new SclassTeacherVo();
				vo.setClId(s.getClId());
				vo.setClName(s.getClName());
				vo.setClCount(s.getClCount());
				vo.setTeId(s.getTeId());
				Teacher  teacher = adminDao.selectByIdTeacher(s.getTeId());
				vo.setTeName(teacher.getTeName());
				list.add(vo);
			}
			
		}
		return list;
		
	}

    
	/* 
	 * �������Ʋ�ѯ����
	 */
	public String selectRoomIfExist(String roName) {
		
		String hql="from Room where roName=?";
		
		Query query = this.getSession().createQuery(hql);
		query.setString(0, roName);
		List<Major> list = query.list();
		if(list != null && list.size()>0){
			return "no";
		}else{
		return "yes";
		}
		
	}
	/* 
	 * ���ӽ���
	 */
	public void addRoom(Room room) {
		this.getHibernateTemplate().save(room);
		
	}


	
	/* 
	 * ��ҳ��ѯ���н���
	 */
	public List<Room> findAllRoom(int begin,int max) {
		
		String hql ="from Room"; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		
		query.setFirstResult(begin);//��ʼ����
		query.setMaxResults(max);//ÿҳչʾ������
		List<Room> rooms  =  query.list();
		
		if(rooms != null && rooms.size()>0){
			return rooms;
		}
		return null;
	}
	
	/* 
	 * ��ѯ���н�������
	 */
	public int allRoom(){
		int count = 0;
		List<Room> list = this.getHibernateTemplate().find("from Room");
		if(list != null && list.size()>0){
			count =list.size();
			
		}
		return count;
		
	}

	/*
	 *��ѯָ������
	 */
	public Room findRoomById(int id) {
		Room room =(Room) this.getSession().get(Room.class, id);
		return room;
	}

	/* 
	 *���½��� 
	 */
	public void updateRoom(Room room) {
		
		this.getHibernateTemplate().update(room);
		
	}

	
	/* 
	 *
	 */
	public List<Major> findAllMajor(int beginPage, int max) {
		String hql ="from Major"; //��ѯ�־û���
		Query query = this.getSession().createQuery(hql);
		
		query.setFirstResult(beginPage);//��ʼ����
		query.setMaxResults(max);//ÿҳչʾ������
		List<Major> majors  =  query.list();
		
		if(majors != null && majors.size()>0){
			return majors;
		}
		return null;
	}

	/* 
	 *רҵ���� 
	 */
	public int allMajor() {
		int count = 0;
		List<Major> list = this.getHibernateTemplate().find("from Major");
		if(list != null && list.size()>0){
			count =list.size();
			
		}
		return count;
	}

	

	

	
	

}