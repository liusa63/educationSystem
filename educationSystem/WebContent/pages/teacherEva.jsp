<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学评估</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript">
	function jumpfun() {
		//要跳转的页码
		var gopage = $("#jump").val();
		//总页数
		var countPage = ${evaPage.countPage};
		if (gopage != null && gopage != "") {
			var reg = /^\d+$/;
			if (reg.test(gopage)) {
				if (gopage > 0 && gopage <= countPage) {
					window.location.href = "${pageContext.request.contextPath}/teacherAction_pageEva?pageEva.currentPage="
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
					<div class="fresh-datatables" >
						<table id="datatables"
							class="table table-striped table-no-bordered table-hover"
							cellspacing="0" width="100%" style="width: 100%">
							<thead>
								<tr>
									<th>课程</th>
									<c:forEach items="${questions}" var="q">
										<th>${q.qcontent}</th>
									</c:forEach>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>课程</th>
									<c:forEach items="${questions}" var="q">
										<th>${q.qcontent}</th>
									</c:forEach>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${evaPage.list}" var="e">
									<tr>
									    <td>${e.coName}</td>
										<td>${e.answer1}</td>
										<td>${e.answer2}</td>
										<td>${e.answer3}</td>
										<td>${e.answer4}</td>
										<td>${e.answer5}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_full_numbers"
								id="datatables_paginate">
								<ul class="pagination">
								<li>
								第${evaPage.currentPage}页
								共${evaPage.totalNum }条
							          共${evaPage.countPage}页
							    </li>
									<li class="paginate_button first" id="datatables_first"><a
										href="${pageContext.request.contextPath}/teacherAction_pageEva?pageEva.currentPage=1">首页</a>

									</li>
									<li class="paginate_button previous" id="datatables_previous">
										<c:if test="${evaPage.currentPage>1}">
											<a
												href="${pageContext.request.contextPath}/teacherAction_pageEva?pageEva.currentPage=${evaPage.currentPage-1}">上一页</a>
										</c:if>
									</li>

									<li class="paginate_button next" id="datatables_next"><c:if
											test="${evaPage.currentPage<evaPage.countPage}">
											<a
												href="${pageContext.request.contextPath}/teacherAction_pageEva?pageEva.currentPage=${evaPage.currentPage+1}">下一页</a>
										</c:if></li>
									<li class="paginate_button last" id="datatables_last"><a
										href="${pageContext.request.contextPath}/teacherAction_pageEva?pageEva.currentPage=${evaPage.countPage}">尾页</a>
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
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>