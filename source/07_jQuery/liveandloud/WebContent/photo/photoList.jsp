<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>★★★ 클럽 라이브앤라우드 공식 홈페이지 ★★★</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<style>
		#content_form {
			width:1000px;
			height:800px;
			margin: 30px auto 0px;
		}
		#content_form table tr { height: 10px;}
	</style>
	<style>
		html, body { overflow:hidden; }
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function(){
			$('tr').click(function(){
				var pid = Number($(this).children().eq(0).text()); 
				if(!isNaN(pid)){
					location.href = '${conPath}/photoContent.do?pid='+ pid + '&pageNum=${pageNum}';
				}
			});
		});
		function tdClicked(pid){
			location.href = '${conPath}/photoContent.do?pid=' + pid + '&pageNum=${pageNum}';
		}
	</script>
</head>
<body>
	<c:if test="${not empty photoResult }">
		<script>alert('${photoResult}');</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
		<div id="content_form">
		<table>
			<tr>
				<td>
						<c:if test="${not empty admin }"><a href="${conPath }/photoWriteView.do">사진등록</a></c:if>
						<c:if test="${empty admin }"><a href="${conPath }/adminLoginView.do?next=photoWriteView.do">사진등록</a></c:if>
				</td>
			</tr>
		</table>
		<br>
		<table>
			<c:if test="${totCnt==0 }">
				<tr><td colspan="6">등록된 사진이 없습니다</td></tr>
			</c:if>
			<tr>
			<c:set var="i" value="0"/>
			<c:forEach items="${photoList }" var="photo">
				<c:if test="${i eq 4 }">
					</tr><tr>
				</c:if>
				<td onclick="tdClicked('${photo.pid }')">
					<%-- ${photo.pid }<br> --%>
					${photo.ptitle } <!-- 글제목에 a태그를 걸지 말고 query로 tr을 클릭하면 상세보기 페이지로 가기 -->
					<img src="${conPath }/photoUp/${photo.pfileName}" width="235">
				</td>
				<c:set var="i" value="${i + 1 }"/>					
			</c:forEach>
			</tr>
		</table>
		<div class="paging">
			<c:if test="${startPage > BLOCKSIZE }">
				[ <a href="${conPath }/photoList.do?pageNum=${startPage-1}"> 이전 </a> ]
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i == pageNum }">
					<b> [ ${i } ] </b>
				</c:if>
				<c:if test="${i != pageNum }">
					[ <a href="${conPath }/photoList.do?pageNum=${i}"> ${i } </a> ]
				</c:if>
			</c:forEach>
			<c:if test="${endPage<pageCnt }">
			  [ <a href="${conPath }/photoList.do?pageNum=${endPage+1}"> 다음 </a> ]
			</c:if>
		</div>
	</div>
	
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>