<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/ck_login.js"></script>
</head>

<body>
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>
		<div id="navbar">
			<form method="get" name="search" action="servlet/doBookListServlet">
				搜索：<input class="input-text" type="text" name="bookName"
					value='' /><input
					class="input-btn" type="submit" name="submit" value='' />
			</form>
		</div>
	</div>
	<div id="login">
		<h2>用户登陆</h2>
		<form method="post" action="servlet/doLoginServlet">
			<dl>
				<dt>用户名：</dt>
				<dd>
					<input class="input-text" type="text" name="userName"
						id="loginNameId" onfocus="change();" />
				<dt>密 码：</dt>
				<dd>
					<input class="input-text" type="password" name="password"
						id="loginPassword" onfocus="change();" />
				<dt></dt>
				<dd class="button">
					<input class="input-btn" type="submit" name="submit" value="" /> <input
						class="input-reg" type="button" name="register" value=""
						onclick="window.location='/bookStore/jsp/register.jsp';" />
				</dd>
			</dl>
			<div align="center"
				<c:if test="${not empty requestScope.msg}">style="border: 1px red solid"</c:if>>
				<font color="red"> <c:if test="${not empty requestScope.msg}">${requestScope.msg}</c:if>
				</font>
			</div>
		</form>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>
