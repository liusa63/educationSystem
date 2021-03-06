<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>学籍登记表</title>
<link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap-datepicker.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/pages/statistics_query/year.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function subform(){
		var sex = $(":radio:checked").val();
		var sro = $(":radio:checked").val();
		$("#aa").val(sex);
		$("#bb").val(sro);
		$("#formsub").submit();
	}
</script>

</head>
<body>
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">修改学生学籍信息</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">
					<i class="iconfont">&#xe76a;</i>
					<span class="button-label"	onclick="subform();">确认修改</span>				
				</div>
			</div>
			<br><br>
			
			<div class="button-group">
			<form
				action="${pageContext.request.contextPath }/adminAction!updateStudentSroll"
				method="post"  id="formsub" enctype="multipart/form-data">
				<input type="hidden" name="sroll.srSex" id="aa">
				<input type="hidden" name="sroll.srIsRoll" id="bb">
				<input type="hidden" name="sroll.srId" value="${sroll.srId }">
				<input type="hidden" name="sroll.srNumber" value="${sroll.srNumber }">
				<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">学号</td>
							<td class="kv-content">
							${sroll.srNumber }
							
							</td>

							<td class="kv-label">姓名</td>
							<td class="kv-content">
								<input type="text" value="${sroll.srName }" name="sroll.srName">
							
							</td>
								
							<td class="kv-label">性别</td>
							<td class="kv-content" colspan="1">
							 <c:if test="${sroll.srSex=='1'}">
							 <input type="radio" value="1" checked="checked" name="sex">  女
                             <input type="radio" value="2"  name="sex"> 男
                     
                       </c:if>
                        <c:if test="${sroll.srSex=='2'}">
                        <input type="radio" value="1"  name="sex">女
                         <input type="radio" value="2" checked="checked" name="sex">男
                       </c:if>
							</td>
						
							<td class="kv-content" rowspan="3">
							
							<img src="/static/${sroll.srImg }" height="200px" width="250">
							 <input type="file" name="file">
							</td>
						</tr>
						<tr>
							<td class="kv-label">身份证号</td>
							<td class="kv-content" colspan="1">
								<input type="text" value="${sroll.srIdCard }" name="sroll.srIdCard">
							
							</td>

							<td class="kv-label">籍贯</td>
							<td class="kv-content multi" colspan="3">
							<input type="text" value="${sroll.srAddress }" name="sroll.srAddress">
								
							</td>
							

						</tr>

						<tr>
							<td class="kv-label">是否有学籍</td>
							<td class="kv-content">
                       <c:if test="${sroll.srIsRoll =='1'}">
                       <input type="radio" value="1" checked="checked" name="roll">是
                        <input type="radio" value="1"  name="roll">否
                       
                       </c:if>
                        <c:if test="${sroll.srIsRoll =='2'}">
                         <input type="radio" value="1"  name="roll">是
                         <input type="radio" value="2" checked="checked" name="roll">否
                       </c:if>
								</td>
							<td class="kv-label">出生年月</td>

							<td class="kv-content">
							<div class="date">
									<input class="easyui-datebox"
										data-options="sharedCalendar:'#cc'" name="sroll.srBirthday"
										id="srTime" value="${sroll.srBirthday }">
									<div id="cc" class="easyui-calendar"></div>
								</div>
								
							</td> 
							
							<td class="kv-label">入学时间</td>
							<td class="kv-content">
								<div class="date">
									<input class="easyui-datebox"
										data-options="sharedCalendar:'#cc'" name="sroll.srTime"
										id="srTime" value="${sroll.srTime }">
									<div id="cc" class="easyui-calendar"></div>
								</div>
								
								
							</td>
							
						</tr>
					</tbody>

				</table>
			</form>

		</div>
</div>
		
</div>
	
</body>
</html>
