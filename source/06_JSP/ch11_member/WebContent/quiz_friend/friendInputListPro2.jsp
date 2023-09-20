<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%	
		FriendDao friendDao = FriendDao.getInstance();
		int insertResult = friendDao.insertFriend(dto);
		if(insertResult==FriendDao.SUCCESS){
			response.sendRedirect("friendInputList2.jsp?insertResult="+insertResult);
		}
	%>
</body>
</html>