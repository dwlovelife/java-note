package concurrent.basic;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        new Thread(() -> readWriteLockDemo.write((int) (Math.random() * 1000)), "Write").start();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> readWriteLockDemo.get()).start();
        }
    }

}

class ReadWriteLockDemo {

    private int number = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-number:" + number);
        } finally {
            lock.readLock().unlock();
        }
    }


    public void write(int number){
        lock.writeLock().lock();
        try {
            this.number = number;
        } finally {
            lock.writeLock().unlock();
        }
    }

}
