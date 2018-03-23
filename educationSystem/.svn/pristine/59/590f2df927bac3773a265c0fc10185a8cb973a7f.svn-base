<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
function gotoPage(){
	  //获取输入的页码
	var inputPage=  $("#inputPage").val();
	 var rex=/^\d+$/;
	 var countPage=${page.countPage};
	 //判断是否为正整数
	 //判断输入的不为空
	 if(inputPage!=null){
		 if(rex.test(inputPage)){
			 //判断输入的页码是否小于总页数
			 if(inputPage<=countPage){
				 window.location.href="${pageContext.request.contextPath}/adminAction!selectAllExcourse?currentPage="+inputPage;
			 }else{
				 alert("最大页数是"+countPage);
			 }
		 }else{
			 alert("请输入正整数");

		 }
	 }else{
		 alert("请输入页码");
	 }
}

function updateexcourse(){
	var exid = $(":radio:checked").val();
	if(exid!=undefined){		
		$("#aa").val(exid);
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
					class="crumbs-label">选课信息</a>
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
					<i class="iconfont">&#xe76a;</i> 
					<a href="${pageContext.request.contextPath}/backend/addExCourse.jsp"><span class="button-label">录入</span></a>
					
				</div>


       <div class="button">
		            <i class="iconfont">&#xe621;</i>
		            <span class="button-label" onclick="updateexcourse();">修改</span>
		          <form action="${pageContext.request.contextPath}/adminAction!findByIdExcourse" id="formsub">
						<input type="hidden" id="aa" name="excourse.exId">
					</form>		        </div>

				
				<div class="tip">提示：</div>
			</div>
			<div class="table-zone">

				<table>
					<thead>
						<tr>
						<td class="num">编号</td>
							<td class="name">课程名称</td>
							<td class="name">教师姓名</td>
							<td class="name">学分</td>
							<td class="name">课余量</td>
							<td class="name">周次</td>
							<td class="name">星期</td>
							<td class="name">教室</td>
							<td class="name">开始时间</td>
							<td class="name">结束时间</td>
							

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list }" var="excourse">
							<tr>
								<td><input type="radio" value="${excourse.exId }" name="excourse.exId"></td>
								<td>${excourse.exName }</td>
								<td>
								<c:forEach items="${tlist }" var="t">
									<c:if test="${t.teId ==excourse.teId}">
									${t.teName }
									</c:if>
								</c:forEach>
								</td>

								<td>${excourse.exScore }</td>
								<td>${excourse.exCount }</td>
								<td>${excourse.exWeek }</td>
								<td>${excourse.exDay }</td>

								<td>
								<c:forEach items="${rlist }" var="r">
									<c:if test="${r.roId ==excourse.roId}">
									${r.roName }
									</c:if>
								</c:forEach>
								</td>

								<td>${excourse.exStart }</td>
									<td>${excourse.exEnd }</td>
								
								
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
			href="${pageContext.request.contextPath}/adminAction!selectAllExcourse?currentpage=1">首页</a>
			
		<!-- 如果当前页码大于1，才展示上一页 -->
			${page.currentPage+1}
		<c:if test="${page.currentPage>0 }">
			<a
				href="${pageContext.request.contextPath}/adminAction!selectAllExcourse?currentpage=${page.currentPage-1}">上一页</a>
		</c:if>
	
		<!-- 	如果当前页码小于总页数，才展示下一页 -->
		<c:if test="${page.currentPage<page.countPage }">
			<a
				href="${pageContext.request.contextPath}/adminAction!selectAllExcourse?currentpage=${page.currentPage+1}">下一页</a>
		</c:if>
		<a
			href="${pageContext.request.contextPath}/adminAction!selectAllExcourse?currentpage=${page.countPage}">尾页</a>
		共${page.totalNum}条,共${page.countPage}页 <input id="inputPage"
			type="text"
			style="margin-right: 10px; padding: 2px; width: 30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
		<input type="button" value="跳转" onclick="gotoPage();" />
	</div>




</body>
</html>