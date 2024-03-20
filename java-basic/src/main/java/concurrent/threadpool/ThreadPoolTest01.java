package concurrent.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class ThreadPoolTest01 {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService executorService = new ThreadPoolExecutor(5, 40, 4, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(40);
        executor.setKeepAliveSeconds(4);
        executor.setQueueCapacity(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("service-thread-");
        executor.initialize();

        ThreadLocal
    }
}
