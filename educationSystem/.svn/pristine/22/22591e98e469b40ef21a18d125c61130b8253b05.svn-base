<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<title>学生--首页</title>
<style type="text/css" media="screen">
html, body {
width: 100%;
}
ul li {
list-style: none;
}
*{margin:0;padding:0;}
#box00 {
width: 1200px;
margin-top: 100px;
}
.slide00 {
height: 500px;
position: relative;
}
.slide00 ul {
height: 100%;
}
.slide00 li {
position: absolute;
left:200px;
top:0;
}
.slide00 li img{
width: 100%;
}
.arraw00 {
opacity: 0;
}
.arraw00 a {
width: 70px;
height: 110px;
display: block;
position: absolute;
top: 50%;
margin-top: -55px;
z-index: 999;
}
.next {
background: url(${pageContext.request.contextPath}/image/right.png) no-repeat;
right: -10px;
/*opacity: .5;*/
/*filter: alpha(opacity=50);*/
}
.prev {
background: url(${pageContext.request.contextPath}/image/left.png) no-repeat;
left: -10px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	
</head>
<body>


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

                欢迎 ${student.sclass.clName } 
        <c:if test="${student.stBehave==1}">
                           班长
        </c:if>
        <c:if test="${student.stBehave==2}">
                           学生 
        </c:if>
        
          : ${student.stName }登录教务系统
            
    </div> 
   
    <!-- 图片轮播 -->
      <div id="box00"  style=" width:1050px;height:550px;margin-top:30px; margin-left:270px">
		<div class="slide00">
		<ul>
		 <li><a href="#"><img src="${pageContext.request.contextPath }/image/1.jpg" alt=""></a></li>
		 <li><a href="#"><img src="${pageContext.request.contextPath }/image/2.jpg" alt=""></a></li>
		 <li><a href="#"><img src="${pageContext.request.contextPath }/image/3.jpg" alt=""></a></li>
		 <li><a href="#"><img src="${pageContext.request.contextPath }/image/4.jpg" alt=""></a></li>
		 <li><a href="#"><img src="${pageContext.request.contextPath }/image/5.jpg" alt=""></a></li>
		</ul>
		<div class="arraw00">
		  <a href="javascript:;" class="next"></a>
		  <a href="javascript:;" class="prev"></a>
		  
		  
		</div>
		</div>
		</div>
		<div style="margin-top:-580px; ">
		<%@include  file="student.jsp"%>
		</div>
  <script type="text/javascript">
		$(function(){
			
		
		var box00 = document.querySelector('#box00');
		var slide00 = document.querySelector('.slide00');
		var arraw00 = document.querySelector('.arraw00');
		var lis = document.querySelectorAll('li');
		var json = [  //  包含了5张图片里面所有的样式
			{   //  1
				width:400,
				top:100,
				left:100,
				opacity:20,
				z:2,
				id:1
			},
			{  // 2
				width:600,
				top:100,
				left:50,
				opacity:60,
				z:3,
				id:2
			},
			{   // 3
				width:800,
				top:100,
				left:200,
				opacity:100,
				z:4,
				id:3
			},
			{  // 4
				width:600,
				top:70,
				left:550,
				opacity:60,
				z:3,
				id:4
			},
			{   //5
				width:400,
				top:20,
				left:650,
				opacity:20,
				z:2,
				id:5
			}
		];
	/* 	box.addEventListener('mouseover', function(){
		// console.log('aaa')
		animate(arraw, {opacity: 100});
		}); 
		box.addEventListener('mouseout', function(){
		// console.log('aaa')
		animate(arraw, {opacity: 0});
		});
		*/
		var next = document.querySelector('.next');
		var prev = document.querySelector('.prev');
		var timer = null;
		var flag = true;
		next.addEventListener('click', function(){
		// alert('next');
		// console.log(json);
		// console.log('================')
		clearInterval(timer);
		if(flag == true){
		move(true);
		flag = false;
		}
		//console.log(json);
		});
		next.addEventListener('mouseleave', function(){
		
		clearInterval(timer);
		//alert('next')
		run();
		//console.log(json);
		
		});
		prev.addEventListener('click', function(){
		clearInterval(timer);
		// alert('prev')
		if(flag == true){
		move(false);
		flag = false;
		}
		});
		prev.addEventListener('mouseleave', function(){
		// alert('prev')
		// clearInterva(timer);
		run();
		});
		
		move();
		run();
		function run(){
		clearInterval(timer);
		timer = setInterval(function(){
		// console.log('run')
		if(flag == true){
		flag = false;
		move(true);
		}
		// console.log(json)
		},500);
		}
		
		function move(x){
		if(x != undefined){
		if(x){
		json.push(json.shift());
		}else{
		  json.unshift(json.pop());
		};
		};
		
		for(var i = 0; i<json.length; i++){
		animate(lis[i],{
		  width: json[i].width,
		  top: json[i].top,
		  left: json[i].left,
		  opacity: json[i].opacity,
		  zIndex: json[i].z
		},function(){flag = true;})
		};
		}
		
		function animate(obj, json, callback){
		// 先停止定时器
		  clearInterval(obj.timers);
		  obj.timers = setInterval(function(){
			var stoped = true;
			// console.log('sss')
			for(var k in json){
			 // var leader = parseInt(getStyle(obj, k));
			 var leader = 0;
			 if(k == 'opacity'){
			  leader = Math.round(getStyle(obj, k)*100) || 100;
			 }else {
			  // console.log(json[k]);
			  leader = parseInt(getStyle(obj, k)) || 0;
			 };
		//         console.log(leader);
			 // json[k]是目标位置
			 var step = (json[k]-leader)/10;
			 step = step > 0? Math.ceil(step) : Math.floor(step);
			 leader = leader + step;
			 if(k == 'opacity'){
			  obj.style[k] = leader/100;
			  obj.style['filter'] = 'alpha(opacity='+ leader +')';
			 }else if(k == 'zIndex'){
			  obj.style['zIndex'] = json[k];
				 console.log(666);
			 }else{
			  obj.style[k] = leader + "px";
			 }
			 if(leader != json[k]){
			  stoped = false;
			  }
			 };
			 if(stoped){
				// console.log('stop')
				clearInterval(obj.timers);
				callback && callback();
			  };
		  },50);
		};
		//获取属性值
		function getStyle(obj, attr){
		  if(obj.currentStyle){
			return obj.currentStyle[attr];
		  }else{
			return window.getComputedStyle(obj, null)[attr];
		  };
		};
		
		})
</script>  
    
   


</body>
</html>