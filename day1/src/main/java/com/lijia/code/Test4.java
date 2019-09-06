package com.lijia.code;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		List list = new ArrayList();
		for(int i = 0;i<10;i++) {
			list.add(i);
		}
		System.out.println(list);
		
		list.set(0, 10);
		System.out.println(list);
		
		
	}

	 public class ListNode {
	     int val;
	    ListNode next;
	     ListNode(int x) {
	          val = x;
	        next = null;
	     }
	 }

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans = null;
        ListNode pa = headA;
        ListNode pb = headB;
        boolean afull= false;
        boolean bfull = false;
        
        while(pa != null && pb != null ){
            if(pa.val==pb.val){
                if(ans != null){
                    ans = pa;
                }
            }else{
                ans = null;
            }
            
            pa = pa.next;
            pb = pb.next;
            if(!afull && pa == null){
                pa = headB;
                afull = true;
            }
            if(!bfull && pb == null){
                pb = headA;
                bfull = true;
            }
        }
        return ans;
    }
}
