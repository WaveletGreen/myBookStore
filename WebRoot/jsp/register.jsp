<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript" src="js/ck_register.js"></script>
</head>
<body onload="unselectLicensr()">
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
	<div id="register">
		<div class="title">
			<h2>欢迎注册网上书城</h2>
		</div>
		<div class="steps">
			<ul class="clearfix">
				<li class="current">1.填写注册信息</li>
				<li class="unpass">2.注册成功</li>
			</ul>
		</div>
		<form action="servlet/doRegisterServlet" method="post"
			onsubmit="return checkAll();">
			<dl>
				<dt>用 户 名：</dt>
				<dd>
					<input class="input-text" type="text" value="请输入用户名"
						name="userName" id="userNameId" onfocus="change();"
						onblur="checkName();" onfocus="msgDispear('f_userNameMsg')" />
					<p id="userNameMsg">
						<font color="red" id="f_userNameMsg"> <%
 	if (request.getAttribute("msg") != null) {
 %> <%=request.getAttribute("msg")%> <%
 	}
 %>
						</font>
					</p>
				</dd>

				<dt>密 码：</dt>
				<dd>
					<input class="input-text" type="password" name="password"
						id="passWordId" onblur="checkPassWord();"
						onfocus="msgDispear('passWordMsg')" />
					<p id="passWordMsg"></p>
				</dd>

				<dt>确认密码：</dt>
				<dd>
					<input class="input-text" type="password" name="rePassword"
						id="rePassWordId" onblur="checkRePassword();"
						onfocus="msgDispear('rePassWordMsg')" />
					<p id="rePassWordMsg"></p>
				</dd>

				<dt>Email地址：</dt>
				<dd>
					<input class="input-text" type="text" name="email" id="emailId"
						onblur="checkemail();" onfocus="msgDispear('emailMsg')" />
					<p id="emailMsg"></p>
				</dd>

				<dt>用户协议：</dt>
				<dd>
					<label for="textarea"></label>
					<textarea name="textarea" id="textarea" cols="40" rows="3"
						style="overflow:scroll; value=" readonly="readonly">
			  ......................................................................这是协议内容，提交前请认真阅读</textarea>
				</dd>

			</dl>
			<dl>
				<dt></dt>
				<dd class="button">
					<input type="submit" value="提交" id="submit1" disabled="disabled" />
					<input type="reset" name="重置" value="重置" /> <input type="checkbox"
						id="checkOption" onclick="agree();" value="同意协议" />同意协议
				</dd>
			</dl>
		</form>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>
