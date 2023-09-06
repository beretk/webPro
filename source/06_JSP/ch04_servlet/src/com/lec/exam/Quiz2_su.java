package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Quiz2")
public class Quiz2_su extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0;
		for(int i=1 ; i<=su ; i++) {
			sum += i;
		}
		System.out.println("1부터 "+su+"까지 누적합은 " + sum);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<style>");
		out.println("h2 {color:red;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>1부터 "+su+"까지 누적합은 "+sum+"</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}