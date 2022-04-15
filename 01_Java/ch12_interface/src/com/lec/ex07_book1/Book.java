package com.lec.ex07_book1;

public class Book implements ILendable {
	
	private String bookNo; //å ��ȣ
	private String booktitle; // å ����
	private String writer; // ����
	private String borrower;// å ������
	private String checkOutDate;// ������
	private int state; // ���� ��(1), ���Ⱑ��(0)
	
	public Book(String bookNo, String booktitle, String writer) {
		this.bookNo = bookNo;
		this.booktitle = bookNo;
		this.writer = writer;
		
	}

	@Override
	public void checkOut(String borrower, String checkoytDate) {
		if (state == STATE_BORROWED) {
			System.out.println(booktitle+"������ ���� �� �Դϴ�");
			return;
		}
			this.borrower = borrower;
			this.checkOutDate = checkoytDate;
			state = STATE_BORROWED;
			System.out.println(booktitle+"����ó�� �Ǿ���");
			System.out.println("������"+borrower+"/t ������ : " +checkOutDate);
		

	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(booktitle+"������ �ݳ��� å�ε� ��������");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(booktitle+ "������ �ݳ� �Ϸ� �Ǿ����ϴ�.");

	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + booktitle +"("+ writer +"����) ���Ⱑ��");
		} else if (state ==STATE_BORROWED) {
			System.out.println(bookNo + "\t" + booktitle +"("+ writer +"����) ������");
		}else {
			System.out.println(bookNo + "\t" + booktitle +"("+ writer +"����) �̻���");
		}
//		String msg = bookNo + "\t" + booktitle +"("+ writer +"����)";
//		msg = msg + ((state == STATE_NORMAL) ? "���Ⱑ��" : (state == STATE_BORROWED)? "������" : "�̻���");
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
