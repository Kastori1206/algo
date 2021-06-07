package leetcode;


/*
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for(int i =2; i<=5;i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		ListNode ans = reverseList(head);
		while(ans!=null) {
			System.out.println(ans);
			ans = ans.next;
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
	 public static ListNode reverseList(ListNode head) {
	        ListNode next = null;
	        ListNode prev = null;
	        
	        while(head != null){
	            next = head.next;
	            head.next = prev;
	            prev = head;
	            head = next;
	        }
	        return prev;
	    }
}
