package com.lec.ex01_inputstreamoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1) 파일은 연다 (스트림객체생성) 
// (2) 데이터를 읽는다
// (3) 파일을 닫는다(스틑림객체를 삭제)
public class Ex01_InpuStream {
	public static void main(String[] args) {
		InputStream input=null;
		try {
			input = new FileInputStream("test_File/test.txt"); // 1. 파일을 연다
			while (true) { // 2. 데이터를 읽는다
				int i = input.read(); // 1byte씩 읽기
				if (i==-1)
					break; // 파일의 끝이면 반복문 break;
				System.out.print((char) i);
			}
			System.out.println("\n끝");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾은 경우 예외 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 못 읽는 경우 예외 : " + e.getMessage());
		} finally {
			// 3. 파일을 닫는다
			try {
				if(input!=null)input.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
