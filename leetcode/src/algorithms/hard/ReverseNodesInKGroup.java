package algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 给定一个链表，一个数字k，以k为单位，划分链表，没个单位的节点做逆序操作，不足的保持原顺序。
 * @author Jarvis
 *
 */
public class ReverseNodesInKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        int i = 0;
        ListNode temp = new ListNode(0);
        ListNode tempHead = temp;
        List<ListNode> list = new ArrayList<>();
        while(null!=head) {
        	tempHead.next = new ListNode(head.val);
        	tempHead = tempHead.next;
        	if(i%k==(k-1)) {
        		list.add(temp.next);
        		temp = new ListNode(0);
        		tempHead = temp;
        	}
        	head = head.next;
        	if(null==head) {
        		list.add(temp.next);
        	}
        	i++;
        }
        if(i%k!=0) {
        	for(int j=0;j<list.size()-1;j++) {
        		ListNode node = reverse(list.get(j));
        		list.set(j, node);
        	}
        } else {
        	for(int j=0;j<list.size();j++) {
        		ListNode node = reverse(list.get(j));
        		list.set(j, node);
        	}
        }
        tempHead = result;
        for (ListNode listNode : list) {
        	ListNode listNode2 = listNode;
			while(null != listNode2) {
				tempHead.next = new ListNode(listNode2.val);
				tempHead = tempHead.next;
				listNode2 = listNode2.next;
			}
		}
        return result.next;
    }
	
	
	
	private ListNode reverse(ListNode node) {
		ListNode newNode = new ListNode(0);
		ListNode temp = newNode;
		List<ListNode> list = new ArrayList<>();
		while(null != node) {
			list.add(node);
			node = node.next;
		}
		for(int i=list.size()-1;i>=0;i--) {
			temp.next = new ListNode(list.get(i).val);
			temp = temp.next;
		}
		return newNode.next;
	}
	
	
	//空间复杂度太高
	public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode result = new ListNode(0);
        int i = 0;
        List<List<ListNode>> list = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        while(null!=head) {
        	list2.add(head);
        	if(i%k==(k-1)) {
        		list.add(list2);
        		list2 = new ArrayList<>();
        	}
        	head = head.next;
        	if(null==head) {
        		list.add(list2);
        	}
        	i++;
        }
        ListNode tempHead = result;
        for (List<ListNode> tempList : list) {
        	int length = tempList.size();
        	if(length == k) {
        		for(int j = k-1;j>=0;j--) {
    				tempHead.next = tempList.get(j);
    				tempHead = tempHead.next;
    			}
        	} else {
        		for(int j = 0;j<length;j++) {
    				tempHead.next = tempList.get(j);
    				tempHead = tempHead.next;
    			}
        	}
		}
        return result.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		l1.next.next.next.next.next.next = new ListNode(7);
		ReverseNodesInKGroup clazz = new ReverseNodesInKGroup();
		clazz.reverseKGroup(l1, 3);
	}

}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
