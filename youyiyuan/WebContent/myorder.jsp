<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-我的订单</title>
<link rel="stylesheet" type="text/css" href="css/myorder.css" />
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="box">
	<div class="total">
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
				<li class="navhover"><a href="main.jsp">首页</a></li>
				<li><a href="ShowBooksListServlet">图书</a></li>
				<li><a href="jianjie.jsp">本站简介</a></li>
				<li><a href="new.jsp">最新资讯</a></li>
				<li><a href="lxwm.jsp">联系我们</a></li>
			</ul>
			</nav>
		</div>

		<!--第三个-->
		<div class="div03">
			<table>
				<tr class="tr01">
					<td><select name="">
							<option value="44">近三个月订单</option>
							<option value="55">近六个月订单</option>
							<option value="66">近一年订单</option>
					</select></td>
					<td align="center"><font>订单详情</font></td>
					<td align="center">数量</td>
					<td align="center"><font>收货人</font></td>
					<td align="center"><font>金额</font></td>
					<td align="center"><select name="">
							<option value="77">全部状态</option>
							<option value="88">待付款</option>
							<option value="99">已完成</option>
					</select></td>
					<td align="center"><font>操作</font></td>
				</tr>

				<tr class="tr02">
					<td colspan="7"></td>
				</tr>

				<!-- 开始循环 -->
				<c:forEach var="listODV" items="${requestScope.list }">
					<tr class="tr03">
						<td><font> <!-- 2018-01-21 19:21:26 -->
								${listODV.otime}
						</font> <font>订单号：${listODV.oid}</font></td>
					</tr>

					<tr class="tr04">

						<td style="width: 35%;"><img
							src="images/book_img/${listODV.bimg}" /> <!-- 图书名称 --> <font>${listODV.bname}</font>
						</td>
						<td></td>
						<td><font>x${listODV.odcount}</font></td>
						<td align="center" style="width: 10%">
							<!-- 收货人 --> <font>${sessionScope.user.uname}</font>
						</td>
						<td align="center" style="width: 10%"><font>总额¥${listODV.total}</font><br />
							<hr /> <font>在线支付/白条</font></td>
						<td align="center" style="width: 10%">
							<!-- 订单状态 --> <font>${listODV.state}</font><br /> <a href="">订单详情</a>
						</td>
						<td align="center" style="width: 15%"><a href="">选购京东服务</a><br />
							<a href="">查看发票</a><br /> <a href="">评价</a><br />
							<button>再次购买</button></td>
					</tr>

				</c:forEach>
				<!-- 结束循环 -->
			</table>
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
