package com.lec.ex07_book1;

public class Book implements ILendable {
	
	private String bookNo; //책 번호
	private String booktitle; // 책 제목
	private String writer; // 저자
	private String borrower;// 책 대출인
	private String checkOutDate;// 대출일
	private int state; // 대출 중(1), 대출가능(0)
	
	public Book(String bookNo, String booktitle, String writer) {
		this.bookNo = bookNo;
		this.booktitle = bookNo;
		this.writer = writer;
		
	}

	@Override
	public void checkOut(String borrower, String checkoytDate) {
		if (state == STATE_BORROWED) {
			System.out.println(booktitle+"도서는 대출 중 입니다");
			return;
		}
			this.borrower = borrower;
			this.checkOutDate = checkoytDate;
			state = STATE_BORROWED;
			System.out.println(booktitle+"대출처리 되었음");
			System.out.println("대출인"+borrower+"/t 대출일 : " +checkOutDate);
		

	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(booktitle+"도서는 반납된 책인데 문제생김");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(booktitle+ "도서가 반납 완료 되었습니다.");

	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + booktitle +"("+ writer +"지음) 대출가능");
		} else if (state ==STATE_BORROWED) {
			System.out.println(bookNo + "\t" + booktitle +"("+ writer +"지음) 대출중");
		}else {
			System.out.println(bookNo + "\t" + booktitle +"("+ writer +"지음) 이상함");
		}
//		String msg = bookNo + "\t" + booktitle +"("+ writer +"지음)";
//		msg = msg + ((state == STATE_NORMAL) ? "대출가능" : (state == STATE_BORROWED)? "대출중" : "이상함");
//		System.out.println(msg);
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

}
