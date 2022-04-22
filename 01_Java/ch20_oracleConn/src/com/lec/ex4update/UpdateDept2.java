package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.createStatement();
			System.out.print("수정할 부서번호 ?");
			int deptno = scanner.nextInt();
			// 입력한 부서번호가 있는지 체크
			String selectSql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
			rs = stmt.executeQuery(selectSql);
			if(rs.next()) { // 수정진행
				System.out.print("수정할 부서명 ?");
				String dname = scanner.next();
				System.out.print("수정할 위치는 ?");
				String loc = scanner.next();
				// 수정
				String insertSql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+
									loc+"' WHERE DEPTNO="+deptno;
				int result = stmt.executeUpdate(insertSql); 
				System.out.println(result>0? "수정성공":"수정실패");
			}else {
				System.out.println(deptno+"번 부서번호는 유효한 부서번호가 아닙니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // (7)
				if(rs!=null)   rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}// main
}
