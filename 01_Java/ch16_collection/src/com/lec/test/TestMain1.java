package com.lec.test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();

		String name;
		String number;
		String address;
		String i;
		Member member = new Member();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("정보입력");
			i=sc.next();
			if (i.equalsIgnoreCase("n")) {
				break;
			}else if (i.equalsIgnoreCase("y")) {
				System.out.println("이름");
				member.setName(sc.next());
				System.out.println("번호");
				member.setNumber(sc.next());
				System.out.println("주소");
				member.setAddress(sc.next());
				list.add(member);
			}
		}
		sc.close();
		if (list.isEmpty()) {
			System.out.println("정보없음");
		}else {
			System.out.println("리스트");
			for(Member m : list) {
				System.out.println(m);
			}
		}
	}
}
