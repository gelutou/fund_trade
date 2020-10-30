package com.zw.ft.modules.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 银行信息表
 * </p>
 *
 * @author Savior
 * @since 2020-10-20
 */
@TableName(value = "t_bank")
@Data
public class TBank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String compId;

    private Integer flagDelete;

    private Integer flagSort;

    private Integer flagStatus;

    private Integer flagVersion;

    private Date makeTime;

    private String makeUser;

    private Date modifyTime;

    private String modifyUser;

    private String accountStyle;

    private String accountType;

    private String areaType;

    private String bankAccount;

    private String bankAddress;

    private String bankFname;

    private String bankCode;

    private String bankName;

    private String contactPerson;

    private String contactPhone;

    private String currType;

    private String customerPkid;

    private String innerCode;

    private String remark;

    /**
     * 协定存款金额
     */
    private BigDecimal accordAmount;

    /**
     * 是否有协定存款、金额
     */
    private String accordCheck;

    /**
     * 协定期限
     */
    private Date accordDate;

    /**
     * 协定存款利率
     */
    private String accordRate;

    /**
     * 账户是否年检
     */
    private String accountCheck;

    /**
     * 是否具有管户权
     */
    private String accountManage;

    /**
     * 银行窗口电话
     */
    private String bankPhone;

    /**
     * 大额核实人
     */
    private String bigContact;

    /**
     * 大额行号
     */
    private String bigRow;

    /**
     * 备头寸联系人
     */
    private String billContact;

    /**
     * 是否有支票
     */
    private String billHas;

    /**
     * 当天走款多少万需备头寸
     */
    private String billOut;

    /**
     * 账户余额
     */
    private BigDecimal accountBalance;

    /**
     * 当天进出款是否备头寸
     */
    private String billRemark;

    /**
     * 业务联系人
     */
    private String bussynessContact;

    /**
     * 证照日期
     */
    private Date cardDate;

    /**
     * 是否有电汇单
     */
    private String electricHas;

    /**
     * 支票、电汇单是否盖章、存放处
     */
    private String electricSave;

    /**
     * 电票系统
     */
    private String electricSys;

    /**
     * 网银累计
     */
    private String internetAdd;

    /**
     * 网银对账
     */
    private String internetBalance;

    /**
     * 网银系统
     */
    private String internetBank;

    /**
     * 网银关闭时间
     */
    private Date internetClose;

    /**
     * 网银到期时间
     */
    private Date internetDued;

    /**
     * 是否开通电票系统
     */
    private String internetElectric;

    /**
     * 网银是否关联
     */
    private String internetRelation;

    /**
     * 网银单笔
     */
    private String internetSingle;

    /**
     * 是否有支付密码器
     */
    private String passwordAuth;

    /**
     * 身份证
     */
    private String personCard;

    /**
     * 打印回单
     */
    private String printBack;

    /**
     * 打印对账单
     */
    private String printBalance;

    /**
     * 凭证日期
     */
    private Date proofDate;

    /**
     * 印鉴日期
     */
    private Date sealDate;

    /**
     * 是否新印鉴
     */
    private String sealNew;

    /**
     * 久悬期限
     */
    private Date unuseTime;

    /**
     * 银行简称
     */
    private String shortName;

    /**
     * 存放处
     */
    private String storage;


}
