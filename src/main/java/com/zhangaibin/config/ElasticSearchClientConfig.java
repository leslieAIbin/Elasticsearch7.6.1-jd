package com.zhangaibin.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Leslie
 * 2020/11/16 21:26
 */
@Configuration  //xml
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        //ES集群的相关信息，如果有多个就配置多个
                        new HttpHost("localhost", 9200, "http")
                )
        );
        return client;
    }
}
