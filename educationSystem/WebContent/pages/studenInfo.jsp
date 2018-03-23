<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--个人信息</title>
</head>
<body>

<%@include  file="student.jsp"%>
<div style="margin-top:-570px; ">
 
 <div class="main-panel" style=" margin-top:-70px">
   <nav class="navbar navbar-default" >
            <div class="container-fluid" >
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
                                <h4 class="title">学籍信息</h4>
                            </div>
                            <div class="content">
                             
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>学号</label>
                                                <input type="text" class="form-control" disabled  value="${sroll.srNumber }">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>姓名</label>
                                                <input type="text" class="form-control" disabled value="${sroll.srName }">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label >性别</label>
                                                <c:if test="${sroll.srSex=='1' }">
                                                <input type="text" class="form-control" disabled  value="女">
                                                 </c:if>
                                                 
                                                 <c:if test="${sroll.srSex=='2' }">
                                                <input type="text" class="form-control" disabled  value="男">
                                                 </c:if>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>入学日期</label>
                                                <input type="text" class="form-control" disabled  value="${sroll.srTime}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>出生日期</label>
                                                <input type="text" class="form-control" disabled  value="${sroll.srBirthday}">
                                            </div>
                                        </div>
                                       
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>身份证号</label>
                                                <input type="text" class="form-control" disabled  value="${sroll.srIdCard }">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>是否有学籍</label>
                                                <c:if test="${sroll.srIsRoll == '1'}">
                                                     <input type="text" class="form-control" disabled  value="是">
                                                </c:if>
                                                 <c:if test="${sroll.srIsRoll == '2'}">
                                                     <input type="text" class="form-control" disabled  value="否">
                                                </c:if>
                                            </div>
                                        </div>
                                       
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>籍贯</label>
                                                <input type="text" class="form-control" disabled  value="${sroll.srAddress }">
                                            </div>
                                        </div>
                                    </div>
                             </div>
                          </div>
                        </div>
                    </div>
                </div>
             </div>
             
             <div class="col-md-4" style="float:right; margin-top:-440px; " >
                        <div class="card card-user">
                            <div class="image">
                                <img src="${pageContext.request.contextPath }/student/picture/full-screen-image-3.jpg" alt="...">
                            </div>
                            <div class="content">
                                <div class="author">
                                     <a href="#">
                                    <img class="avatar border-gray" src="/static/${sroll.srImg }">

                                      <h4 class="title">个人照片
                                         
                                      </h4>
                                    </a>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>
             
    </div>
 
    
</div>


</body>
</html>