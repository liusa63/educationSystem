<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--修改密码</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
		
		var ids="pwd1,pwd2";
		var msg="请输入新密码,请输入确认密码";


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
	$(function(){
		//设置获取焦点触发的事件：错误提示消失
		$("#pwd1").focus(function(){   
			$("#pwd1").val("");
			$("#pwd1Error").html("");
			
		});
		$("#pwd2").focus(function(){
			$("#pwd2").val("");
			$("#pwd2Error").html("");
			$("#msgError").html("");
		});
		
		//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
		$("#pwd1").blur(function(){
			var u=$("#pwd1").val();
			if(u==""){
				$("#pwd1Error").html("新密码不能为空");
			}
		});
		$("#pwd2").blur(function(){
			var p=$("#pwd2").val();
			if(p==""){
				$("#pwd2Error").html("确认密码不能为空");
			}
		});
	});


     //表单提交
    function subFun(){
    	   //判断是否为空
		   if(checkNull(ids,msg)){
		   var  p1 = $("#pwd1").val();
    	   var  p2 = $("#pwd2").val();
    	    
    	      if(p1==p2){
		     		$("#subForm").submit();
			   }else{
				  alert("两次密码输入不一致"); 
			   }
    	}
    	
    }

</script>
</head>
<body>

<%@include  file="student.jsp"%>
<div style="margin-top:-570px; ">
 
 <div class="main-panel" style=" margin-top:-70px">
   <nav class="navbar navbar-default">
            <div class="container-fluid">
				<div class="navbar-minimize">
					<button id="minimizeSidebar" class="btn btn-warning btn-fill btn-round btn-icon">
						<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i>
						<i class="fa fa-navicon visible-on-sidebar-mini"></i>
					</button>
				</div>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">教务系统</a>
                </div>
            </div>
        </nav>
        
         <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">修改密码</h4>
                            </div>
                            <form action="${pageContext.request.contextPath }/studentAction_changePwd" method="post" id="subForm">
                            <div class="content">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>请输入密码</label>
                                                <input type="text" name="upwd" class="form-control" id="pwd1">
                                                <span id="pwd1Error" style="color:red"></span>
                                            </div>
                                        </div>
                                     </div>
                                      <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>请输入确认密码</label>
                                                <input type="text" class="form-control" id="pwd2">
                                                <span id="pwd2Error" style="color:red"></span>
                                            </div>
                                        </div>
                                     </div>  
                                     <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                
                                                <input type="button" onclick="subFun();" class="form-control" value="保存">
                                            </div>
                                        </div>
                                     </div>  
                                     
                                  </div>
                                  
                                </form>  
                              </div>
                           </div>
                          </div>
                      </div>
                   </div>
              </div>
                                        
        
        
        
        
        
        
        
 </div>

        


</body>
</html>