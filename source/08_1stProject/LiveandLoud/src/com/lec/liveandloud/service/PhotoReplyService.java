package com.lec.liveandloud.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.liveandloud.dao.PhotoDao;
import com.lec.liveandloud.dto.AdminDto;
import com.lec.liveandloud.dto.PhotoDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PhotoReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파일첨부 로직 + 파라미터들 받아 DB에 join
		String path = request.getRealPath("equipmentUp");
		int maxSize = 1024*1024*10; // 최대업로드 사이즈는 10M
		String pfileName = "";
		int result = PhotoDao.FAIL;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			pfileName = mRequest.getFilesystemName(param);
			HttpSession httpSession = request.getSession();
			AdminDto admin = (AdminDto)httpSession.getAttribute("admin");
			if(admin ==null) {
				request.setAttribute("photoResult", "로그인 후에만 답글쓰기 가능");
				return;
			}
			String aid = admin.getAid();
			String ptitle = mRequest.getParameter("ptitle");
			String pcontent = mRequest.getParameter("pcontent");
			String pip = request.getRemoteAddr();
			int pgroup = Integer.parseInt(mRequest.getParameter("pgroup"));
			int pstep = Integer.parseInt(mRequest.getParameter("pstep"));
			int pindent = Integer.parseInt(mRequest.getParameter("pindent"));
			PhotoDao photoDao = PhotoDao.getInstance();
			PhotoDto photoDto = new PhotoDto(0, aid, null, ptitle, pcontent, pfileName, null, 0, pgroup, pstep, pindent, pip);
			result = photoDao.reply(photoDto);
			// joinMember결과에 따라 적절히 request.setAttribute
			if(result == PhotoDao.SUCCESS) { // 회원가입 진행
				request.setAttribute("photoResult", "답글쓰기 성공");
			}else {
				request.setAttribute("photoResult", "답글쓰기 실패");
			}
			//★mRequest에서 넘어온 pageNum(mRequest를 사용하면 request의 파라미터들이 다 null이 됨)을 request에 set : modify,reply★
			request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("photoResult", "답글쓰기 실패");
		}
		if(pfileName!=null && result == PhotoDao.SUCCESS) {
			InputStream  is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path+"/" + pfileName);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/webPro/source/08_1stProject/LiveandLoud/WebContent/photoUp/"+ pfileName);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int nByteCnt = is.read(bs);
					if(nByteCnt==-1) break;
					os.write(bs, 0, nByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} // try
		}// 파일 복사 if
	}//execute()
}//class
