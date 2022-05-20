package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2_suOut
 */
@WebServlet(name = "Ex2suOut", description = "sumOut", urlPatterns = { "/Ex2suOut" })
public class Ex2_suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String numStr = request.getParameter("num");
			if (numStr==null || numStr.equals("")) {
				numStr = "1";
			}
			int num = Integer.parseInt(numStr);
			int sum = 0;
			for (int i = 0; i <num; i++) {
				sum += i;
			}
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>1����"+num+"���� �������� "+sum+"�Դϴ�.</h1>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
