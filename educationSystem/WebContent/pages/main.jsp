<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title> 
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/platform/platform.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
 <div class="container">
        <div id="pf-hd">
            <div class="pf-logo">
                <img style="margin-top:-50px;margin-left:-300px" src="${pageContext.request.contextPath }/imgs/main/logo.png" alt="logo">
                <h1 class="system-name">教务管理系统</h1>
            </div>

            <ul class="pf-nav">
                <li class="pf-nav-item home current" data-menu="home">
                    <a href="javascript:;">
                        <span class="pf-nav-icon home-icon"></span>
                        <span class="pf-nav-title">首页</span>
                    </a>
                </li>
                 <li class="pf-nav-item manger" data-menu="mange">
                    <a href="javascript:;">
                        <span class="pf-nav-icon manger-icon"></span>
                        <span class="pf-nav-title">信息管理</span>
                    </a>
                </li>
               
                <li class="pf-nav-item project" data-menu="project">
                    <a href="javascript:;">
                        <span class="pf-nav-icon project-icon"></span>
                        <span class="pf-nav-title">查询信息</span>
                    </a>
                </li>
                <li class="pf-nav-item static" data-menu="query">
                    <a href="javascript:;">
                        <span class="pf-nav-icon static-icon"></span>
                        <span class="pf-nav-title">教学评估</span>
                    </a>
                </li>
               
               
              
                 
                
            </ul>


            <div class="pf-user">
                <div class="pf-user-photo">
                    <img src="${pageContext.request.contextPath }/imgs/main/user.png" alt="">
                </div>
                <h4 class="pf-user-name ellipsis">Admin</h4>
                <i class="iconfont xiala">&#xe618;</i>

                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <li>
                            <a href="javascript:;">
                                <i class="iconfont">&#xe606;</i>
                                <span class="pf-opt-name">用户信息</span>
                            </a>
                        </li>
                        <li class="pf-modify-pwd">
                            <a href="javascript:;">
                                <i class="iconfont">&#xe613;</i>
                                <span class="pf-opt-name">修改密码</span>
                            </a>
                        </li>

                        <li class="pf-logout">
                            <a href="javascript:;">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name">退出</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>

            <div class="pf-notice">
                <i class="iconfont">&#xe612;</i>
                <div class="pf-notice-box ellipsis" onmouseout="marqueeInterval[0]=setInterval('startMarquee()',marqueeDelay)" onmouseover="clearInterval(marqueeInterval[0])">
                    
                </div>

                <div class="pf-notice-opt">
                    <a href="javascript:;" class="iconfont pf-notice-up">&#xe61d;</a>
                    <a href="javascript:;" class="iconfont pf-notice-down">&#xe605;</a>
                </div>
            </div>
        </div>

        <div id="pf-bd">
            <div id="pf-sider">
                <h2 class="pf-model-name">
                    <span class="pf-sider-icon"></span>
                    <span class="pf-name">首页</span>
                </h2>

               <%--  <ul class="sider-nav">
                     <li class="current">
                        <a href="javascript:;">
                            <img src="${pageContext.request.contextPath }/imgs/main/l01.png">
                            <span class="sider-nav-title">首页</span>
                            <i class="iconfont">&#xe611;</i>
                        </a>
                     </li>
          
                 </ul>  --%>
            </div>

            <div id="pf-page">
                <iframe src="${pageContext.request.contextPath }/pages/adminMain.jsp" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
            </div>
        </div>

        <div id="pf-ft">
            
        </div>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/lib/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/menu.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
    [if IE 7]
      <script type="text/javascript">
        $(window).resize(function(){
          $('#pf-bd').height($(window).height()-76);
        }).resize();
        
      </script>
    [endif]  
    <script type="text/javascript">


        var marqueeContent= [];   //滚动主题
                    
            marqueeContent[0]='<a href="javascript:;" class="pf1-notice-item target="_blank">新版系统界面正式上线</a>';
            marqueeContent[1]='<a href="javascript:;" class="pf1-notice-item target="_blank">欢迎访问uimaker.com</a>';
            marqueeContent[2]='<a href="javascript:;" class="pf1-notice-item target="_blank">这里是公告内容</a>';
            marqueeContent[3]='<a href="javascript:;" class="pf1-notice-item target="_blank">这里是测试标题</a>';
            marqueeContent[4]='<a href="javascript:;" class="pf-notice-item target="_blank">测试测试测试!</a>';

            var marqueeInterval=[];  //定义一些常用而且要经常用到的变量
            var marqueeId=0;
            var marqueeDelay=4000;
            var marqueeHeight=20;
            function initMarquee() {
             var str=marqueeContent[0];
             $('.pf-notice-box').html('<div>'+str+'</div>');
             marqueeBox = $('.pf-notice-box')[0];
             marqueeId++;
             marqueeInterval[0]=setInterval(startMarquee,marqueeDelay);
             }
            function startMarquee() {
             var str=marqueeContent[marqueeId];
              marqueeId++;
             if(marqueeId>=marqueeContent.length) marqueeId=0;
             if(marqueeBox.childNodes.length==1) {
              var nextLine=document.createElement('DIV');
              nextLine.innerHTML=str;
              marqueeBox.appendChild(nextLine);
              }
             else {
              marqueeBox.childNodes[0].innerHTML=str;
              marqueeBox.appendChild(marqueeBox.childNodes[0]);
              marqueeBox.scrollTop=0;
              }
             clearInterval(marqueeInterval[1]);
             marqueeInterval[1]=setInterval(scrollMarquee,10);
             }
            function scrollMarquee() {
             marqueeBox.scrollTop++;
             if(marqueeBox.scrollTop%marqueeHeight==marqueeHeight){
              clearInterval(marqueeInterval[1]);
              }
             }
            initMarquee();

    </script>

</body>
</html>