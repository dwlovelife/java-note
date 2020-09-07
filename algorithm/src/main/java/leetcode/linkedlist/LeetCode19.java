package leetcode.linkedlist;

/**
 * 删除链表倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class LeetCode19 {

    /**
     * 这题直接解很简单粗暴,先求长度,然后直接删除
     *
     * @param head
     * @param n
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        int length = 0;
        //先求出总长度
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        //如果要删除头节点 直接返回next
        currentNode = head;
        if (length - n == 0) {
            return head.next;
        }
        //由于要删除链表
        int count = 0;
        while (currentNode != null) {
            count++;
            if (count == length - n) {
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    /**
     * 采用双指针间隔位 找到N
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode currentHead = new ListNode(0);
        currentHead.next = head;
        ListNode first = currentHead;
        ListNode second = currentHead;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while(first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return currentHead.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
