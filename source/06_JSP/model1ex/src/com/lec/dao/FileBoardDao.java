package com.lec.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.lec.dto.FileBoardDto;
// connection pool이용, 싱글톤은 옵션
public class FileBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	// 싱글톤
	private static FileBoardDao instance = new FileBoardDao();
	public static FileBoardDao getInstance() {
		return instance;
	}
	private FileBoardDao() {}
	// Connection 객체 얻어오는 함수
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 글목록(startRow부터 endRow까지 리스트)
	public ArrayList<FileBoardDto> listFBoard(int startRow, int endRow){
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * " + 
				"  FROM (SELECT ROWNUM RN, A.*  " + 
				"        FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C  " + 
				"          WHERE F.CID = C.CID " + 
				"          ORDER BY fGROUP DESC, fSTEP) A) " + 
				"  WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fid        = rs.getInt("fid");
				String cid      = rs.getString("cid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String filename= rs.getString("filename");
				int    fhit     = rs.getInt("fhit");
				String fpw      = rs.getString("fpw");
				int    fgroup     = rs.getInt("fgroup");
				int    fstep = rs.getInt("fstep");
				int    findent= rs.getInt("findent");
				String fip      = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				String cname    = rs.getString("cname");
				String cemail   = rs.getString("cemail");
				dtos.add(new FileBoardDto(fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip, frdate, cname, cemail));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return dtos;
	}
	// 2. 전체 글 갯수
	public int getFBoardTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("cnt");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return totCnt;
	}
	// 3. 원글쓰기 - 글제목, 본문, 첨부파일, 비번, IP
	public int writeFBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, cID, fTITLE, fCONTENT, FILENAME, fPW, " + 
				"                fGROUP, fSTEP, fINDENT, fIP)" + 
				"        VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?," + 
				"                FILEBOARD_SEQ.CURRVAL, 0,0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println("원글 쓰기 성공");
		}catch (SQLException e) {
			System.out.println(e.getMessage() + " - 원글 쓰기 실패 : " + dto);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	
	// 4. FID로 조회수 1 올리기 (글상세보기시 필요)
	public void hitUp(int fid) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	// 5. bID로 DTO가져오기
	public FileBoardDto getFBoard(int fid){
		FileBoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C " + 
				"  WHERE F.CID = C.CID AND FID=?" + 
				"  ORDER BY fGROUP DESC, fSTEP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid      = rs.getString("cid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String filename= rs.getString("filename");
				int    fhit     = rs.getInt("fhit");
				String fpw      = rs.getString("fpw");
				int    fgroup     = rs.getInt("fgroup");
				int    fstep = rs.getInt("fstep");
				int    findent= rs.getInt("findent");
				String fip      = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				String cname    = rs.getString("cname");
				String cemail   = rs.getString("cemail");
				dto = new FileBoardDto(fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip, frdate, cname, cemail);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 6. 글수정 (글제목, 본문, 이메일, 첨부파일, 비번, IP 수정)
	public int modifyFBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD " + 
				"  SET  " + 
				"      FTITLE = ?, " + 
				"      FCONTENT = ?, " + 
				"      FILENAME = ?, " + 
				"      FPW    = ?, " + 
				"      FIP    = ? " + 
				"  WHERE FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFtitle());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글수정 성공" : "해당 글번호가 없어서 글 수정 실패");
		}catch (SQLException e) {
			System.out.println(e.getMessage() + "글수정 쓰기 실패 : " + dto);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 7. 글삭제(비번을 맞게 입력한 경우만 삭제)
	public int deleteFBoard(int fid, String fpw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID=? AND FPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.setString(2, fpw);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글삭제 성공" : "글삭제 실패(비번확인)");
		}catch (SQLException e) {
			System.out.println(e.getMessage() + "글삭제 실패");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 8. 답변글 쓰기 전 단계( 엑셀 ⓐ단계)
	private void preReplyStep(int fgroup, int fstep) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+1 WHERE FGROUP=? AND FSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			int result = pstmt.executeUpdate();
			System.out.println(result==0? "첫답변이네": result+"행 fstep 조정");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 9. 답변글 쓰기
	public int replyFBoard(FileBoardDto dto) {
		// fid, fgroup, fstep, flevel : 원글의 정보
		// cid, ftitle, fcontent, filename, fpw, fip : 답변글의 정보
		preReplyStep(dto.getFgroup(), dto.getFstep());
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, cID, fTITLE, fCONTENT, FILENAME, fPW, " + 
				"                fGROUP, fSTEP, fINDENT, fIP)" + 
				"        VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?," + 
				"                ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFgroup()); // 답변글은 원글의 fref
			pstmt.setInt(7, dto.getFstep()+1); // 답변글은 원글의 fre_step + 1
			pstmt.setInt(8, dto.getFindent()+1); // 답변글은 원글의 fre_level+1
			pstmt.setString(9, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println("답변글 쓰기 성공");
		}catch (SQLException e) {
			dto.setFstep(dto.getFgroup()+1);
			dto.setFindent(dto.getFindent()+1);
			System.out.println(e.getMessage() + "답변글 쓰기 실패 : " + dto);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return result;
	}
}