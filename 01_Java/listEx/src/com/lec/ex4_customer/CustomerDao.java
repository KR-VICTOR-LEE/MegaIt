package com.lec.ex4_customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}	
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 0. 레벨이름들 검색
	public Vector<String> getLevelNames(){
		Vector<String> levelNames = new Vector<String>();
		levelNames.add("");
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql);
			while(rs.next()) {
				levelNames.add(rs.getString("levelname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}//
		return levelNames;
	}
	// 1.아이디검색
	public CustomerDto cIdGetCustomer(int cid) {
		CustomerDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//int cId는 매개변수로 받은 거
				String ctel     = rs.getString("ctel");
				String cname    = rs.getString("cname");
				int    cpoint   = rs.getInt("cpoint");
				int    camount  = rs.getInt("camount");
				String levelName= rs.getString("levelName");
				int    forLevelUp=rs.getInt("forLevelUp");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}//
		return dto;
	}
	// 2.폰4자리(FULL)검색: 
	public ArrayList<CustomerDto> cTelGetCustomer(String ctel){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid      = rs.getInt("cid");
				       ctel     = rs.getString("ctel");
				String cname    = rs.getString("cname");
				int    cpoint   = rs.getInt("cpoint");
				int    camount  = rs.getInt("camount");
				String levelName= rs.getString("levelName");
				int    forLevelUp=rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}//
		return dtos;
	}
	// 3.고객이름검색 : 
	public ArrayList<CustomerDto> cNameGetCustomer(String cname){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND CNAME=? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid      = rs.getInt("cid");
				String ctel     = rs.getString("ctel");
				// String cname    = rs.getString("cname");
				int    cpoint   = rs.getInt("cpoint");
				int    camount  = rs.getInt("camount");
				String levelName= rs.getString("levelName");
				int    forLevelUp=rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}//
		return dtos;
	}
	// 4.포인트로만 구매(1번 id가 100원 구매) : 
	public int buyWithPoint(int cid, int camount) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 5.물품구매 : 
	public int buy(int cid, int camount) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT + ( ? * 0.05), " + 
				"          cAMOUNT = cAMOUNT + ? , " + 
				"          LEVELNO = (SELECT L.LEVELNO " + 
				"                     FROM CUSTOMER C, CUS_LEVEL L" + 
				"                     WHERE CAMOUNT + ? BETWEEN LOW AND HIGH AND CID=?)" + 
				"    WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 6.등급별출력 : 
	public ArrayList<CustomerDto> levelNameGetCustomer(String levelName){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME=? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid      = rs.getInt("cid");
				String ctel     = rs.getString("ctel");
				String cname    = rs.getString("cname");
				int    cpoint   = rs.getInt("cpoint");
				int    camount  = rs.getInt("camount");
				//String levelName= rs.getString("levelName");
				int    forLevelUp=rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}//
		return dtos;
	}
	// 7.전체출력 : 
	public ArrayList<CustomerDto> getCustomers(){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,  " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp " + 
				"    FROM CUSTOMER C, CUS_LEVEL L " + 
				"    WHERE C.LEVELNO = L.LEVELNO ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid      = rs.getInt("cid");
				String ctel     = rs.getString("ctel");
				String cname    = rs.getString("cname");
				int    cpoint   = rs.getInt("cpoint");
				int    camount  = rs.getInt("camount");
				String levelName= rs.getString("levelName");
				int    forLevelUp=rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}//
		return dtos;
	}
	// 8.회원가입 : 
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME) " + 
				"    VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 9.번호수정 : 
	public int updateCustomer(int cid, String ctel) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 10.회원탈퇴 : 
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL = ?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
}





