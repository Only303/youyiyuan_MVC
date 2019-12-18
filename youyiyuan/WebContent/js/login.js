$(function(){
	$("table").css({"border":"1px solid red","margin":"0px auto"});
	
	$("input[name='register']").click(function(){
		window.location = "register.jsp";
	});
	
	$("form").submit(function(){
		var uname=$("input[name=uname]").val();
		var pwd=$("input[name=pwd]").val();
		if(uname==""||uname==null){
			alert("用户名不能为空！");
			return false;
		}else if(pwd==""||pwd==null){
			alert("密码不能为空！");
			return false;
		}else{
			var code = $("input[name=verifyCode]").val();
			var flag = true;
			if(code == ""){
				alert("验证码不能为空！");
				return false;
			}else{
				$.ajax({
					url:"ValidateCodeServlet",
					type:"post",
					data:{"verifyCode":code},
					dataType:"text",
					async:false,
					success:function(result){
						if(result == "false"){
							alert("验证码输入不正确!");
							flag = false;
						}
					}
				});
				
				return flag;
			}
		}
	});
	/*// 刷新验证码
	$("#refresh").unbind("click").bind("click", function(){
		$("#code").attr("src", "verify/code.action?r=" + Math.random());
		$("#code").attr("src", "ValidateCodeServlet?="+new Date());
	});*/
});