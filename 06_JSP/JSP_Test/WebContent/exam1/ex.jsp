<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동전찾기</title>
<link href="ex.css" rel="stylesheet">
</head>
<body>
	
	<form action="exPro.jsp">
		<h3>동전이 있는 곳을 맞춰봐</h3>
		<hr>
		<button name="btn1" value="0" onclick="location.href=/exPro.jsp">1번</button>
		<button name="btn2" value="1" onclick="location.href=/exPro.jsp">2번</button>
		<button name="btn3" value="2" onclick="location.href=/exPro.jsp">3번</button>
	</form>
	<div id="msg">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.print(msg);
			}
		%>
	</div>
	
</body>
</html>