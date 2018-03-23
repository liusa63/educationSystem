<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>录入教师信息</title>
<link href="${pageContext.request.contextPath }/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/backend/person_relationship.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/js/lib/ztree/css/zTreeStyle/zTreeStyle.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/backend/person_manger.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/js/lib/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
	
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
	alert("您还没有选择录入方式");
}
	
}
</script>
</head>
<body> 	
 <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">教师管理</a>
			</div>
        </div>

       
			       

		        
		    </div>
            <form action="${pageContext.request.contextPath }/adminAction!checkTeacherMethod" method="post" id="subform">
	
            <div class="button-group">
		        <div class="button current add">
		            <i class="iconfont">&#xe620;</i>
		             
		            <span class="button-label" ><input type="radio" value="0" name="录入"> 单个录入</span>
		        </div>
		         <div class="button current add">
		            <i class="iconfont">&#xe620;</i>
		           
		            <span class="button-label"> <input type="radio" value="1" name="录入">批量录入</span>
		        </div>
		         <div class="button current add">
		            <i class="iconfont">&#xe620;</i>
		           
		            <span class="button-label" onclick="testradio();"> 确定</span>
		        </div>
		        
		      <input type="hidden" name="teMethod" id="teMethod">  
		      <!--  <input type="button" value="确定"  /> -->
		    </div>
			
		</form>	
			
			
        

	<script type="text/template" id="addTpl">
	
	</script>

</body>
</html>
