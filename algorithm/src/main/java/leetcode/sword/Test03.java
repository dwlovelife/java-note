package leetcode.sword;

import leetcode.sword.helper.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Test03 {



    static class Solution {

        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode tempNode = head;
            while(tempNode != null) {
                stack.push(tempNode.val);
                tempNode = tempNode.next;
            }
            int[] arr = new int[stack.size()];
            int i = 0;
            while(!stack.isEmpty()) {
                arr[i++] = stack.pop();
            }
            return arr;
        }

    }


}
