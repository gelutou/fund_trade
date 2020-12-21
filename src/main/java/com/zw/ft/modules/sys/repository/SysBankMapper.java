package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 银行信息表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@Mapper
public interface SysBankMapper extends BaseMapper<SysBank> {

    @Select("SELECT su.*,bc.`name`,us.username FROM sys_bank su " +
            "LEFT JOIN bdm_customer bc ON bc.ID = su.com_id " +
            "LEFT JOIN sys_user us ON us.ID=su.CREATED_BY" +
            "${ew.customSqlSegment}")
    Page<SysBank> querySysBankPageByComId(Page<SysBank> page, @Param("ew") QueryWrapper<SysBank> queryWrapper);

}
