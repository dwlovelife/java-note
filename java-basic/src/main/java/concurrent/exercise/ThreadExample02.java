package concurrent.exercise;

import concurrent.lock.ReentrantTest01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：三个线程，要求实现按序访问，A > B > C
 * A 打印5次, B 打印10次, C打印15次
 * 接着按照上述同样的顺序，再来
 * 20轮
 */
public class ThreadExample02 {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                sr.LoopA(i);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                sr.LoopB(i);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                sr.LoopC(i);
            }
        }, "CC").start();
    }

}

class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void LoopA(int totalLoop) {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\ttotalLoop:" + totalLoop);
            }
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void LoopB(int totalLoop) {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\ttotalLoop:" + totalLoop);
            }
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void LoopC(int totalLoop) {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\ttotalLoop:" + totalLoop);
            }
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

