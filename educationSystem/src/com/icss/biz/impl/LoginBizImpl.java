/**
 * 
 */
package com.icss.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icss.biz.LoginBiz;
import com.icss.dao.LoginDao;
import com.icss.entity.User;


/**
 *<p>Title:LoginBizImpl</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月26日下午8:00:47
 */
@Service(value="loginBiz")
public class LoginBizImpl implements  LoginBiz{

	@Autowired
	@Qualifier(value="loginDao")
	LoginDao loginDao;
	
	
	public User login(User user) {
		
		return loginDao.login(user);
	}

//管理员修改登录密码
	public void updatePassword(User user) {
	 loginDao.updatePassword(user);
		
	}

	public User selectById(int userid) {
	User user=loginDao.selectById(userid);
		return user;
	}

}
