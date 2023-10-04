<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
	<style>
		p{text-align:center}
	</style>
</head>
<body>
	<form action="">
		<p>
			<input type="text" size="1" name="n1" 
				value="<%=(int)(Math.random()*9) + 1 %>" readonly="readonly">
			*
			<input type="text" size="1" name="n2"
				value="<%=(int)(Math.random()*9) + 1 %>" readonly="readonly">
			=
			<input type="number" name="result" placeholder="정답을 입력하세요">
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
	<c:if test="${not empty param.n1 }">
		<p>
			${param.n1 } * ${param.n2 } = ${param.result }는(은)
			<c:if test="${param.n1*param.n2 eq param.result }">
				<b>정답입니다</b>
			</c:if>
			<c:if test="${param.n1*param.n2 != param.result }">
				<b>오답입니다</b>
			</c:if>
	</c:if>		
</body>
</html>




