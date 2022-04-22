package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null ;
		try {
			Class.forName(driver);// �� ����̹�����
			System.out.println("����̹� �˻� ����");
			//�� �����ͺ��̽� ����
			conn = 
			DriverManager.getConnection(url,"victor","1234");
			System.out.println("DB ���� ����");
			//��SQL������ ��ü�����ؼ� SQL������ ��� �ް� ����
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"����̹�����");
		}catch (SQLException e) {
			System.out.println(e.getMessage()+"DB�������");
		} finally {
			try {if(conn!=null) conn.close(); // ���� ����
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"�ݱ����");
			}
		}

	}
}
