/**
 * @tawalisa@163.com
 */
package com.lijia.code;

/**
 * 用单向链表表示十进制整数，求两个正整数的和。如，1234+34=1268，注意单项链表的方向从前向后，不允许使用其他数据结构。
 * @author tawalisa@163.com
 *
 */
public class ListAdd {
	static class Node {
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(3);
		node1.next.next.next = new Node(4);
		Node node2 = new Node(3);
		node2.next = new Node(4);
		Node sum = listSum(node1,node2);
		sum = p(sum);
		
		node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(9);
		node1.next.next.next = new Node(9);
		node2 = new Node(3);
		node2.next = new Node(4);
		sum = listSum(node1,node2);
		sum = p(sum);
		
		node1 = new Node(9);
		node1.next = new Node(9);
		node2 = new Node(3);
		node2.next = new Node(4);
		sum = listSum(node1,node2);
		sum = p(sum);
	}

	private static Node p(Node node) {
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
		return node;
	}

	private static Node listSum(Node node1, Node node2) {
		node1 = revertList(node1);
		node2 = revertList(node2);
		Node retu = null;
		Node current = null;
		int delta = 0;
		while(node1!=null || node2!=null) {
			int v1 = node1==null?0:node1.val;
			int v2 = node2==null?0:node2.val;
			int v = v1 + v2 + delta;
			Node node = new Node(v%10);
			delta = v/10;
			if(retu==null) {
				retu = node;
				current = retu;
			}else {
				current.next = node;
				current = node;
			}
			if(node1 !=null) {
				node1 = node1.next;
			}
			if(node2 !=null) {
				node2 = node2.next;
			}
		}
		if(delta>0) {
			current.next = new Node(delta);
		}
		return revertList(retu);
	}

	private static Node revertList(Node node) {
		if(node == null) {
			return null;
		}
		Node current = node;
		Node next = current.next;
		current.next = null;
		while(next!=null) {
			Node nextNext = next.next;
			next.next = current;
			if(nextNext == null) {
				return next;
			}else {
				current = next;
				next = nextNext;
			}
		}
		return current;
	}

}
