<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-后台左侧菜单栏</title>
<link href="${pageContext.request.contextPath}/back/css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
	function tupian(idt) {
		var nametu = "xiaotu" + idt;
		var tp = document.getElementById(nametu);
		tp.src = "images/ico05.gif";//图片ico04为白色的正方形

		for (var i = 1; i < 30; i++) {

			var nametu2 = "xiaotu" + i;
			if (i != idt * 1) {
				var tp2 = document.getElementById('xiaotu' + i);
				if (tp2 != undefined) {
					tp2.src = "images/ico06.gif";
				}//图片ico06为蓝色的正方形
			}
		}
	}

	function list(idstr) {
		var name1 = "subtree" + idstr;
		var name2 = "img" + idstr;
		var objectobj = document.all(name1);
		var imgobj = document.all(name2);

		//alert(imgobj);

		if (objectobj.style.display == "none") {
			for (i = 1; i <= 6; i++) {
				var name3 = "img" + i;
				var name = "subtree" + i;
				var o = document.all(name);
				if (o != undefined) {
					o.style.display = "none";
					var image = document.all(name3);

				}
			}
			objectobj.style.display = "";
		} else {
			objectobj.style.display = "none";
		}
	}
</SCRIPT>
<body>
	<table width="198" border="0" cellpadding="0" cellspacing="0"
		class="left-table01">
		<tr>
			<TD>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="207" height="55" background="../images/nav01.gif">
							<table width="90%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="25%" rowspan="2"><img src="images/ico02.gif"
										width="35" height="35" /></td>
									<td width="75%" height="22" class="left-font01">您好，<span
										class="left-font02">${sessionScope.admin.a_name}</span></td>
								</tr>
								<tr>
									<td height="22" class="left-font01">[&nbsp;<a
										href="${pageContext.request.contextPath}/back/login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table> 
				<!--  用户信息开始    -->
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img8" id="img8"
										src="images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('5');">用户管理</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</TABLE>
				<table id="subtree5" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="21"><img id="xiaotu21"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%">
						<a href="${pageContext.request.contextPath }/BackUserListServlet" target="mainFrame"
							class="left-font03" >用户信息查看
						</a>
						</td>
					</tr>
				</table>
				<!--  用户信息结束    -->
				<!--  图书类型信息开始    -->
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img1" id="img1"
										src="images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('1');">图书类型管理</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</TABLE>
				<table id="subtree1" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu1"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="${pageContext.request.contextPath }/BackShowBookKindListServlet" target="mainFrame"
							class="left-font03">图书类型信息查看</a></td>
					</tr>

				</table>
				<!--  图书类型信息结束    -->
				<!--  图书信息开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29"><table width="85%" border="0" align="center"
								cellpadding="0" cellspacing="0">
								<tr>
									<td width="8%" height="12"><img name="img2" id="img2"
										src="images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('2');">图书管理</a></td>
								</tr>
							</table></td>
					</tr>
				</table>

				<table id="subtree2" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">

					<tr>
						<td width="9%" height="20"><img id="xiaotu7"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="${pageContext.request.contextPath }/BackShowBooksListServlet"
							target="mainFrame" class="left-font03" >图书信息查看</a></td>
					</tr>
				</table> 
				<!--  图书信息结束    --> 
				<!--  订单信息开始    -->
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img7" id="img7"
										src="images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('4');">订单管理</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</TABLE>
				<table id="subtree4" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">

					<tr>
						<td width="9%" height="20"><img id="xiaotu24"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="${pageContext.request.contextPath }/BackShowOrdersListServlet" target="mainFrame"
							class="left-font03" onClick="tupian('24');">订单信息列表 </a></td>
					</tr>
				</table>
				<!--  订单信息结束    -->
				<!-- 留言信息开始 -->
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img9" id="img9"
										src="images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('6');">留言管理</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</TABLE>
				<table id="subtree6" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="22"><img id="xiaotu22"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="messageList.html" target="mainFrame"
							class="left-font03">留言信息查看</a></td>
					</tr>
				</table> 
				<!-- 留言信息结束 -->
				<!--个人信息管理开始-->
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img9" id="img9"
										src="images/ico04.gif" width="8" height="11" /></td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('3');">个人管理</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</TABLE>
				<table id="subtree3" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="22"><img id="xiaotu22"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="administratorDetail.htm"
							target="mainFrame" class="left-font03">个人信息查看</a></td>
					</tr>
					<tr>
						<td width="9%" height="22"><img id="xiaotu22"
							src="images/ico06.gif" width="8" height="12" /></td>
						<td width="91%"><a href="editAdministrator.htm"
							target="mainFrame" class="left-font03">个人信息修改</a></td>
					</tr>
				</table>
				<!--  个人信息结束    -->
			</TD>
		</tr>

	</table>
</body>
</html>