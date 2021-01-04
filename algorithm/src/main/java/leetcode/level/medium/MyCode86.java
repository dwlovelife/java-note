package leetcode.level.medium;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例：
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 */
public class MyCode86 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        int[] elements = {4, 3, 2, 5, 2};
        ListNode temp = root;
        for (int num : elements) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        temp = root;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("----------------------");
        ListNode node = partition(root, 3);
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode transNode = new ListNode(0);
        ListNode tempNode = transNode;
        ListNode firstGreater = null;
        while (root != null) {
            int val = root.val;
            if (val < x) {
                tempNode.next = new ListNode(val);
                tempNode = tempNode.next;
                root.next = root.next.next;
            }
            if (firstGreater == null && root.next != null && root.next.val >= x) {
                firstGreater = root;
            }
            root = root.next;
        }
        if (firstGreater != null) {
            tempNode.next = firstGreater.next;
            firstGreater.next = transNode.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
