package com.lec.ex01_inputstreamoutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// (1)파일을 연다 (출력용스트림객체생성) 
// (2)write한다 
// (3)파일을닫는다(스트림객체.close)
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("test_File/outTest.txt", true); // (1)
			byte[] bs = { 'H', 'e', 'l', 'l', 'o'};
//			for (int i = 0; i < bs.length; i++) { // (2)
//				os.write(bs[i]);
//			}
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
