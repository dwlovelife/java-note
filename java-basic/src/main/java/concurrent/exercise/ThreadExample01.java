package concurrent.exercise;


import lombok.extern.slf4j.Slf4j;

/**
 * 四个线程分别 对线程进行加1 减1操作 1 0 1 0 1 0
 */
public class ThreadExample01 {
    public static void main(String[] args) {
        final ShareData data = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "DD").start();
    }
}

@Slf4j
class ShareData {

    private int n = 0;

    public synchronized void increment() {
        while(n != 0){
            try {
                this.wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        n++;
        System.out.println("threadName:" + Thread.currentThread().getName() + ",n:" + n);
        this.notifyAll();
    }

    public synchronized void decrement() {
        while(n == 0){
            try {
                this.wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        n--;
        System.out.println("threadName:" + Thread.currentThread().getName() + ",n:" + n);
        this.notifyAll();
    }

}