<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Home</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>
		${greeting } 
	</h1>
	<img src="${conPath }/img/숀코너리.jpg" alt="이미지">
	<img src="img/숀코너리.jpg" alt="이미지">

</body>
</html>

















