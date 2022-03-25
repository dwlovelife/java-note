package leetcode.sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 包含Min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Test02 {


    static class MinStack {

        List<Integer> container;
        int top;
        int size;

        /** initialize your data structure here. */
        public MinStack() {
            container = new ArrayList<>();
            top = -1;
            size = 0;
        }

        public void push(int x) {
            container.add(x);
            top++;
        }

        public void pop() {
            container.remove(top--);
        }

        public int top() {
            return top == -1 ? -1: container.get(top);
        }

        public int min() {
            if(container.isEmpty()) {
                throw new RuntimeException("不存在最小值");
            }
            int min = container.get(0);
            for(int i = 1; i < container.size(); i++) {
                min = Math.min(min, container.get(i));
            }
            return min;
        }

    }

    static class StandardMinStack {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** initialize your data structure here. */
        public StandardMinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.isEmpty() || stack2.peek() >= x) {
                stack2.push(x);
            }
        }

        public void pop() {
            if (stack1.pop().equals(stack2.peek())) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            if(stack2.isEmpty()) {
                throw new RuntimeException("不存在最小值");
            }
            return stack2.peek();
        }

    }

}
