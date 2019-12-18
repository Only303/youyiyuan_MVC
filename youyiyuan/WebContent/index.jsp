<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑主页</title>
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>

<body>
<div class="box">
	<!--头部区域-->
		<div class="topbox">
			<div class="top">
				<a href="main.jsp"><img src="img/top-logo.png" class="top-logo"></a>
				<div class="t-sousuo">
					<div class="sousuok">
						<input type="text" placeholder="Java神书" class="t-txt" id="dimStr">
						<input type="button" value="搜&nbsp;索" class="t-btn" onclick="search()" id="searchDim">
						<script>
							$(function(){
								$("#searchDim").click(function(){
									var dimStr = $("#dimStr").val();
									location.href="ShowBooksListServlet?dimStr="+dimStr;								
								});
							})					
						</script>
					</div>
					<span class="t-gjc">关键词：<span style="color: #cf3232;">Java</span>&nbsp;
						JavaWeb &nbsp; CSS&nbsp; HTML&nbsp; JavaScript&nbsp; 小说&nbsp; 谚语故事
					</span>
				</div>
				<ul>
					<ul class="login">
						<c:if test="${empty sessionScope.user }">
				尚未登录，请<a href="login.jsp">登录</a>&nbsp;|&nbsp;<a href="register.jsp">注册</a>
						</c:if>
						<c:if test="${sessionScope.user !=null }">
				欢迎${sessionScope.user.uname }登录&nbsp;|&nbsp;<a
								href="LoginOutServlet">注销</a>
						</c:if>
					</ul>
					<ul class="login">
						<li><h4>
								<a href="ShowOrdersDetail">我的订单</a>
							</h4></li>
						<li><h4>
								<a href="FindAllCartByUidServlet">我的购物车</a>
							</h4></li>
					</ul>
				</ul>
			</div>
		</div>

		<!--导航区域-->
	<div class="navbox">
		<nav class="nav">
			<ul>
				<li class="navhover"><a href="main.jsp" >首页</a></li>
				<li><a href="ShowBooksListServlet">图书</a></li>
				<li><a href="jianjie.jsp">本站简介</a></li>
				<li><a href="new.jsp">最新资讯</a></li>
				<li><a href="lxwm.jsp">联系我们</a></li>
			</ul>
		</nav>
	</div>
	<!--焦点图区域-->
	<div class="bannerbox">
		<div class="banner">
			<!--图片区域-->
			<ul class="ban-img">
			<li><img src="images/banner3.jpg"></li>
			<li><img src="images/banner1.jpg"></li>
			<li><img src="images/banner2.jpg"></li>
			</ul>
			<!--小圆圈-->
			<ul class="ban-yqbox">
				<li class="on"></li>
				<li></li>
				<li></li>
			</ul>
			<!--左右按钮-->
			<i class="fa fa-chevron-left l-bnt" aria-hidden="true"></i>
			<i class="fa fa-chevron-right r-bnt" aria-hidden="true"></i>
		</div>
	<!--内容-选项卡区域-->
	<div class="conbox">
	<!--内容导航-->
		<div class="con-nav">
			<a href="#" >JAVA</a>
			<a href="#">JAVAWEB</a>
			<a href="#" class="connava">DATABASE</a>
			<a href="#">趣味阅读</a>
			<a href="#">谚语故事</a>
		</div>
		<!--产品-->
		<div class="connent">
			<!--选项卡1内容-->
			<div class="con">
				<h3 class="con-title">上帝的恩赐 人类的神奇语言</h3>
				
				<div class="con1">
					<ul>
						<li><a href="ShowBooksListServlet?bk_id=1">JAVA  <span>></span></a></li>
						<li><a href="ShowBooksListServlet?bk_id=2">JAVAWEB  <span>></span></a></li>
						<li><a href="ShowBooksListServlet?bk_id=3">DATABASE <span>></span></a></li>
						<li><a href="ShowBooksListServlet?bk_id=5">趣味阅读 <span>></span></a></li>
						<li><a href="ShowBooksListServlet?bk_id=6">谚语故事  <span>></span></a></li>
					</ul>
				</div>
				<!-- 循环开始：列出5个 -->
				<c:forEach var="listBK" items="${requestScope.list }" begin="0" end="4" >
				<div class="con1">
					<a href="ShowBooksListServlet?bk_id=${listBK.bk_id}" >
					<img src="images/book_kind/${listBK.bk_img}" class="con-img" style="right: 0px;width:188px;height:259px;margin-right: 70px;">
					<span class="con-ht">${listBK.bk_name}</span>
					</a>
				</div>
				</c:forEach>
				<!-- 循环结束 -->
		</div>
	</div>
	<!--页脚区域-->
	<div class="footbox">
    	<div class="foot">
			<div class="huiding"><a href="#">
				<i class="fa fa-arrow-up" aria-hidden="true"></i>
		   </a></div>
			<ul>
				<li><a href="lxwm.jsp">联系我们</a></li>
				<li><a href="jianjie.jsp">公司简介</a></li>
				<li><a href="new.jsp">公司新闻</a></li>
				<select class="f-xl">
					<option>友情链接</option>
					<option>帅的不堪入目</option>
					<option>耗子（马浩凯）</option>
				</select>
			</ul>

			<p class="f-small">Copyright @ 2010-2016  学者博也，博者智也</p>
			<p class="f-sj">劝君更尽一杯酒<br/><span>满韵香含唯此家</span></p>
       		<img src="images/foot-logo.jpg" style="position:absolute;bottom:10px;right:30px; ">
        </div>
    </div>
    </div>
</div>
</div>
</body>
</html>
