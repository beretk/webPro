package com.lec.ex3_set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;
public class Ex04_iterator_1 {
	public static void main(String[] args) {
		System.out.println("= = = 1. list �迭 = = =");
		ArrayList<String> list = new ArrayList<String>();
		list.add("SAMPLE1"); list.add("SAMPLE2");
		for(String l : list) {
			System.out.println(l);
		}
//		Iterator<String> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		System.out.println("= = = 2. map �迭 = = =");
		HashMap<String, Friend> map = new HashMap<String, Friend>();
		map.put("ȫ�浿", new Friend("ȫ�浿","010-9999-9999"));
		map.put("�赿��", new Friend("�赿��","010-8888-9999"));
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next(); // ȫ�浿, �赿��
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("= = = 3. set �迭 = = =");
		HashSet<Friend> set = new HashSet<Friend>();
		set.add(new Friend("ȫ�浿","010-9999-9999"));
		set.add(new Friend("�赿��","010-8888-9999"));
		Iterator<Friend> iterator2 = set.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
	}
}

