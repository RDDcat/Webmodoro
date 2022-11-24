<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<th> 계정 </th> 
			<td> <%= 1  %></td> 
		</tr>
		<tr>
			<th> 이름 </th> 
			<td> <%= 1 %></td> 
		</tr>
		<tr>
			<th> 학번 </th> 
			<td> <%= 1 %></td> 
		</tr>
		<tr>
			<th> 학과 </th> 
			<td> <%= 1 %></td> 
		</tr>
	</table>
</div> 
<jsp:include page="todo_list.jsp"></jsp:include>
</body>
</html>