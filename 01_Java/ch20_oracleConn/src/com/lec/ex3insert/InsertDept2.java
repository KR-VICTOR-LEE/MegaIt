package com.lec.ex3insert;

// 부서번호를 입력받아 중복체크 확인 후 입력진행
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("입력할 부서번호는 ?");
		int deptno = scanner.nextInt();
		// 부서번호 중복체크
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);// (1)
			conn = DriverManager.getConnection(url, "victor", "1234"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(selectSQL); // (4)+(5)
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("중복된 부서번호는 입력이 불가합니다.");
			} else {
				System.out.print("입력할 부서이름은 ?");
				String dname = scanner.next();
				System.out.print("입력할 부서위치는 ?");
				scanner.nextLine(); // 버퍼 clear
				String loc = scanner.nextLine();
				String insertSql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSql);
				if (result > 0) {
					System.out.println("입력 성공");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 :" + e.getMessage());
		} finally {
			try { // (7)
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
	}
}
