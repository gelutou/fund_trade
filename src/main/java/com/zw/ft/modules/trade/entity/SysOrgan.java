package com.zw.ft.modules.trade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-14
 */
@Data
@TableName(value = "sys_organ")
public class SysOrgan {

    private static final long serialVersionUID = 1L;

    private String pkId;

    private String organCode;

    private String organName;

    private String parentPkid;

    private String parentPath;

    private String manager;

    private String remark;

    private Integer flagStatus;

    private Integer flagSort;

    private Integer flagDelete;

    private Long flagVersion;

    private String makeUser;

    private Date makeTime;

    private String modifyUser;

    private Date modifyTime;

    private String compPkid;

    private Integer flagAudit;

    private String auditPid;

}
