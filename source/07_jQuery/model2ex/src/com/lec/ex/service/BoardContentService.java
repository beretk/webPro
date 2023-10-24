package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BoardContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = BoardDao.getInstance();
		// list.jsp를 통해서 content.do로 올 때만 조회수 1 up
		// list.jsp를 통해서 content.do로 올 때 url : content.do?bid=2&pageNum=2
		// 수정 성공 후 content.do로 오려고 할 때 url : content.do?after=u(BoardList.do로 가려고 하면 무조건 hitUp수행)
		if(request.getParameter("after")==null) {
			bDao.hitUp(fid);
		}
		BoardDto board = bDao.ggetBoardNotHitUp(fid);
		request.setAttribute("board", board);

	}

}
