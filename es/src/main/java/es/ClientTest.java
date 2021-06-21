package es;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(
                "8.131.51.115", 9200, "http"
        )));

        // 关闭客户端连接
        client.close();
    }
}
