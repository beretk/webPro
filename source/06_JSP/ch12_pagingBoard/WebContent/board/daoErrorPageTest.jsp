<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<a href="xx.jsp">에러 페이지로 갈까?</a>
	<%
		BoardDao bDao = BoardDao.getInstance();
		out.println("<h3>1. 글 목록</h3>");
		ArrayList<BoardDto> dtos = bDao.listBoard(11,20);
		for(BoardDto dto : dtos){
			out.println(dto + "<br>");			
		}
		out.println("<h3>2. 글갯수 : " + bDao.getBoardTotalCnt() + "</h3>");
		out.println("<h3>3. 원글쓰기</h3>");
		BoardDto dto = new BoardDto(0, "신길동", "제목5교시", "냉무", null, 0, "111",
				0, 0, 0, "127.4.3.2", null);
		int result = bDao.writeBoard(dto);
		out.print(result == BoardDao.SUCCESS ? ":성공</h3>" : ":실패</h3>");
		out.print("<h3>6. 조회수 안 올리고, 글번호로 dto가져오기</h3>");
		out.print("2번글: " + bDao.getBoardNotHitUp(2) + "</h3>");
		out.print("<h3>4와5. 조회수 올리고, 글번호로 dto가져오기</h3>");
		bDao.hitUp(2);
		out.print("2번글 상세보기: " + bDao.getBoardNotHitUp(2) + "조회수 올리고 상세보기");
		out.print("<h3>7. 글수정</h3>");
		dto = bDao.getBoardNotHitUp(2);// 2번글 정보
		dto.setBname("독특자");
		dto.setBtitle("독특한 제목");
		dto.setBcontent("독특한 본문 수정함\n수정완료");
		result = bDao.modifyBoard(dto);
		out.print(result == BoardDao.SUCCESS ? ":성공</h3>" : ":실패</h3>");
		out.print("<h3>8. 글 삭제");
		result = bDao.deleteBoard(11, "1");
		out.print(result == BoardDao.SUCCESS? "글삭제 성공":"비번오류로 글삭제 실패<br>");
		result = bDao.deleteBoard(11, "111");
		out.print(result == BoardDao.SUCCESS? "글삭제 성공":"비번오류로 글삭제 실패<br>");
	%>
</body>
</html>


























