package com.zw.ft.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @ClassName FormatUtil
 * @Description 处理格式工具
 * @Author Oliver
 * @Date 2020/9/30 14:45
 * @Version 1.0
 **/
public class FormatUtil {

    /**
     *@description: 用于正文标识替换
     *@param:  content 正文
     *@author:  Oliver
     *@date  2020/9/4
     */
    public static String contentReplace(String content,Object... params){

        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String todayDateTime = DateUtil.now();
        return StrUtil.format(content.toLowerCase()
                .replace("$today",today)
                .replace("$datetime",todayDateTime),params);
    }
}
