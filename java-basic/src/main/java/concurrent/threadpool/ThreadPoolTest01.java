package concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest01 {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService executorService = new ThreadPoolExecutor(30, 30, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));
    }
}
