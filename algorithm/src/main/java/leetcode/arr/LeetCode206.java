package leetcode.arr;

import leetcode.sword.ListNode;

public class LeetCode206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode prev = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }
        return prev;
    }
}
