package leetcode.top;

/**
 * @description: 反转链表
 * @author: dingwei17@jd.com
 * @date : 2024/4/7 11:38
 */
public class Top22_160 {
    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode =  head;
        ListNode prev = currentNode;
        while (currentNode.next != null) {
            ListNode current = currentNode.next;
            current.next = prev;
            prev = current;
            currentNode = currentNode.next;
        }
        return prev;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
