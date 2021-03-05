package leetcode.level.diffcult;


public class MyCode25 {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode queenHead = null;
        ListNode result = new ListNode();
        int count = 0;
        while (cur != null) {
            if(count == 0){
                queenHead = cur;
            }
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            if(++count % k == 0){
                queenHead.next = cur.next;

                count = 0;
            }
            cur = nextNode;

        }
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
