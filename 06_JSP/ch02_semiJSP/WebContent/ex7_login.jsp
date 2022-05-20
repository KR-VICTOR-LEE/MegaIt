<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		
	</style>
</head>
<body>
	<form action="ex7_loginPro.jsp" method="post">
	<h1>로그인 화면</h1>
	<hr>
	<table>
		<tr><td>이   름</td><th><input type="text" name="name"></th></tr>
		<tr><td>아이디</td><th><input type="text" name="id"></th></tr>
		<tr><td>패스워드</td><th><input type="password" name="pw" ></th></tr>
		<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
		</table>
	</form>
</body>
</html>