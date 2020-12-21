package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @Pattern(regexp = "/^\\d+$|^\\d+[.]?\\d+$/",message = "只能输入数字",groups = Add.class)
    private Long comId;

    //客商ID
    /* private Integer customerId ;*/

    /**
     * 开户行全称
     */
    @NotNull(message = "银行全称必填",groups = Add.class)
    private String bankFullName;


    /**
     * 银行简称
     */
    @NotNull(message = "银行简称必填",groups = Add.class)
    private String shortName;

    /**
     * 账号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的客商编码：数字和字母",groups = Add.class)
    private String bankAccount;

    /**
     * 账户类别
     */
    private String accountStyle;

    /**
     * 账户性质
     */
    private String accountType;

    /**
     * 账户余额
     */
    @Pattern(regexp = "/(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)/",message = "最多输入两位小数",groups = Add.class)
    private BigDecimal accountBalance;

    /**
     * 银行地区分类
     */
    private String areaType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 公司名称
     */
    @TableField(exist = false)
    private String comName;

    /**
     * 用户名称
     */
    @TableField(exist = false)
    private String username;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;


    private String taxNumber;

    /**
     * @description: 旧公司ID，上线后删除
     */
    private String oldPkidWilldel;

    /**
     * 所属银行
     */
    private String bankName;

    /**
     * 开户行地址
     */
    private String bankAddress;

    /**
     * 银行联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private Long contactNumber;

    /**
     * 币种
     */
    private String currType;

    /**
     * 网银存放处
     */
    private String storage;

    /**
     * 银行会计窗口电话
     */
    private Long bankPhone;

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
    private String internetAdd;

    /**
     * 网银关闭时间
     */
    private LocalDateTime internetClose;

    /**
     * 网银是否关联
     */
    private String internetRelation;

    /**
     * 是否开通电票系统
     */
    private String internetElectric;

    /**
     * 网银到期时间
     */
    private LocalDateTime internetDued;

    /**
     * 大额行号
     */
    private Long bigRow;

    /**
     * 当天进出款是否备头寸
     */
    private String billRemark;

    /**
     * 当天走款多少万需备头寸
     */
    private String billOut;

    /**
     * 备头寸联系人
     */
    private String billContact;

    /**
     * 大额核实人
     */
    private String bigContact;

    /**
     * 是否有支票
     */
    private String billHas;

    /**
     * 是否有电汇单
     */
    private String electricHas;

    /**
     * 是否盖章
     */
    private String electricSave;

    /**
     * 久悬期限
     */
    private LocalDateTime unuseTime;

    /**
     * 账户是否年检
     */
    private String accountCheck;

    /**
     * 证照日期
     */
    private LocalDateTime cardDate;

    /**
     * 印鉴日期
     */
    private LocalDateTime sealDate;

    /**
     * 凭证日期
     */
    private LocalDateTime proofDate;

    /**
     * 身份证
     */
    private String personCard;

    /**
     * 协定存款金额
     */
    private Double accordAmount;

    /**
     * 协定期限
     */
    private LocalDateTime accordDate;

    /**
     * 协定存款利率(%)
     */
    private String accordRate;

    /**
     * 是否具有管户权
     */
    private String accountManage;

    /**
     * 电票系统
     */
    private String electricSys;

    /**
     * 是否新印鉴
     */
    private String sealNew;

    /**
     * 网银对账
     */
    private String internetBalance;

    /**
     * 是否有支付密码器
     */
    private String passwordAuth;

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
    private String bussynessContact;

    /**
     * 银行编码
     */
    private String bankCode;

}
