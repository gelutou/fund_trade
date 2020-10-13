package com.zw.ft.common.base;

/**
 * @ClassName Constant
 * @Description 系统常量
 * @Author Oliver
 * @Date 2020/9/20 12:51
 * @Version 1.0
 **/
public class Constant {

    /** 超级管理员ID */
    public static final int SUPER_ADMIN = 1;

    /**
     *@description: 半个小时
     */
    public static final long HALF_AN_HOUR = 1800;
    /**
     *@description: 一个小时
     */
    public static final long AN_HOUR = 3600;

    /**
     *@description: 一天
     */
    public static final long AN_DAY = 43200;

<<<<<<< HEAD

=======
    /*
     * 功能描述: <br>
     * 〈操作数据库枚举〉
     * @Author: Oliver
     * @Date: 2020/10/9 9:59
     */

    public enum DatabaseOperation{
        /**
         *@description: 添加
         */
        ADD("add"),
        /**
         *@description: 更新
         */
        UPDATE("update");

        private final String value;

        DatabaseOperation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
>>>>>>> 5765c4edaf354ee54b0b087c3565447beb7b413c
}
