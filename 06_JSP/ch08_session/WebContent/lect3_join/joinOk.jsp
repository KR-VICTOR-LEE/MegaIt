<%@page import="java.io.PrintWriter"%>
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
	<%
		String agree = request.getParameter("agree");
	if(agree.equals("y")){ //약관동의한 경우(세션속성값 받아 저장, 일부 세션 날림 -> 다음페이지로)
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
		// 파일저장 (WebContent/WEB-INF/id.txt)
		String filePath = "D:\\webPro\\Source\\06_JSP\\ch08_session\\WebContent\\WEB-INF\\"+id+".txt";
		PrintWriter write = new PrintWriter(filePath);
		write.println("오늘은 DB에 insert대신 파일 출력");
		write.println("아이디 : "+id);
		write.println("비밀번호 : "+pw);
		write.println("이름 : "+name);
		write.close();
		session.removeAttribute("pw");
		session.removeAttribute("name");
		//세션의 id속성은 유지 
		response.sendRedirect("result.jsp?msg=success");
	}else{ // 약관에 동의하지 않는 경우(세션 날림 - > 다음페이지로)
		session.invalidate();// 유효한 세션 속성 삭제
		response.sendRedirect("result.jsp?msg=fail");
	}
	%>
</body>
</html>
<!-- D:\webPro\Source\06_JSP\ch08_session\WebContent\WEB-INF -->