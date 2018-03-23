
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


function selectanswer(){
	var coid = $(":radio:checked").val();
	if(coid!=undefined){
	
		$("#aa").val(coid);
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
					<i class="iconfont">&#xe76a;</i> <span
						class="button-label" onclick="selectanswer();">查询教学评估</span>

				</div>

				<div class="button">
					<i class="iconfont"></i> <span class="button-label"
						onclick="window.history.go(-1);">返回</span>
					<form
						action="${pageContext.request.contextPath}/adminAction!selectEvaluation"
						id="formsub">
						<input type="hidden" id="aa" name="coid">
						
					</form>
				</div>
				<div class="tip">
			
				</div>
			</div>
			<div class="table-zone">

				<table>
					<thead>
						<tr>
						
							<td class="name" colspan="8">课程名称</td>
							
						</tr>
						<tr>
						
							
							<c:forEach items="${en }" var="en">
						   <c:forEach items="${clist }" var="c">
										<c:if test="${c.coId==en.coId}">
										<tr>
										<td class="num" colspan="2">
										<input type="radio" value="${en.coId }" name="coid">
										</td>
										<td class="name" colspan="2">${c.coName }</td>
										</tr>
						            </c:if>
							</c:forEach>
							
						</c:forEach>
							
							

						</tr>
					</thead>				
					</table>	
				<div class="note">
					<span>	${msg }</span>

				</div>
			</div>
		</div>
		<div id="inner-ft"></div>
	</div>
    


</body>
</html>