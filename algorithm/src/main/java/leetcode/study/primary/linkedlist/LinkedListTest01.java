package leetcode.study.primary.linkedlist;


public class LinkedListTest01 {
    public static void main(String[] args) {
        int[] head = {4,5,1,9};
        int node = 9;
        ListNode rootNode = new ListNode(-1);
        ListNode tempNode = rootNode;
        for(int i = 0; i < head.length;i++){
            tempNode.next = new ListNode(head[i]);
            tempNode = tempNode.next;
        }
        ListNode resultNode = deleteNode(rootNode.next, node);
        while(resultNode != null){
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }

    }



    public static ListNode deleteNode(ListNode head, int val) {
        ListNode rootNode = new ListNode(-1);
        rootNode.next = head;
        ListNode tempNode = rootNode;
        while(tempNode.next != null){
            int num = tempNode.next.val;
            if(num == val){
                tempNode.next = tempNode.next.next;
                break;
            }
            tempNode = tempNode.next;
        }
        return rootNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
