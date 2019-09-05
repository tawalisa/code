package com.lijia.code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test7 {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list);
//		list.add(1,4);
//		System.out.println(list);
//		list.set(1,5);
//		System.out.println(list);
		
		String s = "123sdsd\r\n1234332";
		System.out.println(Pattern.compile("[\r\n\t]+",Pattern.MULTILINE).matcher(s).replaceAll(""));
//		java.util.regex.Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
	}

}
