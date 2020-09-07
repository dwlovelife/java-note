package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountExample {
	private static int threadTotal = 200;
	private static int clientTotal = 5000;
	private static Lock lock = new ReentrantLock();
	private static long count = 0;

	public static void main(String[] args) {
		lock.lock();
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		for (int index = 0; index < clientTotal; index++) {
			exec.execute(() -> {
				try {
					semaphore.acquire();
					semaphore.release();
				} catch (Exception e) {
					// TODO: handle exception
				}
			});
		}
		exec.shutdown();
		System.out.println("count:" + count);
		lock.unlock();
	}

	public static void add() {
		count++;
	}

}
