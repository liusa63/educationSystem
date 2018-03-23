<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师--个人信息</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
<%@include  file="teacher.jsp"%>
<div style="margin-top:-630px; ">

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

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8">
							<div class="card">
								<div class="header">
									<h4 class="title">个人信息</h4>
								</div>
								<div class="content">

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>工号</label> <input type="text" class="form-control"
													disabled value="${teacherVo.teNum }">
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>姓名</label>
												 <input type="text" class="form-control"
													disabled value="${teacherVo.teName }">
											</div>
										</div>
									</div>
									
								

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>专业</label> <input type="text" class="form-control"
													disabled value="${teacherVo.maName}">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>身份</label> <input type="text" class="form-control"
													disabled value="${teacherVo.teBehave eq 1 ? "讲师":"班主任"}">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>工资</label> <input type="text" class="form-control"
													disabled value="${teacherVo.teSalary}">
											</div>
										</div>

									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>电话</label> <input type="text" class="form-control"
													disabled value="${teacherVo.tePhone}">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>