/**
 * 
 */
package com.icss.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.icss.biz.LoginBiz;
import com.icss.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *<p>Title:LoginAction</p>
 *<p>Description:</p>
 *<p>Company:</p>
 * @author: LiuSa
 * @date: 2017年9月26日下午7:55:37
 */
@Controller(value="loginAction")
public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();

	public User getModel() {
		return this.user;
	}
	

	@Autowired
	@Qualifier(value="loginBiz")
	LoginBiz loginBiz;
	
	//封装参数
	private String newpwd;
	private String newpwd1;
	
	
	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getNewpwd1() {
		return newpwd1;
	}

	public void setNewpwd1(String newpwd1) {
		this.newpwd1 = newpwd1;
	}

	public  String  userLogin(){
		
		
		User u = loginBiz.login(user);
		
		if(u!=null){
			
			if(u.getUrole()==2){//老师
				
				if(u.getUstatus()==1){//在校
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					
					session.put("user", u);
					
					return  "teacherLogin";
					
				}else{//提示不能登录
					
                    Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
					
                    request.put("msg", "您没有权限登录");
					
					return ERROR;
				}
				
				
			}
			
			if(u.getUrole()==3){//学生
				
                    if(u.getUstatus()==1){//在校
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					
					session.put("user", u);
					
					return  "studentLogin";
					
				}else{//提示不能登录
					
					 Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
						
	                 request.put("msg", "您没有权限登录");
						
				     return ERROR;
					
					
				}
				
				
			}
			
			
		}
		
		 Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
			
         request.put("msg", "学（工）号或密码错误");
		
		return ERROR;
	}

	//管理员登录

	public  String  adminLogin(){
		
		
		User u = loginBiz.login(user);
		
		if(u!=null){
			
			if(u.getUrole()==1){//管理员
				
				if(u.getUstatus()==1){//在校
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					
					session.put("user", u);
					
					return  "adminLogin";
					
				}else{//提示不能登录
					
                    Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
					
                    request.put("msg", "您没有权限登录");
					
					return "adminError";
				}
				
				
			}
			
			
		}
		
		 Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
			
         request.put("msg", "您没有权限登录");
		
		return "adminError";
	}


	//管理员修改登录密码
	
	public String updatePassword(){
		//根据userid查看密码:
		System.out.println(user.getUid());
		User us=loginBiz.selectById(user.getUid());
		if(us!=null){
			System.out.println(user.getUpwd());
			System.out.println(user.getUpwd().equals(us.getUpwd()));
			if(user.getUpwd().equals(us.getUpwd())){
				user.setUpwd(newpwd);
				user.setUrole(1);
				user.setUstatus(1);
				loginBiz.updatePassword(user);
				
			}else{
				Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
				
		         request.put("msg", "原始密码输入错误");
		         return "updatePwdFalse";
				
			}
			
		}
		return "updatePwdSuccess";
		
		
		
	}
 
  }

	
