package com.lec.ex08_book2;

import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {
		
		BookLib[] books = {new BookLib("2022-03-01", "java", "홍길동"),
						   new BookLib("2022-03-02", "oracle", "김길동"),
						   new BookLib("2022-03-03", "mysql", "유길동"),
						   new BookLib("2022-03-04", "jsp", "고길동"),
						   new BookLib("2022-03-05", "spring", "김길동")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;
		
		do {
	         System.out.println(("1:대출| 2:반납| 3:책list |0:종료"));
	         fn = sc.nextInt();
	         switch (fn) {
	         case 1: 
	            //대출처리 : 1.책이름 입력  2.책 조회  3.책상태확인 4.대출인 입력 5.대출날짜 6.대출메소드 호출 checkout
	            //1. 책 이름 입력 
	            System.out.print("대출하고자 하는 책 이름은 ? : ");
	            bTitle = sc.next(); //white-space 앞까지의 스트링만 받음 
	            //2. 책 조회 
	            
	            for(idx = 0; idx<books.length ; idx++) {
	               if(bTitle.equals(books[idx].getBookTitle())) {
	                  break;
	               }
	            }
	            if(idx == books.length) {
	               System.out.println("현재 보유하지 않은 도서입니다");
	            }else { 
	               
	               if(books[idx].getState() == BookLib.STATE_BORROWED) {  
	                  System.out.println("죄송합니다 현재 대출중인 도서입니다.");
	               }else { 
	                  System.out.println("대출자는 ? : ");
	                  borrower = sc.next();
	                  System.out.println("대출 날짜는 ? : ");
	                  checkOutDate = sc.next();
	                  books[idx].checkOut(borrower, checkOutDate);
	                  }
	            }
	            break;
	         case 2: 
	            // 1. 책이름 
	            System.out.println("반납할 책 이름은? : ");
	            bTitle = sc.next();
	            //2. 책조회 
	            for(idx = 0; idx<books.length ; idx++) {
	               if(bTitle.equals(books[idx].getBookTitle())) {
	                  break;
	               }
	            }
	            if(idx==books.length) {
	               System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
	            }else { 
	               books[idx].checkin();
	            }
	            
	            break;
	         case 3:
	            System.out.println("책 리스트는 다음과 같습니다");
	            for(BookLib b : books) {
	               b.printState();
	            }
	         case 0 :break;
	         
	         }
	      }while(fn!=0);
	      System.out.println("대출 프로그램 종료");
	}

}
