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
</head>
<body>
	<!-- requestScope.board, param.bid, prarm.pageNum가 있음 -->
	<form action="${conPath }/board/modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bid" value="${param.bid }">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<table>
			<caption>${param.bid }번 글 수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required" 
						autofocus="autofocus" value="${board.bname }">				
				</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required" value="${board.btitle }">
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" name="bcontent">${board.bcontent }</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="filename" style="width: 300px;">
					첨부된파일:${empty board.bfileName ? "첨부파일없음": board.bfileName}
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="reset" value="초기화" class="btn" onclick="history.back()">
					<input type="button" value="목록" class="btn" 
								onclick="location='${conPath}/board/list.do?pageNum+${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>








