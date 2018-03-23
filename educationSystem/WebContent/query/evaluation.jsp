<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
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
					window.location.href = "adminAction!selectListEvaluation?currentpage="
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
</script>
</head>
<body>

	<table>
		<tr>
		
		<c:forEach items="${qlist }" var ="qlist">
		
		<td>${qlist.qcontent }</td>
		
		</c:forEach>
		<td>教师姓名</td>
		<td>学生姓名</td>
		</tr>
		
		<c:forEach items="${page.list }" var="ev">
			<tr>
				<td>${ev.answer1 }</td>
				<td>${ev.answer2 }</td>
				<td>${ev.answer3 }</td>
				<td>${ev.answer4 }</td>
				<td>${ev.answer5 }</td>
				<td>${ev.coId}</td>
				<td>${ev.teId }</td>
				<td><a href="selectById_employAction?id=${employ.id }&type=0">查看</a>
					<a href="selectById_employAction?id=${employ.id }&type=1">编辑</a> <a
					href="javascript:deleteById(${employ.id })">删除</a> <script
						type="text/javascript">
						function deleteById(id) {
							if (confirm("确认删除吗?")) {
								location.href = "deleteById_employAction?id="
										+ id;
							}
						}
					</script></td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="返回"
				onclick="window.history.go(-1);" /></td>
		</tr>

	</table>
	<div style="float: right; margin-right: 55px;" class="pageDiv">
		<a href="adminAction!selectListEvaluation?currentpage=1">首页</a>
		<!-- 如果当前页码大于1，才展示上一页 -->
		<c:if test="${page.currentPage>1 }">
			<a
				href="adminAction!selectListEvaluation?currentpage=${page.currentPage-1}">上一页</a>
		</c:if>
		${page.currentPage+1}
		<!-- 	如果当前页码小于总页数，才展示下一页 -->
		<c:if test="${page.currentPage<countPage }">
			<a
				href="adminAction!selectListEvaluation?currentpage=${page.currentPage+1}">下一页</a>
		</c:if>
		<a
			href="adminAction!selectListEvaluation?currentpage=${page.countPage}">尾页</a>
		共${page.totalNum}条,共${page.countPage}页 <input id="inputPage"
			type="text"
			style="margin-right: 10px; padding: 2px; width: 30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
		<input type="button" value="跳转" onclick="gotoPage();" />
	</div>




</body>