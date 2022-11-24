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
<nav>
	 <ul>
      <li><a class="active" href="welcome.html"><img alt="" src="img/icon-pomodoro.png" weigh=50px height=30px></a></li>
      <li><a href="todo.jsp">To-do</a></li>
      <li><a href="clock.jsp">뽀모도로</a></li>
      <li><a href="profile.jsp">프로필</a></li>
      <li><a href="ranking.jsp">랭킹</a></li>
      <li><a href="about.html">About</a></li>
    </ul>
</nav>
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
<p>할일 목록 (TODO List)</p>
</div>
</body>
</html>