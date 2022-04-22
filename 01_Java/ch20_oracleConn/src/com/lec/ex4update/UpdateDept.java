package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.createStatement();
			System.out.println("������ �μ���ȣ ?");
			int deptno = scanner.nextInt();
			// �Է��� �μ���ȣ�� �ִ��� ������ üũ�� ����
			System.out.println("������ �μ��� ?");
			String dname = scanner.next();
			System.out.println("������ ��ġ�� ? ");
			String loc = scanner.next();
			String sql = "UPDATE DEPT SET DNAME = '" + dname + "', LOC='" + loc + "' WHERE DEPTNO = " + deptno;
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "��������" : "�ش� �μ��� ���� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { // (7)
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
	}
}
