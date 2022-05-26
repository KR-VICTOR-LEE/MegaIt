<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header{width: 1000px; margin: 0 auto;}
		header #nav ul{overflow: hidden;}
		header #nav li{list-style: none; float: right; padding: 10px 30px;}
		header #nav ul li a{text-decoration: none; font-weight: bold; font-size: 1.5em; color: #A47160;}
	</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
				String id=null;
				Cookie[] cs = request.getCookies();
				if(cs!=null){
					for(Cookie c : cs){
						if(c.getName().equals("id")){
							id = c.getValue();
							break;
						}//if
					}//for
				}//if
			%>
			
			<%if(id==null){ // 로그인 전 해더 메뉴%>
				<ul>
					<li><a href="join.jsp">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
					<li><a href="<%=conPath %>/lect3_header/main.jsp">홈</a></li>
				</ul>
			<%}else{// 로그인 후 해더 메뉴 %>
				<ul>
					<li><a href="logout">로그아웃</a></li>
					<li><a href="clist.jsp">쿠키리스트</a></li>
					<li><a href="#"><%=id %>님</a></li>
				</ul>
			<%}%>
		</div>
	</header>
</body>
</html>