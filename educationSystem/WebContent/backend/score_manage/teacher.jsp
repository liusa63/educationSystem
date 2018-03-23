﻿<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	function gotoPage() {
		//获取输入的页码
		var inputPage = $("#inputPage").val();
		var rex = /^\d+$/;
		var countPage = $
		{
			page.countPage
		}
		;
		//判断是否为正整数
		//判断输入的不为空
		if (inputPage != null) {
			if (rex.test(inputPage)) {
				//判断输入的页码是否小于总页数
				if (inputPage <= countPage) {
					window.location.href = "${pageContext.request.contextPath}/adminAction!selectAllTeacher?currentPage="
							+ inputPage;
				} else {
					alert("最大页数是" + countPage);
				}
			} else {
				alert("请输入正整数");

			}
		} else {
			alert("请输入页码");
		}
	}

	function updateteacher() {
		var teid = $(":radio:checked").val();
		if (teid != undefined) {
		
			$("#aa").val(teid);
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
						href="${pageContext.request.contextPath}/backend/addTeacher.jsp"><span
						class="button-label">录入</span></a>

				</div>
				<div class="button">
		            <i class="iconfont">&#xe621;</i>
		            <span class="button-label" onclick="updateteacher();">修改</span>
		            <form
						action="${pageContext.request.contextPath}/adminAction!findByIdTeacher"
						id="formsub">
						<input type="hidden" id="aa" name="teId">
					</form>
		        </div>

				
				<div class="tip">提示：</div>
			</div>
			<div class="table-zone">

				<table>
					<thead>
						<tr>
							<td class="num">编号</td>
							<td class="name">教师工号</td>
							<td class="name">教师姓名</td>
							<td class="name">联系方式</td>
							<td class="name">身份</td>
							<td class="name">工资</td>
							<td class="name">专业</td>
							<td class="name">操作</td>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list }" var="teacher">
							<tr>
								<td><input type="radio" value="${teacher.teId }"
									name="teacher"></td>
								<td>${teacher.teNum }</td>
								<td>${teacher.teName }</td>

								<td>${teacher.tePhone }</td>

								<td><c:if test="${teacher.teBehave =='1' }">
											讲师
									</c:if>
									 <c:if test="${teacher.teBehave =='2' }">
											班主任
									</c:if>
								</td>

								<td>${teacher.teSalary }</td>
								<td><c:forEach items="${mlist }" var="m">
										<c:if test="${m.maId ==teacher.maId}">
						${m.maName }
						</c:if>
									</c:forEach></td>
								<td><a
									href="${pageContext.request.contextPath}/adminAction!selectByTeacherCourse?teid=${teacher.teId }">查看教学评估</a></td>
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
	<div style="float: right; margin-right: 55px;" class="pageDiv">
		<a
			href="${pageContext.request.contextPath}/adminAction!selectAllTeacher?currentpage=1">首页</a>

		<!-- 如果当前页码大于1，才展示上一页 -->
		${page.currentPage+1}
		<c:if test="${page.currentPage>0 }">
			<a
				href="${pageContext.request.contextPath}/adminAction!selectAllTeacher?currentpage=${page.currentPage-1}">上一页</a>
		</c:if>

		<!-- 	如果当前页码小于总页数，才展示下一页 -->
		<c:if test="${page.currentPage<page.countPage }">
			<a
				href="${pageContext.request.contextPath}/adminAction!selectAllTeacher?currentpage=${page.currentPage+1}">下一页</a>
		</c:if>
		<a
			href="${pageContext.request.contextPath}/adminAction!selectAllTeacher?currentpage=${page.countPage}">尾页</a>
		共${page.totalNum}条,共${page.countPage}页 <input id="inputPage"
			type="text"
			style="margin-right: 10px; padding: 2px; width: 30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
		<input type="button" value="跳转" onclick="gotoPage();" />
	</div>




</body>
</html>