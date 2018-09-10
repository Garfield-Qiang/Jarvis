package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

import utils.ListNode;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 给定一个链表，将相邻的两个节点做交换操作，返回头节点
 * @author Jarvis
 *
 */
public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
        int i = 0;
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        while(null != head) {
        	if(i%2==0) {
        		evens.add(head.val);
        	} else {
        		odds.add(head.val);
        	}
        	head = head.next;
        	i++;
        }
        ListNode  result = new ListNode(0);
        ListNode newHead = result;
        for(int j = 0;j<i;j++) {
        	if(j%2==0) {
                if(j/2 < odds.size()) {
                   newHead.next = new ListNode(odds.get(j/2));
               } else {
                   newHead.next = new ListNode(evens.get(j/2));
               }
	       	} else {
	               if(j/2 < evens.size()) {
	                   newHead.next = new ListNode(evens.get(j/2));
	               } else {
	                   newHead.next = new ListNode(odds.get(j/2));
	               }
	       	}
        	newHead = newHead.next;
        }
        return result.next;
    }

}
