<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	/* 遍历所有专业 */
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/adminAction!selectAllMajor",
		success:function(mlist){			
		 	var str="<select id='ma'>";
		 	var vm=$("#vm").val();
		 	var vmajor=$("#vmajor").val();
		 	str+="<option value="+vm+">"+vmajor+"<option>";
			for(var i=0;i<mlist.length;i++){
				str+="<option value="+mlist[i].maId+">"+mlist[i].maName+"<option>";
			}
			str+="</select>";
			$("#con").html(str); 
		},
		error:function(){
			alert("失败");
		}
		
		
		
	})
	
	
})
	
function testradio(){
	var status = $(":radio:checked").val();
	alert(status);
	$("#aa").val(status);
	//获取下拉框选中的值
	var maid=$("#ma>option:selected").val();
	 alert(maid);
	 if(maid!=undefined){
			$("#bb").val(maid);
			$("#subform").submit();
		}else{
			alert("请选择专业");
		}
	
}
</script>
</head>
<body>
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">修改课程信息</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">

					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="testradio()">确认修改</span>
				</div>
			</div>
			<br> <br>

			<div class="button-group">
				<form id="subform" action="/educationSystem/adminAction!updateSchoolCourse"
					method="post">
					 <input type="hidden" name="course.coId" value="${course.coId }">
					<table class="kv-table">
						<tbody>
							<tr>
								<td class="kv-label">课程名称</td>
								<td class="kv-content"><input type="text"
									name="course.coName" value="${course.coName }" /></td>

								<td class="kv-label">学分</td>
								<td class="kv-content"><input type="text"
									name="course.coScore" value="${course.coScore }" /></td>
								<td class="kv-label">属性</td>
								<td class="kv-content"><c:if test="${course.coStatus=='1'}">
										<input type="radio" value="1" checked="checked" name="status">  必修
	                             <input type="radio" value="2" name="status"> 选修
	                     
                                 </c:if> 
                                 <c:if test="${course.coStatus=='2'}">
									<input type="radio" value="1" name="status">必修
			                         <input type="radio" value="2"
											checked="status" name="status">选修
			                       </c:if>
			                       <input type="hidden" name="course.coStatus" id="aa">
			                       </td>
								<td class="kv-label">周次</td>
								<td class="kv-content" colspan="1"><input type="text"
									name="course.coWeek" id="coWeek" value="${course.coWeek }" /> <span
									id="coWeekError"></span></td>
							</tr>
							<tr>
								<td class="kv-label">学期始</td>
								<td class="kv-content" colspan="2">
									<div class="date">
										<input class="easyui-datebox"
											data-options="sharedCalendar:'#cc'" name="start"
											id="coStartTime" value="${course.coStartTime }">

										<div id="cc" class="easyui-calendar"></div>
									</div>
								</td>
								<td class="kv-label">学期末</td>
								<td class="kv-content" colspan="2">
									<div class="date">
										<input class="easyui-datebox"
											data-options="sharedCalendar:'#cc'" name="end" id="coEndTime"
											value="${course.coEndTime }">

										<div id="cc" class="easyui-calendar"></div>

									</div>
								</td>
								<td class="kv-label">专业</td>
								<td class="kv-content">
								 <c:forEach items="${mlist }" var="m">
										<c:if test="${m.maId ==course.maId}">
											<input type="hidden" name="maname" value="${m.maName }" id="vmajor"/>
												<input type="hidden" name="maid" value="${m.maId }" id="vm"/>
											
										</c:if>
									</c:forEach> 
									<input type="hidden" name="course.maId" id="bb" />
						           <span id="con"></span>
									
							   </td>
							</tr>
							<tr>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

			<div id="inner-ft"></div>
		</div>
	</div>

</body>
</html>