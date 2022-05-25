<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 리스트</h1>
	<%
		Cookie[] cookies = request.getCookies();
	for(int i =0; i<cookies.length; i++){
		String name = cookies[i].getName(); //idx번째 쿠키의 이름
		String value = cookies[i].getValue();
		out.println("<h2>"+i+"번째 쿠키 이름 : "+name+", 값 : "+value+"</h2>");
	}
	%>
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키생성(cookieName)</a><br>
	<a href="ex2_cookielist.jsp">쿠키들(쿠키이름-쿠키값) 리스트 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName)찾기</a><br>
	<a href="ex2_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>