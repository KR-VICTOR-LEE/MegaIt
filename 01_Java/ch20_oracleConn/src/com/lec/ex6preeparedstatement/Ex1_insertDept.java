package com.lec.ex6preeparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex1_insertDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 추가할 데이터 받기
		System.out.println("추가할 부서번호 ?");
		int deptno = sc.nextInt();
		System.out.println("추가할 부서이름 ? ");
		String dname = sc.next();
		System.out.println("추가할 부서 위치 ?");
		String loc = sc.next();
		String sql = "INSERT INTO DEPT VALUES(?,?,?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); 
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "번 부서 입력 성공" : "입력 실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
