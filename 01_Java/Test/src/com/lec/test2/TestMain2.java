package com.lec.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      HashMap<String, Customer> m = new HashMap<String, Customer>();
	      String name, number, address, ans;
	      while(true) {
	         System.out.println("회원가입 하시겠습니까?(Y/N)");
	         ans = sc.next();
	         if(ans.equalsIgnoreCase("n")) {
	            break;
	         }else if(ans.equalsIgnoreCase("y")) {
	            System.out.println("이름 입력");
	            name = sc.next();
	            System.out.println("전화번호 입력");
	            number = sc.next();
	            if(m.get(number) != null) {
	               System.out.println("중복된 번호입니다. return");
	               continue;
	            }
	            System.out.println("주소 입력");
	            sc.nextLine();
	            address = sc.nextLine();
	            m.put(number, new Customer(name, number, address));
	         }
	      }
	      sc.close();
	      Iterator<String> iter = m.keySet().iterator();
	      while(iter.hasNext()) {
	         String key = iter.next();
	         System.out.println(m.get(key));
	      }
	   }

}
