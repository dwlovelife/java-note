package leetcode.study.primary.linkedlist;

public class LinkedListTest03 {
    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        int n = 2;
        ListNode rootNode = new ListNode(-1);
        ListNode tempNode = rootNode;
        for(int i = 0; i < head.length;i++){
            tempNode.next = new ListNode(head[i]);
            tempNode = tempNode.next;
        }
        ListNode resultNode = reverseList(rootNode.next);
        while(resultNode != null){
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode temp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = temp;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
