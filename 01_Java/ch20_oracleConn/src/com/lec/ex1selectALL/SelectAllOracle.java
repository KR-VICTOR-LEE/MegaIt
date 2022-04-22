package com.lec.ex1selectALL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {

	public static void main(String[] args) {
		 String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	      Connection conn = null; // DB ���� ��ü ����
	      Statement stmt = null; // SQL ���� ��ü ����
	      ResultSet rs = null; // select�� ��� �޴� ��ü ����
	      String query = "SELECT * FROM EMP";
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url, "victor", "1234");// (2)DB
	         stmt = conn.createStatement(); // (3) SQL ���� ��ü ����
	         rs = stmt.executeQuery(query); // (4) SQL ���� + (5) SQL���� ��� �ޱ�
	         // (6) ��� �޾� ���ϴ� ���� ����
	         System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t�޿�\t��\t�μ���ȣ");
	         while (rs.next()) { // rs.next() rs�� �� �������� ����Ű�� false�� ��Ÿ����.
	                        // 14�� �߿��� ������� ��Ÿ���� ����

	            // String empno = rs.getString("empno");
	            // String hiredate = rs.getString("hiredate");
	            // Date hiredate = rs.getDate("hiredate");
	            int empno = rs.getInt("empno"); // Ư������ ������ ��Ī title ���ؼ� �Է�
	            String ename = rs.getString("ename");
	            String job = rs.getString("job");
	            int mgr = rs.getInt("mgr");
	            Timestamp hiredate = rs.getTimestamp("hiredate");
	            int sal = rs.getInt("sal");
	            int comm = rs.getInt("comm");
	            int deptno = rs.getInt("deptno");
	            if(job.length() <= 7) {
	               System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\n ",empno, ename, job, mgr, hiredate, sal,
	                     comm, deptno);
	            }else {
	               if(job.length() >=7)
	                  System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\n ",empno, ename, job, mgr, hiredate, sal,
	                        comm, deptno);
	            }
	         }
	      } catch (ClassNotFoundException e) {
	         System.out.println(e.getMessage());
	      } catch (SQLException e) {
	         System.out.println(e.getMessage());
	      } finally { // (7) ���� ���� close�� �������� �ؾ��Ѵ�
	         try {
	            if (rs != null)
	               rs.close();
	            if (stmt != null)
	               stmt.close();
	            if (conn != null)
	               conn.close();

	         } catch (SQLException e) {
	         }
	      }
	   }
	}