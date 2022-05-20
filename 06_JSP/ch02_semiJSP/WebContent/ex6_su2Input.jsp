<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		document.querySelector('form').onsubmit = function() {
			var su1 = document.querySelector('input[name="su1"]');
			var su2 = document.querySelector('input[name="su2"]');
			if (!su1.value) {
				alert('첫번째 수를 입력하세요');
				su1.focus();
				return false; // 디폴트 이벤트 제한
			} else if (!su2.value) {
				alert('두번째 수를 입력하세요');
				su2.focus();
				return false;
			}
			var s1 = Number(su1.value);
			var s2 = Number(su2.value);
			if (s1 > s2) {
				alert('첫번째 숫자가 작거나 같은 수를 넣으세요');
				su1.value = '';
				su2.value = '';
				su1.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
	<form action="ex6_guguOut.jsp" method="get">
		<p>
			단수 <input type="number" name="su1" min="2" max="9"> <b>~</b>
			<input type="number" name="su2" min="2" max="9">
		</p>
		<p>
			<input type="submit" value="원하는 구구단 출력">
		</p>
	</form>
</body>
</html>