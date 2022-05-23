package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/join.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id='join_title'>ȸ����������</div>");
		out.println("<h2>hiddenParam = "+hiddenParam+"</h2>");
		out.println("<h2>�̸� = "+name+"</h2>");
		out.println("<h2>���̵� = "+id+"</h2>");
		out.println("<h2>��й�ȣ = ");
		for (int i = 0; i < pw.length(); i++) {
			out.println('*');
		}
		out.println("</h2>");
		out.println("<h2>������� : "+birth+"</h2>");
		out.println("<h2>�������(java.sql.Date) : "+birth2+"</h2>");
		out.println("<h2>������� (java.sql.Timestampe) : "+birth3+"</h2>");
		out.println("<h2>��� : ");
		if(hobby!=null) {
			for (int i = 0; i < hobby.length; i++) {
				if(i == hobby.length-1) {
					out.println(hobby[i]);
				}else {
					out.println(hobby[i]+",");
				}
			}
		}else {
			out.println("���õ� ��̰� ����");
		}
		out.println("</h2>");
		out.println("<h2>���� : "+gender+"</h2>");
		out.println("<h2>�̸��� : "+email+"</h2>");
		out.println("<h2>���� ���� ���� : "+Arrays.toString(mailSend)+"</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
