<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游弋苑-注册</title>
<link rel="stylesheet" href="css/style1.css">
<script type="text/javascript" src="js/check_register.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<!--背景-->
	<div class="wel" id="background-3"></div>
	<!--左右两边云-->
	<div class="wel" id="box" style="">
		<div class="box-1 lefp"></div>
		<div class="box-1">
			<div class="righp"></div>
		</div>
	</div>
	<!--荧光点点-->
	<div class="wel" id="git"></div>
	<!--注册表-->
	<div class="wel" id="from">
		<div class="box-2 le-2">
			<form action="" method="post" onsubmit="return check()" id="form">
				<div class="flrg-1">
					<h3>注册</h3>
					<div class="a">
						<input type="text" class="in-1" placeholder="您的用户名"
							name="username" id="username" onblur="checkNotName()"> <br>
						<font color="red" id="usernameError"></font>
					</div>
					<div class="a">
						<input type="password" class="in-1" placeholder="输入密码" name="pwd"
							id="pwd" onblur="checkPwd()"> <br> <font
							color="red" id="pwdError"></font>
					</div>
					<div class="a">
						<input type="password" class="in-1" placeholder="再次确认密码"
							name="repwd" id="rePwd" onblur="checkRePwd()"> <br>
						<font color="red" id="rePwdError"></font>
					</div>
					<div class="a">
						<input type="text" class="in-1" placeholder="输入手机号码" name="phone"
							id="phone" onblur="checkPhone()"> <br> <font
							color="red" id="phoneError"></font>
					</div>
					<div class="a">
						<input type="email" class="in-1" placeholder="输入邮箱地址" name="email"
							id="email" onblur="checkEmail()"> <br> <font
							color="red" id="emailError"></font>
					</div>
					<div class="a">
						<input type="text" class="in-1" placeholder="邮箱验证码" name="eCode"
							id="eCode"> <br> <font color="red" id="eCodeError"></font>
					</div>
					<div class="a">
						<input type="button" id="send" value="发送邮箱验证码">
					</div>
					<div class="a">
						<input type="button" id="btn" style="text-align: center;"
							value="注册">
					</div>
					<script>
	                $("#send").click(function(){
	            		alert('发送验证码');
	            		var email = $("#email").val();
	            		var result = "ok";
	            		$.ajax({
	            			type:"post",
	            			async:true,
	            			url:"SendEmailVilidataCodeServlet",
	            			data:"firstEmail="+email,
	            			dataType:"json",
	            			success:function(sendResult){
	            				if(result==sendResult){
	            					alert("已发送成功，注意查收");
	            				}else{
	            					$("#send").val("请重新发送");
	            				}
	            			},
	            			error:function(){
	            				alert("发送验证码失败");
	            			}
	            		})
	            	});
                </script>
					<script>
		                $("#btn").click(function(){
		                	var username = $("#username").val();
		            		var pwd = $("#pwd").val();
		            		var rePwd = $("#rePwd").val();
		            		var phone = $("#phone").val();
		            		var eCode = $("#eCode").val();
		            		var email = $("#email").val();
		            		var result = "ok";
		            		$.ajax({
		            			type:"post",
		            			async:true,
		            			url:"RegisterServlet",
								data:"username="+username+"&pwd="+pwd+"&rePwd="+rePwd+"&eCode="+eCode+"&email="+email+"&phone="+phone,
		            			dataType:"json",
		            			success:function(resultFinal){
		            				if(result==resultFinal){
										alert(resultFinal);
										window.location.href="login.jsp";
									}else{
										$("#eCodeError").html(resultFinal);
									}
		            			},
		            			error:function(){
		            				alert("注册失败");
		            			}
		            		})
		            	});
                </script>
				</div>
			</form>
		</div>
	</div>
</body>
</html>