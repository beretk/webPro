<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입</div>	
		<form action="joinPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="name">이름</label></th>				
					<td>
						<input type="text" name="name" class="name" id="name" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="id">아이디</label></th>				
					<td>
						<input type="text" name="id" class="id" id="id" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>				
					<td>
						<input type="password" name="pw" class="pw" id="pw" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>				
					<td>
						<input type="password" name="pwChk" class="pwChk" id="pwChk" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="date">생년월일</label></th>				
					<td>
						<input type="date" name="birth" class="birth" id="birth" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="hobby">취미</label></th>
					<td>
						<input type="checkbox" name="hobby" value="독서">독서
						<input type="checkbox" name="hobby" value="요리">요리
						<input type="checkbox" name="hobby" value="운동">운동
						<input type="checkbox" name="hobby" value="취침">취침
					</td>
				</tr>
				<tr>
					<th><label for="gender">성별</label></th>
					<td>
						<input type="radio" name="gender" value="남자" checked="checked">남자
						<input type="radio" name="gender" value="여자">여자						
					</td>
				</tr>
				<tr>
					<th><label for=email>이메일</label></th>
					<td>
						<input type="text" name="email" class="email" id="email" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for=mailSend>메일수신</label></th>
					<td>
						<select name="mailSend" multiple="multiple" class="mailSend">
							<option value="광고">광고</option>
							<option value="배송">배송</option>
							<option value="공지">공지</option>
							<option value="문자">문자</option>
						</select>
					</td>
				</tr>
				<tr><td colspan="2"></td></tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="joinBtn_style" value="가입하기">
						<input type="reset" class="joinBtn_style" value="다시하기">
						<input type="button" class="joinBtn_style" onClick="location.href='<%=conPath%>/member/login.jsp'" value="로그인">
						
					</td>
				</tr>
			</table>		
		</form>			
	</div>
	<jsp:include page="../member/footer.jsp"/>	
</body>
</html>



