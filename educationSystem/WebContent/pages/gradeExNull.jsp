<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩表----没有录入选修成绩</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/teacherAction_selectAllExcourses1",
				datatype:"json",
				success:function(exList){
					
					var str="<select id='ex' onchange='findSclass()'>";
					   str+="<option value='undefined' >"+"请选择课程"+"</option>"; 
					for(var i=0;i<exList.length;i++){
						str+="<option value="+exList[i].exId+">"+exList[i].exName+"</option>";
					}
					str+="</selsect>";
					$("#content").html(str);
				},
				error:function(){
					alert("失败");
				}
				
			});
		});


     function search(){
		var exid=$("#ex>option:selected").val();
		$("#pw").html("");
		window.location.href="${pageContext.request.contextPath}/teacherAction_selectExGrades?exid="+exid;
    } 
</script>
</head>
<body>
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
						<label> 课程：<span id="content"></span></label> <label> 班级：<span
							id="contentSclass"></span></label> 
							<input type="button"onclick="search();" value="搜索" style="border-style: none; color: blue; border-radius: 20px; height: 35px; width: 50px;">
                         <br><span style="color: red">${msg}</span>
						<table id="datatables"
							class="table table-striped table-no-bordered table-hover"
							cellspacing="0" width="100%" style="width: 100%">
							<thead>
								<tr>
									<th>课程名</th>
									<th>学号</th>
									<th>分数</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>课程名</th>
									<th>学分</th>
									<th>分数</th>
								</tr>
							</tfoot>

							<tbody id="tbody">
								<c:forEach items="${pageGrade.list}" var="t">
									<tr>
										<td>${t.coName }</td>
										<td>${t.stNum}</td>
										<td>${t.score}</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						
					</div>
				</div>
				<!-- end content-->
			</div>
		</div>

	</div>



</body>
</html>