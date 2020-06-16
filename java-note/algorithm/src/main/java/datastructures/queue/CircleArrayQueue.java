package datastructures.queue;


public class CircleArrayQueue<E> {
    private int maxSize;
    private int front;
    private int rear;
    private Object[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
    }

    public static void main(String[] args) {
        CircleArrayQueue<Integer> circleArrayQueue = new CircleArrayQueue<>(4);
        circleArrayQueue.push(1);
        circleArrayQueue.push(2);
        circleArrayQueue.push(3);
        circleArrayQueue.printAll();
        circleArrayQueue.pop();
        circleArrayQueue.printAll();
        circleArrayQueue.push(4);
        circleArrayQueue.push(5);
        circleArrayQueue.printAll();

    }

    public boolean isEmpty() {
        return front == rear;
    }

    //空一个元素
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean push(E element) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("队列已空");
            return null;
        }
        E element = (E) arr[front];
        front = (front + 1) % maxSize;
        return element;
    }

    public int size() {
        //求出当前数组有效元素
        return (rear + maxSize - front) % maxSize;
    }

    public void printAll() {
        System.out.println("------start-------");
        for (int i = front; i < front + size(); i++) {
            System.out.print("[index:" + (i % maxSize) + ",value:" + arr[i % maxSize] + "] ");
        }
        System.out.println("\n------end-------");
    }

}
