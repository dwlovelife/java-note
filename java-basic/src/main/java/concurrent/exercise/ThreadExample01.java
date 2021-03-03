package concurrent.exercise;


import lombok.extern.slf4j.Slf4j;

public class ThreadExample01 {
    public static void main(String[] args) {
        final ShareData data = new ShareData();
        new Thread(() -> {
            for(int i = 0; i < 10; i++){
                data.increment();
            }
        }, "AA").start();
        new Thread(() -> {
            for(int i = 0; i < 10; i++){
                data.decrement();
            }
        }, "BB").start();
        new Thread(() -> {
            for(int i = 0; i < 10; i++){
                data.increment();
            }
        }, "CC").start();
        new Thread(() -> {
            for(int i = 0; i < 10; i++){
                data.decrement();
            }
        }, "DD").start();
    }
}

@Slf4j
class ShareData {

    private int n = 0;

    public synchronized void increment() {
        while (n != 0) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        n++;
        log.info("threadName:{},n:{}", Thread.currentThread().getName(), n);
        this.notifyAll();
    }

    public synchronized void decrement() {
        while (n == 0) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        n--;
        log.info("threadName:{},n:{}", Thread.currentThread().getName(), n);
        this.notifyAll();
    }

}