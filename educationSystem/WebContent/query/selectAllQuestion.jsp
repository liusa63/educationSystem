<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评估表</title>
<link href="${pageContext.request.contextPath}/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/project/normal_exam.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/js/lib/umeditor/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
	<script type="text/javascript"
	src="/educationSystem/js/jquery.js"></script>
<script type="text/javascript">

function updatequestion(){
	var questionid = $(":radio:checked").val();
	if(questionid!=undefined){		
		$("#aa").val(questionid);
		$("#formsub").submit();
		
	}
	
	
}
</script>

	
</head>
<body>
	
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">教师信息</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="kv-group-outer">
				<div class="kv-group clearfix">
					<div class="kv-item">
						<div class="item-lt">专业：</div>
						<div class="item-rt">
							<select>
								<option>2015</option>
							</select>
						</div>
					</div>
					<div class="kv-item">
						<div class="item-lt">周期：</div>
						<div class="item-rt">
							<select>
								<option>第一季度</option>
							</select>
						</div>
					</div>

				</div>
			</div>
			<div class="button-group">
				<div class="button current">
					<i class="iconfont">&#xe76a;</i> <a
						href="${pageContext.request.contextPath}/query/addQuestion.jsp"><span
						class="button-label">录入</span></a>

				</div>

				<%-- <div class="button">
					<i class="iconfont"></i> <span class="button-label"
						onclick="">修改11</span>
					<form
						action="${pageContext.request.contextPath}/adminAction!findByIdTeacher"
						id="formsub">
						<input type="hidden" id="aa" name="teId">
					</form>
				</div> --%>
				
				
				<div class="button">
					<i class="iconfont">&#xe621;</i> <span class="button-label"
						onclick="updatequestion();">修改</span>
					<form action="adminAction!selectByIdQuestion" id="formsub">
						<input type="hidden" id="aa" name="question.qid">
					</form>
				</div>
				
				<div class="tip">提示：</div>
			</div>
			<div class="table-zone">

				<table>
					<thead>
						<tr>
							<td class="num">选择</td>
							<td class="num">问题编号</td>
							<td class="name">问题名称</td>


						</tr>
					</thead>
					<tbody>

						<c:forEach items="${qList }" var="q">
							<tr>
								<td><input type="radio" value="${q.qid }" name="qid"></td>
								<td>${q.qid }</td>
								<td>${q.qcontent }</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>

				<div class="note">
					<span>注：</span>

				</div>
			</div>
		</div>
		<div id="inner-ft"></div>
	</div>
</body>
</html>
