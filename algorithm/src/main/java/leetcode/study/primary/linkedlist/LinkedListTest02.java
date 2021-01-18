package leetcode.study.primary.linkedlist;


public class LinkedListTest02 {
    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        int n = 2;
        ListNode rootNode = new ListNode(-1);
        ListNode tempNode = rootNode;
        for(int i = 0; i < head.length;i++){
            tempNode.next = new ListNode(head[i]);
            tempNode = tempNode.next;
        }
        ListNode resultNode = removeNthFromEnd(rootNode.next, n);
        while(resultNode != null){
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rootNode = new ListNode(-1);
        rootNode.next = head;
        remove(rootNode, n);
        return rootNode.next;
    }

    public static int remove(ListNode head, int n){
        if(head.next == null){
            return n;
        }
        int index = remove(head.next, n);
        if(--index == 0){
            head.next = head.next.next;
        }
        return index;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
