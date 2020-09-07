package datastructures.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(11);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.list();
        stack.pop();
        stack.pop();
        stack.list();
    }
}

//定义一个ArrayStack来表示栈
class ArrayStack {

    private int maxSize; //栈的大小
    private int[] stack; //数组,将数组模拟栈,数据就放在该数组中
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈-push
    public void push(int value){
        //先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop,将栈顶的数据返回
    public int pop(){
        //先判断栈顶是否为空
        if(isEmpty()){
            throw new RuntimeException("栈空没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况
    public void list(){
        if(isEmpty()){
            System.out.println("栈空,没有数据~");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
        System.out.println("----------打印完毕------------");
    }

}