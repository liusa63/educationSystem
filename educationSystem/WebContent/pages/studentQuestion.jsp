<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生--评估</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript">
	
	  function subfun(){
		  
		  var a1 =$('input:radio[name="answer1"]:checked').val();
		  var a2 =$('input:radio[name="answer2"]:checked').val();
		  var a3 =$('input:radio[name="answer3"]:checked').val();
		  var a4 =$('input:radio[name="answer5"]:checked').val();
		  var a5 =$('input:radio[name="answer6"]:checked').val();
		 
		 if(a1 != undefined && a2 != undefined && a3 != undefined && a4 != undefined && a5 != undefined){
			
			  $("#answer1").val(a1);
			  $("#answer2").val(a2);
			  $("#answer3").val(a3);
			  $("#answer4").val(a4);
			  $("#answer5").val(a5);
			  
			  
	 		  $("#subForm").submit();
			 
		 }else{
			 
			 alert("请完成所有问题再提交");
		 }
		   
		  
		  
	  }
	
	
	</script>
</head>
<body>

<form action="${pageContext.request.contextPath}/studentAction_addEvaluation" method="post" id="subForm">
 <input  type="hidden" name="answer1" id="answer1">
 <input  type="hidden" name="answer2" id="answer2">
 <input  type="hidden" name="answer3" id="answer3">
 <input  type="hidden" name="answer4" id="answer4">
 <input  type="hidden" name="answer5" id="answer5">
 <input  type="hidden" name="coId" value="${coId }">
 <input  type="hidden" name="teId" value="${teacher.teId }">
</form>


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
                                <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="50%" style="width:50%">
                						<thead>
                							<tr>
                								<th>教学评估----请对${teacher.teName } 老师打分 </th>
                							</tr>
                						</thead>
                						<tfoot>
                							<tr>
                								<th>
                								<input type="button" value="提交" onclick="subfun();" style="border-style : none; color:#f08a49;border-radius:20px;height:35px; width:50px;">
                								<input type="button" value="返回" onclick="window.history.go(-1);" style="margin-left:50px; border-style : none; color:#f08a49;border-radius:20px;height:35px; width:50px;">
                								</th>
                							</tr>
                						</tfoot>
                						<tbody>
                						<c:forEach items="${questionList}" var="e">
                							<tr>
                								<td><span style="color:blue">${e.qcontent }</span></td>
                							</tr>
                							<tr>
                							    <td><input type="radio" id="choose" name="answer${e.qid }" value="${e.qa }">${e.qa }分</td>
                							</tr>
                							<tr>
                							    <td><input type="radio" id="choose" name="answer${e.qid}" value="${e.qb }">${e.qb }分</td>
                							</tr>
                							<tr>
                							    <td><input type="radio" id="choose" name="answer${e.qid }" value="${e.qc }">${e.qc }分</td>
                							</tr>
                							<tr>
                							    <td><input type="radio" id="choose" name="answer${e.qid}" value="${e.qd }">${e.qd }分</td>
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