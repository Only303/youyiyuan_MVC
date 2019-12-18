<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-书屋</title>
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<link href="css/books.css" type="text/css" rel="stylesheet">
<!-- <link href="css/chanping.css" rel="stylesheet"> -->
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/chanping.js"></script>
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
				<span class="t-gjc">关键词：<span style="color: #cf3232;">Java</span>&nbsp; JavaWeb
				&nbsp; CSS&nbsp; HTML&nbsp; JavaScript&nbsp; 小说&nbsp; 谚语故事</span>
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
	
	<!--焦点产品区域-->
	<!-- 图书列表开始 -->
	<div class="banbox">
		<div class="ban">
		<ul class="b-list">
		<!-- 循环开始 -->
			<c:forEach items="${requestScope.list }" var="book" varStatus="status" begin="0" end="9">
			<li><a href="ShowBookInfoServlet?bid=${book.b_id}"><img src="images/book_img/${book.bimg }" style="text-align: center;"></a>
					<div class="b-listjs">
					<a href="ShowBookInfoServlet?bid=${book.b_id}">
					<p>查看详情
					<i class="fa fa-caret-square-o-right" aria-hidden="true" style="font-size: 24px;"></i>
					</p>
					</a>
					</div>
			</li>
			</c:forEach>
		<!-- 循环结束 -->
		</ul>
		</div>
	</div>
	<!-- 图书列表结束 -->
	<!--内容区域-->
	<div class="conbox">
		<ul class="c-nav">
			<li><a href="">JAVA</a>
				<ul class="c-nav-hover">
					<li><a href="ShowBooksListServlet">蓝冰王</a></li>
					<li><a href="ShowBooksListServlet">加拿诗</a></li>
					<li><a href="ShowBooksListServlet">安大略</a></li>
					<li><a href="ShowBooksListServlet">红冰酒</a></li>
				</ul>
			</li>
			<li><a href="">JAVAWEB</a>
				<ul class="c-nav-hover">
					<li><a href="">佳丽酿</a></li>
					<li><a href="ShowBooksListServlet">赤霞珠</a></li>
					<li><a href="ShowBooksListServlet">蛇龙珠</a></li>
					<li><a href="ShowBooksListServlet">品丽珠</a></li>
					<li><a href="ShowBooksListServlet">白诗南</a></li>
					<li><a href="ShowBooksListServlet">塞米雍</a></li>
				</ul>
			</li>
			<li><a href="">DATABASE</a>
				<ul class="c-nav-hover">
					<li><a href="ShowBooksListServlet">湖南酒</a></li>
					<li><a href="ShowBooksListServlet">湖北酒</a></li>
					<li><a href="ShowBooksListServlet">黑檽米</a></li>
				</ul>
			</li>
			<li><a href="">趣味阅读</a>
				<ul class="c-nav-hover">
					<li><a href="ShowBooksListServlet">1982</a></li>
					<li><a href="ShowBooksListServlet">1992</a></li>
				</ul>
			</li>
			<li><a href="">谚语故事</a>
				<ul class="c-nav-hover">
					<li><a href="ShowBooksListServlet">雷司令</a></li>
					<li><a href="ShowBooksListServlet">贵人香</a></li>
					<li><a href="ShowBooksListServlet">李将军</a></li>
					<li><a href="ShowBooksListServlet">长相思</a></li>
				</ul>
			</li>
		</ul>
		<ul class="cp-list">
		<!-- 循环开始 -->
		<c:forEach items="${requestScope.list }" var="book" varStatus="status">
			<li><a href="ShowBookInfoServlet?bid=${book.b_id}">
				<img src="images/book_img/${book.bimg}" width="230"></a>
				<!-- 书名 -->
				<h4><a href="AddCartServlet?b_id=${book.b_id}">${book.bname}</a></h4>
				<i class="fa fa-heart-o shoucan" aria-hidden="true"></i>
				<i class="fa fa-heart shoucan2" aria-hidden="true"></i>
				<a class="jrgwc" href="AddCartServlet?b_id=${book.b_id}">加入购物车</a>
				<div class="list-h">
					<p>类型：${book.bk_name}<br>
					作者：${book.bauto}<br>
					概要：${book.bprice}<br>
					</p>
					<p>零售价：￥${book.bprice}</p>
				</div>
			</li>
			</c:forEach>
			<!-- 循环结束 -->
		</ul>
	</div>
	<!--内容-名酒商标区域-->
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
</body>
</html>
