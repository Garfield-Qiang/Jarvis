package algorithms.hard;

/**
 * 合并多个有序链表
 * @author Jarvis
 *
 */

public class MergeKSortedLists {

	    public ListNode mergeKLists(ListNode[] lists) {
	    	if(lists.length==0) {
	    		return null;
	    	}
	        if(lists.length==1) {
	        	return lists[0];
	        }
	        ListNode result = mergeTwoLists(lists[0], lists[1]);
	        int i = 2;
	        while(i < lists.length) {
	        	result = mergeTwoLists(result, lists[i]);
	        	i++;
	        }
	        return result;
	    }
	    
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
