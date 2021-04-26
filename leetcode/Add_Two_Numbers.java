package leetcode;

/*
 * https://leetcode.com/problems/add-two-numbers/
 * Add Two Numbers
 */
public class Add_Two_Numbers {
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
	}

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);		
		ListNode node = addTwoNumbers(l1, l2);
		while(node !=null) {
			System.out.print(node.val);
			node = node.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        //l1, l2 ,answer를 가르키는 head
        ListNode h1 = l1, h2 = l2, h3 = answer;
        int carry=0;
        
        while(h1!=null || h2!=null) {
        	if(h1!=null) {
        		carry+= h1.val;
        		h1 = h1.next;
        	}
        	if(h2!=null) {
        		carry+= h2.val;
        		h2 = h2.next;
        	}
        	h3.next = new ListNode(carry%10);
        	h3 = h3.next;
        	carry /= 10;        	
        }
        //마지막
        if(carry == 1) {
        	h3.next = new ListNode(1);
        }
        
        return answer.next;    
        
    }
}
