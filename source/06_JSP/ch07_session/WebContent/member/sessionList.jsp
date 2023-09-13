<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#mainForm_wrap{line-hegiht:80px}
	</style>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<div id="mainForm_wrap">
		<h3>세션 데이터 리스트</h3>
		<%
			Enumeration<String> sAttrNames = session.getAttributeNames();
			int cnt = 0;
			while(sAttrNames.hasMoreElements()){
				cnt++;
				String sname = sAttrNames.nextElement();
				String svalue = session.getAttribute(sname).toString();
				out.println(sname+"(세션명) : "+svalue+"(세션값)<br>");
			}
			if(cnt==0){
				out.println("유효한 세션이 없습니다");
			}
		%>
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>