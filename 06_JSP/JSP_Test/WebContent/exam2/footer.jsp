<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="footer.css" rel="stylesheet">
</head>
<body>
	<footer>
		<div class="office_logo">
			<img src="data:image/png;base64,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">
		</div>
		<div class="office_address">
			<ul>
				<li>서울시 XX구 XX로 000 XXX빌딩 8F | TEL : 02-999-9999 | FAX : 02-999-9998</li>
				<li>사업자등록번호 : 000-12-00000 | 통신판매업신로 : 종로 제0000호 | 대표이사 : 홍길동</li>
				<li>좋은시스템 문의 메일 : webmaster@joeun.com</li>
			</ul>
		</div>
		<div class="copyright">
			ⓒ2022 JOEUNSYSTEM.Co.,Ltd. All Rights Reserved.
		</div>
	</footer>
</body>
</html>
