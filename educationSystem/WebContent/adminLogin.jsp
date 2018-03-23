<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>学生教务管理系统_uimaker</title>
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/platform/login.css"	rel="stylesheet">
<script type="text/javascript"	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	var ids="uNumber,uPwd";
	var msg="请输入学（工）号,请输入密码";
		//非空验证
		function  checkNull(ids,msg){
			  var idArray=ids.split(",");
			   var msgArray=msg.split(",");
			   for(var i=0;i<idArray.length;i++){
				  var id= $("#"+idArray[i]).val();
				  //如果为空，给出错误提示
				  if(id==""){
					  $("#"+idArray[i]+"Error").html(msgArray[i]);
					  return false;
				  }
			   }
			   return true;
		 }
		//登录
		function loginfun(){
			   //判断用户名和密码是否为空
			   if(checkNull(ids,msg)){
				   
				   $("#loginform").submit();
			   }
		}
		
		 //页面加载完成触发的事件
			$(document).ready(function(){
				//设置获取焦点触发的事件：错误提示消失
				$("#uNumber").focus(function(){
					$("#uNumber").val("");
					$("#uNumberError").html("");
				});
				$("#uPwd").focus(function(){
					$("#uPwd").val("");
					$("#uPwdError").html("");
				});
				
				//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
				$("#uNumber").blur(function(){
					var u=$("#uNumber").val();
					if(u==""){
						$("#uNumberError").html("学（工）号不能为空");
					}
				});
				$("#uPwd").blur(function(){
					var p=$("#uPwd").val();
					if(p==""){
						$("#uPwdError").html("密码不能为空");
					}
				});
			});
</script>
</head>
<body>
<div class="left-bg"></div>
    <div class="right-bg"></div>
    <div class="login-logo"></div>
    <div class="login-center">
    	<div class="login-content">
    		<div class="notice">
    			<div class="notice-title">
    				<i class="notice-icon"></i>
    				<span>通知公告</span>
    			</div>
    			<ul class="notice-list">
    				<li class="list-item ellipsis">
    					<a href="notice.html" target="_blank">
    						<i class="rt-icon"></i>
    						2016国家公务员考试行测选择
    					</a>
    				</li>
    				<li class="list-item ellipsis">
    					<a href="notice.html" target="_blank">
	    					<i class="rt-icon"></i>
	    					行政机关公务员管理系统
    				   </a>
    				</li>
    				<li class="list-item ellipsis">
    					<a href="notice.html" target="_blank">
	    					<i class="rt-icon"></i>
	    					公务员怎么考核比考什么重要
	    				</a>
    				</li>
    				<li class="list-item ellipsis">
    					<a href="notice.html" target="_blank">
	    					<i class="rt-icon"></i>
	    					公务员考核关键看平时--新闻报道
	    				</a>
    				</li>
    				<li class="list-item ellipsis">
    					<a href="notice.html" target="_blank">
	    					<i class="rt-icon"></i>
	    					关于公务员平时考核的实施方案
	    				</a>
    				</li>
    				<li class="list-item ellipsis">
    					<a href="notice.html" target="_blank">
	    					<i class="rt-icon"></i>
	    					我国公务员考核制度存在的问题及原因
	    				</a>
    				</li>
    			</ul>
    		</div>
    		<form action="${pageContext.request.contextPath }/loginAction!adminLogin" method="post" id="loginform">
    		<div class="login-input">
    			<div class="login-label">用户登录</div>
    			<div class="username">
    				<i class="username-icon"></i>
    				<input type="text" name="unumber" id="uNumber">
    			</div>
    			<div class="password">
    				<i class="password-icon"></i>
    				<input type="password" name="upwd" id="uPwd">
    			</div> 			
    			<span id="uPwdError"></span>${msg}   			
    			<input class="login-btn" type="button" value="登录" onclick="loginfun();">    			   						
    		</div>
    		</form>    		
    	</div>
    </div>
</body>
</html>

