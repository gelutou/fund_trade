package com.zw.ft.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.BaseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 返回信息模板
 * @author: Oliver
 * @date 2020/9/15
 */
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R data(List<? extends BaseEntity> list) {
        R r = new R();
        r.put("data", list);
        return r;
    }

    public static R data(BaseEntity entity) {
        R r = new R();
        r.put("data", entity);
        return r;
    }

    public static R data(JSONArray jsonArray) {
        R r = new R();
        r.put("data", jsonArray);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R page(Page<?> page) {
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("data", page.getRecords());
        r.put("count", page.getTotal());
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
