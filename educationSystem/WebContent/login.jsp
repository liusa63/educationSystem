<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台登录</title>
  
    <link href="${pageContext.request.contextPath }/student/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/student/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath }/student/css/demo.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/student/css/font-awesome.min.css" rel="stylesheet">
    <link href='${pageContext.request.contextPath }/student/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath }/student/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

	var ids="uNumber,uPwd";
	var msg="请输入学（工）号,请输入密码";


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
		//登录
		function loginfun(){
			   //判断用户名和密码是否为空
			   if(checkNull(ids,msg)){
				   
				   $("#loginForm").submit();
			   }
		}
		
		 //页面加载完成触发的事件
			$(function(){
				//设置获取焦点触发的事件：错误提示消失
				$("#uNumber").focus(function(){   
					$("#uNumber").val("");
					$("#uNumberError").html("");
					
				});
				$("#uPwd").focus(function(){
					$("#uPwd").val("");
					$("#uPwdError").html("");
					$("#msgError").html("");
				});
				
				//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
				$("#uNumber").blur(function(){
					var u=$("#uNumber").val();
					if(u==""){
						$("#uNumberError").html("学（工）号不能为空");
					}
				});
				$("#uPwd").blur(function(){
					var p=$("#uPwd").val();
					if(p==""){
						$("#uPwdError").html("密码不能为空");
					}
				});
			});


</script>

</head>
<body>

<nav class="navbar navbar-transparent navbar-absolute">
    <div class="container">    
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">欢迎登录教务系统</a>
        </div>
        <div class="collapse navbar-collapse">       
            
            <ul class="nav navbar-nav navbar-right">
                <li>
                   <a href="adminLogin.jsp">
                          admin登录                          
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="wrapper wrapper-full-page">
    <div class="full-page login-page" data-color="orange" data-image="${pageContext.request.contextPath }/student/${pageContext.request.contextPath }/student/assets/img/full-screen-image-1.jpg">   
        
    <!--   you can change the color of the filter page using: data-color="blue | azure | green | orange | red | purple" -->
        <div class="content">
            <div class="container">
                <div class="row">                   
                    <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
                       <form action="loginAction!userLogin"  method="post"  id="loginForm">
                            
                            
                            
                        <!--   if you want to have the card without animation please remove the ".card-hidden" class   -->
                            <div class="card card-hidden">
                                <div class="header text-center">Login </div>
                                <center>
                                  <span id="msgError"  style="color:red">${msg}</span>
                                  </center>
                                <div class="content">
                                    <div class="form-group">
                                        <label>学（工）号</label><span id="uNumberError" style="color:red"></span>
                                        <input type="text" name="unumber" id="uNumber" placeholder="Number" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label> <span id="uPwdError" style="color:red"></span>
                                        <input type="password" name="upwd" id="uPwd" placeholder="Password" class="form-control">
                                  
                                    </div>                                    
                                 
                                </div>
                                <div class="footer text-center">
                                    <button type="button" value="登录" onclick="loginfun()" class="btn btn-fill btn-warning btn-wd">登录</button>
                                </div>
                            </div>
                               
                               
                               
                                
                        </form>
                                
                    </div>                    
                </div>
            </div>
        </div>
    	
    	

    </div>                             
       
</div>



<div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown"> 
        <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title">Background Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <div class="switch"
                        data-on-label="ON"
                        data-off-label="OFF">
                        <input type="checkbox" checked/>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Filters</p>
                    <div class="pull-right">
                        <span class="badge filter" data-color="black"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange active" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple" data-color="purple"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Images</li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${pageContext.request.contextPath }/student/picture/full-screen-image-1.jpg">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${pageContext.request.contextPath }/student/picture/full-screen-image-2.jpg">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${pageContext.request.contextPath }/student/picture/full-screen-image-3.jpg">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${pageContext.request.contextPath }/student/picture/full-screen-image-4.jpg">
                </a>
            </li>
        </ul>
    </div>
</div>



</body>
    
    <!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
    <script src="${pageContext.request.contextPath }/student/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/student/js/jquery-ui.min.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath }/student/js/bootstrap.min.js" type="text/javascript"></script>
	
	
	<!--  Forms Validations Plugin -->
	<script src="${pageContext.request.contextPath }/student/js/jquery.validate.min.js"></script>
	
	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script src="${pageContext.request.contextPath }/student/js/moment.min.js"></script>
	
    <!--  Date Time Picker Plugin is included in this js file -->
    <script src="${pageContext.request.contextPath }/student/js/bootstrap-datetimepicker.js"></script>
    
    <!--  Select Picker Plugin -->
    <script src="${pageContext.request.contextPath }/student/js/bootstrap-selectpicker.js"></script>
    
	<!--  Checkbox, Radio, Switch and Tags Input Plugins -->
	<script src="${pageContext.request.contextPath }/student/js/bootstrap-checkbox-radio-switch-tags.js"></script>
	
	<!--  Charts Plugin -->
	<script src="${pageContext.request.contextPath }/student/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="${pageContext.request.contextPath }/student/js/bootstrap-notify.js"></script>
    
    <!-- Sweet Alert 2 plugin -->
	<script src="${pageContext.request.contextPath }/student/js/sweetalert2.js"></script>
        
    <!-- Vector Map plugin -->
	<script src="${pageContext.request.contextPath }/student/js/jquery-jvectormap.js"></script>
	
    <!--  Google Maps Plugin    -->
    <script src="${pageContext.request.contextPath }/student/js/aa743e8f448a4792bad10d201a7080f6.js"></script>
	
	<!-- Wizard Plugin    -->
    <script src="${pageContext.request.contextPath }/student/js/jquery.bootstrap.wizard.min.js"></script>

    <!--  Datatable Plugin    -->
    <script src="${pageContext.request.contextPath }/student/js/bootstrap-table.js"></script>
    
    <!--  Full Calendar Plugin    -->
    <script src="${pageContext.request.contextPath }/student/js/fullcalendar.min.js"></script>
    
    <!-- Light Bootstrap Dashboard Core javascript and methods -->
	<script src="${pageContext.request.contextPath }/student/js/light-bootstrap-dashboard.js"></script>
	
	<!--   Sharrre Library    -->
    <script src="${pageContext.request.contextPath }/student/js/jquery.sharrre.js"></script>
	
	<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
	<script src="${pageContext.request.contextPath }/student/js/demo.js"></script>
	    
    <script type="text/javascript">
        $().ready(function(){
            lbd.checkFullPageBackgroundImage();
            
            setTimeout(function(){
                // after 1000 ms we add the class animated to the login/register card
                $('.card').removeClass('card-hidden');
            }, 700)
        });
    </script>
    
    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    
      ga('create', 'UA-46172202-1', 'auto');
      ga('send', 'pageview');
    
    </script>


</html>