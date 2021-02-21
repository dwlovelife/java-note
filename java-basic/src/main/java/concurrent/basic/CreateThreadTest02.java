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
    private static final ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        //定义任务list，创建任务并加入list
        List<Callable<Map<String,Object>>> taskList = new ArrayList<>();
        taskList.add(new Task("url1"));
        taskList.add(new Task("url2"));
        taskList.add(new Task("url3"));
        taskList.add(new Task("url4"));

        //定义返回结果list，通过future获取返回值
        List<Future<Map<String,Object>>> resultList = new ArrayList<>();

        for (final Callable<Map<String,Object>> task:taskList){
            Future<Map<String,Object>> future = pool.submit(task);
            resultList.add(future);
        }

        for (final Future<Map<String,Object>> future:resultList){
            try {
                System.out.println(future.get(3,TimeUnit.SECONDS).get("url"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

    }
}
//线程执行任务类
class Task implements Callable<Map<String,Object>>{

    private String url;

    public Task (String url){
        this.url = url;
    }

    @Override
    public Map<String, Object> call() throws Exception {
        Map<String,Object> result = new HashMap<>();
        result.put("url", this.url);
        result.put("result", "OK");
        System.out.println("task running: " + this.url);
        return result;
    }
}
