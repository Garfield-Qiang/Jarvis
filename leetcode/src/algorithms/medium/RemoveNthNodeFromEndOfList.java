package algorithms.medium;

import utils.ListNode;

/**
 * 给定一个链表，剔除该链表倒数第n位的节点
 * @author Jarvis
 *
 */
public class RemoveNthNodeFromEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode count = head;
		ListNode temp = head;
		while(count != null) {
			length++;
			count = count.next;
		}
		if(length == n) {
			return length == 1 ? null:head.next;
		}
		if(n == 1) {
			for(int i = 1;i<length-1;i++) {
				temp = temp.next;
			}
			temp.next = null;
			return head;
		}
		for(int i = 0;i<length-1;i++) {
			if(i== length-n-1) {
				temp.next = temp.next.next;
				temp = temp.next;
			} else {
				temp = temp.next;
			}
		}
        return head;
    }
	
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList clazz = new RemoveNthNodeFromEndOfList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		clazz.removeNthFromEnd(head, 3);
	}
	
}

