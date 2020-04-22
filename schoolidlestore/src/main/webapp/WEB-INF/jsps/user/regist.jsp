<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

	  <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
	  <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
	  <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>
	  <link href="<c:url value="/static/css/login.css"/>"  rel="stylesheet">

    <title>注册</title>
    
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
  <%-- 1.显示输入验证的错误 errors 
       2.显示可能抛出的异常错误 msg
       3. 回显form --%>
  <p id="titlelogin">注册</p>

<form action="${pageContext.request.contextPath }/user/registuser" method="post" class="form-group" id="registform">

	Username：<input type="text" name="username" value="${form.username}" class="form-control" placeholder="请输入用户名"/>
	<span style="color: red; font-weight: 900">${errors.username}</span><br/>
	Password：<input type="password" name="password" value="${form.password}" class="form-control" placeholder="请输入密码"/>
	<span style="color: red; font-weight: 900">${errors.password }</span><br/>
	Email：<input type="text" name="email" value="${form.email}" class="form-control" placeholder="请输入邮箱"/>
	<span style="color: red; font-weight: 900">${errors.email }</span><br/>
	<input type="submit" value="注册" class="form-control"/>
</form>
  </body>
</html>
