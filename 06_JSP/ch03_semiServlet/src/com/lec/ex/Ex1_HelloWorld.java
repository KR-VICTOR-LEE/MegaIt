package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1_HelloWorld
 */
// @WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
public class Ex1_HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGetȣ��");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1{color:blue;");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�ȳ��ϼ���. ù servlet �����Դϴ�.</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPostȣ��");
		doGet(request, response);
	}
}
