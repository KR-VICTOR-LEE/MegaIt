package com.lec.test;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Friend[] fiFriends = { new Friend("홍길동", "서울시 용산구", "010-9999-1234", "05-22"),
				new Friend("신길동", "서울시 마포구", "010-8888-8888", "03-28"),
				new Friend("마길동", "서울시 강남구", "010-8888-9999", "08-22") };

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("검색할 주소 앞 글자 2자리 입력 종료(X)");
			String searchAddress = sc.next();
			if (searchAddress.equalsIgnoreCase("x")) {
				break;
			}
			boolean Ok = false;
			for (int i = 0; i < fiFriends.length; i++) {
				String address = fiFriends[i].getAddress();
				String search = address.substring(0,2);
				if (search.equals(searchAddress)) {
					System.out.println(fiFriends[i]);
					Ok = true;
				} 
			}
			if(! Ok) {
				System.out.println("검색하신 주소는 없습니다.");
			}

		}
		System.out.println("검색 종료");
		sc.close();
	}

}
