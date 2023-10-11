package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = MemberDao.FAIL;		
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			String mname = request.getParameter("mname");
			String memail = request.getParameter("memail");
			String mbirthStr = request.getParameter("mbirth");
			//Date mbirthStr = mbirth.equals("") ? null:Date.valueOf(mbirthStr);
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = request.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			// mid 중복체크
			result = mDao.midConfirm(mid);
			if(result == MemberDao.NONEXISTENT) { 
				MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mbirth, maddress, null);
				// 회원가입
				result = mDao.joinMember(newMember);
				if(result == MemberDao.SUCCESS) {  
					HttpSession session = request.getSession();
					session.setAttribute("mid", mid);
					request.setAttribute("joinResult", "회원가입이 완료 되었습니다");
				}else{  
					request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
				}
			}else { 
				request.setAttribute("joinErrorMsg", "중복된 ID는 회원가입이 불가합니다");				
		} 
	}  
}  


















