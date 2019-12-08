<%@ page pageEncoding="UTF-8" contentType="text/html; utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="page" var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${path}/css/style.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			$(function () {
				$("#uname").blur(function () {
					// console.log("username:"+$(this).val());
					if ($(this).val()==""){
						$("#userMesg").html($("<font color='red'>请输入账号</font>"));
					}else{
						$("#userMesg").html($("<font color='#90ee90'>OK</font>"));
					}
				});

				$("#upwd").blur(function () {
					// console.log("username:"+$(this).val());
					if ($(this).val()==""){
						$("#pwdMesg").html($("<font color='red'>请输入密码</font>"));
					}else{
						$("#pwdMesg").html($("<font color='#90ee90'>OK</font>"));
					}
				});
			});
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form action="${path}/user/login" method="post">

						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td><span></span></td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="uname"/>
								</td>
								<td>
									<span id="userMesg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" id="upwd"/>
								</td>
								<td>
									<span id="pwdMesg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="${path}/user/security" onclick="document.getElementById('num').src = '${path}/user/security?'+(new Date()).getTime()"/>
									<a href="javascript:;" onclick="document.getElementById('num').src = '${path}/user/security?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="security" />
								</td>
							</tr>

						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
