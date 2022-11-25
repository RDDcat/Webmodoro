<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
<title>웹모도로</title>
</head>
<jsp:include page="nav.html"></jsp:include>
<body>
<header>회원가입</header>
<div>	
	<form name="form1" action="/webmodoro/LoginUserServlet?cmd=register" method="post"> 
	<fieldset>
		<legend id=slow>개인정보 입력</legend> 
		<ul>
			<li>ID: <input type="text" name="name" autofocus required placeholder="공백없이 입력하세요"></li> 
			<li>PASSWORD: <input type="password" name="passwd" required placeholder="공백없이 입력하세요"></li> 
			<li>contact : <input type="text" name="contact" required placeholder="공백없이 입력하세요"></li> 
		</ul> 
	</fieldset>
	<fieldset>
		<input type="submit" name="submit" value="보내기">
		<input type="reset" name="reset" value="다시 작성"> 
	</fieldset>
</form> 
</div>
</body>
</html>