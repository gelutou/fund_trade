package com.zw.ft.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;

import java.util.Map;

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


    /*
     * 功能描述: <br>
     * 〈判断接口参数需不需要加入sql条件〉
     * @Return: false 不设置条件 true 设置条件""查所有
     * @Author: Oliver
     * @Date: 2020/10/13 15:15
     */

    public static String isSelectKey(String key, Map<String,Object> params){
        Object o = params.get(key);
        if(o == null){
            return "false";
        }else if ("".equals(o.toString()) || "null".equals(o.toString())){
            return "false";
        }else if(" ".equals(o.toString())){
            return "";
        }else {
            return "true";
        }
    }
}
