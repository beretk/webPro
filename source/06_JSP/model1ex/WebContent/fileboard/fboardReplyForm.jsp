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
			// 넘어온 파라미터 : bid(원글의 글번호), pageNum
			String pageNum = request.getParameter("pageNum");
			int fid = Integer.parseInt(request.getParameter("fid"));
			FileBoardDao fDao = FileBoardDao.getInstance();
			FileBoardDto originalDto = fDao.getFBoard(fid);// 원글의 정보(bgroup, bstep, bindent)
		%>
		<form action="fboardReplyPro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="fid" value="<%=originalDto.getFid()%>"> <!-- 원글 -->
			<input type="hidden" name="fgroup" value="<%=originalDto.getFgroup()%>"> <!-- 원글 -->
			<input type="hidden" name="fstep" value="<%=originalDto.getFstep()%>"> <!-- 원글 -->
			<input type="hidden" name="findent" value="<%=originalDto.getFindent()%>"> <!-- 원글 -->
			<table>
				<caption><%=fid %>번 글의 답변글 쓰기</caption>
				<tr><th>제목</th>
						<td>
							<input type="text" name="ftitle" required="required" 
									value="답 : <%=originalDto.getFtitle()%>" autofocus="autofocus">
						</td>
				</tr>
				<tr><th>첨부파일</th><td><input type="file" name="filename"></td></tr>
				<tr><th>본문</th><td><textarea rows="5" cols="2" name="fcontent"></textarea></td></tr>
				<tr><th>삭제비번</th><td><input type="password" name="fpw" required="required"></td></tr>
				<tr><td colspan="2">
							<input type="submit" value="답글쓰기" class="btn">
							<input type="reset" value="다시쓰기" class="btn">
							<input type="button" value="목록" onclick="location='fboardList.jsp?pageNum=<%=pageNum%>'" class="btn">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>	
</body>
</html>