package leetcode.sword;

import lombok.Data;

import java.util.Stack;

/**
 剑指Offer01
 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 */
public class Test01 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    @Data
    static class CQueue {

        Stack<Integer> containerStack;
        Stack<Integer> flagStack;

        public CQueue() {
            containerStack = new Stack<>();
            flagStack = new Stack<>();
        }

        public void appendTail(int value) {
            containerStack.push(value);
        }

        public int deleteHead() {
            if (flagStack.isEmpty()) {
                while (!containerStack.isEmpty()) {
                    flagStack.push(containerStack.pop());
                }
            }
            if(flagStack.isEmpty()) {
                return -1;
            } else {
                return flagStack.pop();
            }
        }

    }

}
