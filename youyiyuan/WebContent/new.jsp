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
	
	<!--焦点图区域-->
	<div class="banbox">
		<ul class="ban-img">
			<li><img src="images/news/ban-3.jpg"></li>
			<li><img src="images/news/ban-2.jpg"></li>
			<li><img src="images/news/ban-1.jpg"></li>
		</ul>
		<!--小圆圈盒子-->
		<div class="ban-yq">
			<a href="#" class="ban-yqa"></a>
			<a href="#"></a>
			<a href="#"></a>
		</div>
		<!--左右按钮-->
			<i class="fa fa-chevron-left l-bnt" aria-hidden="true"></i>
			<i class="fa fa-chevron-right r-bnt" aria-hidden="true"></i>
	</div>
	<!--筛选区域-->
	<div class="shuax">
		<!--下拉选项-->
		<div class="xialasx">
			<p>筛选：</p>
			<select>
				<option>2016年</option>
				<option>2015年</option>
				<option>2014年</option>
				<option>2013年</option>
			</select>
			<select>
				<option>10-12月</option>
				<option>7-9月</option>
				<option>4-6月</option>
				<option>1-3月</option>
			</select>
			<select>
				<option>视频</option>
				<option>文章</option>
				<option>图片</option>
			</select>
		</div>
		<div class="xlss">
				<input type="text" placeholder="请输入关键字">
				<input type="button" value="搜索">
		</div>
		<ul class="moshi">
			<li>列表模式</li>
			<li>图文模式</li>
		</ul>
	</div>
	
	<!--新闻列表区域-->
	<div class="newsbox" id="newsbox">
		<!--11月-->
		<div class="new">
			<p class="yuefen">=================================================Java=================================================</p>
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
			<!--展--------开------------之--------------后-->
			<ul class="yczq1">
				<li>
					<a href=""><img src="images/news/new3-1.jpg" width="450px" height="250px"></a>
					<p class="wen-bt">木地酒庄新酿酒点成功建好，预计今年年底投入运营，供应不足的将不再是木地酒庄的软骨</p>
					<div class="new-hover">
						<p>2016年10月20日正午12时巴拿马万国博览会在旧金山开幕。旧金山市市长Rolph在开幕式上发表演讲，美国总统伍德罗·威尔逊到会致贺词。美国副总统托马斯·马歇尔及前总统西奥多·罗斯福等国家政要亲临会场助兴。
博览会开幕的第一天，参观者如潮水涌动，络绎不绝地进入展馆，人数超过20万。出于对古老中国的神秘、好奇感的驱使，当天到中国馆参观的人数达8万人之多.... ....<br>
					</p>
					<a href="xwxq.jsp">查看详情</a>
					</div>
				</li>
				<li>
					<a href=""><img src="images/news/new3-2.jpg" width="450px" height="250px"></a>
					<p class="wen-bt">2016年，其酒瓶背标上的广告语写着解放前曾在巴拿马赛会评为世界名酒第二位，这显然不是金奖</p>
					<div class="new-hover">
						<p>2016年10月20日正午12时巴拿马万国博览会在旧金山开幕。旧金山市市长Rolph在开幕式上发表演讲，美国总统伍德罗·威尔逊到会致贺词。美国副总统托马斯·马歇尔及前总统西奥多·罗斯福等国家政要亲临会场助兴。
博览会开幕的第一天，参观者如潮水涌动，络绎不绝地进入展馆，人数超过20万。出于对古老中国的神秘、好奇感的驱使，当天到中国馆参观的人数达8万人之多.... ....<br>
					</p>
					<a href="xwxq.jsp">查看详情</a>
					</div>
				</li>
			</ul>
			<a class="zhankai1">---------------展开---------------<br><i class="fa fa-angle-double-down" aria-hidden="true"></i></a>
			<a class="shouqi1">---------------收起---------------<br><i class="fa fa-angle-double-up" aria-hidden="true"></i></a>
		</div>
			<!--10月-->
		<!--09月-->
	
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
