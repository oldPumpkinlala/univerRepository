<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <base href="">


      <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
      <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
      <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>

    <title>body</title>
    
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
 body{
  background-color: white;
 }
</style>
  </head>
  
  <body>
  <c:choose>
     <c:when test="${empty sessionScope.session_user.username}">
       <h1>您现在是游客身份</h1>
     </c:when>
     <c:otherwise>
        <h1 align="center">欢迎您：${sessionScope.session_user.username}  使用校园闲置物品交易系统</h1>
     </c:otherwise>
  </c:choose>
    
  </body>
</html>
