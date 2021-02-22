package concurrent.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 某个接口功能是分别http调用四个服务并将返回结果整合成一个结果返回，
 * 四个服务之间相互独立，因此使用多线程处理。由于需要获取每个服务的返回值，
 * 这里打算采用Callable和Future来实现
 */
public class CreateThreadTest02 {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("url1"));
        tasks.add(new Task("url2"));
        tasks.add(new Task("url3"));
        tasks.add(new Task("url4"));
        List<Future<Map<String, Object>>> futures = new ArrayList<>();
        for (final Callable<Map<String, Object>> task : tasks) {
            futures.add(executorService.submit(task));
        }

        for (Future<Map<String, Object>> future : futures) {
            try {
                System.out.println(future.get(3, TimeUnit.SECONDS).get("url"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

//线程执行任务类
class Task implements Callable<Map<String, Object>> {

    String url;

    public Task(String url) {
        this.url = url;
    }

    @Override
    public Map<String, Object> call() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("url", url); //假设这个部分
        map.put("result", "OK");
        return map;
    }

}
