<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
		String conPath = request.getContextPath();
		String appPath = application.getContextPath();
		String absolutePath = application.getRealPath(".");
	%>
	
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
	
	<%
		String filePath = application.getRealPath("WEB-INF/input.txt");
		out.println(filePath);
		// 스트림객체생성(화일연다) - 읽는다 - 스트림객체를 닫는다.
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while(true){
			String line = br.readLine(); // 파일읽기 (한줄씩). 파일의 끝이면 null을 반환
			if(line==null) break;
			out.println(line+"<br>");
		}
		br.close();
		/* try{
			br = new BufferedReader(new FileReader(filePath));// 스트림객체생성
			while(true){
				String line = br.readLine(); // 파일읽기 (한줄씩). 파일의 끝이면 null을 반환
				if(line==null) break;
				out.println(line+"<br>");
			}
		}catch(Exception e){
			out.println("파일이 존재하지 않습니다.");
		}finally{
			try{
				if(br!=null) br.close();
			}catch(Exception e){
				
			}
		} */
	%>
</body>
</html>