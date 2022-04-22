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
			System.out.println("1:�Է� || 2 :��������ȸ || 3:��ü��ȸ || �׿�: ����");
			fn = sc.next();
			switch (fn) {
			case "1" : // �̸�, ������, ��, ��, �� �Է¹޾� insert
					sql ="INSERT INTO PERSON " + 
						" VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "victor", "1234");
					pstmt = conn.prepareStatement(sql);
					System.out.println("�Է��� �̸���?");
					pstmt.setString(1, sc.next());
					System.out.println("������? (���, ����)");
					pstmt.setString(2, sc.next());
					System.out.println("�������� �Է�");
					pstmt.setInt(3, sc.nextInt());
					System.out.println("�������� �Է�");
					pstmt.setInt(4, sc.nextInt());
					System.out.println("�������� �Է�");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
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
						" FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM\r\n" + 
						" FROM PERSON P, JOB J " + 
						" WHERE P.JNO=J.JNO AND JNAME=? " + 
						" ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url,"victor","1234");
					pstmt = conn.prepareStatement(sql);
					System.out.println("������ ? (���, ����)");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t�̸�\t\t����\t��\t��\t��\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int	kor = rs.getInt("kor");
							int eng =  rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"��\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
							
						} while (rs.next());
					} else {
						System.out.println("�ش� ������ ����� �Էµ��� �ʾҽ��ϴ�.");
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
						" FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM\r\n" + 
						" FROM PERSON P, JOB J " + 
						" WHERE P.JNO=J.JNO" + 
						" ORDER BY SUM DESC) A ";
				try {
					conn = DriverManager.getConnection(url,"victor","1234");
					//pstmt = conn.prepareStatement(sql);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("rank\t�̸�\t\t����\t��\t��\t��\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int	kor = rs.getInt("kor");
							int eng =  rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"��\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
							
						} while (rs.next());
					} else {
						System.out.println("�ش� ������ ����� �Էµ��� �ʾҽ��ϴ�.");
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
		System.out.println("����");
	}

}
