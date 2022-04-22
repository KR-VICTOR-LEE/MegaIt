package com.lec.ex6preeparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
public class Ex2_select {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("�μ��� �Է�");
		String dname = sc.next();
		String sql = "SELECT EMPNO, ENAME, JOB, SAL \r\n" + 
				"    FROM EMP E, DEPT D\r\n" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"victor","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
				} while (rs.next());
			} else {
				System.out.println(dname + "���� �μ���");
			} 
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
