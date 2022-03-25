package leetcode.sword;

import leetcode.sword.helper.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Test04 {


    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode temp = head;
            ListNode result = null;
            while (temp != null) {
                ListNode cur = temp.next;
                temp.next = result;
                result = temp;
                temp = cur;
            }
            return result;
        }
    }

}
