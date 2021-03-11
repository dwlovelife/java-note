package concurrent.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest01 {
    final static CountDownLatch count = new CountDownLatch(10);
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.execute(new ShareData());
        }
        count.await();
        executor.shutdown();
        System.out.println(num);
    }

    static class ShareData implements Runnable {
        final static Lock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                add();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                count.countDown();
            }
        }

        public static void add() {
            lock.lock();
            for (int j = 0; j < 100; j++) {
                ++num;
            }
            lock.unlock();
        }
    }
}
