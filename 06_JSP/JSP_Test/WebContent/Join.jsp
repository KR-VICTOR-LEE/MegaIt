<%@page import="java.util.Arrays"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
		request.setCharacterEncoding("utf-8");
		String hiddenParam = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		Date birth2=null; Timestamp birth3=null;
		if(birth!="") {
			birth2 = Date.valueOf(request.getParameter("birth"));
			birth3 = Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter p = response.getWriter();
		p.println("<html>");
		p.println("<head>");
		p.println("<link href='css/join.css' rel='stylesheet'>");
		p.println("</head>");
		p.println("<body>");
		p.println("<div id='joinForm_wrap'>");
		p.println("<div id='join_title'>회원가입정보</div>");
		p.println("<h2>hiddenParam = "+hiddenParam+"</h2>");
		p.println("<h2>이름 = "+name+"</h2>");
		p.println("<h2>아이디 = "+id+"</h2>");
		p.println("<h2>비밀번호 = ");
		for (int i = 0; i < pw.length(); i++) {
			out.println('*');
		}
		p.println("</h2>");
		p.println("<h2>생년월일 : "+birth+"</h2>");
		p.println("<h2>생년월일(java.sql.Date) : "+birth2+"</h2>");
		p.println("<h2>생년월일 (java.sql.Timestampe) : "+birth3+"</h2>");
		p.println("<h2>취미 : ");
		if(hobby!=null) {
			for (int i = 0; i < hobby.length; i++) {
				if(i == hobby.length-1) {
					out.println(hobby[i]);
				}else {
					out.println(hobby[i]+",");
				}
			}
		}else {
			out.println("선택된 취미가 없음");
		}
		p.println("</h2>");
		p.println("<h2>성별 : "+gender+"</h2>");
		p.println("<h2>이메일 : "+email+"</h2>");
		p.println("<h2>메일 수신 동의 : "+Arrays.toString(mailSend)+"</h2>");
		p.println("</div>");
		p.println("</body>");
		p.println("</html>");
	%>
	<%@include file="../exam2/footer.jsp" %>
</body>
</html>