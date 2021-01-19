package leetcode.study.primary.linkedlist;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LinkedListTest05 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        boolean result = isPalindrome(head);
        System.out.println(result);
    }

    public static boolean isPalindrome(ListNode head) {
        //TODO
        return false;
    }

    static class ListNode {
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
}
