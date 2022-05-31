package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MemberDao {
	public static final int SUCCESS = 1; // ȸ������, �������� �� ���� ���ϰ�
	public static final int FAIL    = 0; // ȸ������, �������� �� ���� ���ϰ�
	public static final int MEMBER_EXISTENT = 0; // �ߺ��� ID�� �� ���ϰ�
	public static final int MEMBER_NONEXISTENT = 1; // ��밡���� ID�� �� ���ϰ�
	public static final int LOGIN_SUCCESS = 1; // �α��� ������ ���ϰ�
	public static final int LOGIN_FAIL_ID = -1; // �α��ν� ID������ �� ���ϰ�
	public static final int LOGIN_FAIL_PW = 0; // �α��ν� PW������ �� ���ϰ�
	
	// �̱���
	private static MemberDao instance; // �ڱⰡ �ڱ� Ŭ���� ����
	public static MemberDao getInstance() {
		if(instance==null) {
			instance = new MemberDao();
		}
		return instance;
	}	
	private MemberDao() {}
	// conn��ü �����ϴ� �Լ�
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver"); // (1)
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
																"victor", "1234"); // (2)
		return conn;
	}
	//1. ȸ�����Խ� ID�ߺ�üũ : 
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT; // �ʱ�ȭ
		// �ߺ����� ��밡������ sql���� ��ȸ : SELECT * FROM MEMBER WHERE ID='aaa'
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // (4)+(5)
			if(rs.next()) {
				result = MEMBER_EXISTENT; // �ִ� ID (ȸ�����Խ� �ߺ��� ID)
			}else {
				result = MEMBER_NONEXISTENT; // ���� ID (ȸ�����Խ� ��밡���� ID)
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	//2. ȸ������ : INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
    			//VALUES ('aaa','111','ȫ�浿','02','1111','1111','m','hong@h.com', '1995-12-12', SYSDATE, '����'); 
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		// dto DB�� insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, "
				+ 							"EMAIL, BIRTH, RDATE, ADDRESS)" + 
				"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setTimestamp(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "ȸ�����Լ���":"ȸ�����Խ���");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ȸ������ ���� : " + dto);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	//3. �α���(id/pw) : SELECT id, pw FROM MEMBER WHERE ID='aaa';
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID; // �ʱ�ȭ
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // (4)+(5)
			if(rs.next()) { // ��ȿ�� ID
				String pwDB = rs.getString("pw");
				if(pwDB.equals(pw)) { // pw�� �´��� üũ
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;
				}
			}else { // ��ȿ���� ���� ID
				result = LOGIN_FAIL_ID;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	//4. ID�� dto�������� : SELECT * FROM MEMBER WHERE ID='aaa';
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // (4)+(5)
			if(rs.next()) {
				String pw     = rs.getString("pw");
				String name   = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email  = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth");
				Date      rdate = rs.getDate("rdate");
				String    address = rs.getString("address");
				dto = new MemberDto(id, pw, name, phone1, phone2, 
						phone3, gender, email, birth, rdate, address);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	//5. ȸ������ ���� : 
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		// dto DB�� update
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW=?, " + 
				"                NAME = ?, " + 
				"                PHONE1 = ?, " + 
				"                PHONE2 = ?, " + 
				"                PHONE3 = ?, " + 
				"                GENDER = ?, " + 
				"                EMAIL = ?, " + 
				"                BIRTH = ?, " + 
				"                ADDRESS = ?" + 
				"            WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setTimestamp(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "ȸ����������":"ȸ����������");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ȸ������ ���� : " + dto);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
}




