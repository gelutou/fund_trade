package com.zw.ft.common.utils;

import java.util.Map;

/**
 *@description: Map转实体
 *@author:  Oliver
 *@date  2020/9/25
 *@修改人和其它信息
 */
public class Map2ObjUtils {
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }

        Object obj = beanClass.newInstance();

        org.apache.commons.beanutils.BeanUtils.populate(obj, map);

        return obj;
    }

    public static Map<?, ?> objectToMap(Object obj) {
        if(obj == null) {
            return null;
        }

        return new org.apache.commons.beanutils.BeanMap(obj);
    }
}
