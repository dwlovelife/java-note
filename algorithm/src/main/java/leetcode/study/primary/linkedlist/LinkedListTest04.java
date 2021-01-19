package leetcode.study.primary.linkedlist;


public class LinkedListTest04 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode rootNode1 = l1;
        ListNode rootNode2 = l2;
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while (rootNode1 != null || rootNode2 != null) {
            int nodeVal;
            if (rootNode1 == null) {
                nodeVal = rootNode2.val;
                rootNode2 = rootNode2.next;
            } else if (rootNode2 == null) {
                nodeVal = rootNode1.val;
                rootNode1 = rootNode1.next;
            } else {
                int a = rootNode1.val;
                int b = rootNode2.val;
                if (a <= b) {
                    nodeVal = a;
                    rootNode1 = rootNode1.next;
                } else {
                    nodeVal = b;
                    rootNode2 = rootNode2.next;
                }
            }
            dummy.next = new ListNode(nodeVal);
            dummy = dummy.next;
        }
        return result.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 == null ? l2 : l1;
        return result.next;
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
