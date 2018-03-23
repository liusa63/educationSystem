<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>录入全校课表</title> 
    <link
	href="${pageContext.request.contextPath }/js/lib/datepicker/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/backend/grade.css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
/* 获取选中单选框 */
function testradio(){
	var v = $(":radio:checked").val();
	if(v!=undefined){
		$("#teMethod").val(v);
		$("#subform").submit();
}else{
	alert("您还没有选择录入种类");
}
	
}
</script>
</head>
<body>	
 <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">课程录入</a>
			</div>
        </div>
        <div id="inner-bd">	       
            <div class="button-group">
		        <div class="button current">
		            <i class="iconfont">&#xe616;</i>
		            <a href="${pageContext.request.contextPath }/adminAction!checkCourseMethod?coMethod=0">
		            <span class="button-label">全校课程</span>
		            </a>
		        </div>
		          <div class="button current">
		            <i class="iconfont">&#xe616;</i>
		            <a href="${pageContext.request.contextPath }/adminAction!checkCourseMethod?coMethod=1">
		            <span class="button-label">必修课程</span>
		            </a>
		        </div>		       
		    </div>			
        </div>    
    </div>
</body>
</html>
