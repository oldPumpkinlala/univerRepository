<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
      <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
      <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>
    <title>商品详细</title>
    
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
	#image {
		margin:20px;
		border: solid 2px #8B81C3;
		width: 150px;
		height: 155px;
		position: relative;
		top:80px;
		left:30px;
		
	}
	img{
	 position: relative;
	 left:20px;
	}
	li {
		margin: 10px;
	}
	a {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -70px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	a:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -106px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#main{
	position: absolute;
	left:300px;
	top:70px;
	}
</style>
  </head>
  
  <body>
  
  <div id="image">
    <img src="<c:url value='/${book.image }'/>" border="0"/>
  </div>
  <div id="main">
  <table  class="table table-bordered">
  <ul>
  
  <tr><td><li>书名：${book.bname}</li></td></tr>
  <tr><td><li>作者：${book.author }</li></td></tr>
  <tr><td> <li>单价：${book.price}</li></td></tr>

  </ul>
  </table>
  <form id="form" action="<c:url value='/CartServlet'/>" method="post">
  
  <input type="hidden" name="method" value="add"/>
       请选择数量：<input type="hidden" name="bid" value="${book.bid }"/><!-- 传递参数 -->
  
  	<input type="text" size="3" name="count" value="1"/>
  </form>
  <a href="javascript:document.getElementById('form').submit();"></a>
  
  </div>
  </body>
</html>
