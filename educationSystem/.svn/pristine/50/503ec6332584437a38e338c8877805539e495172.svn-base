<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩表----必修查询失败</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	/* function jumpfun() {
		//要跳转的页码
		var gopage = $("#jump").val();
		//总页数
		var countPage = ${pageGrade.countPage};
		if (gopage != null && gopage != "") {
			var reg = /^\d+$/;
			if (reg.test(gopage)) {
				if (gopage > 0 && gopage <= countPage) {
					window.location.href = "${pageContext.request.contextPath}/teacherAction_pageGrades?pageGrade.currentPage="
							+ gopage;
				} else {
					$("#pageError").html("请输入页码范围内的数");
				}
			} else {
				$("#pageError").html("请输入正整数");
			}
		} else {
			$("#pageError").html("请输入跳转的页码");
		}
	} */
	
	
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
	
	/* function findStudents(){
		var man = $("#clid>option:selected").val();
		
		$(function(){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/teacherAction_selectAllStudents?clid="+man,
				async:false,
				success:function(students){
					var str1 = "";
				
					for(var i=0;i<students.length;i++){
						var str="<tr>";
						str+="<td>"+students[i].stNum+"</span></td>";
						str+="<td>"+students[i].stName+"</td>";
						str+="<td><input type='text' id='scores"+i+"' name='scores'></td>";
						str+="</tr>";
						$("#t").after(str);
						str1 += students[i].stNum+",";
					}
					document.getElementById("stNum").value=str1;//给隐藏的学号文本域赋值
				},
				error:function(){
					alert("失败");
				}
				
			});
		});
	} */
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
						<%-- <div  id="pw">
							<p>第${pageGrade.currentPage}页 共${pageGrade.totalNum }条
								共${pageGrade.countPage}页</p>
							<div class="col-sm-7">
								<div class="dataTables_paginate paging_full_numbers"
									id="datatables_paginate">
									<ul class="pagination">
										<li class="paginate_button first" id="datatables_first"><a
											href="${pageContext.request.contextPath}/teacherAction_pageGrades?pageGrade.currentPage=1">首页</a>

										</li>
										<li class="paginate_button previous" id="datatables_previous">
											<c:if test="${pageGrade.currentPage>1}">
												<a
													href="${pageContext.request.contextPath}/teacherAction_pageGrades?pageGrade.currentPage=${pageGrade.currentPage-1}">上一页</a>
											</c:if>
										</li>

										<li class="paginate_button next" id="datatables_next"><c:if
												test="${pageGrade.currentPage<pageGrade.countPage}">
												<a
													href="${pageContext.request.contextPath}/teacherAction_pageGrades?pageGrade.currentPage=${pageGrade.currentPage+1}">下一页</a>
											</c:if></li>
										<li class="paginate_button last" id="datatables_last"><a
											href="${pageContext.request.contextPath}/teacherAction_pageGrades?pageGrade.currentPage=${pageGrade.countPage}">尾页</a>
										</li>

										<li><input type="text" id="jump"
											style="margin-right: 10px; padding: 2px; width: 30px; height: 30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
											<input type="button" value="跳转" onclick="jumpfun();"
											style="border-style: none; color: blue; border-radius: 20px; height: 35px; width: 50px;">
										</li>
										<span id="pageError" style="color: red;"></span>
									</ul>

								</div>
							</div>
						</div> --%><!-- 隐藏分页 -->
					</div>
				</div>
				<!-- end content-->
			</div>
		</div>

	</div>



</body>
</html>