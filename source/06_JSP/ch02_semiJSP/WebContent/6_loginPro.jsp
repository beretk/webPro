<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%!	 // 선언부(함수, 변수 선언)에 선언된 변수는 자동 초기화
		String name, id, pw;
	%>
	<%
		request.setCharacterEncoding("utf-8"); // post방식 전송시 추가
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	<h2>아이디는 <%=id %></h2>
	<h2>패스워드는 <%=pw %></h2>
	<h2><%=name %>님 반갑습니다</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='6_login.html'">로그인</button>
</body>
</html>