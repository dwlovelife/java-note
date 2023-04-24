package concurrent.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @description: TODO
 * @author: dingwei17@jd.com
 * @date : 2023/3/30 17:03
 */
public class ZeroEvenOdd {

    private int n ;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int flag = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            try {
                lock.lock();
                while (flag != 0) {
                    condition1.await();
                }
                printNumber.accept(0);
                if (i % 2 == 0) {
                    flag = 2;
                    condition2.signal();
                } else {
                    flag = 1;
                    condition3.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            try {
                lock.lock();
                while (flag != 2) {
                    condition2.await();
                }
                printNumber.accept(i);
                flag = 0;
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            try {
                lock.lock();
                while (flag != 1) {
                    condition3.await();
                }
                printNumber.accept(i);
                flag = 0;
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
