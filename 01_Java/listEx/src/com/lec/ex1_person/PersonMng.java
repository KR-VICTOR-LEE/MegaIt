package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersonMng {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String fn, sql;
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		do {
			System.out.println("1:입력 || 2 :직업별조회 || 3:전체조회 || 그외: 종료");
			fn = sc.next();
			switch (fn) {
			case "1" : // 이름, 직업명, 국, 영, 수 입력받아 insert
					sql ="INSERT INTO PERSON " + 
						" VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "victor", "1234");
					pstmt = conn.prepareStatement(sql);
					System.out.println("입력할 이름은?");
					pstmt.setString(1, sc.next());
					System.out.println("직업은? (배우, 가수)");
					pstmt.setString(2, sc.next());
					System.out.println("국어점수 입력");
					pstmt.setInt(3, sc.nextInt());
					System.out.println("영어점수 입력");
					pstmt.setInt(4, sc.nextInt());
					System.out.println("수학점수 입력");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "입력성공" : "입력실패");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} finally {
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			case "2" :
				sql = "SELECT ROWNUM RANK, A.* " + 
						" FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM\r\n" + 
						" FROM PERSON P, JOB J " + 
						" WHERE P.JNO=J.JNO AND JNAME=? " + 
						" ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url,"victor","1234");
					pstmt = conn.prepareStatement(sql);
					System.out.println("직업은 ? (배우, 가수)");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t이름\t\t직업\t국\t영\t수\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int	kor = rs.getInt("kor");
							int eng =  rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"등\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
							
						} while (rs.next());
					} else {
						System.out.println("해당 직업의 사람이 입력되지 않았습니다.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
						if(rs != null) rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			case "3" :
				sql = "SELECT ROWNUM RANK, A.* " + 
						" FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM\r\n" + 
						" FROM PERSON P, JOB J " + 
						" WHERE P.JNO=J.JNO" + 
						" ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url,"victor","1234");
					//pstmt = conn.prepareStatement(sql);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("rank\t이름\t\t직업\t국\t영\t수\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int	kor = rs.getInt("kor");
							int eng =  rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"등\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
							
						} while (rs.next());
					} else {
						System.out.println("해당 직업의 사람이 입력되지 않았습니다.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("종료");
	}

}
