<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet" type="text/css">
	<script>
	window.onload = function(){
		document.querySelector('form').onsubmit = function(){
			var pw = document.getElementById('pw');
			var pwChk = document.getElementById('pwChk');
			var patternEmail = /^[a-zA-Z0-9_\.]{2,}@\w+(\.[a-zA-Z]+){1,2}$/;// macth함수 사용
			var email = document.getElementById('email');
			var hobby = document.getElementsByName('hobby');
			var mailSend = document.querySelector('select[name="mailSend"]');
			var mailOption = mailSend.querySelectorAll('option');
			if(pw.value != pwChk.value){
				alert('비밀번호를 확인하세요');
				pw.value = '';
				pwChk.value = '';
				pw.focus();
				return false;
			}else	if(email.value && !email.value.match(patternEmail)){
	      alert('메일 형식을 확인하세요');
	      email.focus();
	      return false;
	    }/*else if(!hobby[0].checked && !hobby[1].checked && !hobby[2].checked && !hobby[3].checked){
	    	alert('취미를 억지로라도 한가지 이상 선택해 주세요');
				return false;
			}else if(!mailOption[0].selected && !mailOption[1].selected 
				&& !mailOption[2].selected && !mailOption[3].selected ){
				alert('메일수신을 한가지 이상 선택해 주세요');
				return false;
			}*/
			/* 바로 위의 if문을 아래로 변경 가능() 
			var mailOptionCnt = 0;
			for(var i=0 ; i<mailOption.length ; i++){
				mailOptionCnt += mailOption[i].selected;
			}
			if(!mailOptionCnt){
				alert('메일수신을 한가지 이상 선택해 주세요');
				return false;
			} */
		};
	};
	</script>
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
							<option value="공지" selected="selected">공지</option>
							<option value="문자">문자</option>
						</select>
					</td>
				</tr>
				<tr><td colspan="2"></td></tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="joinBtn_style" value="가입하기">
						<input type="reset" class="joinBtn_style" value="다시하기">
						<input type="button" class="joinBtn_style" onClick="history.back()"value="뒤로가기">
						
					</td>
				</tr>
			</table>		
		</form>			
	</div>
	<%@ include file="footer.jsp" %>	
</body>
</html>