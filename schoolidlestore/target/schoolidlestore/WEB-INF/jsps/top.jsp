<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
	<link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
	<script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>
<title>top</title>

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
/* nav { */
/* 	position: relative; */
/* 	top: 3px; */
/* 	border-radius: 10px; */
	
/* } */

/*  * {  */
/*  	margin: 0px;  */
/* 	padding: 0px;  */
/*  }  */

body {
	background-color: rgb(255, 255, 255);

}


 .navbar-brand{
 color: white;
}
.navbar .nav >li >a:visited{
color: white;
background-color: #0000ff;
}
.navbar .nav > li > a:hover {
color: white;
background-color: #000000;
}
.navbar .nav >li >a:active{
color: white;
background-color: #00ff00;
}

</style>


</head>



<c:choose>
	<c:when test="${empty sessionScope.session_user }">

		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				
				<a class="navbar-brand" href="#"> <img src="../static/images/home.png"
					height="22px" />
				</a> <a class="navbar-brand" href="#">校园闲置交易系统</a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand"
						href="login" target="_parent">登录</a></li>
					<li><a class="navbar-brand"
						href="regist" target="_parent">注册</a></li>
			</ul>
			</div>
		</div>
		</nav>

	</c:when>

	<c:otherwise>

		<nav class="navbar navbar-inverse  navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				
				<a class="navbar-brand" href="#"> <img src="../images/home.png"
					height="22px" />
				</a> <a class="navbar-brand" href="#">您好：${sessionScope.session_user.username}</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand"
						href="goodslist" target="body">我的购物车</a></li>
					<li><a class="navbar-brand"
						href="<c:url value=''/>"
						target="body">我的订单</a></li>





				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a class="navbar-brand"
						href="<c:url value=''/>" target="_top">退出</a></li>
				</ul>
			</div>
		</div>
		</nav>




	</c:otherwise>
</c:choose>





</body>
</html>
