<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
	  <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
	  <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>
    <title>购物车列表</title>
    
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
	* {
		font-size: 11pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='../../../static/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='../../../static/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	th{
	background-color:#9B90C2;
	}
</style>
  </head>
  
  <body>
  <h1>购物车</h1>
  <c:choose>
     <c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0 }">
         <img src="<c:url value='../../../static/images/cart.png'/>"  width="300"/><p><b>您还未添加商品！！！</b></p>
     </c:when>
<c:otherwise>
 
  


<table border="1" width="100%" cellspacing="0" background="black" class="table table-hover">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="<c:url value='CartServlet?method=clear'/>">清空购物车</a>
		</td>
	</tr>
	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
<c:forEach items="${sessionScope.cart.cartItems }"  var="cartitem">
	<tr>
		<td><div><img src="<c:url value='/${cartitem.book.image }'/>"/></div></td>
		<td>${cartitem.book.bname}</td>
		<td>${cartitem.book.author}</td>
		<td>${cartitem.book.price}</td>
		<td>${cartitem.count}</td>
		<td>${cartitem.subTotal}</td>
		<td><a href="<c:url value='/CartServlet?method=delete&bid=${cartitem.book.bid}'/>">删除</a></td>
	</tr>
</c:forEach>	
	
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			合计：${sessionScope.cart.totals }元
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="<c:url value='/OrderServlet?method=add'/>"></a>
		</td>
	</tr>
</table>

 </c:otherwise>
</c:choose>
  </body>
</html>
