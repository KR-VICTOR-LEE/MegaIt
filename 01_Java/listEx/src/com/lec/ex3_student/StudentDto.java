package com.lec.ex3_student;

public class StudentDto {
	private int rank;   // 등수
	private String sNo;    // 학번
	private String sName;  // 학생이름
	private String mName;  // 학과이름
	private int score;     // 점수
	public StudentDto() {}
	// 입력용
	public StudentDto(String sName, String mName, int score) {
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	// 수정용
	public StudentDto(String sNo, String sName, String mName, int score) {
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	// 출력용
	public StudentDto(int rank, String sNo, String sName, String mName, int score) {
		this.rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	@Override
	public String toString() {
		if(rank!=0) {
			return rank+"등\t"+sName+"\t"+mName+"\t"+score;
		}else {
			return sNo+"\t"+sName+"\t"+mName+"\t"+score;
		}
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}