<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务系统--录入选修成绩</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/teacherAction_selectAllExcourses",
			datatype:"json",
			success:function(exList){
				if(exList.length==0){
					alert("本学期没有你的选修课，不需要录入成绩");
				}else{
					var str="<select id='ex' onchange='findStudents()' name='grList[0].coName'>";
					   str+="<option value='undefined' >"+"请选择课程"+"</option>"; 
					for(var i=0;i<exList.length;i++){
						str+="<option value="+exList[i].exId+">"+exList[i].exName+"</option>";
					}
					str+="</selsect>";
					$("#content").html(str);
				}
				
			},
			error:function(){
				alert("失败");
			}
			
		});
	});


function findStudents(){
	
	var exid = $("#ex>option:selected").val();
	/* alert(exid); */
	$(function(){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/teacherAction_selectExcourseStudents?exid="+exid,
			async:false,
			success:function(stuList){

				for(var i=0;i<stuList.length;i++){
					 
					var str="<tr>";
					str+="<td>"+stuList[i].stNum+"</span></td>";
					str+="<td>"+stuList[i].stName+"</td>";
					str+="<td><input type='text' id='scores"+i+"' name='grList["+i+"].score'></td>";
					str+="</tr>";
					str+="<input type='hidden' name='grList["+i+"].stNum' value='"+stuList[i].stNum+"'>";
					$("#t").after(str);
					/* str1 += students[i].stNum+","; */
				}
				
			/* 	document.getElementById("stNum").value=str1; *///给隐藏的学号文本域赋值
			},
			error:function(){
				alert("失败");
			}
			
		});
	});
}





function save(){
	$("#gradeForm").submit();
	/* var coid =  $("#coid>option:selected").val();
	var stnum = $("#stNum").val();
	
	var st=stnum.split(",");
		for(var i =0;i<st.length-1;i++){
			 var num = st[i];
			 var score=$("#scores"+i).val();
			$(function(){
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/teacherAction_saveGrades?grade.coName="+coid+"&grade.stNum="+num+"&grade.score="+score,
					async:false,
					success:function(msg){
						if(msg=="该班级已经录入成绩,请选择其它班级"){  */
							 /* alert(msg);  */
							/*  $("#msg").val(msg);  */
						   /*  history.go(0); */
						 /* setTimeout(function(){$("#msg").val(msg)}, 3000); */
							 
								/*   if(confirm("确认删除吗?")){
									  location.href="${pageContext.request.contextPath}/pages/teacherInputGrades.jsp";
								  } */
							

							/*  return false;

						}
						
             
					},
					error:function(){  
						alert("失败");
		
					}
					
				});
			});
		}
		 */
		/* window.location.href="${pageContext.request.contextPath}/teacherAction_pageGrades";  */

	
}

</script>
</head>
<body>
 <form  action="${pageContext.request.contextPath}/teacherAction_saveExGrades" method="post" id="gradeForm"> 
  
	<%@include file="teacher.jsp"%>
	<div
		style="padding-left: 15px; padding-right: 15px; margin-left: auto; margin-right: auto; margin-top: -662px;">

		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-minimize">
					<button id="minimizeSidebar"
						class="btn btn-warning btn-fill btn-round btn-icon">
						<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i> <i
							class="fa fa-navicon visible-on-sidebar-mini"></i>
					</button>
				</div>
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">教务系统</a>
				</div>

			</div>
			</nav>

			<div class="card">
				<div class="content">
					<div class="toolbar">
						<!--        Here you can write extra buttons/actions for the toolbar              -->
					</div>
					<div class="fresh-datatables">
					    <label> 课程：<span id="content"></span></label>
						<br>
						<span style="color: red">${m}</span>
						
						<table id="datatables"
							class="table table-striped table-no-bordered table-hover"
							cellspacing="0" width="100%" style="width: 100%">
							<thead>
								<tr id="t">
									<th>学号</th>
									<th>姓名</th>
									<th>成绩</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>成绩</th>
								</tr>
							</tfoot>
						</table>
						
					            <input type="button" value="保存" onclick="save();" style="border-style: none; color: blue; border-radius: 20px; height: 35px; width: 50px;">
					           

					</div>
				</div>
			</div>
		</div>
	</div>
 </form> 
</body>
</html>

