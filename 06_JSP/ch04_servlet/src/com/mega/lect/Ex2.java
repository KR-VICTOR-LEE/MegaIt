package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// menu, rest �Ķ���� : request.getParameterValues("�Ķ�����̸�") => �迭�� ����
							// �����̸��� �Ķ���͸� ������ ���޹��� ���
		// nation �Ķ���� : request.getParameter("�Ķ�����̸�") => String���� ����
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(menu!=null) {
			out.println("<h4>������ �޴��� ");
			for(String m : menu) {
				out.println(m + ". ");
			}
			out.println("</h4>");
		}else {
			out.println("<h4>������ �޴��� �����ϴ�</h4>");
		}
		if(rest!=null) {
			out.println("<h4>���� �Ĵ� ������ "+Arrays.toString(rest)+"�Դϴ�</h4>");
		}else {
			out.println("<h4>������ �Ĵ� ������ �����ϴ�</h4>");
		}
		out.println("<h4>������ ������ "+nation+"�Դϴ�</h4>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
