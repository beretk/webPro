<%@page import="com.lec.dao.BookDao"%>
<%@page import="com.lec.dto.BookDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		#content_form{
			width:1000px; margin: 0px auto; height: 570px; 
			text-align: center;
			color: #003300;
			padding-top:30px;
		}
		#content_form input {height: 20px; padding:3px; margin: 10px 0;}
		#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<%
		// 첨부한 파일 저장(서버에)하고 파일이름 받아온다
		String path = request.getRealPath("bookImg");
		out.println("서버에 저장될 폴더:" + path + "<br>");
		int maxSize = 1024*1024*3; // 최대 업로드 사이즈를 3M
		String[] images = {"",""};
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", 
												new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			int idx = 0;
			while(params.hasMoreElements()){
				String param = params.nextElement();
				images[idx] = mRequest.getFilesystemName(param);
				System.out.println(idx+"번째 처리한 파라미터:" + param + "/파일명:" + images[idx]);
				idx++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일을 소스폴더로 복사(사용자에게 배포시 제거 로직)
		for(String filename : images){
			InputStream is = null;
			OutputStream os = null;
			try{
				File severFile = new File(path + "/" + filename);// 서버에 업로드된 파일
				//if(filename!=null){
				if(severFile.exists()){
					is = new FileInputStream(severFile);
					os = new FileOutputStream("C:/webPro/source/06_JSP/model1ex/WebContent/bookImg/"
					                                             + filename);//소스폴더로 복사될 파일
					byte[] bs = new byte[(int)severFile.length()];
					while(true){
						int readByteCnt = is.read(bs);
						if(readByteCnt==-1) break;
						os.write(bs,0,readByteCnt);
					}
					System.out.println(filename +" 복사 완료");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null)os.close();
				if(is!=null)is.close();
			}
		}
		// btitle, bprice, bcontent, bdiscount 파라미터값 받아온다
		String btitle = mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = images[1]==null ? "noImg.png" : images[1];
		String bimage2 = images[0]!=null ? images[0] : "NOTHING.JPG";
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		// String ip = request.getRemoteAddr(); ip가 필요한 경우는 request
		// DB에 저장
		BookDto book = new BookDto(0,btitle, bprice, bimage1,bimage2,bcontent,bdiscount,null);
		BookDao bDao = BookDao.getInstance();
		int result = bDao.insertBook(book);
		if(result==BookDao.SUCCESS){
			out.print("<h2>책등록 성공</h2>");
		}else{
			out.print("<h2>책등록 실패</h2>");
		}
	%>
	<h3>책이름 : <%=btitle %></h3>
	<h3>
		<%if(bdiscount!=0){ %>
		책가격 : <del><%=bprice %></del>
		<b>
			<%=bprice * (100-bdiscount) / 100 %>원(<%=bdiscount %>%할인)
		</b>
		<%}else{ %>
			<%=bprice %>원
		<%} %>		
	</h3>
	<h3>대표이미지 : <%=path %>/bookImg/<%=bimage1 %></h3>
	<h3>추가이미지 : <%=path %>/bookImg/<%=bimage2 %></h3>
	<img src="<%=conPath %>/bookImg/<%=bimage1 %>" alt = "대표이미지">
	<img src="<%=conPath %>/bookImg/<%=bimage2 %>" alt = "추가이미지">
	<h3>책설명</h3>
	<pre><%=bcontent %></pre>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>





















