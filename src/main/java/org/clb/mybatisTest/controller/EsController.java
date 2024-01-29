package org.clb.mybatisTest.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiParam;
import org.clb.mybatisTest.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EsController {

    @Autowired
    DataSourceService dataSourceService;
    @GetMapping("get/data")
    public List<JSONObject> getDataSourceData(
            @RequestParam(value = "sql", required = false) @ApiParam(name = "sql") String sql,
            @RequestParam("resource_id") @ApiParam(required = true,
                    name = "resource_id") String resourceId,
            @RequestParam(value = "db_name",
                    required = false) @ApiParam(name = "db_name") String dbName,
            @RequestParam(value = "table_name",
                    required = false) @ApiParam(name = "table_name") String tableName,
            @RequestParam(value = "custom_params",
                    required = false) @ApiParam(name = "custom_params") String customParams) {

        return dataSourceService.getEsDataSourceData(sql, resourceId, dbName, tableName, customParams);
    }


}
