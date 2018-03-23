<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<title>管理员--教室</title>
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/project/normal_exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/lib/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	
	<script type="text/javascript">
	function jumpfun(){
		   //要跳转的页码
		  var gopage= $("#jump").val();
		  //总页数
		  var countPage=${roomPage.countPage};
		  if(gopage!=null && gopage!=""){
			 var reg=/^\d+$/;
			  if(reg.test(gopage)){
				  if(gopage>0 && gopage<=countPage){
					  window.location.href="${pageContext.request.contextPath}/adminLittleAction!findAllRoom?page.currentPage="+gopage;
				  }else{
					  $("#pageError").html("请输入页码范围内的数");
				  }
			  }else{
				  $("#pageError").html("请输入正整数");
			  }
		  }else{
			  $("#pageError").html("请输入跳转的页码");
		  }
	   }

</script>
</head>
<body>

   <!--  <div class="button-group">
        <div class="button current">
           
        </div>
    </div> -->
  <div style="height:50px;">
  
  </div>
    <div class="container">
    <div class="table-zone">
         <table class="no-data">
            <thead>
              <tr>
              <td style="width:100px;">教室ID</td>
              <td style="width:160px;">教室名</td>
              <td style="width:110px;">操作</td>
            </tr></thead>
            <tbody>
              
              <c:forEach items="${roomPage.list }" var="r">
              <tr>
                <td >${r.roId}</td>
                <td >${r.roName }</td>
                <td ><a href="${pageContext.request.contextPath}/adminLittleAction!findRoomById?roid=${r.roId}"><span style="color:blue">修改</span></a></td>
              </tr>
              
              </c:forEach>
            </tbody> 
            
            
         </table>
         
         
        <div style="float: right; margin-right: 55px;" class="pageDiv">
           <a href="${pageContext.request.contextPath}/adminLittleAction!findAllRoom?page.currentPage=1" >首页</a>
	        <c:if test="${roomPage.currentPage>1}">
	              <a href="${pageContext.request.contextPath}/adminLittleAction!findAllRoom?page.currentPage=${roomPage.currentPage-1}" >上一页</a>
	        </c:if>   
	        
	            ${roomPage.currentPage}
	      <a href="${pageContext.request.contextPath}/adminLittleAction!findAllRoom?page.currentPage=${roomPage.countPage}" >尾页</a>
            <c:if test="${roomPage.currentPage<roomPage.countPage}">
	         <a href="${pageContext.request.contextPath}/adminLittleAction!findAllRoom?page.currentPage=${roomPage.currentPage+1}" >下一页</a>
           </c:if>   
           
                                          共${roomPage.totalNum }条 
				共${roomPage.countPage}页                                                                
	       <input type="text" id="jump" style="margin-right: 10px; padding: 2px; width: 30px; height:30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
           <input type="button" value="跳转" onclick="jumpfun();" style="border-style : none; color:blue;border-radius:20px;height:35px; width:50px;">
           <span id="pageError" style="color: red; "></span>
          </div>   						                                                       
       
     
     
       				    
                						  
    </div>
  </div>
</body>
</html>