package com.lec.ex01_inputstreamoutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// (1)파일을 연다 (출력용스트림객체생성) 
// (2)write한다 
// (3)파일을닫는다(스트림객체.close)
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("test_File/outTest.txt"); // (1)
			String str = "Hello , Java\n 한글 쌉가능";
			byte[] bs = str.getBytes(); // 스트링을 byte배열로 바꾸는 함수
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // (3)
				if (os != null)
					os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
