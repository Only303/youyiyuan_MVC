<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-后台用户信息</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
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
		document.getElementById("fom").action = "addrenwu.htm";
		document.getElementById("fom").submit();
	}
</SCRIPT>
</head>
<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="../images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21"><img src="images/ico07.gif" width="20"
											height="18" /></td>
										<td width="538">查看内容：按用户名： <input name="textfield"
											type="text" size="12" /> <input
											name="Submit4" type="button" class="right-button02"
											value="查 询" /></td>
										<td width="144" align="left"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY:" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>
							<form name="fom" id="fom" method="post" action="${pageContext.request.contextPath }/BackDeleteUsersByUidServlet">
							<table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="20"><span class="newfont07">选择：<a
												href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
											<input type="submit" class="right-button08" value="删除所选用户" />
											</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size: 16px">用户列表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="4%" align="center" height="30">选择</td>
													<td width="10%">用户名</td>
													<td width="10%">注册时间</td>
													<td width="10%">家庭住址</td>
													<td width="12%">操作</td>
												</tr>
												<!-- 循环开始 -->
												<c:forEach var="pu" items="${requestScope.pageUtil.list}">
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" id="checkbox" name="checkbox" value="${pu.uid}" /></td>
														<td><a href="listmokuaimingxi.htm" onclick="">${pu.uname}</a></td>
														<td>2019-11-11</td>
														<td>${pu.uaddress}</td>
														<td><a
															href="${pageContext.request.contextPath }/BackShowUpdateUserByUid?uid=${pu.uid}">编辑|</a><a
															href="${pageContext.request.contextPath }/BackShowUserDetailByUidServlet?uid=${pu.uid}">查看</a></td>
													</tr>
												</c:forEach>
												<!-- 循环结束 -->
											</table>
										</td>
									</tr>
								</table>
							</form>
					<jsp:include page="page.jsp"></jsp:include>
				</td>
				</tr>
				</table>
			</tr>
		</table>
</body>
</html>
