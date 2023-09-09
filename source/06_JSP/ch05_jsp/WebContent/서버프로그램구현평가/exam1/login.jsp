<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#wrap{
		width:250px; 
		margin: 10px auto; 
		border: 1px solid #D4A190; 
		padding:20px;
		text-align: center;
		}
		#msg {color:red; text-align: center;}
	</style>
</head>
<body>
	<div id="wrap">
		<form action="loginPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th><label for="pw">패스워드</label></th>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr><td colspan="3"></td></tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
		<div id="msg">
		<%
			String msg = request.getParameter("msg");
				if(msg!=null){
					out.println(msg);
				}
		%>
		</div>
	</div>
</body>
</html>