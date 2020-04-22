<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
      <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
      <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>

    <title>My JSP 'msg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>${msg}</h1>
<ul>
  <li><a href="index">主页</a></li>
  <li><a href="login">登录</a></li>
  <li><a href="regist">注册</a></li>
</ul>
  </body>
</html>
