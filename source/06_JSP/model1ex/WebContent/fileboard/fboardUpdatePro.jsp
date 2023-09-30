<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
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
</head>
<body>
	<%	
	String path = request.getRealPath("fileboardUpload");
	int maxSize = 1024*1024*5;
	String filename = "";
	MultipartRequest multipartRequest = null;
	try{
		multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8",
																													new DefaultFileRenamePolicy());
		Enumeration<String> params = multipartRequest.getFileNames();
		//while(params.hasMoreElements()){
			String param = params.nextElement();
			filename = multipartRequest.getFilesystemName(param);
		//}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	InputStream is = null;
	OutputStream os = null;
	try{
		File serverFile = new File(path+"/"+filename);
		if(serverFile.exists()){
			is = new FileInputStream(serverFile);
			os = new FileOutputStream("C:/webPro/source/06_JSP/model1ex/WebContent/fileboardUpload/"+filename);
			byte[] bs = new byte[(int)serverFile.length()];
			int readByteCnt;
			while((readByteCnt=is.read(bs))!=-1){
						os.write(bs, 0, readByteCnt);
			}
		}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}finally{
		if(is!=null) is.close();
		if(os!=null) os.close();
	}
	String pageNum = multipartRequest.getParameter("pageNum");
	int fid = Integer.parseInt(multipartRequest.getParameter("fid"));
	//String cid = ((CustomerDto)session.getAttribute("customer")).getCid();
	String ftitle = multipartRequest.getParameter("ftitle");
	String fcontent = multipartRequest.getParameter("fcontent");
	String dbfilename = multipartRequest.getParameter("dbfilename");
	// 첨부파일을 수정하기를 원하지 않으면 첨부 안 함 처리
	if(filename==null) filename = (dbfilename.equals("null") ? "":dbfilename);
	String fpw = multipartRequest.getParameter("fpw");
	String fip = request.getRemoteAddr();
	FileBoardDto fDto = new FileBoardDto(fid, null,ftitle, fcontent, filename, 0, fpw, 0, 0, 0, fip, null, null, null);
	FileBoardDao fDao = FileBoardDao.getInstance();
	int result = fDao.modifyFBoard(fDto);
	if(result == FileBoardDao.SUCCESS){
%>
		<script>
			alert('글수정 완료');
			location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
		</script>
<% }else{%>
		<script>
				alert('글수정 실패');
				history.back();
		</script>
<%	}%>
	
</body>
</html>