package com.lijia.code;

public class Test2 {

	public static void main(String[] args) {
		System.out.println(new Solution().romanToInt("IV"));
	}
	static class Solution {
	    public int romanToInt(String s) {
	        int ans = 0;
	        for(int i = 0;i<s.length();i++){
	        	
	            switch(s.charAt(i)){
	                
	                case 'I':
	                if((i+1)< s.length() && s.charAt(i+1) =='V'){
	                    ans = ans + 4;
	                    i++;
	                }if((i+1)< s.length() && s.charAt(i+1) =='X'){
	                    ans = ans + 9;
	                    i++;
	                }else{
	                    ans = ans + 1;
	                }
	                break;
	            case 'V':
	                    ans = ans + 5;
	                break;
	            case 'X':
	               if((i+1)< s.length() && s.charAt(i+1) =='L'){
	                    ans = ans + 40;
	                    i++;
	                }if((i+1)< s.length() && s.charAt(i+1) =='C'){
	                    ans = ans + 90;
	                    i++;
	                }else{
	                    ans = ans + 10;
	                }
	                break;
	            case 'L':
	                    ans = ans + 50;
	                break;
	            case 'C':
	                if((i+1)< s.length() && s.charAt(i+1) =='D'){
	                    ans = ans + 400;
	                    i++;
	                }if((i+1)< s.length() && s.charAt(i+1) =='M'){
	                    ans = ans + 900;
	                    i++;
	                }else{
	                    ans = ans + 100;
	                }
	                break;
	            case 'D':
	                ans = ans + 500;
	                break;
	            case 'M':
	                ans = ans + 1000;
	                break;
	            }
	            
	        }
	        return ans;
	    }
	    
	}
}
