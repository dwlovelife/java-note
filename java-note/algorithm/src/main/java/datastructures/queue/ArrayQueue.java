package datastructures.queue;

/**
 * 用数组模拟队列
 */
public class ArrayQueue<E> {
    private int maxSize;
    private int front;
    private int rear;
    private Object[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new Object[maxSize];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.printAll();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.printAll();
        arrayQueue.pop();
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean push(E element){
        if(isFull()){
            System.out.println("队列已满");
            return false;
        }
        arr[++rear] = element;
        return true;
    }

    public E pop(){
        if(isEmpty()){
            System.out.println("队列已空!");
            return null;
        }
        return (E) arr[++front];
    }

    public void printAll(){
        System.out.println("start-------------");
        if(isEmpty()){
            return;
        }
        for (int i = front + 1; i <= rear ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nend-------------");
    }
}
