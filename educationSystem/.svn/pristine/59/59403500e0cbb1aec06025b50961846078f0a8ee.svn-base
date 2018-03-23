<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员--修改专业</title>
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/project/normal_exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/lib/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript">
	  function  savefun(){
		  
		  $("#saveForm").submit();
		  
	  }
	
	</script>

</head>
<body>
<div style="height:50px;">
  
  </div>

 <div class="container">
    <div class="table-zone">
      <form action="${pageContext.request.contextPath}/adminLittleAction!updateMajor" id="saveForm">
         <table class="no-data">
            <thead>
              <tr>
              <td style="width:100px;">专业ID</td>
              <td style="width:160px;">专业名</td>
            </tr></thead>
            <tbody>
            
            <tr>
            
                <td><input type="hidden" name="maid" value="${major.maId }" >${major.maId }</td> 
                <td ><input type="text" name="maname" value="${major.maName }"></td>
              </tr>
             
             </tbody>
              
               </table>
               <input type="button" value="保存" onclick="savefun();" style="margin-left:1000px; margin-top:50px; border-style : none; color:green;border-radius:20px;height:35px; width:50px;">
               </form>
         </div>
     </div>
</body>
</html>