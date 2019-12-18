<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-后台订单展示</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jedate.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jedate.js"></script>
</head>
<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function selectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "sendxiaoxi.htm";
		document.getElementById("fom").submit();
	}

	function on_load() {
		var loadingmsg = document.getElementById("loadingmsg");
		var mainpage = document.getElementById("mainpage");
		loadingmsg.style.display = "";
		mainpage.style.display = "none";

		loadingmsg.style.display = "none";
		mainpage.style.display = "";
	}
</SCRIPT>
<style>
.datainp {
	width: 200px;
	height: 30px;
	border: 1px #ccc solid;
}

.datep {
	margin-bottom: 40px;
}
</style>
<body onload="on_load()">
	<form name="fom" id="fom" method="post" action="">
		<table id="mainpage" width="100%" border="0" cellspacing="0"
			cellpadding="0">

			<tr>
				<td height="30"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td height="62" background="../images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21"><img src="images/ico07.gif" width="20"
											height="18" /></td>
										<td width="550">查看内容：按时间： <input class="datainp"
											id="start" type="text" placeholder="请选择" readonly> <span
											class="newfont06">至</span> <input class="datainp" id="end"
											type="text" placeholder="请选择" readonly> <input
											name="Submit" type="button" class="right-button02"
											value="查 询" /> <script type="text/javascript">
												jeDate({
													dateCell : "#start",
													format : "YYYY年MM月DD日 hh:mm:ss",
													isinitVal : true,
													isTime : true, //isClear:false,
													minDate : "2014-09-19 00:00:00",
													okfun : function(val) {
														alert(val)
													}
												})

												jeDate(
														{
															dateCell : "#end",
															format : "YYYY年MM月DD日 hh:mm:ss",
															isinitVal : true,
															isTime : true, //isClear:false,
															minDate : "2014-09-19 00:00:00",
															okfun : function(
																	val) {
																alert(val)
															}
														})
											</script>
										</td>
										<td width="132" align="left">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY:" width="100%"
						border="0" cellspacing="0" cellpadding="0">

						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">

									<tr>
										<td height="20"><span class="newfont07">选择：<a
												href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
											<input name="Submit" type="button" class="right-button08"
											value="删除所选订单" /></td>
									</tr>
									<tr>
										<td height="40" class="font42"><table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">

												<tr>
													<td height="20" colspan="8" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														消息总列表 &nbsp;</td>
												</tr>
												<tr>
													<td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
													<td width="15%" height="20" align="center"
														bgcolor="#EEEEEE">订单编号</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">订餐人</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">订餐电话</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">下单时间</td>
													<td width="8%" align="center" bgcolor="#EEEEEE">订单状态</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">总价</td>
													<td width="12%" align="center" bgcolor="#EEEEEE">操作</td>
												</tr>
												<!-- 循环开始 -->
												<c:forEach var="listPage"
													items="${requestScope.pageUtil.list }">
													<tr align="center">
														<td bgcolor="#FFFFFF"><input type="checkbox"
															name="delid" /></td>
														<td height="20" bgcolor="#FFFFFF">${listPage.oid }</td>
														<td bgcolor="#FFFFFF">${listPage.uname }</td>
														<td bgcolor="#FFFFFF">${listPage.uphone }</td>
														<td bgcolor="#FFFFFF">${listPage.otime }</td>
														<td bgcolor="#FFFFFF">${listPage.state}</td>
														<td bgcolor="#FFFFFF">${listPage.total}</td>
														<td bgcolor="#FFFFFF"><a href="editOrder.htm">编辑</a>|<a
															href="orderDetail.htm">查看</a>|<a href="#">删除</a></td>
													</tr>
												</c:forEach>
												<!-- 循环结束 -->
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table>
				<jsp:include page="page.jsp"></jsp:include>
				</td>
			</tr>
		</table>
	</form>

	<div id="loadingmsg"
		style="width: 100px; height: 18px; top: 0px; display: none;">
		<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
	</div>
	<script type="text/javascript">
		$("input[name='act_start_time'],input[name='act_stop_time']")
				.datetimepicker();
	</script>
	<script type="text/javascript">
		//jeDate.skin('gray');
		jeDate({
			dateCell : "#indate",//isinitVal:true,
			format : "YYYY-MM",
			isTime : false, //isClear:false,
			minDate : "2015-10-19 00:00:00",
			maxDate : "2016-11-8 00:00:00"
		})
		jeDate({
			dateCell : "#dateinfo",
			format : "YYYY年MM月DD日 hh:mm:ss",
			isinitVal : true,
			isTime : true, //isClear:false,
			minDate : "2014-09-19 00:00:00",
			okfun : function(val) {
				alert(val)
			}
		})

		//alert("YYYY/MM".match(/\w+|d+/g).join("-"))
	</script>
</body>
</html>
