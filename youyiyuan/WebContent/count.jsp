<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结算页面</title>
<link type="text/css" rel="stylesheet" href="css/count.css" />
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="box">
	<div class="div01">
		<!--灰色部分div-->
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
		<!--logo div-->
		<div class="linediv"></div>

		<!--核对订单表下面的div-->
		<form action="AddOrdersAndOrdersDetailServlet" method="post">
		
		<div class="linediv1"></div>

		<!--图书div-->
		<div style="width: 100%; height: 55%; background-color: #F3FBFE;">
			<table style="width: 100%; height: 100%; text-align: center;">
				<tr>
					<td><font class="font5">图书</font></td>
					<td><font class="font5">作者</font></td>
					<td><font class="font5">单价</font></td>
					<td><font class="font5">数量</font></td>
					<td><font class="font5">库存</font></td>
				</tr>

				<!-- 循环开始 -->
				<c:set var="totalPrice" value="0"></c:set>
				<c:forEach var="cv" items="${requestScope.list }">
					<tr>
						<td><img src="images/book_img/${cv.bimg }"
							style="height: 150px; width: 150px" /></td>
						<td><font class="font6">${cv.bname} <br />李盈春 译 解忧杂货铺
								文学小说
						</font> <br /> <font class="font7">支持七天无理由退货</font></td>
						<td><font class="font8">￥${cv.bprice} </font></td>
						<td>×${cv.count}</td>
						<td><font>有货</font></td>
					</tr>
					<c:set var="totalPrice" value="${totalPrice+(cv.bprice*cv.count)}"></c:set>
				</c:forEach>
				<!-- 循环结束 -->
			</table>
		</div>

		<!--最下面的div-->
		<div class="botdiv">
			<div class="botdiv_01">
				<h4>应付金额:￥${totalPrice}</h4>
				<input type="hidden" name="total" value="${totalPrice}">
				<!-- </font> -->
				<br />
				<h4> 寄送至：</h4>
				<%--  <input type="text" name="address" value="${requestScope.address }"> --%>
				 <input type="text" name="address" value="${requestScope.address.address }">
				<br>
				<h4>收货人：</h4>
				<input type="text" name="uname" value="${sessionScope.user.uname }">
				<input type="hidden" name="cidStr" value="${requestScope.cidStr}">
				<div class="mid_03">
				<div class="mid_03_1">
					<h4>收货人备注：</h4>
					<input type="text" name="uremark">
					<h4><a href="add_address.jsp" class="a2" name="addressNew">新增收货地址</a></h4>
				</div>
		</div>
			</div>
			<div class="botdiv_02">
				<input type="submit" value="提交订单" class="input4" />
			</div>
		</div>
		</form>
	</div>
	<!--导航区域-->
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
