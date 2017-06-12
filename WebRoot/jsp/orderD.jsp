<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>我的订单</title>

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
		<div id="presentUser" style="margin-left: 70%">
			<c:if test="${not empty sessionScope.loginedUser}">网上书城欢迎您，${sessionScope.loginedUser.userName}</c:if>
		</div>
		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li><a href="servlet/toIndexServlet">首页</a></li>
					<li class="current"><a href="servlet/orderServlet">我的订单</a></li>
					<li><a href="servlet/shoppingCartServlet">购物车</a></li>
					<li><a href="servlet/logoutServlet">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search" action="">
				搜索：<input class="input-text" type="text" name="keywords" /><input
					class="input-btn" type="submit" name="submit" value="" />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list orderList">
			<table>
				<c:if test="${empty sessionScope.orderDList}">
					<tr>
						<td>您最近没有订单，<a href="servlet/toIndexServlet">赶紧去购物吧</a></td>
					</tr>
				</c:if>
				<c:if test="${not empty sessionScope.orderDList}">
					<tr>
						<th class="orderId">订单编号</th>
						<th class="orderId">商品名称</th>
						<th class="price">单价</th>
						<th class="status">数量</th>
					</tr>
					<c:forEach items="${sessionScope.orderDlist}" var="item"
						varStatus="status">
						<tr class="title"
							<c:if test="${status.index%2!=0 }">class="odd"</c:if>>
							<td class="thumb">${item.order_id }</td>
							<td class="thumb">${item.odbook_name}</td>
							<td class="thumb">${item.odbook_price}</td>
							<td class="thumb">${item.odbook_amount}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<div class="page-spliter">
				<a href="#">&lt;</a> <a href="#">首页</a> <span class="current">1</span>
				<a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <span>...</span>
				<a href="#">尾页</a> <a href="#">&gt;</a>
			</div>
			<div class="button">
				<input class="input-gray" type="submit" name="submit"
					value="查看一个月前的订单" /><input class="input-gray" type="submit"
					name="submit" value="查看一个月前的订单" />
			</div>
		</div>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>
