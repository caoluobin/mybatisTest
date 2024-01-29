package org.clb.mybatisTest.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DataSourceService {
    List<JSONObject> getEsDataSourceData(String sql, String resourceId, String dbName, String tableName, String customParams);

}
