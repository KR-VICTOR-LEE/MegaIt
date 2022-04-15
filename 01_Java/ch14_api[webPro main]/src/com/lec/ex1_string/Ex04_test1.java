package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		
		fn = sc.next();
		if ('2' == fn.indexOf(7)) {
			System.out.println("남자");
		}else {
			System.out.println("여자");
		}
	}

}
