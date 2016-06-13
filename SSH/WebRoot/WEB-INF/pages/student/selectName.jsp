<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
  <head>
    <script type="text/javascript">
    	/* function deleteAll(){
    		document.forms[0].action="${pageContext.request.contextPath}/student/todelete.action";
    		document.forms[0].submit();
    	} */
    </script>

  </head>
  
  <body>
    学生信息 <br>
    
    <form method="post">
    	<table border="1">
    		
    		<tr>
    			
    			<td>编号</td>
    			<td>姓名</td>
    			<td>学号</td>
    			<td>年龄</td>
    			<td>班级</td>
    			
    		</tr>
    		<c:forEach items="${student}" var="stu" varStatus="status">
    			<tr>
    				<td><input type="checkbox" name="id"/></td>
    				<td>${status.index+1}</td>
    				<td>${stu.name}</td>
    				<td>${stu.number}</td>
    				<td>${stu.age}</td>
    				<td>${stu.grade}</td>
    				<td><a href="${pageContext.request.contextPath}/student/toupdate.action?id=${stu.id}">修改</a></td>
    				<td><a href="${pageContext.request.contextPath}/student/todelete.action?id=${stu.id}">删除</a></td>
    			</tr>
    		</c:forEach> 
    		
    	</table>
    </form>
  </body>
</html>
