<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--我的选修</title>
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="content">
								<div class="toolbar">
	                                <!--        Here you can write extra buttons/actions for the toolbar              -->
	                            </div>
                                <div class="fresh-datatables">
                              <span style="color:red">
                                  ${msgnull}
                                  </span>
                					<table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                						<thead>
                							<tr>
                								<th>课程名</th>
                								<th>学分</th>
                								<th>属性</th>
                								<th>星期</th>
                								<th>时间</th>
                								<th>周次</th>
                								<th>老师</th>
                								<th>教室</th>
                								<th>成绩</th>
                							</tr>
                						</thead>
                						<tfoot>
                							<tr>
                								<th>课程名</th>
                								<th>学分</th>
                								<th>属性</th>
                								<th>星期</th>
                								<th>时间</th>
                								<th>周次</th>
                								<th>老师</th>
                								<th>教室</th>
                								<th>成绩</th>
                							</tr>
                						</tfoot>
                						<tbody>
                						<c:forEach items="${excourseList}" var="e">
                							<tr>
                								<td>${e.exName }</td>
                								<td>${e.exScore}</td>
                								<td>
                								    选修
                								</td>
                								<td>${e.exDay}</td>
                								<td>${e.exStart}~${e.exEnd}</td>
                								<td>${e.exWeek}</td>
                								<td>${e.teName}</td>
                								<td>${e.roName}</td>
                								<c:if test="${e.grade >0}">
                								   <td>${e.grade}</td>
                								</c:if>
                								<c:if test="${e.grade ==0}">
                								   <td></td>
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
</body>
</html>