<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员--添加专业</title>
<link href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap-datepicker.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css"	rel="stylesheet">
<link	href="${pageContext.request.contextPath }/css/project/userinfo.css" rel="stylesheet">

<script type="text/javascript"	src="${pageContext.request.contextPath }/js/jquery.js"></script>
 <script type="text/javascript">
   function saveFun(){
	  var ma = $("#maname").val();
	  if(ma != "" && ma!= undefined){
		  $.ajax({
			  type : "post",
			  url : "${pageContext.request.contextPath }/adminLittleAction!selectMajorIfExist?maname="+ma,
			  success : function(msg) {
				  
				  if(msg=="yes"){//没有该专业,表单提交
					  $("#addForm").submit();
					  
				  }else{
					  
					  $("#manameErrror").html("已经存在该专业，不可重复录入");
					  
				  }
				  
			  },
			  error : function() {
					alert("失败");
				}
		  })
		  
	  }else{
		  $("#manameErrror").html("请输入专业名称再保存");
	  }
   }
   
   function  moreFun(){
	   window.location.href="${pageContext.request.contextPath }/backend/addMoreMajor.jsp";
   }
 
 </script>

</head>
<body>

<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">专业信息登记表</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">
					<i class="iconfont">&#xe76a;</i> 
					<span class="button-label" onclick="saveFun();">保存</span>
				</div>
                 <div class="button current">
					<i class="iconfont">&#xe620;</i> 
					<span class="button-label" onclick="moreFun();">批量录入</span>
				</div>

			</div>
			<br> <br>

			<div class="button-group">
				<form id="addForm" action="${pageContext.request.contextPath }/adminLittleAction!addMajor" method="post">

					<table class="kv-table">
						<tbody>
						<tr>
								<td class="kv-label">请输入专业名称</td>
								<td class="kv-content" colspan="2">
								<input type="text" name="maname" id="maname"/>
								<span id="manameErrror"  style="color:red"></span>
								</td>
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