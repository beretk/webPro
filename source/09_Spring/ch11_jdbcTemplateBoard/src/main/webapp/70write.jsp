<%@page import="com.lec.ch11.vo.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String bname=null, btitle=null, bcontent="", bip=null;
		BoardDao bDao = new BoardDao();
		for(int i=1 ; i<=70 ; i++){
			BoardDto board = new BoardDto();
			board.setBname("홍길동"+i);
			board.setBtitle("제목" + i);
			board.setBip("192.168.1."+i);
			int result = bDao.writeBoard(board);
			System.out.println(result==1? i+"번째 성공": i+"번째 실패");
		}
		response.sendRedirect("board/list.do");
	%>
</body>
</html>