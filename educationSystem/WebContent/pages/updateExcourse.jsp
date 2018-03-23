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
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">

//获取选中下拉框
function testradio() {


		
			
				
				var roid = $("#ro>option:selected").val();/* 选择教室 */
				if (roid != undefined) {
					$("#bb").val(roid);				
					var teid = $("#te>option:selected").val(); /* 选择老师 */
					if (teid != undefined) {
						$("#cc").val(teid);						
						$("#formadd").submit();
					} else {
						alert("请选择老师");
					}

				} else {
					alert("请选择教室");
				}

			

	
}


/* 遍历所有教室 */
$(function() {

	$
			.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/adminAction!selectAjaxRoom",
				success : function(rlist) {
					
					var str = "<select id='ro'>";
					 var vroname=$("#roname").val();
					 var vroid=$("#roid").val();
					 	
				 	
				 	str+="<option value="+vroid+">"+vroname+"<option>"; 
					for ( var i = 0; i < rlist.length; i++) {
						str += "<option value="+rlist[i].roId+">"
								+ rlist[i].roName + "<option>";
					}
					str += "</select>";
					$("#content2").html(str);
				},
				error : function() {
					alert("失败");
				}

			})



/* 遍历所有教师 */
$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectByIdTeacher?tebehave=1",
					success : function(tlist) {

						var str = "<select id='te'>";
						 var vtename=$("#tename").val();
						 var vteid=$("#teid").val();
					 	
					 	str+="<option value="+vteid+">"+vtename+"<option>"; 
						for ( var i = 0; i < tlist.length; i++) {
							str += "<option value="+tlist[i].teId+">"
									+ tlist[i].teName + "<option>";
						}
						str += "</select>";
						$("#content3").html(str);
					},
					error : function() {
						alert("失败");
					}

				})
		})		
</script>
</head>
<body>
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">选课信息表</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<!-- <div class="button current">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="testradio();">11保存</span>
				</div> -->
				
				<div class="button">
		            <i class="iconfont">&#xe621;</i>
		            <span class="button-label" onclick="testradio();">确认修改</span>
		        </div>
			</div>
			<br> <br>
			<div class="button-group">
				<form id="formadd"
					action="${pageContext.request.contextPath }/adminAction!updateExCourse"
					method="post">
                       <input type="hidden" name="excourse.exId" value="${excourse.exId }" >
                       <input type="hidden" name="excourse.exName" value="${excourse.exName }" >
					<table class="kv-table">
						<tbody>
							<tr>
								<td class="kv-label">课程名称</td>
								<td class="kv-content">
									${excourse.exName }
								</td>

								<td class="kv-label">学分</td>
								
								<td class="kv-content"><input type="text"
									name="excourse.exScore" value="${excourse.exScore }" />
								</td>
								
								<td class="kv-label">周次</td>
								
								<td class="kv-content multi">
									<div class="textarea-wrap">
										<input type="text" name="excourse.exWeek"
											value="${excourse.exWeek}" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="kv-label">课余量</td>
								<td class="kv-content" colspan="1"><input type="text"
									name="excourse.exCount" value="${excourse.exCount }" /></td>
								<td class="kv-label">星期</td>
								<td class="kv-content" colspan="1"><input type="text"
									name="excourse.exDay" value="${excourse.exDay }" /></td>
								<td class="kv-label">教室</td>
								<td class="kv-content" colspan="1"><c:forEach
										items="${rlist }" var="r">
										<c:if test="${r.roId ==excourse.roId}">
											<input type="hidden" name="roname" value="${r.roName }" id="roname"/>
											<input type="hidden" name="roid" value="${r.roId }" id="roid"/>
										</c:if>
									</c:forEach>
									<span id="content2"></span>
									<input type="hidden" name="excourse.roId" id="bb" />
								</td>
							</tr>
							<tr>
								<td class="kv-label">老师</td>
								<td class="kv-content" colspan="1"><c:forEach
										items="${tlist }" var="t">
										<c:if test="${t.teId ==excourse.teId}">
											<input type="hidden" name="tename" value="${t.teName }"  id="tename"/>
                                            <input type="hidden" name="teid" value="${t.teId }"  id="teid"/>
										</c:if>
									</c:forEach>
									<span id="content3"></span>
									<input type="hidden" name="excourse.teId" id="cc" />
									</td>
								<td class="kv-label">开始时间</td>
								<td class="kv-content" colspan="1"><input type="text"
									name="excourse.exStart" value="${excourse.exStart }" /></td>

								<td class="kv-label">结束时间</td>
								<td class="kv-content" colspan="1"><input type="text"
									name="excourse.exEnd" value="${excourse.exEnd }" /></td>
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
