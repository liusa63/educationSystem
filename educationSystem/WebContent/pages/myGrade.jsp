<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--我的方案成绩</title>
    <link href="${pageContext.request.contextPath }/student/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/student/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath }/student/css/demo.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/student/css/font-awesome.min.css" rel="stylesheet">
    <link href='${pageContext.request.contextPath }/student/css/685fd913f1e14aebad0cc9d3713ee469.css' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath }/student/css/pe-icon-7-stroke.css" rel="stylesheet" />

    <script src="${pageContext.request.contextPath }/student/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/student/js/jquery-ui.min.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath }/student/js/bootstrap.min.js" type="text/javascript"></script>
	
<script language="javascript" src="${pageContext.request.contextPath }/print/jquery-1.4.4.min.js"></script>
<script language="javascript" src="${pageContext.request.contextPath }/print/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">

		function printFun(){

			$("#dayin").jqprint();
			
		}
		

	

</script>


</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-color="orange" data-image="${pageContext.request.contextPath }/student/assets/img/full-screen-image-3.jpg">
       
        <div class="logo">
            <a href="#" class="logo-text">
                                       操作栏
            </a>
        </div>
		

    	<div class="sidebar-wrapper">

            <div class="user">
                <div class="photo">
                   <img src="${pageContext.request.contextPath }/student/picture/0.jpg" style="width:78px;height:73px"/>
               
                </div>
                <div class="info">
                    <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                                                           学院教务
                    </a>
                    
                </div>
            </div>

            <ul class="nav">
                <li>
                    <a href="${pageContext.request.contextPath }/studentAction_findStudent">
                        <i class="pe-7s-graph"></i>
                        <p>首页</p>
                    </a>
                </li>
                <li class="active">
                    <a data-toggle="collapse" href="#componentsExamples">
                        <i class="pe-7s-plugin"></i>
                        <p>个人信息
                           <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="componentsExamples">
                        <ul class="nav">
                            <li><a href="${pageContext.request.contextPath }/studentAction_findInfo">基本信息</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/changeStudentPwd.jsp">修改密码</a></li>
                        </ul>
                    </div>
                </li>
                <li class="active">
                    <a data-toggle="collapse" href="#formsExamples">
                        <i class="pe-7s-note2"></i>
                        <p>必修
                           <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="formsExamples">
                        <ul class="nav">
                            <li><a href="${pageContext.request.contextPath }/studentAction_findNowCourse">本学期课表</a></li>
                            <li><a href="${pageContext.request.contextPath }/studentAction_AllCourse">方案课表</a></li>
                            <li><a href="${pageContext.request.contextPath }/studentAction_finishedCourse">方案完成情况</a></li>
                            <li><a href="${pageContext.request.contextPath }/studentAction_undoneCourse">待完成方案</a></li>
                        </ul>
                    </div>
                </li>

                <li class="active">
                    <a data-toggle="collapse" href="#tablesExamples">
                        <i class="pe-7s-news-paper"></i>
                        <p>选修
                           <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="tablesExamples">
                        <ul class="nav">
                            <li><a href="${pageContext.request.contextPath }/studentAction_findMyExcourse">已选课程</a></li>
                            <li><a href="${pageContext.request.contextPath }/studentAction_elective">我要选课</a></li>
                        </ul>
                    </div>
                </li>

                <li class="active">
                    <a data-toggle="collapse" href="#mapsExamples">
                        <i class="pe-7s-map-marker"></i>
                        <p>成绩
                           <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="mapsExamples">
                        <ul class="nav">
                            <li><a href="${pageContext.request.contextPath }/studentAction_findMyGrade?type=1">方案成绩</a></li>
                           <%--  <li><a href="${pageContext.request.contextPath }/studentAction_findMyGrade?type=2">通过</a></li> --%>
                            <li><a href="${pageContext.request.contextPath }/studentAction_findMyGrade?type=3">未通过</a></li>
                        </ul>
                    </div>
                </li>



               
            </ul>
    	</div>
    </div>
</div>



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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="content">
								<div class="toolbar">
	                                <!--        Here you can write extra buttons/actions for the toolbar              -->
	                            </div>
                                <div class="fresh-datatables">
                                <span style="color:red">
                                  ${grademsg}
                                  </span>
                                   
                                   <input type="button" value="打印"    id="print" onclick="printFun();" style="border-style : none; color:#f08a49;border-radius:20px;height:35px; width:50px; margin-left:700px" />
                					<div id="dayin">
                					     学号：      ${user.unumber}
                					<table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                						
                						<thead>
                							<tr>
                								<th>课程名</th>
                							
                								<th>成绩</th>
                							</tr>
                						</thead>
                						<tfoot>
                							<tr>
                								<th>课程名</th>
                								
                								<th>成绩</th>
                							</tr>
                						</tfoot>
                						<tbody>
                						<c:forEach items="${gradeList}" var="e">
                							<tr>
                								<td>${e.coName }</td>
                								
                								<c:if test="${e.score>59.9 }">
                								<td><span style="color:green">${e.score}</span></td>
                								</c:if>
                								
                								<c:if test="${e.score<60}">
                								<td><span style="color:red">${e.score}</span></td>
                								</c:if>
                							</tr>
                						   </c:forEach>
                						</tbody>
                					</table>
                					</div>
                					
                					
                					
                		       </div>
                			</div>
                		</div>
                	</div>
                </div>
               </div>
            </div>
          </div>
       </div>
</body>
</html>