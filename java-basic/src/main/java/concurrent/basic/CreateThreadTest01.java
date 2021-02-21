package concurrent.basic;

public class CreateThreadTest01 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        t1.start();
        t2.start();
    }

}
//Thread方法与Runnable方法类似
class MyThread implements Runnable {

    int ticket = 100;

    @Override
    public void run(){
        while (ticket > 0) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前余票:" + --ticket);
        }
    }

}

