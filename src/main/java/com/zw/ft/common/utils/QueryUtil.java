package com.zw.ft.common.utils;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName QueryUtil
 * @Author Oliver
 * @Date 2020/9/23 18:01
 * @Version 1.0
 **/
public class QueryUtil<T> extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = -103551643233726060L;

    private Page<T> page;

    private long current = 1L;

    private long limit = 10L;

    public QueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        if (params.get("currentPage") != null) {
            current = Convert.toLong(params.get("currentPage"));
        }
        if (params.get("pageSize") != null) {
            limit = Convert.toLong(params.get("pageSize"));
        }
        //mybatis-plus分页
        this.page = new Page<>(current, limit);
    }

    public Page<T> getPage() {
        return page;
    }

    public long getCurrent() {
        return current;
    }

    public long getLimit() {
        return limit;
    }
}
