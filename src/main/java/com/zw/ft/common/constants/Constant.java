package com.zw.ft.common.constants;

/**
 * @ClassName Constant
 * @Description 系统常量
 * @Author Oliver
 * @Date 2020/9/20 12:51
 * @Version 1.0
 **/
public class Constant {

    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;
    public static final String ADMIN = "admin";
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /**
     * @description: 半个小时
     */
    public static final long HALF_AN_HOUR = 1800;
    /**
     * @description: 一个小时
     */
    public static final long AN_HOUR = 3600;

    /**
     * @description: 一天
     */
    public static final long AN_DAY = 43200;

    /*
     * 功能描述: <br>
     * 〈操作数据库枚举〉
     * @Author: Oliver
     * @Date: 2020/10/9 9:59
     */

    public enum DatabaseOperation {
        /**
         * @description: 添加
         */
        ADD("add"),
        /**
         * @description: 更新
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

    /*
     * 功能描述: <br>
     * 〈系统需求状态〉
     * @Author: Oliver
     */

    public enum NeedStatus {
        /**
         * @description: 未解决
         */
        unresolved(0),
        /**
         * @description: 已解决
         */
        resolved(1),
        /**
         * @description: 已确认
         */
        confirmed(2);

        private final Integer value;

        NeedStatus(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 功能描述 : 合同类型描述
     * @author Oliver 2021-1-18 9:43
     */
    public enum ContractType {
        /**
         * @description: 采购合同
         */
        PROCUREMENT(1),

        /**
         * @description: 销售合同
         */
        SELL(2),

        /**
         * @description: 仓储合同
         */
        WAREHOUSE(3);

        private final Integer value;

        ContractType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 功能描述 : 合同状态描述
     * @author Oliver 2021-1-18 9:43
     */
    public enum ContractStatus {
        /**
         * @description: 未解决
         */
        ORDER_MAKING(0),

        /**
         * @description: 已解决
         */
        EFFECTIVE(1),

        /**
         * @description: 已确认
         */
        DONE(2),

        /**
         * @description: 已确认
         */
        INVALIDATED(3);

        private final Integer value;

        ContractStatus(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 功能描述 : 合同审批状态描述
     * @author Oliver 2021-1-18 9:43
     */
    public enum ContractAuditStatus {
        /**
         * @description: 未提交
         */
        NOT_SUBMITTED(0),

        /**
         * @description: 待审批
         */
        PENDING_AUDIT(1),

        /**
         * @description: 已通过
         */
        PASSED(2),

        /**
         * @description: 未通过
         */
        FAILED(3);

        private final Integer value;

        ContractAuditStatus(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 功能描述 : 合同付款类型
     * @author Oliver 2021-1-18 9:43
     */
    public enum ContractPaymentType {
        /**
         * @description: 现汇
         */
        SPOT_EXCHANGE(1),

        /**
         * @description: 银承
         */
        BANK_ACCEPTANCE(2),

        /**
         * @description: 电子银承
         */
        ELECTRONIC_BANK_ACCEPTANCE(3),

        /**
         * @description: 其他
         */
        OTHER(0);

        private final Integer value;

        ContractPaymentType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }


}
