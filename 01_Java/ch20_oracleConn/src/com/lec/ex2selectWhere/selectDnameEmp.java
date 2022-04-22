package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class selectDnameEmp {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서명은 ? ");
		String dname = scanner.next();
		String sql1 =  "SELECT * FROM DEPT WHERE DNAME=UPPER('"+dname+"')";
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')",dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE "+ 
						" FROM EMP E, SALGRADE, DEPT D " + 
						" WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO "+
						" AND DNAME = UPPER('%s')",dname);
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,"victor","1234");
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql1);
			if (rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno") );
				System.out.println("부서이름 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade+"등급");
						
					} while (rs.next());
				}else {
					System.out.println(dname + "부서의 사원은 존재하지 않습니다.");
				}
			}else {
				System.out.println("해당 부서이름은 유효하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}

}
