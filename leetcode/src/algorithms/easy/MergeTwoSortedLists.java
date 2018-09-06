package algorithms.easy;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 * @author Jarvis
 *
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		while(null != l1 || null != l2) {
			if(null == l1) {
				head.next = new ListNode(l2.val);
                l2 = l2.next;
                head = head.next;
				continue;
			}
			if(null == l2) {
				head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
				continue;
			}
			if(l1.val>l2.val) {
				head.next = new ListNode(l2.val);
				l2 = l2.next;
			} else {
				head.next = new ListNode(l1.val);
				l1 = l1.next;
			}
            head = head.next;
		}
	    return result.next;
	}
	
	 class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
}




