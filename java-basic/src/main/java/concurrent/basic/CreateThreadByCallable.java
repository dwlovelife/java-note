package concurrent.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 创建多线程通过callable
 */
public class CreateThreadByCallable {

    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<MyCallable> threadTasks = new ArrayList<>();
        threadTasks.add(new MyCallable("URL1"));
        threadTasks.add(new MyCallable("URL2"));
        threadTasks.add(new MyCallable("URL3"));
        threadTasks.add(new MyCallable("URL4"));
        List<Future<Map<String, Object>>> futures = new ArrayList<>();

        for (MyCallable callable: threadTasks) {
            futures.add(executor.submit(callable));
        }

        for (Future<Map<String,Object>> future: futures) {
            System.out.println("结果:" + future.get());
        }

    }



    static class MyCallable implements Callable<Map<String, Object>> {

        private String url;

        public MyCallable(String url) {
            this.url = url;
        }

        @Override
        public Map<String, Object> call() throws Exception {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("url", url);
            return resultMap;
        }
    }

}
