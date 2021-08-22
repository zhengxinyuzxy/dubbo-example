package com.mellow;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class testHightREST {

    // 执行搜索对象
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testDemo01() throws Exception{
        // 创建request对象，指定index
        SearchRequest request = new SearchRequest("db_article");

        // 创建搜索构造器对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 封装搜索的内容
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("article_content", "中国队");

        // 构造器对象包装内容对象
        searchSourceBuilder.query(matchQueryBuilder);

        // request对象执行构造器对象
        request.source(searchSourceBuilder);

        // 执行搜索
        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        // 解析搜索结果
        SearchHits hits = search.getHits();

        // 打印搜索结果的长度
        System.out.println(hits.getHits().length);

        // 对搜索结果内容进行遍历
        for (SearchHit hit : hits) {
            // Map结果集
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            // Map结果转换为Set结果集
            Set<Map.Entry<String, Object>> entries = sourceAsMap.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                System.out.println("key：" + key);

                Object value = entry.getValue();
                System.out.println("value：" + value);
            }

        }


    }

    @Before
    public void init(){
        restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.6.96",9200, "http")));
    }

    @After
    public void clear() throws Exception{
        restHighLevelClient.close();
    }
}
