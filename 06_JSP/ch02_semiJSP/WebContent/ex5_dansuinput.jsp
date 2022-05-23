<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		p {text-align: center;}
	</style>
</head>
<body>
	<h5>원하는 구구단 수를 입력하세요</h5>
	<form action="5_gugudanOut.jsp" method="get">
		<p>단 수 <input type="number" name="su" min="2" max="9" required="required"></p>
		<p><input type="submit" value="원하는 구구단 출력"></p>
	</form>
</body>
</html>
















