package com.lec.ex1_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "        ja      va           ";
		System.out.println("1."+str1.concat(str1)); // 문자열 결합
		System.out.println("2."+str1.substring(3)); // 3번째 부터 끝까지 출력
		System.out.println("3."+str1.substring(3,5)); // 3번부터 5번까지 출력
		System.out.println("4."+str1.length()); // 글자길이 출력 
		System.out.println("5."+str1.toUpperCase()); // 대문자로 변환
		System.out.println("6."+str1.toLowerCase()); // 소문자로 변환 
		System.out.println("7."+str1.charAt(3)); // 3번째 문자 출력
		System.out.println("8."+str1.indexOf('b')); // 첫번째 'b' 가 나오는 인덱스 1
		System.out.println("9."+str1.indexOf('b',3)); // 3번째 부터 검색해서 천번째 'b' 위치출력 5 
		System.out.println("10."+str1.indexOf("abc")); // 첫번째 "abc" 나오는 위치 0
		System.out.println("11."+str1.indexOf("abc",3)); // 3번째부터 검색해서 "abc"위치 4
		System.out.println("12."+str1.indexOf("z")); // 없으면 -1
		System.out.println("13."+str1.lastIndexOf("b")); // 마지막 'b' 위치 5
		System.out.println("14."+str1.lastIndexOf("b",3)); // 3번째부터 맨 마지막 b 1
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "        ja      va           ";
		System.out.println("15."+str1.equals(str2)); // str1과 str2가 같은 문자열인지 비교 false
		System.out.println("16."+str1.equalsIgnoreCase(str2)); // 대소문자 구분없이 비교 true
		System.out.println("17."+str3.trim()); // 앞뒤 공백 제거  ja      va
		System.out.println("18."+str1.replace('a','9')); // 'a' 를 '9'로 변환
		System.out.println("19."+str1.replace("abc", "★")); // "abc"을 "★" 변환
		System.out.println("20."+str3.replace(" ","")); // 공백 제거
		System.out.println("21."+str1.replaceAll("abc","Z")); // "abc" 을 "z"
		
		String str = "안녕Hello";
		System.out.println(str.replaceAll("[a-zA-Z]","")); // 알파벳을 "" 변환
		System.out.println(str.replaceAll("[가-히]","")); // 한글문자를 "" 변환
		// 문자열 메소드는 문자열을 수정 안함
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

	}

}
