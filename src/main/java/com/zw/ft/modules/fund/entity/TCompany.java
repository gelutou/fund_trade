package com.zw.ft.modules.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 内部公司表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-13
 */
@TableName(value = "t_company")
@Data
public class TCompany implements Serializable {

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

    private String compAddress;

    private String compCity;

    private String compCode;

    private String compDistrict;

    private String compName;

    private String compProvince;

    private Date compRegtime;

    private String compTaxNum;

    private Integer compType;

    private String contactMail;

    private String contactName;

    private String contactPhone;

    private Integer customerStates;

    private Integer flagSets;

    private String managerMail;

    private String managerMobile;

    private String managerPassword;

    private String parentId;

    private String shortCompName;

    private String systemManager;

    private String remark;

    private BigDecimal acutalCapital;

    /**
     * 地区
     */
    private String compArea;

    private String corporation;

    private String fundManager;

    private String fundMember;

    private String keepPersent;

    private Date licenseTerm;

    private String managerPhone;

    private String memberPhone;

    private String registerAddress;

    private BigDecimal registerCapital;

    private String stockHolder;

    private String taxpayerNumber;

    private Date timeLimit;

    private String workingAddress;

}
