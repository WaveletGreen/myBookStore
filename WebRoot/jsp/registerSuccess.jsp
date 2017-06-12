<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	if (request.getAttribute("registSucz") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'registerSuccess.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>

<body>
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>
		<div id="navbar">
			<form method="get" name="search" action="servlet/doBookListServlet">
				搜索：<input class="input-text" type="text" name="bookName" value='' /><input
					class="input-btn" type="submit" name="submit" value='' />
			</form>
		</div>
	</div>
	<div id="register">
		<div class="title">
			<h2>欢迎注册网上书城</h2>
		</div>
		<div class="steps">
			<ul class="clearfix">
				<li class="past">1.填写注册信息</li>
				<li class="last">2.注册成功</li>
			</ul>
		</div>
		<div class="success">
			<div class="information">
				<p>恭喜：注册成功！</p>
				<p>
					<a href="servlet/toIndexServlet">点此进入商城购物&gt;&gt;</a>
				</p>
			</div>
		</div>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>
