package concurrent.basic;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("时间:" + (endTime - startTime));

    }
}

class LatchDemo implements Runnable {

    private CountDownLatch countDownLatch;

    public LatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                if (i % 2 == 0) {
                    System.out.println("数值：" + i);
                }
            }
        } finally {
            countDownLatch.countDown();
        }
    }
}
