<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改班级信息</title>
<link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap-datepicker.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/project/userinfo.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/project/userinfo.css"
	rel="stylesheet">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lib/datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lib/datepicker/locales/bootstrap-datepicker.zh-CN.min.js">
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
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
			$("#content").html(str); 
		},
		error:function(){
			alert("失败");
		}
		
		
		
	})
	
	/* 遍历所有教师表 */
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/adminAction!selectByIdTeacher?tebehave=2",
				
		success:function(tlist){		   
		 	 var str="<select id='te'>";
		 	var teacherid=$("#teacherid").val();
		 	var teachername=$("#teachername").val();
		 	str+="<option value="+teacherid+">"+teachername+"<option>";
		 	
			for(var i=0;i<tlist.length;i++){
				str+="<option value="+tlist[i].teId+">"+tlist[i].teName+"<option>";
			}
			str+="</select>";
			$("#content1").html(str); 
		},
		error:function(){
			alert("失败");
		}
		
		
	})
})
	
function sub(){
	//获取下拉框选中的值
	var maid=$("#ma>option:selected").val();
	
	 if(maid!=undefined){
			$("#aa").val(maid);
			var teid=$("#te>option:selected").val();
			 if(teid!=undefined){
					$("#bb").val(teid);
					
					$("#subform").submit();
				}else{
					alert("请选择班主任");
				}
			
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
					class="crumbs-label">班级信息</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="button-group">

				<!-- <div class="button current save">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="sub();">11保存</span>
				</div> -->
				<div class="button">
		            <i class="iconfont">&#xe621;</i>
		            <span class="button-label" onclick="sub();">确认修改</span>
		        </div>
				
			</div>

			<form id="subform"
				action="${pageContext.request.contextPath }/adminAction!updateSclass"
				method="post">
					<input type="hidden" name="sclass.clId" value="${sc.clId }" >
				<table class="kv-table">

					<tr>
						<td class="kv-label">班级名称</td>
						<td class="kv-content">
							<div class="date">
								<input type="text" name="sclass.clName" value="${sc.clName }" > <span
									id="clNameError"></span>
							</div>
						</td>
					<tr>
						<td class="kv-label">班级人数</td>
						<td class="kv-content">
							<div class="date">
								<input type="text" name="sclass.clCount" value="${sc.clCount }"> <span
									id="clCountError"></span>
							</div>
						</td>
					</tr>
					 <tr>
						<td class="kv-label">专业:</td>
						<td class="kv-content">
						<input type="hidden" name="${sc.major.maId }" value="${sc.major.maName }" id="vmajor">
						<input type="hidden" name="${sc.major.maId }" value="${sc.major.maId }" id="vm">
						<input type="hidden" name="maid" id="aa" />
						<span id="content"></span>
						</td>
					</tr> 

					<tr>

						<td class="kv-label">班主任:</td>
						<td class="kv-content">
						
						
						
						<c:forEach items="${tlist }" var="teacher">
						<c:if test="${teacher.teId ==sc.teId}">
						 <input type="hidden" name="tename" value="${teacher.teName} " id="teachername">
						<input type="hidden" name="tename" value="${teacher.teId} " id="teacherid">
						
						</c:if>
					</c:forEach> 
					<span id="content1"></span>
						<input type="hidden" name="sclass.teId" id="bb" />
						
						</td>
						
					</tr>
				</table>
			</form>


		</div>

		<div id="inner-ft"></div>
	</div>

</body>
</html>