<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<style>
		p {width:400px; margin: 0 auto;}
	</style>
</head>
<body>

	<form action="friendInputListPro.jsp">
		<p>친구이름 <input type="text" name="name" required="required"	size="10">
			 전화 <input type="text" name="tel" size="10">
			 <input type="submit" value="추가">
		</p>
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
		
	</table>
</body>
</html>