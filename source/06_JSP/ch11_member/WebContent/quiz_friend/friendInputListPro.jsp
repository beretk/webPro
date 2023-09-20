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
		if(insertResult == FriendDao.SUCCESS){
	%>		
			<script>
				alert('친구추가 성공');
				location.href = 'friendInputList.jsp';
			</script>
	<%}else{ %>
			<script>
				alert('친구추가 실패. 이름이나 전화번호가 너무 길면 안되요');
				location.href = 'friendInputList.jsp';
			</script>
	<%} %>
	<%--
		FriendDao friendDao = FriendDao.getInstance();
		int insertResult = friendDao.insertFriend(dto);
		response.sendRedirect("friendInputList.jsp?insertResult="+insertResult);
	--%>
</body>
</html>