package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaaa");
		System.out.println(list.get(0)); // list계열의 collection은 index로 get함.
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11"); // 11 key 값에 매핑되는 데이터 " str11" 추가
		hashMap.put(20, "Str20"); // 20 key 값에 매핑되는 데이터 " str20" 추가
		hashMap.put(33, "str33"); // 30 key 값에 매핑되는 데이터 " str33" 추가
		System.out.println(hashMap.get(20)); // key 값으로 데이터 get함
		System.out.println("remove 전 : " + hashMap);
		hashMap.remove(20); // 20 key와 값이 remove
		System.out.println("remove 후 : " + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 모두 삭제" : "데이터 있음");
		hashMap.put(0, "홍길동");
		hashMap.put(10, "kim dongil");
		hashMap.put(22, "이순신");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iteraator = hashMap.keySet().iterator(); // HashMap 반복문.
		while(iteraator.hasNext()) {
			Integer key = iteraator.next();
			System.out.println(key + "의 데이터는" + hashMap.get(key));
		}
	}

}
