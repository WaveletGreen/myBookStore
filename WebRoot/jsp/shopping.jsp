<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	if (session.getAttribute("loginedUser") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${sessionScope.loginedUser.userName}的购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/shoppingCartJs.js"></script>
</head>
<%
	//String loginUser ="当前用户未登录";
	String loginUser = "<a href='/bookStore/jsp/login.jsp'>点击登陆</a>";
	if (session.getAttribute("loginedUser") == null && session.getAttribute("tourer") == null) {
		response.sendRedirect("../servlet/toIndexServlet");
	}
%>
<body onload="checkValidate()">
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>
		<div id="presentUser" style="margin-left: 70%">
			<c:if test="${not empty sessionScope.loginedUser}">网上书城欢迎您，${sessionScope.loginedUser.userName}</c:if>
			<c:if test="${empty sessionScope.loginedUser}"><%=loginUser%></c:if>
		</div>
		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li><a href="servlet/toIndexServlet">首页</a></li>
					<li><a href="servlet/orderServlet">我的订单</a></li>
					<li class="current"><a href="servlet/shoppingCartServlet">${loginedUser.userName}购物车</a>
					</li>
					<li><a href="servlet/logoutServlet">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search" action="servlet/doBookListServlet">
				搜索：<input class="input-text" type="text" name="bookName" value='' /><input
					class="input-btn" type="submit" name="submit" value='' />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="post" name="shoping" action="servlet/getOrderServlet">

				<table>
					<c:if test="${empty sessionScope.shoppingCart}">
						<tr>
							<td>您的购物车还没有东西，<a href="servlet/toIndexServlet">继续购物</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${not empty sessionScope.shoppingCart}">
						<input type="hidden" name="orderStatus" value=1 />
						<input type="hidden" name="userName"
							value="${loginedUser.userName}" />
						<tr class="title">
							<th class="view">图片预览</th>
							<th>书名</th>
							<th class="nums">数量</th>
							<th class="price">价格&nbsp;&nbsp;&nbsp;&nbsp;</th>
						</tr>
						<c:forEach items="${sessionScope.shoppingCart}" var="item"
							varStatus="status">
							<c:set var="book" value="${item.key}" scope="page"></c:set>
							<tr <c:if test="${status.index%2!=0 }">class="odd"</c:if>>
								<td class="thumb"><img src="${book.pic_path}" /></td>
								<td class="title" id="bname${book.book_id }">${book.book_name
									}</td>
								<td><c:if test="${item.value !=0 }">
										<input type="button" name="button" value=" &ndash; "
											id="butSub${book.book_id}"
											onclick="chageAmount(${book.book_id},-1)" />
									</c:if>
									<c:if test="${item.value ==0 }">
										<input type="hidden" name="button" value=" &ndash; "
											id="butSub${book.book_id}"
											onclick="chageAmount(${book.book_id},-1)" />
									</c:if>
									<input class="input-text" id="${book.book_id }" type="text"
									name="nums" value="${item.value }"
									onfocus="getValidate(${book.book_id })"
									onblur="setValidate(${book.book_id })" /> <input type="button"
									name="button" id="butAdd${book.book_id}" value=" + "
									onclick="chageAmount(${book.book_id},1)" /></td>
								<td><input type="hidden" name="price" value=${book.price } />${book.price
									}&nbsp;<input
									type="button" name="button" value="删除"
									onclick="delItem(${book.book_id},1)" /></td>

							</tr>
						</c:forEach>
					</c:if>

				</table>
				<div class="button">

					<h4>
						<input type="hidden" name="totalCost" id="totalCost" value=0 />总价：￥<span
							id="cost">...</span>元
					</h4>
					<input class="input-chart" type="submit" name="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>

</body>
</html>
