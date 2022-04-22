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
			Class.forName(driver);// ① 드라이버연결
			System.out.println("드라이버 검색 성공");
			//② 데이터베이스 연결
			conn = 
			DriverManager.getConnection(url,"victor","1234");
			System.out.println("DB 연결 성공");
			//③SQL실행할 객체생성해서 SQL날리고 결과 받고 쓰기
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"드라이버오류");
		}catch (SQLException e) {
			System.out.println(e.getMessage()+"DB연결실패");
		} finally {
			try {if(conn!=null) conn.close(); // 연결 끊기
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"닫기오류");
			}
		}

	}
}
