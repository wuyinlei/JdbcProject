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
	<style type="text/css">
		table{
			width:900px;
			border:1px solid gray ;
			border-collapse: collapse;
		}
		table td{
			border:1px solid gray ;
		}
		
	</style>
  </head>
  
  <body>
       <h1>注册用户</h1>
       <hr>
       <center>
       <form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
       	   	<table>
       	   	   <tr>
       	   	   	   <td align  ="right">姓名：</td>
       	   	   	   <td align = "left"><input type = "text" name = "username" value = "${user.username }"></td>
       	   	   	   <td><span>${user.errors.username }</span></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td align  ="right">密码：</td>
       	   	   	   <td align = "left"><input type = "password" name = "password" ></td>
       	   	   	   <td><span>${user.errors.password }</span></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td align  ="right">确认密码：</td>
       	   	   	   <td align = "left"><input type = "password" name = "repassword" ></td>
       	   	   	   <td></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td align  ="right">邮箱：</td>
       	   	   	   <td align = "left"><input type = "text" name = "email" value = "${user.email }"></td>
       	   	   	   <td><span>${user.errors.email }</span></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td align  ="right">生日：</td>
       	   	   	   <td align = "left"><input type = "text" name = "birthday" value = "${user.birthday }"></td>
       	   	   	   <td><span>${user.errors.birthday }</span></td>
       	   	   </tr>
       	   	   <tr>
       	   	   	   <td colspan = "3" align = "center"><input type = "submit" value = "注册"></td>
       	   	   </tr>
       	   </table>
       </form>
       </center>
  </body>
</html>
