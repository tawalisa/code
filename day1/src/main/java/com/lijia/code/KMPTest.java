package com.lijia.code;

import java.util.Arrays;
import java.util.stream.Stream;

public class KMPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//        String[] array = {"a", "b", "c", "d", "e"};
//        
//        //Arrays.stream
//        Stream<String> stream1 = Arrays.stream(array);
//        stream1.forEach(x -> System.out.println(x));
		int[] r = getN("ababaaaba");
		Arrays.stream(r).forEach(cc -> System.out.print(cc + ","));
		System.out.println("\n================");
		char[] array1 = "ababaaaba".toCharArray();
		int[] next1 = next(array1);
//		System.out.println(next1);
//		System.out.println(array1.length);
//		
//		
//		Stream<java.lang.Character> stream2 = Arrays.stream(array1);
		Arrays.stream(next1).forEach(cc -> System.out.print(cc + ","));
	}

	private static int[] next(char[] array) {
		if (array == null || array.length == 0) {
			return new int[] {};
		}
		int[] retu = new int[array.length];
		retu[0] = 0;
		for (int i = 1; i < array.length; i++) {
			retu[i] = getN(array,i);
//			int temp = 1;
//			boolean first = true;
//			for (int j = 0; j < i - 1; j++) {
//				
////				for (int k = 0; k < j + 1; k++) {
////					if (array[j] == array[j + 1 - k]) {
////
////					}
////				}
////				if (array[j] == array[i - j - 1]) {
////					if (first) {
////						first = false;
////						continue;
////					}
////					temp++;
////				} else {
////					break;
////				}
//			}
//			retu[i] = temp;
		}

		return retu;
	}

	private static int getN(char[] array, int i) {
		if(i == 1) {
			return 1;
		}
		int temp = 0;
		for(int j = 0;j<i;j++) {
			if(compareInernStr(i, j, array)) {
				temp++;
			}
		}
		return temp<1?1:temp;
	}

	private static boolean compareInernStr(int i, int j, char[] array) {
		return false;
	}

	// KMP算法实现
	private static void KMP(String source, String pattern) {
		int[] N = getN(pattern);
		int res = 0;
		int sourceLength = source.length();
		int patternLength = pattern.length();
		for (int i = 0; i <= (sourceLength - patternLength);) {
			res++;
			String str = source.substring(i, i + patternLength);// 要比较的字符串
			p(str);
			int count = getNext(pattern, str, N);
			p("移动" + count + "步");
			if (count == 0) {
				p("KMP：匹配成功");
				break;
			}
			i = i + count;
		}
		p("KMP：一共匹配" + res + "次数");
	}

	/**
	 * 得到下一次要移动的次数
	 * 
	 * @param pattern
	 * @param str
	 * @param N
	 * @return 0,字符串匹配；
	 */
	private static int getNext(String pattern, String str, int[] N) {
		int n = pattern.length();
		char v1[] = str.toCharArray();
		char v2[] = pattern.toCharArray();
		int x = 0;
		while (n-- != 0) {
			if (v1[x] != v2[x]) {
				if (x == 0) {
					return 1;// 如果第一个不相同，移动1步
				}
				return x - N[x - 1];// x:第一次出现不同的索引的位置，即j
			}
			x++;
		}
		return 0;
	}

	private static int[] getN(String pattern) {
		char[] pat = pattern.toCharArray();
		int j = pattern.length() - 1;
		int[] N = new int[j + 1];
		for (int i = j; i >= 2; i--) {
			N[i - 1] = getK(i, pat);
		}
		for (int a : N)
			p(a);
		return N;
	}

	private static int getK(int j, char[] pat) {
		int x = j - 2;
		int y = 1;
		while (x >= 0 && compare(pat, 0, x, y, j - 1)) {
			x--;
			y++;
		}
		return x + 1;
	}

	private static boolean compare(char[] pat, int b1, int e1, int b2, int e2) {
		int n = e1 - b1 + 1;
		while (n-- != 0) {
			if (pat[b1] != pat[b2]) {
				return true;
			}
			b1++;
			b2++;
		}
		return false;
	}

	public static void p(Object obj) {
		System.out.println(obj);
	}

}
