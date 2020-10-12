package com.zw.ft.modules.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Oliver
 * @since 2020-10-12
 */
@TableName("t_user")
@Data
public class TUser {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer sex;

    private String accountId;

    private String accountName;

    private String bankCode;

    private String bankName;

    private String bindAccount;

    private Date birthday;

    private String detailedAddress;

    private Integer flagLogin;

    private Integer flagModifyPsd;

    private String formerName;

    private String headImageUrl;

    private String homePhone;

    private String idcard;

    private Date joiningDate;

    private Date leavingDate;

    private String nameCity;

    private String nameDistrict;

    private String nameProvince;

    private String officePhone;

    private String qq;

    private String remark;

    private String salt;

    private String userAddress;

    private String userCode;

    private String userEmail;

    private String userMobile;

    private String userName;

    private String weixin;

    private String createUser;

    private String modifyUser;

    private String compId;

    private Integer flagDelete;

    private Integer flagSort;

    private Integer flagStatus;

    private Integer flagVersion;

    private Date makeTime;

    private String makeUser;

    private Date modifyTime;

    private String userPassword;

    private Integer userKind;

    private String organId;
}
