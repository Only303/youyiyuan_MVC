<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-购物车</title>
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" href="css/shopcar.css" />
</head>
<body>
<div class="box">
	<div class="total">
		<!--第一行-->
		<!--头部区域-->
		<div class="topbox">
			<div class="top">
				<a href="main.jsp"><img src="img/top-logo.png" class="top-logo"></a>
				<div class="t-sousuo">
					<div class="sousuok">
						<input type="text" placeholder="Java神书" class="t-txt" id="dimStr">
						<input type="button" value="搜&nbsp;索" class="t-btn"
							onclick="search()" id="searchDim">
						<script>
							$(function() {
								$("#searchDim").click(
									function() {
									var dimStr = $(
											"#dimStr")
											.val();
									location.href = "ShowBooksListServlet?dimStr="
											+ dimStr;
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
		<!--第二行-->
	<form action="ShowCheckedCartByCidServlet" method="get" id="form">
		<div class="div_two">
			<buttton class="k">全部商品</buttton>
			&nbsp;&nbsp;&nbsp;
			<buttton class="k">京东书店</buttton>
			<select name="selects">
				<option value="11">朝阳区三环以内</option>
				<option value="22">西城区二环以内</option>
				<option value="33">昌平区六环以外</option>
			</select> <font>配送至：</font>
		</div>


		<!--第三行-->
		<div class="div_three">
			<table align="center" cellspacing="0">
				<tr style="background-color: #f3f3f3;">
					<td style="width: 10%;"><font>选择</font></td>
					<td style="width: 10%;"><font>编号</font></td>
					<td style="width: 25%;"><font>商品</font></td>
					<td style="width: 15%;"><font>名称</font></td>
					<td style="width: 10%;"><font>单价</font></td>
					<td style="width: 10%;"><font>数量</font></td>
					<td style="width: 10%;"><font>小计</font></td>
					<td style="width: 10%;"><font>操作</font></td>
				</tr>
			</table>
		</div>

		<!--第四行 -->
		<div class="div_four">
			<!--订单详情-->
			
				<table class="table01">
					<!-- 循环开始 -->

					<c:set var="totalPrice" value="0"></c:set>
					<c:forEach var="cv" items="${requestScope.list}" varStatus="status">
						<tr>
							<td style="width: 10%;">
							<input type="checkbox" name="cid" id="cid" value="${cv.cid }" onclick="changeTotalPrice(${cv.count*cv.bprice})" /></td>
							<td style="width: 10%;"><font>${status.count}</font></td>
							<td style="width: 25%;"><img
								src="images/book_img/${cv.bimg }" /></td>
							<td style="width: 15%;"><font style="float: left;">${cv.bname}</font>
								<br /> <a href="#">支持7天无理由退货</a></td>
							<td style="width: 10%;">
							¥<input type="text" id="totalPrice" value="${cv.bprice }" readonly="readonly" style="width: 35px;" >
							<input type="hidden" id="price" value="${cv.bprice }">
							<br /></td>
							<td style="width: 10%;">
								<div>
									<input id="jian" type="button" value="-" onclick="changeCountByBtn('-',${status.index},${cv.b_id },${cv.cid})">
									<input type="text"id="count${status.index }" value="${cv.count}" style="width: 30px;"
									 onblur="changeCount(${status.index},${cv.b_id}),${cv.cid}">
									<input id="jia" type="button" value="+" onclick="changeCountByBtn('+',${status.index},${cv.b_id })">
								</div>
							</td>
							<td style="width: 10%;">¥${cv.count*cv.bprice}</td>
							<td style="width: 10%;"><a href="DeleteCartByCidServlet?cid=${cv.cid }" class="l">删除</a><br /> <a
								href="" class="l">移到我的关注</a><br /> <a href="" class="l">加到我的关注</a>
							</td>
						</tr>
						<c:set var="totalPrice" value="${totalPrice+(cv.count*cv.bprice)}"></c:set>
					</c:forEach>
					<!-- 循环结束 -->
				</table>
			</div>
				<script>
					function changeCountByBtn(op,index,b_id,cid){
						var count = parseInt(document.getElementById("count"+index).value);
			 			if(op == "+"){
			 				location.href="UpdateCartCountByUidAndB_idServlet?count="+(count+1)+"&b_id="+b_id;
			 			}else{
			 				if(count>1){
				 				location.href="UpdateCartCountByUidAndB_idServlet?count="+(count-1)+"&b_id="+b_id;
			 				}else{
			 					if(confirm('确定要删除吗?')){
			 						location.href="DeleteCartByCidServlet?cid="+cid;
			 					}else{
			 						alert('取消删除');
			 					}
			 				}
			 			}
					}
					function changeCount(index,b_id){
		          		//获取文本框的内容
		          		var count = document.getElementById("count"+index,b_id).value;
		          		if(isNaN(count) && count<=0){
		          			alert('请输入大于0的数字');
		          		}else{
		          			//修改count
		          			location.href="UpdateCartCountByUidAndB_idServlet?count="+count+"&b_id="+b_id;
		          		}
		          	}
					function onForm() {
						document.getElementById("form").submit();
					}
					function changeTotalPrice(smallTotalPrice){
						var finTotalPrice = $("#showTotalPrice").val();
						var showTP = Number(finTotalPrice);
						showTP = showTP+smallTotalPrice;
						$("#showTotalPrice").val(showTP);
					}
				</script>
			</form>
	
			<!--结算-->
			<table class="table02">
				<tr>
					<td><font class="font01">¥<input type="text" readonly="readonly" value="0" id="showTotalPrice"></font> <font
						class="font02">总价：</font></td>
					<td rowspan="2" style="width: 120px;">
						<%-- <input type="hidden" value="${cv.cid }" /> --%>
						<button onclick="onForm()">去结算</button>
					</td>
				</tr>
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
