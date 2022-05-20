<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	//내장객체 request 이용하여 받은 파라미터 값은 String
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h3><%=su %>단 구구단 출력</h3>
	<% for(int i=1; i<=9; i++){%>
	
		<p><%=su %>*<%=i %>=<%=su*i %></p><br>
			
	<%}%>
	
</body>
</html>