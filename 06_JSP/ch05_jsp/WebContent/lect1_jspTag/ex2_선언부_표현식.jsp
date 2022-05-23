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
		int j = 0;
	i++;
	j++;
	strBuf.append("<span>♥<span>");
	out.println("strBuf = "+strBuf+"<br>");
	out.println("sum(5,2) = "+sum(5,2)+"<br>");
	%>
	전역번수 i =<%=i%><br> 
	지역번수 j =<%=j%><br> 
	<%--strBuf =<%=strBuf%> --%>
	
	<%!int i; // 0으로 초기화
	StringBuffer strBuf = new StringBuffer("Good ");

	public int sum(int a, int b) {
		return a + b;
	}%>
</body>
</html>