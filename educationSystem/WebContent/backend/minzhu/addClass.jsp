<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入班级信息</title>
<link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap-datepicker.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/project/userinfo.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/project/userinfo.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lib/datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lib/datepicker/locales/bootstrap-datepicker.zh-CN.min.js">
</script>


<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">

var ids="clName,clCount";
var msg="请输入班级名称,请输入班级人数";


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

function sub(){
	
	 if(checkNull(ids,msg)){
		 var maid=$("#ma>option:selected").val();
		 alert(maid);
		 if(maid!="undefined"){
				$("#aa").val(maid);
				var teid=$("#te>option:selected").val();
				 if(teid!="undefined"){
						$("#bb").val(teid);						
						 $("#formadd").submit();   
					}else{
						alert("请选择班主任");
					}
				
			}else{
				alert("请选择专业");
			}
		
		  
	   }	
}



$(function(){
	
	
	
	
	/* 遍历所有专业 */
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/adminAction!selectAllMajor",
		success:function(mlist){
			
		 	var str="<select id='ma'>";
		 	str+="<option value="+'undefined'+">"+"请选择专业"+"<option>";
			for(var i=0;i<mlist.length;i++){
				str+="<option value="+mlist[i].maId+">"+mlist[i].maName+"<option>";
			}
			str+="</select>";
			$("#content").html(str); 
		},
		error:function(){
			alert("失败");
		}
		
		
		
	})
	
	/* 遍历所有教师表 */
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/adminAction!selectByIdTeacher?tebehave=2",
		success:function(tlist){
			
		   
		 	var str="<select id='te'>";
		 	str+="<option value='undefined'>"+"请选择班主任"+"<option>";
			for(var i=0;i<tlist.length;i++){
				str+="<option value="+tlist[i].teId+">"+tlist[i].teName+"<option>";
			}
			str+="</select>";
			$("#content1").html(str); 
		},
		error:function(){
			alert("失败");
		}
		
		
	})
	
	//设置获取焦点触发的事件：错误提示消失
	$("#clName").focus(function(){
		$("#clName").val("");
		$("#clNameError").html("");
	});
	$("#clCount").focus(function(){
		$("#clCount").val("");
		$("#clCountError").html("");
	});
	
	
	//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
	$("#clName").blur(function(){
		var u=$("#clName").val();
		if(u==""){
			$("#clNameError").html("班级名称不能为空");
		}
	});
	$("#clCount").blur(function(){
		var p=$("#clCount").val();
		if(p==""){
			$("#clCountError").html("班级人数不能为空");
		}
	});

}) 
</script>
</head>
<body>

	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">班级信息</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="button-group">

				<div class="button current save">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="sub();">保存</span>
				</div>
				<div class="button current save">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="window.history.go(-1);">返回</span>
				</div>
			</div>

			<form id="formadd"
				action="${pageContext.request.contextPath }/adminAction!addSclass"
				method="post">
				<table class="kv-table">

					<tr>
						<td class="kv-label">班级名称</td>
							<td class="kv-content"><input type="text" name="sclass.clName" id="clName"> <span
									id="clNameError"></span></td>
						
						
						<td class="kv-label">班级人数</td>
								<td class="kv-content"><input type="text" name="sclass.clCount" id="clCount"> 
					</td></tr>
					<tr>
					<td class="kv-label">选择专业</td>
								<td class="kv-content"><span id="content"></span>
									<div class="item-rt"></div> 
									<input type="hidden" name="maid" id="aa" />
									</td>
					
						<td class="kv-label">选择班主任:</td>
						<td class="kv-content"><span id="content1"></span><div class="item-rt"></div>
						
						<input type="hidden" name="sclass.teId" id="bb" /></td>
					</tr>

					
				</table>
			</form>


		</div>

		<div id="inner-ft"></div>
	</div>
</body>
</html>
