<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/project/normal_exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/js/lib/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.9.2.min.js"></script>
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/project/normal_exam.css"rel="stylesheet">
<link href="${pageContext.request.contextPath }/js/lib/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
var ids="tnum1,tname1,tphone1,tsalary1,tnum2,tname2,tphone2,tsalary2,tnum3,tname3,tphone3,tsalary3,tnum4,tname4,tphone4,tsalary4,tnum5,tname5,tphone5,tsalary5";
var msg="请输入教师工号,请输入联系方式,请输入工资,请输入教师工号,请输入联系方式,请输入工资,请输入教师工号,请输入联系方式,请输入工资,请输入教师工号,请输入联系方式,请输入工资,请输入教师工号,请输入联系方式,请输入工资";


	//非空验证
	function  checkNull(ids,msg){
		  var idArray=ids.split(",");
		   var msgArray=msg.split(",");
		   for(var i=0;i<idArray.length;i++){
			  var id= $("#"+idArray[i]).val();
			  //如果为空，给出错误提示
			  if(id==""){
				  $("#"+idArray[i]+"Error").html(msgArray[i]);
				  return false;
			  }
		   }
		   return true;
	 }

	/* 遍历所有专业 */
	$(function() {
		$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectAllMajor",
					success : function(mlist) {						
						var str = "<select id='ma1'>";
						str += "<option value='undefined'>" + "请选择专业"+ "<option>"; 
						
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"+ mlist[i].maName + "<option>";														
						}
						str += "</select>";
						 $("#content0").html(str);
						
					},
					error : function() {
						alert("失败");
					}
				})				
			$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectAllMajor",
					success : function(mlist) {						
						var str = "<select id='ma2'>";
						str += "<option value='undefined'>" + "请选择专业"+ "<option>"; 
						
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"+ mlist[i].maName + "<option>";
						}
						str += "</select>";
						
						$("#content1").html(str);
						
					},
					error : function() {
						alert("失败");
					}
				})				
				$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectAllMajor",
					success : function(mlist) {						
						var str = "<select id='ma3'>";
						str += "<option value='undefined'>" + "请选择专业"+ "<option>"; 						
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"+ mlist[i].maName + "<option>";														
						}
						str += "</select>";						
						$("#content2").html(str);						
					},
					error : function() {
						alert("失败");
					}
				})
				$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectAllMajor",
					success : function(mlist) {						
						var str = "<select id='ma4'>";
						str += "<option value='undefined'>" + "请选择专业"+ "<option>"; 
						
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"+ mlist[i].maName + "<option>";												
						}
						str += "</select>";
						
						$("#content3").html(str); 
						
					},
					error : function() {
						alert("失败");
					}
				})
				$.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectAllMajor",
					success : function(mlist) {						
						var str = "<select id='ma5'>";
						str += "<option value='undefined'>" + "请选择专业"+ "<option>"; 					
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"+ mlist[i].maName + "<option>";
							}
						str += "</select>";
						
						$("#content4").html(str); 
					},
					error : function() {
						alert("失败");
					}
				})
				//设置获取焦点触发的事件：错误提示消失
				$("#tnum1").focus(function(){
					$("#tnum1").val("");
					$("#tnum1Error").html("");
				});
				$("#tname1").focus(function(){
					$("#tname1").val("");
					$("#tname1Error").html("");
				});
				$("#tphone1").focus(function(){
					$("#tphone1").val("");
					$("#tphone1Error").html("");
				});
				$("#tsalary1").focus(function(){
					$("#tsalary1").val("");
					$("#tsalary1Error").html("");
				});
				
				$("#tnum2").focus(function(){
					$("#tnum2").val("");
					$("#tnum2Error").html("");
				});
				$("#tname2").focus(function(){
					$("#tname2").val("");
					$("#tname2Error").html("");
				});
				$("#tphone2").focus(function(){
					$("#tphone2").val("");
					$("#tphone2Error").html("");
				});
				$("#tsalary2").focus(function(){
					$("#tsalary2").val("");
					$("#tsalary2Error").html("");
				});
				$("#tnum3").focus(function(){
					$("#tnum3").val("");
					$("#tnum3Error").html("");
				});
				$("#tname3").focus(function(){
					$("#tname3").val("");
					$("#tname3Error").html("");
				});
				$("#tphone3").focus(function(){
					$("#tphone3").val("");
					$("#tphone3Error").html("");
				});
				$("#tsalary3").focus(function(){
					$("#tsalary3").val("");
					$("#tsalary3Error").html("");
				});
				$("#tnum4").focus(function(){
					$("#tnum4").val("");
					$("#tnum4Error").html("");
				});
				$("#tname4").focus(function(){
					$("#tname4").val("");
					$("#tname4Error").html("");
				});
				$("#tphone4").focus(function(){
					$("#tphone4").val("");
					$("#tphone4Error").html("");
				});
				$("#tsalary4").focus(function(){
					$("#tsalary4").val("");
					$("#tsalary4Error").html("");
				});
				$("#tnum5").focus(function(){
					$("#tnum5").val("");
					$("#tnum5Error").html("");
				});
				$("#tname5").focus(function(){
					$("#tname5").val("");
					$("#tname5Error").html("");
				});
				$("#tphone5").focus(function(){
					$("#tphone5").val("");
					$("#tphone5Error").html("");
				});
				$("#tsalary5").focus(function(){
					$("#tsalary5").val("");
					$("#tsalary5Error").html("");
				});
				
				
				//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
				$("#tnum1").blur(function(){
					var u=$("#tnum1").val();
					if(u==""){
						$("#tnum1Error").html("教师工号不能为空");
					}
				});
				$("#tname1").blur(function(){
					var p=$("#tname1").val();
					if(p==""){
						$("#tname1Error").html("教师姓名不能为空");
					}
				});
				$("#tphone1").blur(function(){
					var p=$("#tphone1").val();
					if(p==""){
						$("#tphone1Error").html("联系方式不能为空");
					}
				});
				$("#tsalary1").blur(function(){
					var p=$("#tsalary1").val();
					if(p==""){
						$("#tsalary1Error").html("工资不能为空");
					}
				});
				$("#tnum2").blur(function(){
					var u=$("#tnum2").val();
					if(u==""){
						$("#tnum2Error").html("教师工号不能为空");
					}
				});
				$("#tname2").blur(function(){
					var p=$("#tname2").val();
					if(p==""){
						$("#tname2Error").html("教师姓名不能为空");
					}
				});
				$("#tphone2").blur(function(){
					var p=$("#tphone2").val();
					if(p==""){
						$("#tphone2Error").html("联系方式不能为空");
					}
				});
				$("#tsalary2").blur(function(){
					var p=$("#tsalary2").val();
					if(p==""){
						$("#tsalary2Error").html("工资不能为空");
					}
				});
				$("#tnum3").blur(function(){
					var u=$("#tnum3").val();
					if(u==""){
						$("#tnum3Error").html("教师工号不能为空");
					}
				});
				$("#tname3").blur(function(){
					var p=$("#tname3").val();
					if(p==""){
						$("#tname3Error").html("教师姓名不能为空");
					}
				});
				$("#tphone3").blur(function(){
					var p=$("#tphone3").val();
					if(p==""){
						$("#tphone3Error").html("联系方式不能为空");
					}
				});
				$("#tsalary3").blur(function(){
					var p=$("#tsalary3").val();
					if(p==""){
						$("#tsalary3Error").html("工资不能为空");
					}
				});
				$("#tnum4").blur(function(){
					var u=$("#tnum4").val();
					if(u==""){
						$("#tnum4Error").html("教师工号不能为空");
					}
				});
				$("#tname4").blur(function(){
					var p=$("#tname4").val();
					if(p==""){
						$("#tname4Error").html("教师姓名不能为空");
					}
				});
				$("#tphone4").blur(function(){
					var p=$("#tphone4").val();
					if(p==""){
						$("#tphone4Error").html("联系方式不能为空");
					}
				});
				$("#tsalary4").blur(function(){
					var p=$("#tsalary4").val();
					if(p==""){
						$("#tsalary4Error").html("工资不能为空");
					}
				});
				$("#tnum5").blur(function(){
					var u=$("#tnum5").val();
					if(u==""){
						$("#tnum5Error").html("教师工号不能为空");
					}
				});
				$("#tname5").blur(function(){
					var p=$("#tname5").val();
					if(p==""){
						$("#tname5Error").html("教师姓名不能为空");
					}
				});
				$("#tphone5").blur(function(){
					var p=$("#tphone5").val();
					if(p==""){
						$("#tphone5Error").html("联系方式不能为空");
					}
				});
				$("#tsalary5").blur(function(){
					var p=$("#tsalary5").val();
					if(p==""){
						$("#tsalary5Error").html("工资不能为空");
					}
				});

	})
	function inputTeacher() {
		 if(checkNull(ids,msg)){
		var mid1 = $("#ma1>option:selected").val();
		var mid2 = $("#ma2>option:selected").val();
		var mid3 = $("#ma3>option:selected").val();
		var mid4 = $("#ma4>option:selected").val();
		var mid5 = $("#ma5>option:selected").val();
		if (mid1!= undefined) {
			$("#a2").val(mid1);
			$("#b2").val(mid2);
			$("#c2").val(mid3);
			$("#d2").val(mid4);
			$("#e2").val(mid5);
			var tid1 = $("#tebe1>option:selected").val();
			var tid2 = $("#tebe2>option:selected").val();
			var tid3 = $("#tebe3>option:selected").val();
			var tid4 = $("#tebe4>option:selected").val();
			var tid5 = $("#tebe5>option:selected").val();
			if (tid1 != undefined) {
				$("#a1").val(tid1);
				$("#b1").val(tid2);
				$("#c1").val(tid3);
				$("#d1").val(tid4);
				$("#e1").val(tid5);
				$("#subform").submit();
			} else {
				alert("请选择专业");
			}
		} else {
			alert("请选择专业");
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
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="inputTeacher();">录入</span>
				</div>
				


				<div class="tip">提示：</div>
			</div>
			<div class="table-zone">
				<form
					action="${pageContext.request.contextPath }/adminAction!addTeachers"
					method="post" id="subform">
					<table>
						<thead>
							<tr>
								<td class="name">教师工号</td>
								<td class="name">教师姓名</td>
								<td class="name">联系方式</td>
								<td class="name">身份</td>
								<td class="name">工资</td>
								<td class="name">专业</td>


							</tr>
						</thead>
						<tbody>

							<tr>

								<td><input type="text" name="teachers[0].teNum" id="tnum1">
								<span id="tnum1Error" style="color:red;"></span>
								</td>
								<td><input type="text" name="teachers[0].teName"
									id="tname1" >
								<span id="tname1Error" style="color:red;"></span>
								</td>
                         
								<td><input type="text" name="teachers[0].tePhone"
									id="tphone1">
								<span id="tphone1Error" style="color:red;"></span>
								</td>

								<td><select id="tebe1">
										<option value="1">讲师</option>
										<option value="2">班主任</option>
								</select> <input type="hidden" id="a1" name="teachers[0].teBehave"></td>
								<td><input type="text" value="" name="teachers[0].teSalary"
									id="tsalary1">
								<span id="tsalary1Error" style="color:red;"></span>
									</td>
								<td><span id="content0"></span> <input type="hidden"
									id="a2" name="teachers[0].maId"></td>
							</tr>
							<tr>

								<td><input type="text" name="teachers[1].teNum" id="tnum2">
								<span id="tnum2Error"></span>
								</td>
								<td><input type="text" name="teachers[1].teName"
									id="tname2">
								<span id="tname2Error" style="color:red;"></span>
								</td>

								<td><input type="text" name="teachers[1].tePhone"
									id="tphone2">
									<span id="tphone2Error" style="color:red;"></span>
									</td>

								<td><select id="tebe2">
										<option value="1">讲师</option>
										<option value="2">班主任</option>
								</select> <input type="hidden" id="b1" name="teachers[1].teBehave"></td>

								<td><input type="text" value="" name="teachers[1].teSalary"
									id="tsalary2">
									<span id="tsalary2Error" style="color:red;"></span>
									</td>
								<td><span id="content1"></span> <input type="hidden"
									id="b2" name="teachers[1].maId">
									
									</td>

							</tr>
							<tr>

								<td><input type="text" name="teachers[2].teNum" id="tnum3">
								<span id="tnum3Error" style="color:red;"></span>
								</td>
								<td><input type="text" name="teachers[2].teName"
									id="tname3" style="color:red;">
									<span id="tname3Error"></span>
									</td>

								<td><input type="text" name="teachers[2].tePhone"
									id="tphone3">
									<span id="tphone3Error" style="color:red;"></span>
									</td>

								<td><select id="tebe3">
										<option value="1">讲师</option>
										<option value="2">班主任</option>
								</select> <input type="hidden" id="c1" name="teachers[2].teBehave"></td>

								<td><input type="text" name="teachers[2].teSalary"
									id="tsalary3">
									<span id="tsalary3Error" style="color:red;"></span>
									</td>
								<td><span id="content2"></span> <input type="hidden"
									id="c2" name="teachers[2].maId"></td>

							</tr>
							<tr>

								<td><input type="text" name="teachers[3].teNum" id="tnum4">
								<span id="tnum4Error" style="color:red;"></span>
								</td>
								<td><input type="text" name="teachers[3].teName"
									id="tname4">
									<span id="tname4Error" style="color:red;"></span>
									</td>

								<td><input type="text" name="teachers[3].tePhone"
									id="tphone4">
									<span id="tphone4Error" style="color:red;"></span>
									</td>

								<td><select id="tebe4">
										<option value="1">讲师</option>
										<option value="2">班主任</option>
								</select> <input type="hidden" id="d1" name="teachers[3].teBehave"></td>

								<td><input type="text" name="teachers[3].teSalary"
									id="tsalary4">
									<span id="tsalary4Error" style="color:red;"></span>
									</td>
								<td><span id="content3"></span> <input type="hidden"
									id="d2" name="teachers[3].maId"></td>

							</tr>
							<tr>

								<td><input type="text" name="teachers[4].teNum" id="tnum5">
								<span id="tnum5Error" style="color:red;"></span>
								</td>
								<td><input type="text" name="teachers[4].teName"
									id="tname5" >
									<span id="tname5Error" style="color:red;"></span>
									</td>

								<td><input type="text" name="teachers[4].tePhone"
									id="tphone5">
									<span id="tphone5Error" style="color:red;"></span>
									</td>

								<td><select id="tebe5">
										<option value="1">讲师</option>
										<option value="2">班主任</option>
								</select> 
								<input type="hidden" id="e1" name="teachers[4].teBehave">
								</td>

								<td><input type="text" name="teachers[4].teSalary"
									id="tsalary5">
									<span id="tsalary5Error" style="color:red;"></span>
									</td>
								<td><span id="content4"></span> 
								<input type="hidden" id="e2" name="teachers[4].maId"></td>
							</tr>
							<tr id="addte"></tr>
							
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



</body>
</html>