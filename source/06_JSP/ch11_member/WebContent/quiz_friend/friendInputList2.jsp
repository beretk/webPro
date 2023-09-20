<%@page import="com.lec.friend.FriendDto"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<script>
		const search = function(){
			var name = document.getElementsByName("name")[0].value;
			var tel  = document.getElementsByName("tel")[0].value;
			location.href = 'friendInputList2.jsp?name='+name+'&tel='+tel;
		};
	</script>
</head>
<body>
	<%
		String insertResult = request.getParameter("insertResult");
		if(insertResult!=null && insertResult.equals("1")){
			out.println("<script>alert('친구추가 성공');</script>");
		}else if(insertResult!=null && insertResult.equals("0")){
			out.println("<script>alert('친구추가 실패. 이름이나 전화번호가 너무 길면 안되요');</script>");
		}
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
	%>
	<form action="friendInputListPro2.jsp">
		<p>
			친구이름 <input type="text" name="name" required="required" size="10" value="<%=name!=null? name:""%>">
			전화 <input type="text" name="tel" size="10" value="<%=tel!=null? tel:""%>">
			<input type="button" value="검색" onclick="search()">
			<input type="submit" value="추가">
		</p>
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
		<%
			FriendDao friendDao = FriendDao.getInstance();
			ArrayList<FriendDto> friends = friendDao.listFriends(name, tel);
			for(FriendDto friend : friends){
				tel = friend.getTel();
				out.println("<tr>");
				out.println(" <td>"+friend.getNo() + "</td>");
				out.println(" <td>"+friend.getName() + "</td>");
				out.println(" <td>"+(tel==null? "":tel)+ "</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>