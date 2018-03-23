<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <title>Insert title here</title>
 <link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/pages/statistics_query/leader.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">

var ids="qcontext,qa,qb,qc,qd";
var msg="请输入问题,请输入选项内容,请输入选项内容,请输入选项内容";


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
	
	
	 //页面加载完成触发的事件
		$(document).ready(function(){
			//设置获取焦点触发的事件：错误提示消失
			$("#qcontext").focus(function(){
				$("#qcontext").val("");
				$("#qcontextError").html("");
			});
			$("#qa").focus(function(){
				$("#qa").val("");
				$("#qaError").html("");
			});
			$("#qb").focus(function(){
				$("#qb").val("");
				$("#qbError").html("");
			});
			$("#qc").focus(function(){
				$("#qc").val("");
				$("#qcError").html("");
			});
			$("#qd").focus(function(){
				$("#qd").val("");
				$("#qdError").html("");
			});
			
			
			//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
			$("#qcontext").blur(function(){
				var u=$("#qcontext").val();
				if(u==""){
					$("#qcontextError").html("问题不能为空");
				}
			});
			$("#qa").blur(function(){
				var p=$("#qa").val();
				if(p==""){
					$("#qaError").html("选项不能为空");
				}
			});
			$("#qb").blur(function(){
				var p=$("#qb").val();
				if(p==""){
					$("#qbError").html("选项不能为空");
				}
			});
			$("#qc").blur(function(){
				var p=$("#qc").val();
				if(p==""){
					$("#qcError").html("选项不能为空");
				}
			});
			
			$("#qd").blur(function(){
				var p=$("#coStart").val();
				if(p==""){
					$("#qdError").html("选项不能为空");
				}
			});
			
			
		});


function testradio(){
	
	 if(checkNull(ids,msg)){
		
			
		
				 $("#formadd").submit();    
			}
		  
	   
	
}




</script>
</head>
<body>

	
 <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">教学评估表</a>
			</div>
        </div>
<div id="inner-bd">
			<div class="kv-group-outer"></div>
			<div>
				<div class="button current">
					<i class="iconfont">&#xe76a;</i> <span class="button-label"
						onclick="testradio();">保存</span>
				</div>
			</div>
      
          <div class="kv-group-outer">
              
          </div>
          <div class="table-zone">
         <form id="formadd" action="${pageContext.request.contextPath }/adminAction!addQuestion" method="post">
             <table>
                <thead>
                  <tr>
                    <td class="comment">问题</td>
                    <td class="dept">选项A</td>
                    <td class="dept">选项B</td>
                    <td class="dept">选项C</td>
                    <td class="dept">选项D</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                    <input type="text" name="question.qcontent" id="qcontext"/> </td>
				<span id="qcontextError"></span>
                   
                    <td><input type="text" name="question.qa" id="qa" /> </td>
			
                    
                   <span id="qaError"></span>
                    <td><input type="text" name="question.qb" id="qb" /></td>
				
				
				 <span id="qbError"></span>
                    <td><input type="text" name="question.qc" id="qc"/></td>
				
				  <span id="qcError"></span>
                    <td>
                    <input type="text" name="question.qd" id="qd"/> </td>
			
				<span id="qdError"></span>
                   
                  </tr>
                 
                </tbody> 
             </table>
             ${msg }
             </form>
             <div class="note">
              <span>注：</span>
             
             </div>
          </div>
        </div>

        

        <div id="inner-ft">
            
        </div>
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