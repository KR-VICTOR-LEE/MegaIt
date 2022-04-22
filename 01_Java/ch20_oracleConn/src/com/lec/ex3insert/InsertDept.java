package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력할 부서번호는 ?");
		int deptno = scanner.nextInt();
		System.out.println("입력할 부서명은 ?");
		String dname = scanner.next();
		System.out.println("입력할 부서위치는 ?");
		String loc = scanner.next();
		String sql = "INSERT INTO DEPT VALUES(" + deptno + ",'" + dname + "','" + loc + "')";
		sql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')", deptno, dname, loc);
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력성공" : "입력실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
