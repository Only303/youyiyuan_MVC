<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-新闻</title>
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/header.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<link href="css/new.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/new.js"></script>
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
<!--内容区域-->
<div class="conbox">
	<div  class="mianbao">
		<ul>
			<li>公司新闻-</li>
			<li>-新闻详情</li>
		</ul>
	</div>
	<h3>2015加拿大农业食品出口贸易洽谈会-中国<br><span>发布时间：2015-06-29</span></h3>
	<p class="zw">2016加拿大农业食品出口贸易洽谈会在中国上海、重庆、北京召开.加拿大农业部邀请木地酒庄一同参加.在这次贸易洽谈会上,加拿大木地酒庄作为加拿大农业部组团成员之一,为加拿大介绍冰葡萄酒的饮用与配餐等方面的知识,并携带多款冰葡萄酒,与大家分享.</p>
	<div class="xw-img">
		<img src="images/xinwenxiangqing/pic1.jpg">
		<img src="images/xinwenxiangqing/pic2.jpg">
	</div>
	<p class="zw">2017年即将来临，作为葡萄酒行业的实践者，红酒老郭根据个人的体会对2017年葡萄酒行业一点非常不成熟的思考，敬请行业同仁以娱乐的心情解读，不承担根据这个猜想所作出决定的任何后果。本猜想特指中国大陆地区，不包含港澳台地区市场。</p>
	<p class="zw">	一瓶红酒的价值讨论让李嘉图和古典经济学陷入了非常尴尬的处境，古典经济学被颠覆的同时，也促进了经济学的发展，这就是经济学中有名的“李嘉图悖论”　。
12月7日济南奔富电子商务有限公司推出的葡萄酒特卖商城红唯会正式上线，仅仅上线一天，商 城内葡萄酒销量已超过1400瓶</p>
	<p class="zw">一瓶红酒到底值多少钱？几千美元一瓶的拉菲和一瓶几美元的普通红酒劳动成本基本相同，为啥市场上的价格差距如此之大？后面的经济学家很简单的回答了这个问题，敬请红酒老郭的后续解读</p>
			<div class="new">
			<p class="gdxw">更多新闻-----------------------------------------------------------------------------------------------------------------------------------------<a href="new.jsp">more</a>----</p>
			<ul>
				<li>
					<a href=""><img src="images/news/new1.jpg" width="450" height="250"></a>
					<p class="wen-bt">“葡酒节”市民尽情品尝木地酒庄产品的美味，为市民提供了愉快的放松环境</p>
					<div class="new-hover">
						<p>2016年10月20日正午12时巴拿马万国博览会在旧金山开幕。旧金山市市长Rolph在开幕式上发表演讲，美国总统伍德罗·威尔逊到会致贺词。美国副总统托马斯·马歇尔及前总统西奥多·罗斯福等国家政要亲临会场助兴。
博览会开幕的第一天，参观者如潮水涌动，络绎不绝地进入展馆，人数超过20万。出于对古老中国的神秘、好奇感的驱使，当天到中国馆参观的人数达8万人之多.... ....<br>
					</p>
					<a href="xwxq.jsp">查看详情</a>
					</div>
				</li>
				<li>
					<a href=""><img src="images/news/new1-2.jpg" width="450" height="250"></a>
					<p class="wen-bt">市级领导到木地庄园进行指导和验收，并对该庄园的肯定与支持</p>
					<div class="new-hover">
						<p>2016年10月20日正午12时巴拿马万国博览会在旧金山开幕。旧金山市市长Rolph在开幕式上发表演讲，美国总统伍德罗·威尔逊到会致贺词。美国副总统托马斯·马歇尔及前总统西奥多·罗斯福等国家政要亲临会场助兴。
博览会开幕的第一天，参观者如潮水涌动，络绎不绝地进入展馆，人数超过20万。出于对古老中国的神秘、好奇感的驱使，当天到中国馆参观的人数达8万人之多.... ....<br>
					</p>
					<a href="xwxq.jsp">查看详情</a>
					</div>
				</li>
			</ul>
			<a class="zhankai">---------------展开---------------<br>
			</a>
		</div>
</div>
<!--页脚区域-->
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
