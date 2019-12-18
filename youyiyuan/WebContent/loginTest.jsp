<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证测试</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js" ></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<h3>${mess }</h3>
	<form action="login.action" method="post">
		<table>
			<tr>
				<td></td>
				<td><h3>请登陆用户名</h3></td>
				<td></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="uname" /></td>
				<td></td>
			</tr>
			<tr>
				<td>密&nbsp;码：</td>
				<td><input type="password" name="pwd" /></td>
				<td></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="verifyCode" id="valueCode" /></td>
				<td>
					<img id="code" src="ValidateCodeServlet">
					<a class="a_code" href="javascript:changeCode()">换一张</a>
					<script>
					 function changeCode(){
						 var img = document.getElementById('code');
				    	 img.src="${pageContext.request.contextPath}/ValidateCodeServlet?a="+new Date().getTime();
					  }
					</script>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" name="login" value="登陆"/><input type="button" name="register" value="注册"/></td>
				<td></td>
			</tr>
			
		</table>
	</form>
</body>
</html>