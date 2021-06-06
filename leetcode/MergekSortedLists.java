package leetcode;

import java.util.*;

/*
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode[] lists = new ListNode[3];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		
		ListNode answer = mergeKLists(lists);
		while(answer.next!=null) {
			System.out.println(answer);
			answer = answer.next;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}
		
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			
			@Override
			public int compare(ListNode a, ListNode b) {
				return Integer.compare(a.val, b.val);
			}
		});
		
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;
		
		for(ListNode node : lists) {
			if(node != null) {
				pq.offer(node);
			}
		}
		
		while(!pq.isEmpty()) {
			ListNode node = pq.poll();
			p.next = node;
			p = p.next;
			if(node.next != null) {
				pq.offer(node.next);
			}
		}
		
		return newHead.next;
	}

}
