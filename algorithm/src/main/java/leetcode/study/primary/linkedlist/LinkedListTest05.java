package leetcode.study.primary.linkedlist;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LinkedListTest05 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        //boolean result = isPalindrome(head);
        //System.out.println(result);
    }

    public  boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode halfOfEnd = findFirstEndOfHalf(head);
        ListNode reverseNode = reverseListNode(halfOfEnd.next);
        ListNode p1 = head;
        ListNode p2 = reverseNode;
        boolean result = true;
        while(result && p2 != null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    /**
     * 只反转后半部分链表
     * @param head
     * @return
     */
    private ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    private ListNode findFirstEndOfHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
