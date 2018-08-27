package algorithms;


/**
 * 给定两个链表，例1->2>3,4->5->6，
 * 求出这两个链表所对应的数字之和，123+456=579，所对应的链表5->7->9
 * @author Jarvis
 *
 */
public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = (l1.val + l2.val) % 10;
		int up = (l1.val + l2.val) / 10;
		ListNode listNode = new ListNode(sum);
		while (null != l1.next || null != l2.next) {
			l1 = l1.next;
			l2 = l2.next;
			if (null == l1 || null == l2) {
				l1 = null == l1 ? new ListNode(0) : l1;
				l2 = null == l2 ? new ListNode(0) : l2;
			}
			if (null != l1 && null != l2) {
				sum = (l1.val + l2.val + up) % 10;
				up = (l1.val + l2.val + up) / 10;
				ListNode temp = new ListNode(sum);
				temp.next = listNode;
				listNode = temp;
			}
		}
		if (up == 1) {
			ListNode upNodes = new ListNode(1);
			upNodes.next = listNode;
			listNode = upNodes;
		}
		ListNode nodes = new ListNode(listNode.val);
		while (null != listNode) {
			listNode = listNode.next;
			if (null != listNode) {
				ListNode temp = new ListNode(listNode.val);
				temp.next = nodes;
				nodes = temp;
			}
		}

		return nodes;
	}
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        System.out.println("curr.val:"+curr.val);
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        System.out.println("curr.val:"+curr.val);
	        System.out.println("dummyHead.next.val:"+dummyHead.next.val);
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers clazz = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		ListNode listNode = clazz.addTwoNumbers1(l1, l2);
		while (null != listNode) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}

class ListNode {
	
	int val;
	
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}