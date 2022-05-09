package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �����ϰ��� �ϴ� �μ���ȣ�� �Է¹޾� �����ϱ�
public class DeleteDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.println("������ �μ���ȣ��?");
		int deptno = scanner.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0?deptno+"�� �μ� ��������" : deptno + "�� �μ��� �������� �ʽ��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����"+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql����"+e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}