<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Domain.TaskVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/todo.css" type="text/css"></link>
<title>웹모도로</title>
</head>
<body>
<jsp:include page="nav.html"></jsp:include>
<jsp:include page="todo_list.jsp"></jsp:include>
</body>
</html>