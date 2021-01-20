package com.zw.ft.modules.bdm.entity;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.modules.sys.entity.SysBank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客商实体
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_customer")
@Data
public class BdmCustomer extends BaseEntity {

    private static final long serialVersionUID = 5093346423530256838L;

    /**
     * 客商编码
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的客商编码：数字和字母",groups = Add.class)
    private String code;

    /**
     * 客商名
     */
    @NotNull(message = "请传入客商名",groups = Add.class)
    private String name;

    /**
     * 客商简称
     */
    @NotNull(message = "请传入客商简称",groups = Add.class)
    private String shortname;

    /**
     * 税务号码
     */
    @NotNull(message = "请传入税务号码",groups = Add.class)
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的税务号码：数字和字母",groups = Add.class)
    private String taxNum;

    /**
     * 类型 1内部公司 2外部公司 3仓储公司 4集团公司
     */
    @NotNull(message = "请传入客商类型，1内部公司 2外部公司 3仓储公司 4集团公司",groups = Add.class)
    private Integer type;

    /**
     * 类型描述
     */
    @TableField(exist = false)
    private String typeDes;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 联系人职位
     */
    private String contactPosition;

    /**
     * 客商地址
     */
    @NotNull(message = "请传入客商地址",groups = Add.class)
    private String area;

    /**
     * 城市
     */
    @NotNull(message = "请传入城市ID",groups = Add.class)
    private String cityId;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;

    /**
     * 旧的部门PKID，只用于合并数据，系统上线后删除
     */
    private String oldPkidWilldel;

    /**
     * 创建人名称
     */
    @TableField(exist = false)
    private String creator;

    /**
     * 银行
     */
    @TableField(exist = false)
    private List<SysBank> banks;

    /**
     * 银行id和是否默认Map
     */
    @TableField(exist = false)
    private JSONArray bankIdAndIsDefault;
}
