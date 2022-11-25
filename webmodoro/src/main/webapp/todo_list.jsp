<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Domain.TaskVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/todo.css" type="text/css"></link>
<title>웹모도로</title>
</head>

<body>
<div id="myDIV" class="header">
  <h2>My To Do List</h2>
  <input type="text" id="myInput" placeholder="Title...">
  <span onclick="newElement()" class="addBtn">Add</span>
</div>
<div class="myUL">
	<ul id="myUL">
		<c:forEach items="${tasks}" var="task">	
		<li>
			<input type="text" placeholder="Title..." value=${task.taskDescribtion}>
			<img src="img/edit.png" weigh=40px height=40px onclick="myFunction();">
			<a href="http://localhost:8080/webmodoro/DeleteTaskServlet?taskId=${task.taskId}"><img src="img/remove.png" weigh=40px height=40px></a>
		</li>
		</c:forEach>
	</ul>
</div>
<script src="js/todo.js"></script>
</body>
</html>