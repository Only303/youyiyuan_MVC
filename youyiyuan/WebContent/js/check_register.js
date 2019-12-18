/*正则表示工具*/
/*不为空的用户名校验*/
function checkNotName(){
	var value = document.getElementById("username").value;
	if(value==null || value==""){
		document.getElementById("usernameError").innerHTML="用户名不能为空！";
		return false;
	}else{
		document.getElementById("usernameError").innerHTML="";
	}
	return true;
}

//登录时密码不能为空的校验
function checkLPWD(){
	//第一次密码
	var value = document.getElementById("lpwd").value;
	if(value==null || value==""){
		document.getElementById("passwordError").innerHTML="密码不能为空！";
		return false;
	}else{
		document.getElementById("passwordError").innerHTML="";
	}
	return true;
}

/*
 * 校验密码
 * 密码强度正则，
 * 最少6位，
 * 包括至少1个大写字母，
 * 1个小写字母，
 * 1个数字，
 * 1个特殊字符
*/
function checkPwd(){
	//第一次密码
	var value = document.getElementById("pwd").value;
	var reg = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
	if(!reg.test(value)){
		document.getElementById("pwdError").innerHTML="密码不合法！";
		return false;
	}else{
		document.getElementById("pwdError").innerHTML="";
	}
	return true;
}

/*二次密码校验*/
function checkRePwd(){
	//第一次密码
	var value = document.getElementById("pwd").value;
	//确认密码
	var repwd = document.getElementById("rePwd").value;
	if(repwd != value && value.length == 0 && repwd.length == 0){
		document.getElementById("rePwdError").innerHTML="两次密码不匹配！";
		return false;
	}else{
		document.getElementById("rePwdError").innerHTML="";
	}
	return true;
}

/*邮箱校验*/
function checkEmail(){
	var value = document.getElementById("email").value;
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if(!reg.test(value)){
		document.getElementById("emailError").innerHTML="邮箱不合法！";
		return false;
	}else{
		document.getElementById("emailError").innerHTML="";
	}
	return true;
}

/*校验QQ号*/
function checkQQ(){
	var value = document.getElementById("qq").value;
	var reg = /^[1-9][0-9]{4,10}$/;
	if(!reg.test(value)){
		document.getElementById("qqError").innerHTML="QQ号输入有误！";
		return false;
	}else{
		document.getElementById("qqError").innerHTML="";
	}
	return true;
}

/*手机号校验*/
function checkPhone(){
	var value = document.getElementById("phone").value;
	var reg = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[0-9])|(18[0,5-9]))\d{8}$/;
	if(!reg.test(value)){
		document.getElementById("phoneError").innerHTML="手机号输入有误！";
		return false;
	}else{
		document.getElementById("phoneError").innerHTML="";
	}
	return true;
}

/*校验url*/
function checkUrl(){
	var value = document.getElementById("url").value;
	var reg = /^((https?|ftp|file):\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/;
	if(!reg.test(value)){
		document.getElementById("urlError").innerHTML="url不合法！";
		return false;
	}else{
		document.getElementById("urlError").innerHTML="";
	}
	return true;
}

function clearError(){
	document.getElementById("verifyCode").value="";
	document.getElementById("verifyCodeError").innerHTML="";
}

//登录时的校验
function checkLogin(){
	if(checkNotName() && checkLPWD()){
		return true;
	}
	return false;
}

//注册时的校验
function check(){
	if(checkNotName() && checkPwd() && checkRePwd() && checkEmail() && checkPhone()){
		return true;
	}
	return false;
}