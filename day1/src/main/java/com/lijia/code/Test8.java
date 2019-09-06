package com.lijia.code;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> q = new PriorityQueue(100);
		q.add(100);
		q.add(5);
		q.add(3);
		q.add(8);
		q.add(2);
		q.add(10);
		q.add(9);
		
		while (!q.isEmpty()){
		      System.out.print(q.poll() + ",");
		    }
		q.stream().forEach(System.out::println);
		
	}

}
