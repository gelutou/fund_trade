package com.zw.ft.modules.sys.redis;
/*
 * 功能描述: <br>
 * 〈RedisService〉
 * @Author: Oliver
 * @Date: 2020/10/9 10:53
 */

public interface RedisService {

    /*
     * 功能描述: <br>
     * 〈往redis中存数据〉
     * @Param: expire过期时间，单位秒
     * @Author: Oliver
     * @Date: 2020/10/9 10:53
     */

    void set(String key, String value,long expire);

    /*
     * 功能描述: <br>
     * 〈往redis中取数据〉
     * @Param: key key
     * @Author: Oliver
     * @Date: 2020/10/9 10:53
     */

    String get(String key);

    /*
     * 功能描述: <br>
     * 〈从redis中删除数据〉
     * @Param: key key
     * @Author: Oliver
     * @Date: 2020/10/9 10:53
     */

    void remove(String key);

    /*
     * 功能描述: <br>
     * 〈自增〉
     * @Param: key key
     * @Author: Oliver
     * @Date: 2020/10/9 10:53
     */

    Long increment(String key, long delta);

    /*
     * 功能描述: <br>
     * 〈获取过期时间，单位秒〉
     * @Param: key key
     * @Author: Oliver
     * @Date: 2020/10/9 10:53
     */

    Long getExpire(String key);
}
