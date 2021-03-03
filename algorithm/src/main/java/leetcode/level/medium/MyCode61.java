package leetcode.level.medium;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class MyCode61 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 找尾节点，形成环形链表
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head;

        // 2. 尾节点移动 length - k 步
        k %= length;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }

        // 3. 找到头节点，断开头尾连接
        head = tail.next;
        tail.next = null;
        return head;
    }

    class ListNode {
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
