<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
$(function(){
	$("#a").click(function(){
		var value = $("#aa").val();
		$.ajax({
			type:"post",
			async:true,
			url:"TestAjaxServlet",
			data:"a="+value,
			success:function(result){
				$("#bb").html(result);
			},
			error:function(){
				alert("失败");
			}
		})
	})
})
</script>
</head>
<body>
<input id="a" type="button" value="按钮">
<input type="text" id="aa">
<div id="bb" style="background-color: yellow;"></div>

</body>
</html>