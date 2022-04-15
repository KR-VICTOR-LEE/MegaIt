package com.lec.ex1_string;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// String은 new 로 생성하지 않고 "  "를 사용한 문자열 상수를 이용. 자동으로 힙 영역에 String 객체가 이미 존재하는지 확인하고
		// 이미 존재하는 문자열 객체를 공유, 존재하지 않으면 String 객체 생성
		int i = 10;
		String str1 = "Java";
		String str2 = "java";
		String str3 = new String("java"); // 무조건 생성
		if(str1 == str2) {
			System.out.println("str1과 str2는 같은 주소값이 있음");
		}else {
			System.out.println("str1과 str2는 다른 주소값이 있음");
		}
		
		if (str1.equals(str2)) {
			System.out.println("같은문자열");
		}
		System.out.println(str1==str3 ? "str1과 3은 같은 주소 " : "str1과 3은 다른주소");
		System.out.println(str1.equals(str3)? "같은 스트링" : "다른 문자열");
		
		
	}

}
