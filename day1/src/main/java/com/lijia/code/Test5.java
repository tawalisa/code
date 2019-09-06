package com.lijia.code;

public class Test5 {

//	static int  i =1;
	public static void main(String[] args) {
		int n = 10;
		step(0,n,"");
	}
	static void  step(int start,int n,String output) {
		if(start <= n-1) {
			step(start+1,n,"1"+output);
		}
		if(start <= n-2) {
			step(start+2,n, "2"+output);
		}
		if(start >= n) {
			System.out.println(output);
//			System.out.println(i++); 
		}
	}

}
