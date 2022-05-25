<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결과화면</title>
</head>
<body>
	<form action="ex.jsp">
<%
   int num = (int)(Math.random()*3);
   String btn1 = request.getParameter("btn1");
   String btn2 = request.getParameter("btn2");
   String btn3 = request.getParameter("btn3");
   if((num==0 && btn1==null) || (num==1 && btn2==null) || (num==2 && btn3==null)){
      
      String msg = "<p>Wrong! Try Again! 정답은 "+(num+1)+"번 입니다</p>";
      msg = URLEncoder.encode(msg, "utf-8");
      response.sendRedirect("ex.jsp?msg="+msg);
   }
   
%>
   <table>
      <tr>
         <th colspan="3">동전이 있는 곳을 맞춰봐</th>
      </tr>
      
      <tr>
         <td>
         <h2>정답입니다</h2>
         <h2>동전이 있던 곳은 <%=(num+1) %>번</h2>
         <input type="submit" value="다시 도전">
         </td>
      </tr>
   </table>
</form>

	
</body>
</html>