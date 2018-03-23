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
	var ids = "enStart,enEnd";
	var msg = "请输入开始时间,请输入结束时间";

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
		$("#enStart").focus(function() {
			$("#enStart").val("");
			$("#enStartError").html("");
		});
		$("#enEnd").focus(function() {
			$("#enEnd").val("");
			$("#enEndError").html("");
		});
		


		//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
		$("#enStart").blur(function() {
			var u = $("#enStart").val();
			if (u == "") {
				$("#enStartError").html("开始时间不能为空");
			}
		});
		$("#enEnd").blur(function() {
			var p = $("#enEnd").val();
			if (p == "") {
				$("#enEndError").html("结束时间不能为空");
			}
		});
		
		
		
	});

	function selectBasicCourse(){
		var mid = $("#ma>option:selected").val();
		$(function() {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/adminAction!selectBasicCourse?costatus=1&&"
						+ "maid="+mid,
				async:false,
				success : function(clist) {
					
					var str = "<select id='co'>";
					str += "<option value='undefined'>"+ "请选择课程" + "<option>";
					for ( var i = 0; i < clist.length; i++) {
						str += "<option value="+clist[i].coId+">"+ clist[i].coName + "<option>";
					}
					str += "</select>";
					$("#content1").html(str);
				},
				error : function() {
					alert("失败");
				}

			})
			
	/* 遍历专业下的班级表 */
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/adminAction!ajaxSelectSclassByMajor?maid="+mid,
		success:function(sclassList){	  
		 	var str="<select id='sc'>";
			str += "<option value='undefined'>"+ "请选择班级" + "<option>";
			for(var i=0;i<sclassList.length;i++){
				str+="<option value="+sclassList[i].clId+">"+sclassList[i].clName+"<option>";
			}
			str+="</select>";
			$("#content2").html(str); 
		},
		error:function(){
			alert("失败");
		}
		
		
	})
	/* 遍历专业下的教师 */	
	
		$(function() {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/adminAction!selectTeacherByMajor?tebehave=2&&"
						+ "maid="+mid,
				async:false,
				success : function(tlist) {
					
					var str = "<select id='te'>";
					str += "<option value='undefined'>"+ "请选择教师" + "<option>";
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
		})
	}
	
	
	//获取选中单选框
	function testradio() {
		if (checkNull(ids, msg)) {
				var maid = $("#ma>option:selected").val(); //获取选中的专业值
				if (maid!= "undefined") {					
					$("#aa").val(maid);
					var coid = $("#co>option:selected").val(); //获取选中的课程值
					if (coid!= "undefined") {						
						$("#bb").val(coid);
						
						var tid = $("#te>option:selected").val(); //获取选中的老师的值
						if (tid!= undefined) {						
							$("#dd").val(tid);
							
							var rid = $("#ro>option:selected").val(); //获取选中的教室的值的值
							if (rid!= "undefined") {						
								$("#ee").val(rid);
								
								var scid = $("#sc>option:selected").val(); //获取选中的班级的值
								if (scid!= "undefined") {						
									$("#cc").val(scid);
									
									var enday = $("#enday>option:selected").val(); //获取选中的星期的值
									if (enday!= "undefined") {						
										$("#ff").val(enday);
										
										
										$("#formadd").submit();
									} else {
										alert("请选择星期");
									}
									
								} else {
									alert("请选择班级");
								}
								
							} else {
								alert("请选择教室");
							}
							
						} else {
							alert("请选择教师");
						}
						
					} else {
						alert("请选择课程");
					}
										
				} else {
					alert("请选择专业");
				}

			}

		}

	
	/* 遍历所有专业 */
	$(
			function() {

				$.ajax({
					type : "post",
					url : "adminAction!selectAllMajor",
					success : function(mlist) {
						
						var str = "<select id='ma' onchange='selectBasicCourse();'>";
						str += "<option value='undefined'>"+"请选择专业"+"<option>";
						for ( var i = 0; i < mlist.length; i++) {
							str += "<option value="+mlist[i].maId+">"+ mlist[i].maName + "<option>";
						}
						str += "</select>";
						$("#content").html(str);
					},
					error : function() {
						alert("失败");
					}

				})
				
				$
				.ajax({
					type : "post",
					url : "${pageContext.request.contextPath }/adminAction!selectAjaxRoom",
					success : function(rlist) {
						
						var str = "<select id='ro'>";
						str += "<option value='undefined'>"+ "请选择教室" + "<option>";
						for ( var i = 0; i < rlist.length; i++) {
							str += "<option value="+rlist[i].roId+">"
									+ rlist[i].roName + "<option>";
						}
						str += "</select>";
						$("#content4").html(str);
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
					class="crumbs-label">课程信息录入表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">

					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="testradio()">保存</span>
				</div>
			</div>
			<br> <br>

			<div class="button-group">
				<form id="formadd" action="${pageContext.request.contextPath }/adminAction!addBasicCourse" method="post">
								

					<table class="kv-table">
						<tbody>
							<tr>
							<td class="kv-label">选择专业</td>
								<td class="kv-content"><span id="content"></span>
									<div class="item-rt">
										<input type="hidden" name="encourse.maId" id="aa" />
									</div>
								</td>
								<td class="kv-label">课程名称</td>
								<td class="kv-content">
								<span id="content1"></span>
									<div class="item-rt">
										<input type="hidden" name="encourse.coId" id="bb" />
									</div>
								</td>

								<td class="kv-label">班级</td>
								<td class="kv-content">
								<span id="content2"></span>
									<div class="item-rt">
										<input type="hidden" name="encourse.clId" id="cc" />
									</div>
								</td>
								<td class="kv-label">教师</td>
								<td class="kv-content">
								<span id="content3"></span>
									<div class="item-rt">
										<input type="hidden" name="encourse.teId" id="dd" />
									</div>
								</td>
							</tr>
							<tr>
							
								<td class="kv-label">教室</td>
								<td class="kv-content">
								<span id="content4"></span>
									<div class="item-rt">
										<input type="hidden" name="encourse.roId" id="ee" />
									</div>
								</td>
								<td class="kv-label">星期</td>
								<td class="kv-content">
								<select id="enday">
								<option value="undefined">请选择星期</option>
								<option value="星期一">星期一</option>
								<option value="星期二">星期二</option>
								<option value="星期三">星期三</option>
								<option value="星期四">星期四</option>
								<option value="星期五">星期五</option>
								<option value="星期六">星期六</option>
								<option value="星期日">星期日</option>
								</select>
									<input type="hidden" name="course.enDay" id="ff" />
								</td>
									<td class="kv-label">开始时间</td>
								<td class="kv-content" colspan="1">
										<input type="text" name="encourse.enStart" id="enStart">
										<span id="enStartError"></span>
									
								</td>
								<td class="kv-label">结束时间</td>
								<td class="kv-content" colspan="1">
									<input type="text" name="encourse.enEnd" id="enEnd">
									<span id="enEndError"></span>
								</td>
								
							</tr>
							<tr>
							
							
							</tr>
						</tbody>
					</table>
				</form>
				<span style="color:red">${msg }</span>
			</div>

			<div id="inner-ft"></div>
		</div>
	</div>
</body>
</html>