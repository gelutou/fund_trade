package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;

/**
 * <p>
 * 系统部门表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-20
 */
public class SysDepartment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer comId;

    private Integer parentId;

    private String deptName;

    private Integer leader;


    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
        "comId=" + comId +
        ", parentId=" + parentId +
        ", deptName=" + deptName +
        ", leader=" + leader +
        "}";
    }
}
