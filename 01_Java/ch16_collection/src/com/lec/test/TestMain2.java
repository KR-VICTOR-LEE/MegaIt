package com.lec.test;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String, Member> map = new HashMap<String, Member>();
		String name, number, address, i;

		Scanner sc = new Scanner(System.in);
		Member member = new Member();
		while (true) {
			System.out.println("정보입력");
			i = sc.next();
			if (i.equalsIgnoreCase("n")) {
				break;
			} else if (i.equalsIgnoreCase("y")) {
				System.out.println("이름");
				name = sc.next();
				System.out.println("번호");
				number = sc.next();
				System.out.println("주소");
				address = sc.next();
				map.get(member);
				
				continue;
			}
			if (map.get(i) != null) {
				System.out.println("중복번호");
			}
		}
		sc.close();
		if (map.isEmpty()) {
			System.out.println("정보없음");
		}else {
			System.out.println("리스트");
			
		}
	}

}
