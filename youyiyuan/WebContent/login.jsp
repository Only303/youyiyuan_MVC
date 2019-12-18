<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>游弋苑-登录窗口</title>
    <link rel="stylesheet" href="css/style1.css">
    <script type="text/javascript" src="js/check_register.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
</head>
<body>
<!--背景-->
<div class="wel" id="background-3"></div>
<!--左右两边云-->
<div class="wel" id="box" style="width: 100%;">
    <div class="box-1 lefp"></div>
    <div class="box-1">
        <div class="righp"></div>
    </div>
</div>
<!--荧光点点-->
<div class="wel" id="git"></div>
<!--登录注册表-->
<div class="wel" id="from">
    <div class="box-2 le-1">
        <form action="" method="post">
            <div class="flrg">
                    <h3>登录</h3>
                <div class="a">
                    <!--<label>账号：</label>-->
                    <input type="text" class="in-1" placeholder="请输入账号" name="username" id="username" onblur="checkNotName()">
                    <br>
                    <font color="red" id="usernameError"></font>
                </div>
                <div class="a">
                    <!--<label>密码：</label>-->
                    <input type="password" class="in-1" placeholder="请输入密码" name="password" id="lpwd" onblur="checkLPWD()">
                     <br>
                   	 <font color="red" id="passwordError"></font>
                </div>
                <div class="a">
                    <img id="code" src="ValidateCodeServlet">
					<a class="a_code" href="javascript:changeCode()">换一张</a>
               		<input type="text" name="verifyCode" id="verifyCode" class="in-1" placeholder="验证码"  onfocus="clearError()"/>
					 <font color="red" id="verifyCodeError"></font>
					<script>
					 function changeCode(){
						 var img = document.getElementById('code');
				    	 img.src="${pageContext.request.contextPath}/ValidateCodeServlet?a="+new Date().getTime();
					  };
					</script>
                </div>
                <div class="a">
                    <input type="button" id="btn" style="text-align: center;" value="登录">
                </div>
                <script>
                $(function(){
    				$("#btn").click(function(){
    					var username = $("#username").val();
    					var password = $("#lpwd").val();
    					var verifyCode = $("#verifyCode").val();
    					var img = $("#code").val();
    					var rs = "ok";
    					$.ajax({
    						type:"post",
    						async:true,
    						url:"LoginServlet",
    						data:"username="+username+"&password="+password+"&verifyCode="+verifyCode,
    						dataType:"json",//服务器放回数据类型
    						success:function(result){
    							if(result==rs){
    								window.location.href="main.jsp";
    							}else{
    								changeCode();
    								$("#verifyCodeError").html(result);
    							}
    						},
    						error:function(){
    							alert("登录失败");
    						}
    					})
    				});
    			})
                </script>
                <div class="a">
                    <div class="hr"></div>
                </div>
                <div class="a">
                    <a href="#">忘记密码？</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>