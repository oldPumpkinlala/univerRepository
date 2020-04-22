<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

      <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
      <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
      <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>
    <title>left</title>
    
    
    <base target="body"/>
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
		*{
			font-size:10pt;
			text-align: center;
			margin: 0px;
			padding:0px;
		}


		body{
		background-color: white;
		}
        .list-group{
        position: relative;
        top:10px;
        }

	</style>
  </head>
  
  <body>



<div class="col-xs-110 col-sm-8 sidebar-offcanvas"  role="navigation">
   <div class="list-group">
   <a href="<c:url value=''/>" class="list-group-item">全部分类</a>
    <c:forEach  items="${categorylist }" var="category">
   
	<a href="<c:url value=''/>" class="list-group-item">${category.cname}</a>
    
</c:forEach>
    </div>
</div>
  </body>
</html>
