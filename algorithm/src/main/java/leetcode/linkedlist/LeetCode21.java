package leetcode.linkedlist;


public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode curResult = resultNode;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                curResult.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else {
                curResult.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            curResult = curResult.next;
        }
        curResult.next = cur1 == null ? cur2 : cur1;
        return resultNode.next;
    }

    public class ListNode {
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
