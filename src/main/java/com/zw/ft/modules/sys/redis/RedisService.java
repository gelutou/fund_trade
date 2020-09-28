package com.zw.ft.modules.sys.redis;

public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value,long expire);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
