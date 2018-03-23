<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员--批量录入专业</title>
<link href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap-datepicker.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css"	rel="stylesheet">
<link	href="${pageContext.request.contextPath }/css/project/userinfo.css" rel="stylesheet">
<script type="text/javascript"	src="${pageContext.request.contextPath }/js/jquery.js"></script>
 <script type="text/javascript">
 //页面加载完成触发的事件
	$(function(){
		//设置获取焦点触发的事件：错误提示消失
		$("#lr1").focus(function(){   
			$("#lr1").val("");
			$("#lr1Error").html("");
			
		});
		$("#lr2").focus(function(){
			$("#lr2").val("");
			$("#lr2Error").html("");
		});
		$("#lr3").focus(function(){
			$("#lr3").val("");
			$("#lr3Error").html("");
		});
		
		//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
		$("#lr1").blur(function(){
			var u=$("#lr1").val();
			if(u==""){
				$("#lr1Error").html("专业名称不能为空");
			}
		});
		$("#lr2").blur(function(){
			var u=$("#lr2").val();
			if(u==""){
				$("#lr2Error").html("专业名称不能为空");
			}
		});
		$("#lr3").blur(function(){
			var u=$("#lr3").val();
			if(u==""){
				$("#lr3Error").html("专业名称不能为空");
			}
		});
	});
 
 
   
     var ids="lr1,lr2,lr3";
	 var msg="不能为空,不能为空,不能为空";
   
    
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
   
		
	var names="lr1,lr2,lr3";
    function saveFun(){

    	if(checkNull(ids,msg)){
    		 $("#saveMoreForm").submit();
    		/* var nameArray=names.split(",");
 		    for(var i=0;i<nameArray.length;i++){
 			  var maname= $("#"+nameArray[i]).val();
 	
 				  $.ajax({
 					  type:"post",
 				      url:"${pageContext.request.contextPath }/adminLittleAction!addMoreMajor?maname="+maname,
 				      sync:false,
 				      success:function(msg){
 					    	if(msg=="ok"){
 					    		
 					    	}
 					  },
 					   error:function(){
 						
 					   }
 				  },1000)
 		   }
 
 		window.location.href="${pageContext.request.contextPath }/adminLittleAction!findAllMajor";
    		 */
    		
     }
 	
    	
   }
    
    function addTrFun(){
    	
    	$("#add").before("<tr><td class='kv-content' colspan='2'><input type='text' name='maNames' id='lr3'/><span id='lr3Error' style='color:red'></span></td></tr>");
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
               

			</div>
			<br> <br>

			<div class="button-group">
			
                 <form action="${pageContext.request.contextPath }/adminLittleAction!addMoreMajor" id="saveMoreForm" method="post">
					<table class="kv-table">
						<tbody>
						<tr>
								<td class="kv-label">请输入专业名称</td>
						</tr>
                        <tr>
                            <td class="kv-content" colspan="2">
								<input type="text" name="maNames" id="lr1"/>
								<span id="lr1Error"  style="color:red"></span>
							</td>
                        </tr>
                         <tr>
                            <td class="kv-content" colspan="2">
								<input type="text" name="maNames" id="lr2"/>
								<span id="lr2Error"  style="color:red"></span>
							</td>
                        </tr>
                         <tr>
                            <td class="kv-content" colspan="2">
								<input type="text" name="maNames" id="lr3"/>
								<span id="lr3Error"  style="color:red"></span>
							</td>
                        </tr>
                         <tr id="add"></tr>
						</tbody>
					</table>
				
			  </form>
			  
			    <div>
			    
				<div class="button current">
					<i class="iconfont">&#xe620;</i> 
					<span class="button-label" onclick="addTrFun()">添加一行</span>
				</div>
               
                
                 
			</div>

			</div>

			<div id="inner-ft"></div>
		</div>
	</div>
</body>
</html>