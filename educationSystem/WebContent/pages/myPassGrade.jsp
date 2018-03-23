<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--通过成绩</title>
</head>
<body>

<%@include  file="student.jsp"%>
<div style="margin-top:-570px; ">
 
 <div class="main-panel">
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
                							
                							   <c:if test="${e.score>59.9 }">
                							   <tr>
                								<td>${e.coName }</td>
                								<td><span style="color:green">${e.score}</span></td>
                							  </tr>
                							</c:if>
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
</body>
</html>