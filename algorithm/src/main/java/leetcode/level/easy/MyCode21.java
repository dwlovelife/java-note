package leetcode.level.easy;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MyCode21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = mergeTwoLists3(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tempHead = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempHead.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tempHead.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tempHead = tempHead.next;
        }
        tempHead.next = l1 == null ? l2 : l1;
        return head.next;
    }

    /**
     * 自己的解法
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode resultNode = new ListNode(0);
        ListNode tempResultNode = resultNode;
        ListNode leftNode = l1, rightNode = l2;
        while (true) {
            if (leftNode == null) {
                tempResultNode.next = rightNode;
                break;
            } else if (rightNode == null) {
                tempResultNode.next = leftNode;
                break;
            }
            int leftNum = leftNode.val;
            int rightNum = rightNode.val;
            if (leftNum <= rightNum) {
                tempResultNode.next = new ListNode(leftNum);
                leftNode = leftNode.next;
            } else {
                tempResultNode.next = new ListNode(rightNum);
                rightNode = rightNode.next;
            }
            tempResultNode = tempResultNode.next;
        }

        return resultNode.next;
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
