<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
		</tr>
		<tr>
			<td height="33"><table width="100%" border="0" align="center"
					cellpadding="0" cellspacing="0" class="right-font08">
					<tr>
						<td width="50%">共 <span class="right-text09">${requestScope.pageUtil.pageCount}</span>
							页 | 第 <span class="right-text09">${requestScope.pageUtil.currentPage}</span>
							页
						</td>
						<td width="49%" align="right">[<a
							href="${pageContext.request.contextPath }/${path }?currentPage=1"
							class="right-font08">首页</a> | <a
							href="${pageContext.request.contextPath }/${path }?currentPage=${requestScope.pageUtil.currentPage==1?1:requestScope.pageUtil.currentPage-1}"
							class="right-font08">上一页</a> | <a
							href="${pageContext.request.contextPath }/${path }?currentPage=${requestScope.pageUtil.currentPage==requestScope.pageUtil.pageCount?requestScope.pageUtil.pageCount:requestScope.pageUtil.currentPage+1}"
							class="right-font08">下一页</a> | <a
							href="${pageContext.request.contextPath }/${path }?currentPage=${requestScope.pageUtil.pageCount}"
							class="right-font08">末页</a>] 转至：
						</td>
						<td width="1%"><table width="20" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td width="1%"><input id="cp" type="text"
										class="right-textfield03" size="1" /></td>
									<td width="87%"><input id="btn" name="Submit23222"
										type="button"
										onclick="goPage(${requestScope.pageUtil.pageCount})"
										class="right-button06" />
									<script>
									function goPage(countPage){
										var currentPage = document.getElementById("cp").value;
										if(isNaN(currentPage)){
											alert("请确保你所输入的是数字！");
											
										}else{
											if(currentPage>0 && currentPage <=countPage){
												location.href="${pageContext.request.contextPath }/${path }?currentPage="+currentPage;
											}else{
												alert("请输入有效数字！");
											}
										}
									}
									</script>	
									</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>