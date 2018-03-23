package com.icss.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.icss.dao.LoginDao;
import com.icss.entity.Teacher;
import com.icss.entity.User;


	@Repository(value="loginDao")
	public class LoginDaoImpl  extends HibernateDaoSupport implements LoginDao{

		@Autowired
		@Qualifier(value="sessionFactory")
		public void setSuperSessionFactory(SessionFactory sessionFactory){
			
			super.setSessionFactory(sessionFactory);
		}
		
		
		public User login(User user) {
			

			String hql="from User where unumber=? and upwd=?";


			List<User>  userList = this.getHibernateTemplate().find(hql,user.getUnumber(),user.getUpwd());

			
			User user1 = null;
			
			if(userList != null && userList.size()>0){
				
				user1 = userList.get(0);
				
			}
			
			return user1;
		}


		public void updatePassword(User user) {
			this.getHibernateTemplate().update(user);
			
		}


		public User selectById(int userid) {
			String hql = "from User where uid=?";
			Query query = this.getSession().createQuery(hql);
			query.setInteger(0, userid);
			List<User> list = query.list();
			User user=null;
			if(list!=null&&list.size()>0){
				 user=list.get(0);
			}
			return user;
		}


	

	}



