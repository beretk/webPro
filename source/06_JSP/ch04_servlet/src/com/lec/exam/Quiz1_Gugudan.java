package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Quiz1")
public class Quiz1_Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String[] su = request.getParameterValues("su"); //{"2","3","4"}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/quizq.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		if(su !=null) {
			for(String s : su) {
				int dansu = Integer.parseInt(s);
				out.println("<h4>" + dansu + "</h4>");
				for(int i=1; i<10; i++) {
					out.printf("%d * %d = %d<br>", dansu, i, dansu*i);
				}
			}
		}else {
			out.println("<h4>선택된 구구단이 없습니다.</h4>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}














