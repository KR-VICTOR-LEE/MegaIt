package com.lec.ex_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {

	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); // 0번 인덱스
		linkedList.add("str1"); // 1번 인덱스
		linkedList.add("str2"); // 2번 인덱스
		linkedList.add("str3"); // 3번 인덱스
		linkedList.add("str4"); // 4번 인덱스
		System.out.println(linkedList);
		for(String list : linkedList) {
			System.out.print("\t"+list);
		}
		linkedList.clear();
		System.out.println(linkedList.isEmpty()?"데이터가 없습니다" : "데이터가 있습니다.");
	}

}
