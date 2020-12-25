package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * * <p>
 * * 银行信息表
 * * </p>
 *
 * @author savior
 * @Date 2020/9/27
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_bank")
@Data
public class SysBank extends BaseEntity {

    private static final long serialVersionUID = -2993525210700517999L;

    /**
     * 客商ID
     */
    @Pattern(regexp = "/[^\\d]/g",message = "客商ID只能输入数字，请传入",groups = Add.class)
    private Long cusId;

    /**
     * 银行编码
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的银行编码：数字和字母",groups = Add.class)
    private String code;

    /**
     * 开户行全称
     */
    @NotNull(message = "银行全称必填",groups = Add.class)
    private String bankName;

    /**
     * 银行简称
     */
    @NotNull(message = "银行简称必填",groups = Add.class)
    private String shortName;

    /**
     * 账号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的银行账户：数字和字母",groups = Add.class)
    private String account;

    /**
     * 账户类别
     */
    @NotNull(message = "账户类别必填",groups = Add.class)
    private Integer type;

    @TableField(exist = false)
    private String typeDes;

    /**
     * 账户性质
     */
    @NotNull(message = "账户性质必填",groups = Add.class)
    private Integer nature;

    @TableField(exist = false)
    private String natureDes;

    /**
     * 账户余额
     */
    @Pattern(regexp = "/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/",message = "最多输入两位小数",groups = Add.class)
    private BigDecimal balance;

    /**
     * 银行地区分类
     */
    @NotNull(message = "银行地区分类必填",groups = Add.class)
    private Integer area;

    @TableField(exist = false)
    private String areaDes;

    /**
     * 备注
     */
    private String remark;

    /**
     * 客商名称
     */
    @TableField(exist = false)
    private String cusName;

    /**
     * 用户名称
     */
    @TableField(exist = false)
    private String username;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;

    /**
     * @description: 税号
     */
    private String taxNumber;

    /**
     * @description: 旧公司ID，上线后删除
     */
    private String oldPkidWilldel;

    /**
     * 所属银行
     */
    @NotNull(message = "所属银行必填",groups = Add.class)
    private Integer belongTo;

    @TableField(exist = false)
    private String belongToDes;

    /**
     * 开户行地址
     */
    private String address;

    /**
     * 银行联系人
     */
    private String contactUser;

    /**
     * 联系电话
     */
    private Long contactNumber;

    /**
     * 币种
     */
    private Integer currencyType;

    @TableField(exist = false)
    private String currencyTypeDes;

    /**
     * 网银存放处
     */
    private String storage;

    /**
     * 银行会计窗口电话
     */
    private String accountingPhone;

    /**
     * 网银系统
     */
    private String internetBank;

    /**
     * 网银单笔
     */
    private BigDecimal internetSingle;

    /**
     * 网银累计
     */
    private BigDecimal internetAccumulate;

    /**
     * 网银关闭时间
     */
    private String internetCloseTime;

    /**
     * 网银是否关联
     */
    private Integer internetIsRelated;

    /**
     * 是否开通电票系统
     */
    private Integer internetIsOpenElectric;

    /**
     * 网银到期时间
     */
    private String internetExpirationTime;

    /**
     * 大额行号
     */
    private String largeLineNumber;

    /**
     * 当天进出款是否备头寸
     */
    private Integer isPreparePosition;

    /**
     * 当天走款多少万需备头寸
     */
    private BigDecimal preparePositionOut;

    /**
     * 备头寸联系人
     */
    private String preparePositionContactUser;

    /**
     * 大额核实人
     */
    private String largeVerifyUser;

    /**
     * 是否有电汇单
     */
    private Integer hasElectric;

    /**
     * 是否有支票
     */
    private Integer hasBill;

    /**
     * 是否盖章
     */
    private Integer hasSeal;

    /**
     * 久悬期限
     */
    private String unuseTime;

    /**
     * 账户是否年检
     */
    private Integer accountIsCheck;

    /**
     * 证照日期
     */
    private String cardDate;

    /**
     * 印鉴日期
     */
    private String sealDate;

    /**
     * 凭证日期
     */
    private String proofDate;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 协定存款金额
     */
    private BigDecimal accordAmount;

    /**
     * 协定期限
     */
    private String accordDate;

    /**
     * 协定存款利率
     */
    private BigDecimal accordRate;

    /**
     * 是否具有管户权
     */
    private Integer hasAccountManage;

    /**
     * 电票系统
     */
    private String electricSys;

    /**
     * 是否新印鉴
     */
    private Integer isNewSeal;

    /**
     * 网银对账
     */
    private String internetBalance;

    /**
     * 是否有支付密码器
     */
    private Integer hasPasswordAuth;

    /**
     * 打印对账单
     */
    private String printBalance;

    /**
     * 打印回单
     */
    private String printBack;

    /**
     * 业务联系人
     */
    private String businessContactUser;
}
