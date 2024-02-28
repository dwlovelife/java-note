package leetcode.arr;

import leetcode.sword.ListNode;

public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = new ListNode(-1);
        currentNode.next = head;
        ListNode result = currentNode;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return result.next;
    }
}
