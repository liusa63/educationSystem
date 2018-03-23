<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/project/normal_exam.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/js/lib/umeditor/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">

function subform(){
	
		$("#formsub").submit();
		
	
	
	
}
</script>


</head>
<body>
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">问题信息</a>
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
						href="/educationSystem/query/addQuestion.jsp"><span
						class="button-label">录入</span></a>

				</div>
				<div class="button">
					<i class="iconfont">&#xe621;</i> <span class="button-label"
						onclick="subform();">确认修改</span>

				</div>

				<div class="tip">提示：</div>
			</div>
			<div class="table-zone">
				<form action="adminAction!updateQuestion" id="formsub" method="post">
					<table>
						<thead>
							<tr>

								<td class="num">问题编号</td>
								<td class="name">问题名称</td>


							</tr>
						</thead>
						<tbody>


							<tr>
								<input type="hidden" name="question.qid"
									value="${question.qid }">
								<td>${question.qid }</td>

								<td><input type="text" name="question.qcontent"
									value="${question.qcontent }"></td>

							</tr>




						</tbody>
					</table>
				</form>
				<div class="note">
					<span>注：</span>

				</div>
			</div>
		</div>
		<div id="inner-ft"></div>
	</div>

</body>
</html>