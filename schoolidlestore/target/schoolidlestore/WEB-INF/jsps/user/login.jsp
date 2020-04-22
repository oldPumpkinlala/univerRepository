<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
<script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
<link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
<script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>

<link href="<c:url value="/static/css/login.css"/>"  rel="stylesheet">
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

	#titlelogin{
		position:relative;
		color:black;
		 font-family: sans-serif;
		 top:30px;
		 left:600px;
		 font-size:40px;
	}
</style>
  </head>
  
  <body>
  <p id="titlelogin">登录</p>


<form action="loginuser" method="post" target="_top" class="form-group" id="loginform">
<input type="hidden" name="method" value="login">
	Username：<input type="text" name="username" value="${form.username }" class="form-control" placeholder="请输入用户名"/>
	<span style="color:red">${errors.username}</span><br/>
	Password：<input type="password" name="password" value="${from.password }"class="form-control" placeholder="请输入密码"/>
	<span style="color:red">${errors.password}</span><br/>
	</br>
	<p style="color: red; font-weight: 900">${msg }</p>
	<input type="submit" value="登录"  class="form-control" />
</form>
</div>
  </body>
</html>
