package leetcode.level.medium;


public class MyCode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode node = addTwoNumbers(l1,l2);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node1 = l1, node2 = l2, temp = result;

        int remainder = 0;
        while (node1 != null || node2 != null) {
            int num1 = node1 == null ? 0 : node1.val;
            int num2 = node2 == null ? 0 : node2.val;

            int sum = num1 + num2 + remainder;
            remainder = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if(node1 != null){
                node1 = node1.next;
            }
            if(node2 != null){
                node2 = node2.next;
            }
        }

        if(remainder != 0){
            temp.next = new ListNode(remainder);
        }
        return result.next;
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
