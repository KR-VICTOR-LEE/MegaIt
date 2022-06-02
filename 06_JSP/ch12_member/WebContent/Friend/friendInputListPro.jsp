<%@page import="com.lec.friend.FriendDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto"/>
	<jsp:setProperty property="*" name="dto"/>
<%
	FriendDao fDao = FriendDao.getInstance();
	int result = fDao.insertFriend(dto);
	response.sendRedirect("friendInputList.jsp?result="+result);

%>
</body>
</html>