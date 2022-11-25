<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/clock.css" type="text/css"></link>
<title>웹모도로</title>
</head>
<body>
<jsp:include page="nav.html"></jsp:include>
<div class="clock">
	<div class="timer-container">
	        <div id="timer" class="timer">
	            <div class="cover1"></div>
	            <div id="lines">
	            </div>
	            <div id="fins">
	            </div>
	            <div id="num-container">
	            </div>
	            <div class="cover2"></div>
	        </div>
	    </div>
	    <div class="time-container">
	        <div id="remain-time" class="remain-time"></div>
	        <div id="total-time" class="total-time"></div>
	    </div>
	    <div class="button-container">
	        <button id="control" class="control"><i class="fas fa-pause"></i></button>
	    </div>
	    <script src="js/index.js"></script>
	<div>
</div>
<jsp:include page="todo_list.jsp"></jsp:include>
</div>
</body>
</html>