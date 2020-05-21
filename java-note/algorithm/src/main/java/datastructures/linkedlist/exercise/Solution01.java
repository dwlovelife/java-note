package datastructures.linkedlist.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转一个单链表 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class Solution01 {

	public ListNode reverseList1(ListNode head) {
		List<Integer> nums = new ArrayList<>();
		ListNode curNode = head;
		while (curNode.next != null) {
			nums.add(head.val);
			curNode = curNode.next;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (i == 0) {
				head = new ListNode(nums.get(i));
				curNode = head;
			} else {
				curNode.next = new ListNode(nums.get(i));
				curNode = curNode.next;
			}
		}
		return head;
	}

	public ListNode reverseList2(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode tempNode = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tempNode;
		}
		return prev;
	}

	public ListNode reverseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = reverseList3(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
