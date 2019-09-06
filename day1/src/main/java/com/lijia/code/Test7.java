package com.lijia.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import ch.qos.logback.core.util.FileUtil;

public class Test7 {

	public static void main(String[] args) throws IOException {
//		List<Integer> list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list);
//		list.add(1,4);
//		System.out.println(list);
//		list.set(1,5);
//		System.out.println(list);
		
//		String s = "<p>Aug 29 (Reuters) - Former Spain coach Luis Enrique has\r\n" + 
//				"announced the death of his nine-year-old daughter Xana following\r\n" + 
//				"a battle with cancer.</p>";
//		String s = FileUtils.readFileToString(new File("d:/2019-08-29T220109Z_380708479_L5N25P74W_RTRMADT_0_SOCCER-SPAIN-LUISENRIQUE-CORRECTED-PIX.XML"),"utf-8");
//		System.out.println(s);

//		System.out.println(Pattern.compile("[\r\n\t]+",Pattern.MULTILINE).matcher(s).replaceAll(""));
		Set<Integer> set = new HashSet();
		set.add(1);
		set.add(2);
		int[] a = set.stream().mapToInt(Integer::intValue).toArray();
		for(int i:a) {
			System.out.println(i);
		}
	}

}
