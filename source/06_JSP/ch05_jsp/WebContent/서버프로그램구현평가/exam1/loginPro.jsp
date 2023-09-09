<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%!
		String id,pw;
	%>
	<%
		request.setCharacterEncoding("utf-8");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		 if( !id.equals("aaa") || !pw.equals("111")){
			String msg = "<h2>Check ID and PW</h2>";
			response.sendRedirect("login.jsp?msg="+msg);
		}
	%>
	<h2>아이디는<%=id %>이고</h2>
	<h2>비밀번호는<%=pw %>입니다</h2>
	<h2>반갑습니다</h2>
</body>
</html>