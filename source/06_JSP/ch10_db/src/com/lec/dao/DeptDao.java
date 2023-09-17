package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.DeptDto;

public class DeptDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";
	private static DeptDao INSTANCE;//기본 null로 초기화
	public static DeptDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new DeptDao();
		}
		return INSTANCE;
	}
	private DeptDao() {
		try {
			Class.forName(driver);// 1단계 드라이버로드는 한번만
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//ArrayList<DeptDto>를 반환하는 기능
	public ArrayList<DeptDto> deptList(){
		ArrayList<DeptDto> dtos =  new ArrayList<DeptDto>();
		// DB에서 결과받아 dtos에 add
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, uid, upw);//(2)
			stmt = conn.createStatement();//(3)
			rs = stmt.executeQuery(sql);//(4)+(5)
//			while(rs.next()) {
//				int deptno = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getNString("loc");
//				dtos.add(new DeptDto(deptno,dname,loc));
//			}
			while(rs.next()) {
				DeptDto dto = new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}











