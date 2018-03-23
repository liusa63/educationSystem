<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩表----没有录入成绩</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">

	$(function(){
		$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/teacherAction_selectAllCourses1",
				datatype:"json",
				success:function(coList){
					
					var str="<select id='coid' onchange='findSclass()'>";
					   str+="<option value='undefined' >"+"请选择课程"+"</option>"; 
					for(var i=0;i<coList.length;i++){
						str+="<option value="+coList[i].coId+">"+coList[i].coName+"</option>";
					}
					str+="</selsect>";
					$("#content").html(str);
				},
				error:function(){
					alert("失败");
				}
				
			});
		});


	function findSclass(){
		var min = $("#coid>option:selected").val();
		
		$(function(){
			$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/teacherAction_selectAllSclass1?coid="+min,
					async:false,
					success:function(scList){
						
						var str="<select id='clid' >";
						    
						   str+="<option value='undefined' >"+"请选择班级"+"</option>";
						for(var i=0;i<scList.length;i++){
							str+="<option value="+scList[i].clId+">"+scList[i].clName+"</option>";
						}
						str+="</selsect>";
						$("#contentSclass").html(str);
					},
					error:function(){
						alert("失败");
					}
					
				});
			});
	}
	

     function search(){
		var course =$("#coid>option:selected").val();
		var sclass =$("#clid>option:selected").val();
		window.location.href="${pageContext.request.contextPath}/teacherAction_selectGrades?coid="+course+"&clid="+sclass;
		
		/* $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/teacherAction_selectGrades?coid="+course+"&clid="+sclass,
			async:false,
			success:function(grList){
			    
				$("#pw").html("");
				
				var str="";
				for(var i = 0 ;i<grList.length;i++){
					str+="<tr>";
					str+="<td>"+grList[i].coName+"</span></td>";
					str+="<td>"+grList[i].stNum+"</td>";
					str+="<td>"+grList[i].score+"</td>";
					str+="</tr>";
					
				}
				$("#tbody").html(str);
			},
			error:function(){
				alert("失败");
			}
			
		}); */
	
    	/* $("#tbody").html(); */
    	
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
                           <br> <span style="color: red">${msg}</span>
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

							

						</table>
					</div>
				</div>
				<!-- end content-->
			</div>
		</div>

	</div>



</body>
</html>