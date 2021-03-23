package com.lijia.code;

import net.minidev.json.JSONArray;
import org.apache.commons.lang3.ArrayUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class A {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        byte info[]=new byte[-1];
    }
//    public static List<Map> getEntries(RestHighLevelClient client, String fieldName, String fieldVal){
//        List<Map> entryData = new ArrayList<>();
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.size(10);
//        searchSourceBuilder.query(QueryBuilders.matchPhraseQuery(fieldName, fieldVal));
//        searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.DESC));
//        SearchRequest searchRequest = new SearchRequest(ESUtil.INDEX_NAME);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = null;
//        try {
//            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SearchHit[] searchHits = searchResponse.getHits().getHits();
//        while (ArrayUtils.isNotEmpty(searchHits)) {
//            for (SearchHit hit : searchResponse.getHits().getHits()) {
//                String id = hit.getId();
//                System.out.println("id---------" + id);
//                entryData.add(hit.getSourceAsMap());
//            }
//            SearchHit last = searchHits[searchHits.length - 1];
//            searchSourceBuilder.searchAfter(last.getSortValues());
//            try {
//                searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            searchHits = searchResponse.getHits().getHits();
//        }
//        try {
//            client.close();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//        return entryData;
//    }
//    public Response execute() {
//        RestHighLevelClient client = ESUtil.createESClient();
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.size(5000);
//        searchSourceBuilder.query(QueryBuilders.matchPhraseQuery(field, value));
////  searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
//        searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.DESC));
//        SearchRequest searchRequest = new SearchRequest(ESUtil.INDEX_NAME);
//        searchRequest.source(searchSourceBuilder);
//
//        Consumer<SearchHit> consumer = null;
//        List<Map> entryData = null;
//        try {
//            EsSearchAfterHandler.searchForHit(client, searchRequest,
//                    consumer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONArray jsonArray=new JSONArray(entryData);
//        return Response.ok(entryData.toString(), MediaType.APPLICATION_JSON).build();
//    }
}
