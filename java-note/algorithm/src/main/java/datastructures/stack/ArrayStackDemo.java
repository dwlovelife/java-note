package datastructures.stack;


public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(6);
        stack.list();
        stack.pop();
        stack.list();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.list();


    }
}
//定义一个ArrayStack表示战
class ArrayStack {
    //栈的最大数量
    private int maxSize;
    //栈数组(暂且定义成为一个数字栈)
    private int[] stack;
    //栈顶指针
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize  = maxSize;
        stack = new int[maxSize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈元素已满!");
            return;
        }
        stack[++top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空!");
        }
        return stack[top--];
    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈空没有数据");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.println("栈中元素[" + i + "]:" + stack[i]);
        }
        System.out.println("-----------------------------------");
    }

}
