/**
 * 
 */
package com.icss.dao;

import com.icss.entity.User;

/**
 *<p>Title:LoginDao</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月26日下午8:01:10
 */
public interface LoginDao {

	public User login(User user);
	public User selectById(int userid);//根据userid查看密码:
	public void updatePassword(User user);//管理员修改密码
}
