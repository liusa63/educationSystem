<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	var ids = "teNum,teName,tePhone,teSalary";
	var msg = "请输入工号,请输入姓名,请输入联系方式,请输入工资";

	//非空验证
	function checkNull(ids, msg) {
		var idArray = ids.split(",");
		var msgArray = msg.split(",");
		for ( var i = 0; i < idArray.length; i++) {
			var id = $("#" + idArray[i]).val();
			//如果为空，给出错误提示
			if (id == "") {
				$("#" + idArray[i] + "Error").html(msgArray[i]);
				return false;
			}
		}
		return true;
	}

	//页面加载完成触发的事件
	$(document).ready(function() {
		//设置获取焦点触发的事件：错误提示消失
		$("#teNum").focus(function() {
			$("#teNum").val("");
			$("#teNumError").html("");
		});
		$("#teName").focus(function() {
			$("#teName").val("");
			$("#teNameError").html("");
		});
		$("#tePhone").focus(function() {
			$("#tePhone").val("");
			$("#tePhoneError").html("");
		});
		$("#teSalary").focus(function() {
			$("#teSalary").val("");
			$("#teSalaryError").html("");
		});

		//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
		$("#teNum").blur(function() {
			var u = $("#teNum").val();
			if (u == "") {
				$("#teNumrError").html("工号不能为空");
			}
		});
		$("#teName").blur(function() {
			var p = $("#teName").val();
			if (p == "") {
				$("#teNameError").html("姓名不能为空");
			}
		});
		$("#tePhone").blur(function() {
			var p = $("#tePhone").val();
			if (p == "") {
				$("#tePhoneError").html("联系电话不能为空");
			}
		});
		$("#teSalary").blur(function() {
			var p = $("#teSalary").val();
			if (p == "") {
				$("#teSalaryError").html("工资不能为空");
			}
		});
	});

	
	//获取选中单选框
	function testradio() {
		if (checkNull(ids, msg)) {
			var v = $(":radio:checked").val();
			if (v != undefined) {			
				$("#aa").val(v);
				var id = $("#ma>option:selected").val();
				if (id != "undefined") {
					$("#bb").val(id);
					$("#formadd").submit();
				} else {
					alert("请选择专业");
				}
			} else {
				alert("请选择身份");
			}
		}
	}

	/* 遍历所有专业 */
	$(
			function() {

				$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath}/adminAction!selectAllMajor",
					success : function(mlist) {

						var str = "<select id='ma'>";
						str += "<option value='undefined'>" + "请选择专业"
								+ "<option>";
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"
									+ mlist[i].maName + "<option>";
						}
						str += "</select>";
						$("#content").html(str);
					},
					error : function() {
						alert("失败");
					}

				})
				
				$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath }/adminAction!ajaxUserNumber",
						success:function(stnumber){
							
							$("#srnumber").html(stnumber);
							$("#number").val(stnumber);
						},
						error:function(){
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
					class="crumbs-label">教师信息登记表</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="testradio();">保存</span>
				</div>
				 <div class="button current add">
		            <i class="iconfont">&#xe620;</i>
		           
		       <a href="${pageContext.request.contextPath }/pages/addTeachers.jsp"><span class="button-label" > 批量录入</span></a>     
		        </div>
				<div class="button current save">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="window.history.go(-1);">返回</span>
				</div>
			</div>
			<br> <br>
			<div class="button-group">
			
				<form id="formadd"
					action="${pageContext.request.contextPath }/adminAction!addTeacher"
					method="post">

					<table class="kv-table">
						<tbody>
							<tr>
								<td class="kv-label">教师工号</td>
								<td class="kv-content">
								<!-- <input type="text" name="teNum"
									id="teNum" /> <span id="teNumError"></span> -->
									<input type="hidden"	name="teNum" id="number"  value="">  
								 <span id="srnumber"></span> 	
									</td>
								<td class="kv-label">教师姓名</td>
								<td class="kv-content"><input type="text" name="teName"
									id="teName" /> <span id="teNameError"></span></td>
								<td class="kv-label">身份</td>
								<td class="kv-content"><input type="radio" value="1"
									name="teachername">讲师 <input type="radio" value="2"
									name="teachername">班主任 <input type="hidden"
									name="teBehave" id="aa"></td>
							</tr>
							<tr>
								<td class="kv-label">联系电话</td>
								<td class="kv-content" colspan="1"><input type="text"
									name="tePhone" id="tePhone" /> <span id="tePhoneError"></span></td>
								<td class="kv-label">工资</td>
								<td class="kv-content multi" colspan="1">
									<div class="textarea-wrap">
										<input type="text" name="teSalary" id="teSalary" /> <span
											id="teSalaryError"></span>
									</div>
								</td>
								<td class="kv-label">选择专业</td>
								<td class="kv-content"><span id="content"></span>
									<div class="item-rt"></div> <input type="hidden" name="maId"
									id="bb"></td>
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