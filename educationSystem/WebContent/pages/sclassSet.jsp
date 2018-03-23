<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员---专业->班级</title>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/project/normal_exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/lib/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	
</head>
<body>

 <div style="height:50px;">
  
  </div>
    <div class="container">
    <div class="table-zone">
    <span style="color:red">${noClassMsg }</span> 
         <table class="no-data">
            <thead>
              <tr>
              <td style="width:100px;">班级名</td>
              <td style="width:100px;">班级人数</td>
              <td style="width:100px;">班主任</td>
             
            </tr></thead>
            <tbody>
             
              <c:forEach items="${sclassSet}" var="r">
              <tr>
                <td >${r.clName}</td>
                <td >${r.clCount }</td>
                <td >${r.teName }</td>
               
              </tr>
              
              </c:forEach>
            </tbody> 
            
            
         </table>
         

 </div>
  </div>
</body>
</html>