<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-图书详情</title>
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<link href="css/bookInfo.css" type="text/css" rel="stylesheet">
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
	<!--内容区域-->
	<div class="conbox">
		<div class="c-top">
			<div class="c-top-l">
			<img src="images/book_img/${requestScope.book.bimg}" >
			</div>
		  <div class="c-top-r">
				<h3>${requestScope.book.bname}</h3>
				<h4>作者：${requestScope.book.bauto }</h4><input type="hidden" id="bid" value="${requestScope.book.b_id}">
				<br>
				<p>图书编号：${requestScope.book.b_id}</p>
				<br>
				<p>类型Type ：${requestScope.book.bk_name }</p>
				<br>
				<p>出版日期：${requestScope.book.b_press_time}</p>
				<br>
				<p>出版社：${requestScope.book.b_press }</p>
				<br>
			  	<input type="hidden" id="bimg" value="${requestScope.book.bimg}">
			  	<input type="hidden" id="price" value="${requestScope.book.bprice }">
			  	<h4>价格：￥<input id="totalPrice" type="text" value="${requestScope.book.bprice }"></h4>
				<div>
					<input type="button" value="-" id="jian" style="width: 30px">
					<input type="text" value="1" id="count" style="width: 30px">
					<input type="button" value="+" id="jia" style="width: 30px">
				</div>
				<br>
			  	<div class="goumai2">
			  		<input type="button" value="加入购物车" onclick="addCart(${requestScope.book.b_id})">
			  		<input type="button" value="立即购买" id="nowBuy">
			  		<script>
			  			function addCart(b_id){
			  				location.href="AddCartServlet?b_id="+b_id;
			  			}
			  			/* 立即购买事件 */
			  			$("#nowBuy").click(function(){
			  				var totalPrice = $("#totalPrice").val();
			  				var count = $("#count").val();
			  				var b_id = $("#bid").val();
			  				alert(totalPrice+count);
			  				location.href="AddOrdersAndOrdersDetailByNowBuyServlet?totalPrice="+totalPrice+"&count="+count+"&b_id="+b_id;
			  			});
			  			$("#jia").click(function(){
			  				var count = $("#count").val();
			  				var price = $("#price").val();
			  				count = parseInt(count);
			  				if(!isNaN(count)){
			  					count = count+1;
			  					var totalPrice = count*price;
			  					$("#count").val(count);
			  					$("#totalPrice").val(totalPrice);
			  				}else{
			  					alert('不是一个数字');
			  				}
			  			});
			  			$("#jian").click(function(){
			  				var count = $("#count").val();
			  				var price = $("#price").val();
			  				count = parseInt(count);
			  				if(!isNaN(count)){
			  					if(count!=1){
				  					count = count-1;
				  					totalPrice = count*price;
				  					$("#count").val(count);
				  					$("#totalPrice").val(totalPrice);
			  					}
			  				}else{
			  					alert('不是一个数字');
			  				}
			  			});
			  			$("#count").blur(function(){
			  				var count = $("#count").val();
			  				var price = $("#price").val();
			  				count = parseInt(count);
			  				if(!isNaN(count)){
			  					if(count!=1){
				  					totalPrice = count*price;
				  					$("#count").val(count);
				  					$("#totalPrice").val(totalPrice);
			  					}
			  				}else{
			  					alert('不是一个数字');
			  				}
			  			});
			  		</script>
			  	</div>
			</div>
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
</body>
</html>