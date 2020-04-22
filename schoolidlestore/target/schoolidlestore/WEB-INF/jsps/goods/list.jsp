<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品列表</title>

      <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
      <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
      <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>

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
	body {
		font-size: 10pt;
		background-color: white;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>

  <c:forEach items="${booklist }" var="book">
      <div class="icon">
    <a href="<c:url value='/BookServlet?method=load&bid=${book.bid }'/>"><img src="<c:url value='/${book.image}'/>" border="0"/></a>
      <br/>
     	<a href="<c:url value='/BookServlet?method=load&bid=${book.bid }'/>">${book.bname}</a>
     </div>
  </c:forEach>
  

  
  </body>
 
</html>

