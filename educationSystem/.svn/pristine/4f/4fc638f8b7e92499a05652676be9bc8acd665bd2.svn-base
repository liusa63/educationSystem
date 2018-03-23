<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/pages/statistics_query/leader.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">教学评估表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				
			</div>

			<div class="kv-group-outer"></div>
			<div class="table-zone">
				<form id="formadd"
					action="${pageContext.request.contextPath }/adminAction!addQuestion"
					method="post">
					<table>
						<thead>
							<tr>
								<td class="dept">调查项目</td>
								<c:forEach items="${qList }" var="qlist">
									<td class="dept">${qlist.qcontent }</td>
								</c:forEach>
								
							</tr>
						</thead>
						<tbody>
							<tr>

								<td class="dept">平均分</td>


								<td>${q1 } 分</td>
								<td>${q2 } 分</td>
								<td>${q3 } 分</td>
								<td>${q4 } 分</td>
								<td>${q5 } 分</td>
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
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/global.js"></script>
	<script type="text/javascript" src="../js/core.js"></script>
	<script type="text/javascript" src="../js/jquery.select.js"></script>
	<script type="text/javascript" src="../js/jquery.grid.js"></script>
	<script type="text/javascript">
        
    $('select').select();
    </script>


</body>
</html>