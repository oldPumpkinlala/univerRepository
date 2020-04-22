<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <script src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
	  <link href="<c:url value="/static/css/bootstrap.min.css"/>"  rel="stylesheet">
	  <script src="<c:url  value="/static/js/bootstrap.min.js"/>"></script>
    <title>main</title>
    
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
		}
		body{
		    background-color: #9B90C2;
		}
		.table{
			width:100%;
			height:100%;
			
		    border-collapse: collapse;/*单线的列表边框*/
		}
	.table td{
		border:1px solid ;
		border-color: rgb(155,144,194)/*固定边框,1像素*/
		} 
		iframe {
			width: 100%;
			height: 100%;
			
			
		}
		
		
/* 	.col-md-2{  */
		  
/* 		  margin: -2px; */
/*  		  padding: -2px;  */
/* 		}  */
/* 		.col-md-10{ */
/* 		 margin: -2px; */
/* 		  padding: -2px; */
/* 		} */
	</style>
  </head>
  
<!--   <body> -->
<!--   <div class="container"> -->
<!--   <div class="row"> -->
<!--     <div class="col-md-12"> -->
<%--       <iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top" id="top"></iframe> --%>
<!--       </div> -->
<!--   </div> -->
<!--   <div class="row"> -->
<!--      <div class="col-md-2"> -->
<%--         	<iframe frameborder="0" id="left" src="<c:url value='/CategoryServlet?method=findAll'/>" name="left"></iframe>  --%>
<!--      </div> -->
<!--      <div class="col-md-10"> -->
<%--      	<iframe frameborder="0"  id="body" src="<c:url value='/jsps/body.jsp'/>" name="body"></iframe> --%>
<!--      </div> -->
<!--   </div> -->
<!-- </div> -->



<table class="table" align="center">
<!-- 	<tr style="background: red;"> -->
	<tr>
		<td colspan="2" align="center" height="65">

			<iframe frameborder="0" src="top" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td width="250"  align="center" valign="top">
			<iframe frameborder="0" width="200px" src="findallcategory" name="left"></iframe>
		</td>
		<td>
			<iframe frameborder="0" src="body" name="body"></iframe>
		</td>
	</tr>
</table>
  </body>
</html>
