<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		consol.log('예외메세지 : <%=exception.getMessage()%>');
		consol.log('예외타입 : <%=exception.getClass().getName()%>');
	</script>
</head>
<body>
	<h1>공사중 입니다. 빠른 시일내로 복구하겠습니다(500에러)</h1>
	<%
		System.out.println("예외 메세지 : " + exception.getMessage());
		System.out.println("예외타입 : " + exception.getClass().getName());
	%>
</body>
</html>