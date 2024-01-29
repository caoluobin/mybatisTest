package org.clb.mybatisTest.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.EntityUtils;
import org.clb.mybatisTest.exception.BusinessException;
import org.clb.mybatisTest.service.DataSourceService;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataSourceServiceImpl implements DataSourceService {


    @Autowired
    RestClient restClient;

    private String parseEsSQL(String customParams, String sql) {
        HashMap<String, String> map = new HashMap<>();
        //映射自定义参数列表
        if (StringUtils.isNotBlank(customParams)) {
            try {
                JSONArray jsonArray = JSONObject.parseArray(customParams);
                for (Object o : jsonArray) {
                    JSONObject datumObject = JSONObject.parseObject(JSONObject.toJSONString(o));
                    String value = datumObject.getString("value");
                    String name = datumObject.getString("name");
                    if (StringUtils.isNotBlank(value)) {
                        map.put(name, value);
                    }
                }
            } catch (Exception e) {
                throw new BusinessException();
            }
        }
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                String key = "${" + stringStringEntry.getKey() + "}";
                if (sql.contains(key)) {
                    sql = sql.replace(key, "\"" + stringStringEntry.getValue() + "\"");
                }
            }
        }
        return sql;
    }

    @Override
    public List<JSONObject> getEsDataSourceData(String sql, String resourceId, String dbName, String tableName, String customParams) {

        sql = parseEsSQL(customParams, sql);
        String method = sql.substring(0, sql.indexOf(" ")).trim();
        if (!"GET".equals(method)) {
            //只能
            throw new BusinessException("只能查询数据,请使用GET方法");
        }
        String index = sql.substring(sql.indexOf(" "), sql.indexOf("{")).trim();
        Request request = new Request("GET", index);
        sql = sql.substring(sql.indexOf("{"), sql.length());
        request.setJsonEntity(sql);
        try {
            Response response = restClient.performRequest(request);
            String res = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONObject hitObject = jsonObject.getJSONObject("hits");
            JSONArray jsonArray = null;
            if (hitObject != null) {
                jsonArray = hitObject.getJSONArray("hits");
            }
            return jsonArray == null ? new ArrayList<>() : jsonArray.toJavaList(JSONObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
