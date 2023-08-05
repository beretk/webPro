package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

//�����ϰ��� �ϴ� �μ���ȣ�� �Է¹޾� delete
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(deptno + "�� �μ� ���� ����");
			} else {
				System.out.println(deptno + "�� �μ��� ��ȿ�� �μ���ȣ�� �ƴմϴ�");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(stmt!=null)stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} //try-catch-finally
	}
}
