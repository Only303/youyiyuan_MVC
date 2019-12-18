<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-后台用户编辑</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript" src="<script language="JavaScript" type="text/javascript">"></script>
<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

function link(){
	var uaddress = document.getElementById("uaddress").value;
	var uname = document.getElementById("uname").value;
	var upwd = document.getElementById("upwd").value;
	var uid = document.getElementById("uid").value;
   	location.href="BackUpdateUserByUid?uid="+uid+"&uname="+uname+"&upwd="+upwd+"&uaddress="+uaddress;
}
function backHome(){
	location.href="index.jsp";
}
</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="BackUpdateUserByUid" method="get" enctype="multipart/form-data" name="fom" id="fom" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >用户修改</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<input type="hidden" id="uid" value="${requestScope.user.uid}" />
				<legend>修改用户</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">用户名:</td>
					    <td width="43%"><input id="uname" name="uname" class="text" style="width:250px" type="text" size="40" value="${requestScope.user.uname }" />
				        </td>
					    <td align="right" width="17%">密码:</td>
					    <td width="27%"><input id="upwd" name="upwd" id="Input22" class="text"  style="width:250px" value="${requestScope.user.upwd }" /></td>
					    </tr>
					  <tr>
					    <td nowrap align="right">地址:</td>
					    <td colspan="3">
					    <textarea id="uaddress" name="uaddress" rows="10" cols="80" >${requestScope.user.uaddress}</textarea>
					    </td>
					    </tr>
					  </table>
			 <br />
				</fieldset></TD>
		</TR>
		
		</TABLE>
	 </td>
  </tr>
	<TR>
		<TD colspan="2" align="center" height="50px">
		<input id="btn" type="button" name="Submit" value="保存" class="button" onclick="link();"/>　
		<input type="button" id="btn2" name="Submit2" value="返回" class="button" onclick="backHome();"/></TD>
	</TR>
	</TABLE>
</div>
</form>
</body>
</html>
