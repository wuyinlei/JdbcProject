<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
      <center>
  	   <h1>登陆页面</h1>
  	   <hr>
  	   <font color =red>${error }</font>
       <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
       	   	<table>
       	   	   <tr>
       	   	   	   <td align  ="right">姓名：</td>
       	   	   	   <td align = "left"><input type = "text" name = "username" ></td>
       	   	   	   <td><span></span></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td align  ="right">密码：</td>
       	   	   	   <td align = "left"><input type = "text" name = "password" ></td>
       	   	   	   <td><span></span></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td colspan = "3"><input type = "submit" value = "登陆"></td>
       	   	   </tr>
       	   </table>
       </form>
       </center>
  </body>
</html>
