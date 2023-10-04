<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		FileBoardDao fDao = FileBoardDao.getInstance();
		FileBoardDto fDto = new FileBoardDto();
		for(int i=0 ; i<70 ; i++){
			if(i%3==0){
				fDto.setCid("aaa");
			}else if(i%3==1){
				fDto.setCid("bbb");
			}else{
				fDto.setCid("ccc");
			}
			fDto.setFtitle("for문 돌려 강제로 입력한 글 "+i);
			fDto.setFcontent("내용"+i);
			if(i%10 == 0){
				fDto.setFilename("1.docx");
			}else{
				fDto.setFilename(null);
			}
			fDto.setFpw("111");
			fDto.setFip("192.168.20.44");
			fDao.writeFBoard(fDto);
		}
		response.sendRedirect("fboardList.jsp");
	%>
</body>
</html>