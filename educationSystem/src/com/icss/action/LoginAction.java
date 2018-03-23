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
 * @date: 2017��9��26������7:55:37
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
	
	//��װ����
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
			
			if(u.getUrole()==2){//��ʦ
				
				if(u.getUstatus()==1){//��У
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					
					session.put("user", u);
					
					return  "teacherLogin";
					
				}else{//��ʾ���ܵ�¼
					
                    Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
					
                    request.put("msg", "��û��Ȩ�޵�¼");
					
					return ERROR;
				}
				
				
			}
			
			if(u.getUrole()==3){//ѧ��
				
                    if(u.getUstatus()==1){//��У
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					
					session.put("user", u);
					
					return  "studentLogin";
					
				}else{//��ʾ���ܵ�¼
					
					 Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
						
	                 request.put("msg", "��û��Ȩ�޵�¼");
						
				     return ERROR;
					
					
				}
				
				
			}
			
			
		}
		
		 Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
			
         request.put("msg", "ѧ�������Ż��������");
		
		return ERROR;
	}

	//����Ա��¼

	public  String  adminLogin(){
		
		
		User u = loginBiz.login(user);
		
		if(u!=null){
			
			if(u.getUrole()==1){//����Ա
				
				if(u.getUstatus()==1){//��У
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					
					session.put("user", u);
					
					return  "adminLogin";
					
				}else{//��ʾ���ܵ�¼
					
                    Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
					
                    request.put("msg", "��û��Ȩ�޵�¼");
					
					return "adminError";
				}
				
				
			}
			
			
		}
		
		 Map<String,String> request = (Map<String, String>) ActionContext.getContext().get("request");
			
         request.put("msg", "��û��Ȩ�޵�¼");
		
		return "adminError";
	}


	//����Ա�޸ĵ�¼����
	
	public String updatePassword(){
		//����userid�鿴����:
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
				
		         request.put("msg", "ԭʼ�����������");
		         return "updatePwdFalse";
				
			}
			
		}
		return "updatePwdSuccess";
		
		
		
	}
 
  }

	