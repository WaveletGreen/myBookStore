<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//String loginUser ="当前用户未登录";
	String loginUser = "<a href='/bookStore/jsp/login.jsp'>点击登陆</a>";
	if (session.getAttribute("loginedUser") == null && session.getAttribute("tourer") == null) {
		response.sendRedirect("../servlet/toIndexServlet");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>恭喜：购买成功！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
  <body>
<div id="header" class="wrap">
	<div id="logo"><div class="logo_1">LOGO</div><div class="logo_2">网上书城</div></div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li><a href="servlet/toIndexServlet">User首页</a></li>
				<li><a href="servlet/orderServlet">我的订单</a></li>
				<li class="current"><a href="servlet/shoppingCartServlet">购物车</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="success">
		<div class="information">
			<p>恭喜：购买成功！</p>
			<p><a href="servlet/orderServlet">点此查看订单&gt;&gt;</a></p>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
    网上书城 &copy; 版权所有
</div>
</body>
</html>
