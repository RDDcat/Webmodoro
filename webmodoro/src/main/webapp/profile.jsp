<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Domain.TaskVO"%>
<%@page import="Domain.UserVO"%>
<% UserVO user = (UserVO)request.getAttribute("userVO");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
<title>웹모도로</title>
</head>
<body>
<jsp:include page="nav.html"></jsp:include>
<div>
	<table>
		<tr>
			<th> 유저 이름 </th> 
			<td> <%= user.getUserName() %></td> 
		</tr>
		<tr>
			<th> 연락처 </th> 
			<td> <%= user.getContact() %></td> 
		</tr>
	</table>
</div> 
</body>
</html>