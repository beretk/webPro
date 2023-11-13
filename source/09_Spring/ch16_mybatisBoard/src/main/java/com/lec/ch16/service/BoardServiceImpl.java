package com.lec.ch16.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.lec.ch16.repository.BoardRepository;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	private String backupPath = "C:/webPro/source/09_Spring/ch16_mybatisBoard/src/main/webapp/upload/";
	@Override
	public List<Board> boardList(Paging paging) {
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardRepository.boardList(board);
	}
	@Override
	public int getBoardTotCnt() {
		return boardRepository.getBoardTotCnt();
	}
	@Override
	public int boardWrite(MultipartHttpServletRequest mRequest, HttpServletRequest request) {
		String uploadPath = mRequest.getRealPath("upload/");
		String bfileName = null;
		Iterator<String> params = mRequest.getFileNames(); 
		//while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			bfileName = mFile.getOriginalFilename(); // 업로그한 파일명
			// 첨부 여부
			if(bfileName!=null && !bfileName.equals("")) {
				// 첨부함
				if(new File(uploadPath + bfileName).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재 : 현재밀리세컨+파일이름
					bfileName = System.currentTimeMillis() + bfileName;
				}// 중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + bfileName));// 서버에 파일 저장
					logger.info("서버에 저장된 파일 : " + uploadPath + bfileName);
					logger.info("복사될 파일 : " + backupPath + bfileName);
					boolean result = filecopy(uploadPath+bfileName, backupPath+bfileName);
					logger.info(result ? "백업성공":"백업실패");
				} catch (IOException e) {
					logger.error(e.getMessage());
				} 
			}
		//}
		Board board = new Board();
		board.setBname(mRequest.getParameter("bname"));
		board.setBtitle(mRequest.getParameter("btitle"));
		board.setBcontent(mRequest.getParameter("bcontent"));
		board.setBfileName(bfileName);
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardWrite(board);
	}
	@Override
	public int boardWrite(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		logger.info("글쓰기 시작");
		String uploadPath = mRequest.getRealPath("upload/");
		String bfileName = null;
		Iterator<String> params = mRequest.getFileNames(); 
		//while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			bfileName = mFile.getOriginalFilename(); // 업로그한 파일명
			// 첨부 여부
			if(bfileName!=null && !bfileName.equals("")) {
				// 첨부함
				if(new File(uploadPath + bfileName).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재 : 현재밀리세컨+파일이름
					bfileName = System.currentTimeMillis() + bfileName;
				}// 중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + bfileName));// 서버에 파일 저장
					logger.info("서버에 저장된 파일 : " + uploadPath + bfileName);
					logger.info("복사될 파일 : " + backupPath + bfileName);
					boolean result = filecopy(uploadPath+bfileName, backupPath+bfileName);
					logger.info(result ? "백업성공":"백업실패");
				} catch (IOException e) {
					logger.error(e.getMessage());
				} 
			}else {
				logger.info("첨부 안 함");
			}
		//}
		board.setBfileName(bfileName);
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardWrite(board);
	}
	@Override
	public Board boardContent(int bid, String after) {
		if(after==null) { // after는  "u"(수정완료후)이거나 null(list에서 옴)
			boardRepository.boardHitUp(bid);
		}
		return boardRepository.getBoardDto(bid);
	}
	@Override
	public Board boardModifyReplyView(int bid) {
		return boardRepository.getBoardDto(bid);
	}
	@Override
	public int boardModify(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		String uploadPath = mRequest.getRealPath("upload/");
		String filename = null;
		Iterator<String> params = mRequest.getFileNames(); 
		//while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			filename = mFile.getOriginalFilename(); // 업로그한 파일명
			// 첨부 여부
			if(filename!=null && !filename.equals("")) {
				// 첨부함
				if(new File(uploadPath + filename).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재 : 현재밀리세컨+파일이름
					filename = System.currentTimeMillis() + filename;
				}// 중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + filename));// 서버에 파일 저장
					logger.info("서버에 저장된 파일 : " + uploadPath + filename);
					logger.info("복사될 파일 : " + backupPath + filename);
					boolean result = filecopy(uploadPath+filename, backupPath+filename);
					logger.info(result ? "백업성공":"백업실패");
				} catch (IOException e) {
					logger.error(e.getMessage());
				} 
			}
		//}
		// 파일 첨부를 안 했으면 update문에서 빠짐(xml mapper에서 처리함) 
		logger.info(filename.equals("") ? "첨부파일은 수정 안 함":"첨부파일도 수정함");
		board.setBfileName(filename);
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardModify(board);
	}
	@Override
	public int boardDelete(int bid) {
		return boardRepository.boardDelete(bid);
	}
	@Override
	public int boardReply(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		String uploadPath = mRequest.getRealPath("upload/");
		String bfileName = null;
		Iterator<String> params = mRequest.getFileNames(); 
		//while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			bfileName = mFile.getOriginalFilename(); // 업로그한 파일명
			// 첨부 여부
			if(bfileName!=null && !bfileName.equals("")) {
				// 첨부함
				if(new File(uploadPath + bfileName).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재 : 현재밀리세컨+파일이름
					bfileName = System.currentTimeMillis() + bfileName;
				}// 중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + bfileName));// 서버에 파일 저장
					logger.info("서버에 저장된 파일 : " + uploadPath + bfileName);
					logger.info("복사될 파일 : " + backupPath + bfileName);
					boolean result = filecopy(uploadPath+bfileName, backupPath+bfileName);
					logger.info(result ? "백업성공":"백업실패");
				} catch (IOException e) {
					logger.error(e.getMessage());
				} 
			}
		//}
		board.setBfileName(bfileName);
		board.setBip(request.getRemoteAddr());
		boardRepository.boardPreReplyStep(board);
		return boardRepository.boardReply(board);
	}
	@Override
	public void dummyData60Write() {
		for(int i=1 ; i<=60 ; i++){
			Board board = new Board();
			board.setBname("홍길동" + i);
			board.setBtitle("제목 " + i);
			if(i%5==0) {
				board.setBfileName("a.txt");
			}
			board.setBip("192.168.1." + i);
			int result = boardRepository.boardWrite(board);
			System.out.println(result==1? i+"번째 성공": i+"번째 실패");
		}//for
	}//dummyData60Write
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				int nReadBytes = is.read(bs);
				if(nReadBytes == -1) break;
				os.write(bs, 0, nReadBytes);
			}
			isCopy = true;
		} catch (IOException e) {
			logger.error(e.getMessage());
		}finally {
			try {
				if(is!=null) is.close();
				if(os!=null) os.close();
			}catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return isCopy;
	}
}//class