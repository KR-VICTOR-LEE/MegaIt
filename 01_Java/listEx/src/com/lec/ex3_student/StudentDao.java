package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {
// 학번검색, 이름검색, 전공검색, 학생입력, 학생수정, 학생출력, 제적자출력, 제적처리

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static StudentDao INSTANCE;

	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public Vector<String> getmNamelist() {
		Vector<String> mNames = new Vector<String>();
		mNames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mNames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return mNames;

	}

	public StudentDto sNogetStudent(String sNo) {
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE " + " FROM MAJOR M, STUDENT S" + "WHERE M.MNO=S.MNO AND  SNO=?";
		try {
			conn = DriverManager.getConnection(sql, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dto = new StudentDto(sNo, sName, mName, score);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dto;
	}

	public ArrayList<StudentDto> selectsName(String sName) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE " + "    FROM STUDENT S, MAJOR M"
				+ "    WHERE S.MNO=M.MNO AND SNAME=?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sNo = rs.getString("sNo");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(sNo, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dtos;
	}

	public ArrayList<StudentDto> mNamegetStudent(String mName) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE\r\n"
				+ "    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE "
				+ "                FROM STUDENT S, MAJOR M " + "                WHERE S.MNO=M.MNO AND MNAME= ? "
				+ "                ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, null, sName, mName, score));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SERT INTO STUDENT (SNO, SNAME, MNO, SCORE) "
				+ "    VALUES (EXTRACT(YEAR FROM SYSDATE)||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0'), ?, "
				+ "            (SELECT MNO FROM MAJOR WHERE MNAME=?), ?)";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmName());
			pstmt.setString(2, dto.getsName());
			pstmt.setInt(3, dto.getScore());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SNAME=?, " + "                   MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?), "
				+ " SCORE = ?" + "WHERE SNO=?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
			pstmt.setString(4, dto.getsNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

	public ArrayList<StudentDto> getStudents() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE "
				+ "    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE "
				+ "                FROM STUDENT S, MAJOR M\r\n" + "                WHERE S.MNO=M.MNO AND SEXPEL=1"
				+ "                ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, null, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	public ArrayList<StudentDto> getStudentsExpel() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE "
				+ "    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE "
				+ "                FROM STUDENT S, MAJOR M " + "                WHERE S.MNO=M.MNO AND SEXPEL=1 "
				+ "                ORDER BY SCORE DESC)";
		try {
			while (rs.next()) {
				conn = DriverManager.getConnection(url, "victor", "1234");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, null, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;

	}

	public int sNoExpel(String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SEXPEL = 1 WHERE SNO=?";
		try {
			conn = DriverManager.getConnection(url, "victor", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;

	}
}
