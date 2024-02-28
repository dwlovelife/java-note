package concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
        System.out.println("当前值:" +  getSerialNumber());
    }


    public int getSerialNumber (){
        return atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        AtomicDemo a1 = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(a1).start();
        }
    }
}
