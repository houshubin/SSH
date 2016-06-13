<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
   更新 <br>
   <form action="${pageContext.request.contextPath }/student/update.action" method="post">
   		<input type="hidden" name="id" value="${student.id }" />
   		姓名：<input type="text" name="name" value="${student.name }/"><br>
   		学号：<input type="text" name="number" value="${student.number }"/><br>
   		年级：<input type="text" name="grade" value="${student.grade }"/><br>
   		年龄：<input type="text" name="age" value="${student.age }"/><br>
   		<input type="submit" name="submit" value="提交">
   </form>
  </body>
</html>
