<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改成绩</title>
<link
	href="${pageContext.request.contextPath}/js/lib/datepicker/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/js/lib/datepicker/css/bootstrap-datepicker.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/project/userinfo.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/project/userinfo.css"
	rel="stylesheet">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lib/datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lib/datepicker/locales/bootstrap-datepicker.zh-CN.min.js">
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
function sub(){
	$("#subform").submit();
}

</script>

</head>
<body>
<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">成绩信息</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="button-group">			
			</div>			
				<table class="kv-table">

					<tr>
						<td class="kv-label">学号</td>
						<td class="kv-content">
							<div class="date">
								${studentGrade.stNum }
							</div>
						</td>
					<tr>
						<td class="kv-label">课程名称</td>
						<td class="kv-content">
							<div class="date">
								${studentGrade.coName }
							</div>
						</td>
					</tr>
					 <tr>
						<td class="kv-label">成绩</td>
						<td class="kv-content">${studentGrade.score }</td>
					</tr> 
				</table>
			


		</div>

		<div id="inner-ft"></div>
	</div>

</body>
</html>