<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/backend/modify_pwd.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">

	var ids="uPwd,newPwd,newPwd1";
	var msg="请输入原始密码,请输入新密码,请输入确认密码";


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
			   //验证非空
			   if(checkNull(ids,msg)){
				   
				   $("#loginForm").submit();
			   }
		}
		
		 //页面加载完成触发的事件
			$(document).ready(function(){
				//设置获取焦点触发的事件：错误提示消失
				$("#uPwd").focus(function(){
					$("#uPwd").val("");
					$("#uPwdError").html("");
				});
				$("#newPwd").focus(function(){
					$("#newPwd").val("");
					$("#newPwdError").html("");
				});
				$("#newPwd1").focus(function(){
					$("#newPwd1").val("");
					$("#newPwd1Error").html("");
				});
				
				//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
				$("#upwd").blur(function(){
					var u=$("#upwd").val();
					if(u==""){
						$("#upwdError").html("原始密码不能为空");
					}
				});
				$("#newPwd").blur(function(){
					var p=$("#newPwd").val();
					if(p==""){
						$("#newPwdError").html("新密码不能为空");
					}
				});
				$("#newPwd1").blur(function(){
					var p=$("#newPwd1").val();
					if(p==""){
						$("#newPwd1Error").html("确认密码不能为空");
					}
				});
			});


</script>
	
</head>
<body>			
 <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">修改密码</a>
			</div>
        </div>

        <div id="inner-bd">

            <div class="button-group">
		        <div class="button current add">
		            <i class="iconfont">&#xe76a;</i>
		            <span class="button-label" onclick="loginfun();">保存</span>
		        </div>
		        
		    </div>
			<form id="formadd" action="${pageContext.request.contextPath }/loginAction!updatePassword" method="post" target="self">
			<input type="hidden"  name="uid" value="${user.uid }"/>
			<input type="hidden"  name="unumber" value="${user.unumber }"/>
			<table class="kv-table">
				<tbody>
					<tr>
						<td class="kv-label">
							用户名：
						</td>
						<td class="kv-content" style="padding: 10px;">
							${user.unumber }
						</td>
					</tr>
					<tr>
						<td class="kv-label">
							原始密码：
						</td>
						<td class="kv-content" style="padding: 10px;">
							<input type="password" name="upwd" id="uPwd">
					        <span id="uPwdError"></span>
							
							
						</td>
					</tr>
					<tr>
						<td class="kv-label">
							新密码：
						</td>
						<td class="kv-content" style="padding: 10px;">
							<input type="password" name="newpwd" id="newPwd">
					        <span id="newPwdError"></span>
							
						</td>
					</tr>
					<tr>
						<td class="kv-label">
							确认密码：
						</td>
						<td class="kv-content" style="padding: 10px;">
							<input type="password" name="newpwd1" id="newPwd1">
					        <span id="newPwd1Error"></span>
							
							
						</td>
					</tr>
				</tbody>
				
			</table>
			</form>
			<span style="color: red; font-size: 30px">${msg }</span>
			
        </div>

        <div id="inner-ft">
            
        </div>
    </div>

    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/global.js"></script>
	<script type="text/javascript" src="../js/jquery.select.js"></script>
	<script type="text/javascript" src="../js/jquery.pagination.js"></script>
	<script type="text/javascript" src="../js/lib/layer/layer.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>

	<script type="text/javascript">
   $('select').select();
    $('body').on('click', '.add', function(){
    	 if(checkNull(ids,msg)){
			   var npwd=$("#newPwd").val();
			   var npwd1=$("#newPwd1").val();
			   if(npwd==npwd1){
				   layer.confirm('您确定要修改吗？', {
		                 icon: 4,
		    			  title: '确定' //按钮
		    			}, function(){
		    				$("#formadd").submit();
		    			 /*  location.href= 'loginAction!updatePassword';  */
		    			}); 
			   }else{
				   alert("两次输入的密码不一致");
			   }
			   
    		
		   }
    	 
    	
    })
  
	</script>


</body>
</html>
