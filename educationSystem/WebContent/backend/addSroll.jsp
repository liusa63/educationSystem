<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>学籍登记表</title>
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
	var ids = "srNumber,srName,srIdCard,srAddress";
	var msg = "请输入学号,请输入姓名,请输入身份证号,请输入地址";
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

		$("#srNumber").focus(function() {
			$("#srNumber").val("");
			$("#srNumberError").html("");
		});
		$("#srName").focus(function() {
			$("#srName").val("");
			$("#srNameError").html("");
		});
		$("#srIdCard").focus(function() {
			$("#srIdCard").val("");
			$("#srIdCardError").html("");
		});
		$("#srAddress").focus(function() {
			$("#srAddress").val("");
			$("#srAddressError").html("");
		});
		/* $("#srBirthday").focus(function() {
			$("#srBirthday").val("");
			$("#srBirthdayError").html("");
		});
		$("#srTime").focus(function() {
			$("#srTime").val("");
			$("#srTimeError").html("");
		}); */

		//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
		$("#srNumber").blur(function() {
			var u = $("#srNumber").val();
			if (u == "") {
				$("#srNumberError").html("学号不能为空");
			}
		});
		$("#srName").blur(function() {
			var p = $("#srName").val();
			if (p == "") {
				$("#srNameError").html("姓名不能为空");
			}
		});
		$("#srIdCard").blur(function() {
			var p = $("#srIdCard").val();
			if (p == "") {
				$("#srIdCardError").html("身份证不能为空");
			}
		});
		$("#srAddress").blur(function() {
			var p = $("#srAddress").val();
			if (p == "") {
				$("#srAddressError").html("籍贯不能为空");
			}
		});
		/* $("#srBirthday").blur(function() {
			var p = $("#srBirthday").val();
			if (p == "") {
				$("#srBirthdayError").html("出生日期不能为空");
			}
		});
		$("#srTime").blur(function() {
			var p = $("#srTime").val();
			if (p == "") {
				$("#srTimeError").html("入学时间不能为空");
			}
		});
		
		
		
		
		
		 */

	});
	



	
$(function(){
	
	/* 遍历所有班级表 */
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/adminAction!ajaxSelectAllSclass",
		success:function(sclist){
		 	var str="<select id='sc'>";
		 	str+="<option value='undefined'>"+"请选择班级"+"<option>";
			for(var i=0;i<sclist.length;i++){
				str+="<option value="+sclist[i].clId+">"+sclist[i].clName+"<option>";
			}
			str+="</select>";
			$("#content1").html(str); 
		},
		error:function(){
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

	//获取选中下拉框
	function sub() {
		if (checkNull(ids, msg)) {
			var sex= $("#s1>option:selected").val(); /* 选择性别 */
			
			if (sex!= "undefined") {
				$("#aa").val(sex);
				
				var sroll = $("#isroll>option:selected").val(); /* 选择是否有学籍 */
				if (sroll!= "undefined") {
					$("#bb").val(sroll);
					var scl=$("#sc>option:selected").val(); /*  选择班级 */
					if(scl!="undefined"){
						$("#cc").val(scl);
						var sbehave=$("#stb>option:selected").val(); /*  选择身份 */
						if(sbehave!="undefined"){
							$("#srnumber").html(sbehave);
							
							$("#formsub").submit();

						}else{
							alert("请选择身份");
						}
						

					}else{
						alert("请选择班级");
					}
					
					
				} else {
					alert("请是否有学籍");
				}

			} else {
				alert("请选择性别");
			}

		}
	}
</script>

</head>
<body>
	<div class="container">
		<div id="inner-hd">
			<div class="crumbs">
				<i class="crumbs-arrow"></i> <a href="javascript:;"
					class="crumbs-label">学籍信息登记表</a>
			</div>
		</div>

		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="sub();">保存</span>
				</div>
				<div class="button">
					<i class="iconfont">&#xe62e;</i> 
					<span class="button-label" onclick="window.history.go(-1);">返回</span>
					
					
				</div>

			</div>
			<br><br>
			
			<div class="button-group">
			<form
				action="${pageContext.request.contextPath }/adminAction!addSroll"
				method="post"  id="formsub" enctype="multipart/form-data">
				  <input type="hidden" name="sroll.srSex" id="aa">
				   <input type="hidden" name="sroll.srIsRoll" id="bb">
				<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">学号</td>
							<td class="kv-content">
						<input type="hidden"	name="sroll.srNumber" id="number"  value="">  
								 <span id="srnumber"></span> 
								
							</td>

							<td class="kv-label">姓名</td>
							<td class="kv-content">
							<input type="text"	name="sroll.srName" id="srName"> <span id="srNameError"></span></td>
							<td class="kv-label">性别</td>
							<td class="kv-content">
							<select id="s1">
							        <option value="undefined">请选择性别</option>
									<option value="1">女</option>
									<option value="2">男</option>
							</select> 
						</td>
							<td class="kv-label">出生年月</td>

							<td class="kv-content">
								<div class="date">
									<input class="easyui-datebox"
										data-options="sharedCalendar:'#cc'" name="sroll.srBirthday"
										id="srBirthday">
									<div id="cc" class="easyui-calendar"></div>
								</div>
							</td>
						</tr>

						<tr>
							<td class="kv-label">身份证号</td>
							<td class="kv-content" colspan="1">
							<input type="text" name="sroll.srIdCard" id="srIdCard">
							 <span id="srIdCardError"></span>
							</td>

							<td class="kv-label">籍贯</td>
							<td class="kv-content multi" colspan="3">
								<div class="textarea-wrap">
									<input type="text" name="sroll.srAddress" id="srAddress">
									<span id="srAddressError"></span>
								</div>
							</td>
							<td class="kv-label">入学时间</td>
							<td class="kv-content">
								<div class="date">
									<input class="easyui-datebox"
										data-options="sharedCalendar:'#cc'" name="sroll.srTime"
										id="srTime">
									<div id="cc" class="easyui-calendar"></div>
								</div>
							</td>

						</tr>

						<tr>
						
						<td class="kv-label">班级</td>
							<td class="kv-content multi" colspan="1">
								<span id="content1"></span>
								<input type="hidden" id="cc" name="clid" >
							</td>
							<td class="kv-label">身份</td>
							<td class="kv-content multi" colspan="1">
							<div class="item-rt">
									<select id="stb">	
									    <option value="undefined">请选择身份</option>								
										<option value="1">班长</option>
										<option value="2">普通学生</option>
									</select>
								</div> 
									<input type="hidden" id="dd" name="stbehave" >
								
							</td>
							
							
							<td class="kv-label">是否有学籍</td>
							<td class="kv-content">

								<div class="item-rt">
									<select id="isroll">
										<option value="undefined">是否有学籍</option>								
										<option value="1">是</option>
										<option value="2">否</option>
									</select>
								</div> 
							</td>
							<td class="kv-label">上传照片</td>
							<td class="kv-content" colspan="1">
							 <input type="file" name="file"> 
							</td>
						</tr>
					</tbody>

				</table>
			</form>
			<span style="color:red">${msg }</span>

		</div>
</div>
		
</div>
	
</body>
</html>
