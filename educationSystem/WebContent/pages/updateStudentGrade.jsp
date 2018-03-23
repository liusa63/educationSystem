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
	var v=$("#gr").val();
	if(v<100){
		$("#subform").submit();
	}else{
		$("#err").html("输入成绩不能大于100");
	}
	
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

				
				<div class="button">
		            <i class="iconfont">&#xe621;</i>
		            <span class="button-label" onclick="sub();">确认修改</span>
		        </div>
				
			</div>

			<form id="subform"
				action="${pageContext.request.contextPath}/adminAction!updateGrade"
				method="post">
					<input type="hidden" name="grade.grId" value="${studentGrade.grId }" >
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
						<td class="kv-content"><input type="text" name="grade.score" value="${studentGrade.score }" id="gr"></td>
					</tr> 
				</table>
			</form>


		</div>
      
		<div id="inner-ft">
		    <span id="err" style="color:red;"></span>
		</div>
	</div>

</body>
</html>