<%@page import="java.net.URLEncoder"%>
<%@page import="javax.print.URIException"%>
<%@page import="java.net.URI"%>
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
			String msg = "<b>아이디와 비밀번호를 확인하세요</b>";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("ex5_loginFrm.jsp?msg="+msg);
		}else{
			out.println("<h2>ID는"+id+"이고<br>비밀번호는"+pw+"입니다<br>반갑습니다.</h2>");
					
		}
	%>
	<h2>ID는<%=id %>이고<br>
	비밀번호는<%=pw %>입니다<br>
	반갑습니다.
	</h2>
	
</body>
</html>