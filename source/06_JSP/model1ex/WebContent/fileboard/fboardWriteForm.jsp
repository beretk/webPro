<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#content_form{
			width:1000px; margin: 0px auto; height: 550px; 
			text-align: center;
			color: #003300;
			padding-top:50px;
		}
		#content_form input {height: 20px; padding:3px; margin: 10px 0;}
		#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			if(session.getAttribute("customer")==null){
				response.sendRedirect(conPath+"/customer/loginForm.jsp?method=fileboard/fboardWriteForm");
			}
		%>
		<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
			<table>
				<caption>글쓰기</caption>
				<tr><th>제목</th>
						<td><input type="text" name="ftitle" required="required" autofocus="autofocus"></td>
				</tr>
				<tr><th>첨부파일</th><td><input type="file" name="filename"></td></tr>
				<tr><th>본문</th><td><textarea rows="7" cols="3" name="fcontent"></textarea></td></tr>
				<tr><th>삭제비번</th><td><input type="password" name="fpw" required="required"></td></tr>
				<tr><td colspan="2">
							<input type="submit" value="글쓰기" class="btn">
							<input type="reset" value="다시쓰기" class="btn">
							<input type="button" value="목록" onclick="location='fboardList.jsp'" class="btn">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>	
</body>
</html>