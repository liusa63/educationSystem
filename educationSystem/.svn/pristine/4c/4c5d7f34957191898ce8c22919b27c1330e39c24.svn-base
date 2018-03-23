<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--本学期课表</title>
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
                                 <input type="button" value="打印"    id="print" onclick="printFun();" style="border-style : none; color:#f08a49;border-radius:20px;height:35px; width:50px; margin-left:900px" />
                					
                                <div id="dayin">
                                <table   class="table table-striped table-no-bordered table-hover" border=1; cellspacing="1" width="100%" style="text-align:center">
                						<thead style="text-align:center">
                							<tr style="text-align:center">
                								<th>星期一</th>
                								<th>星期二</th>
                								<th>星期三</th>
                								<th>星期四</th>
                								<th>星期五</th>
                								<th>星期六</th>
                								<th>星期日</th>
                							</tr>
                						</thead>
                						<tfoot >
                							<tr style="text-align:center">
                								<th>星期一</th>
                								<th>星期二</th>
                								<th>星期三</th>
                								<th>星期四</th>
                								<th>星期五</th>
                								<th>星期六</th>
                								<th>星期日</th>
                							</tr>
                						</tfoot>
                						<tbody>
                						
      
         <tr>
          <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期一'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期二'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期三'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期四'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期五'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期六'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期日'}">
	    			<c:if test="${e.enStart eq '8:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
        </tr>
        
         <tr height=100px>
          <td width=150px;>
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期一'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px;>
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期二'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期三'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期四'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期五'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期六'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期日'}">
	    			<c:if test="${e.enStart eq '10:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
        </tr>
        
         <tr height=100px>
          <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期一'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期二'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期三'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期四'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期五'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期六'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期日'}">
	    			<c:if test="${e.enStart eq '15:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
        </tr>
        
         <tr height=100px>
          <td width=150px;>
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期一'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期二'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期三'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期四'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
           <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期五'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期六'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
          <td width=150px;height=50px; >
	          <c:forEach items="${nowList}" var="e">
	    			<c:if test="${e.enDay eq '星期日'}">
	    			<c:if test="${e.enStart eq '17:00'}">
	    				<span style="color:#f08a49">${e.coName }</span><br>
	    				${e.teName}<br>
	    				<span style="color:#f08a49">${e.roName}</span><br>
	    				${e.coScore}分<br>
	    				${e.coWeek}周<br>
	    			</c:if>
	    		</c:if>
	    	  </c:forEach>
          </td>
        </tr>
       </tbody>
                					</table>
                					
                				</div>
                					</div>
        				        </div>
                            </div><!-- end content-->
                        </div><!--  end card  -->
                    </div> <!-- end col-md-12 -->
                </div> <!-- end row -->
              </div>
        </div>   			
                						
                						<%-- <tr><td colspan=8; style="color:red; text-align:center">周一</td></tr>
                						<c:forEach items="${nowList}" var="e">
                						<c:if test="${e.enDay eq '星期一'}">
                						
                							<tr>
                								<td>${e.coName }</td>
                								<td>${e.coScore}</td>
                								
                								<td>${e.teName}</td>
                								<td>${e.roName}</td>
                								<td>${e.enDay} ${e.enStart}~${e.enEnd}</td>
                								
                								<td>
                								<c:if test="${e.coStatus==1}">
                								    必修
                								</c:if>
                								<c:if test="${e.coStatus==2}">
                								    选修
                								</c:if>
                								</td>
                								<td>${e.coWeek}</td>
                								
                								<td>${e.coStartTime}~${e.coEndTime}</td>
                								
                							</tr>
                							</c:if>
                						   </c:forEach>
                						
                						   
                						   
                						  <tr><td colspan=8; style="color:red; text-align:center">周二</td></tr>
                						   <c:forEach items="${nowList}" var="e">
                					     	<c:if test="${e.enDay eq '星期二'}">
                							<tr>
                								<td>${e.coName }</td>
                								<td>${e.coScore}</td>
                								
                								<td>${e.teName}</td>
                								<td>${e.roName}</td>
                								<td>${e.enDay} ${e.enStart}~${e.enEnd}</td>
                								
                								<td>
                								<c:if test="${e.coStatus==1}">
                								    必修
                								</c:if>
                								<c:if test="${e.coStatus==2}">
                								    选修
                								</c:if>
                								</td>
                								<td>${e.coWeek}</td>
                								
                								<td>${e.coStartTime}~${e.coEndTime}</td>
                								
                							</tr>
                							</c:if>
                						   </c:forEach>
                						   
                						   
                						   
                						     <tr><td colspan=8; style="color:red; text-align:center">周三</td></tr>
                						   <c:forEach items="${nowList}" var="e">
                					     	<c:if test="${e.enDay eq '星期三'}">
                							<tr>
                								<td>${e.coName }</td>
                								<td>${e.coScore}</td>
                								
                								<td>${e.teName}</td>
                								<td>${e.roName}</td>
                								<td>${e.enDay} ${e.enStart}~${e.enEnd}</td>
                								
                								<td>
                								<c:if test="${e.coStatus==1}">
                								    必修
                								</c:if>
                								<c:if test="${e.coStatus==2}">
                								    选修
                								</c:if>
                								</td>
                								<td>${e.coWeek}</td>
                								
                								<td>${e.coStartTime}~${e.coEndTime}</td>
                								
                							</tr>
                							</c:if>
                						   </c:forEach>
                						   
                						   <tr><td colspan=8; style="color:red; text-align:center">周四</td></tr>
                						   <c:forEach items="${nowList}" var="e">
                					     	<c:if test="${e.enDay eq '星期四'}">
                							<tr>
                								<td>${e.coName }</td>
                								<td>${e.coScore}</td>
                								
                								<td>${e.teName}</td>
                								<td>${e.roName}</td>
                								<td>${e.enDay} ${e.enStart}~${e.enEnd}</td>
                								
                								<td>
                								<c:if test="${e.coStatus==1}">
                								    必修
                								</c:if>
                								<c:if test="${e.coStatus==2}">
                								    选修
                								</c:if>
                								</td>
                								<td>${e.coWeek}</td>
                								
                								<td>${e.coStartTime}~${e.coEndTime}</td>
                								
                							</tr>
                							</c:if>
                						   </c:forEach>
                						   
                						   <tr><td colspan=8; style="color:red; text-align:center">周五</td></tr>
                						   <c:forEach items="${nowList}" var="e">
                					     	<c:if test="${e.enDay eq '星期五'}">
                							<tr>
                								<td>${e.coName }</td>
                								<td>${e.coScore}</td>
                								
                								<td>${e.teName}</td>
                								<td>${e.roName}</td>
                								<td>${e.enDay} ${e.enStart}~${e.enEnd}</td>
                								
                								<td>
                								<c:if test="${e.coStatus==1}">
                								    必修
                								</c:if>
                								<c:if test="${e.coStatus==2}">
                								    选修
                								</c:if>
                								</td>
                								<td>${e.coWeek}</td>
                								
                								<td>${e.coStartTime}~${e.coEndTime}</td>
                								
                							</tr>
                							</c:if>
                						   </c:forEach> --%>
                						</tbody>
                					</table>
                					
                				
                					</div>
        				        </div>
                            </div><!-- end content-->
                        </div><!--  end card  -->
                    </div> <!-- end col-md-12 -->
                </div> <!-- end row -->
              </div>
        </div>   						
                						
        
        
        
        
      </div>
   </div> 

</body>
</html>