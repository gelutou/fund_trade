package com.zw.ft.modules.trade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-12
 */
@TableName("sys_user")
@Data
public class SysUserTrade {

    private static final long serialVersionUID = 1L;

    private String pkId;

    private String userCode;

    private String userName;

    private String userPassword;

    private String salt;

    private Integer flagModifyPsd;

    private String idcard;

    private String sex;

    private Date birthday;

    private String formerName;

    private String userAddress;

    private String userMobile;

    private String homePhone;

    private String officePhone;

    private String bindAccount;

    private String headImageUrl;

    private String userEmail;

    private String qq;

    private String weixin;

    private String bankCode;

    private String bankName;

    private String accountId;

    private String accountName;

    private Date joiningDate;

    private Date leavingDate;

    private String nameProvince;

    private String nameCity;

    private String nameDistrict;

    private String detailedAddress;

    private Integer flagLogin;

    private Integer flagStatus;

    private Integer flagSort;

    private Integer flagDelete;

    private Long flagVersion;

    private String remark;

    private String makeUser;

    private Date makeTime;

    private String modifyUser;

    private Date modifyTime;

    private String compPkid;

    private Integer flagAudit;

    private String auditPid;

}
