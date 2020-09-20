package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 系统部门表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-20
 */
@ApiModel(value="SysDepartment对象", description="系统部门表")
public class SysDepartment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所属公司")
    private Integer comId;

    @ApiModelProperty(value = "父级ID")
    private Integer parentId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "部门负责人")
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
