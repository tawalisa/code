package com.lijia.code;


public class Solution {
    public static long climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        long first = 1;
        long second = 2;
        for (int i = 3; i <= n; i++) {
        	long third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    public static void main(String[] args) {
		System.out.println(climbStairs(20));
	}
}

