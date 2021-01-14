package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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


    /**
     * 功能描述 : 银行信息查询
     * @return 银行分页
     * @author Oliver 2021-1-7 15:06
     */
    @Select("SELECT su.*, bc.name cusName, us.realname creator FROM sys_bank su " +
            " LEFT JOIN bdm_customer bc ON bc.ID = su.cus_id" +
            " LEFT JOIN sys_user us ON us.ID = su.CREATED_BY" +
            " ${ew.customSqlSegment}")
    Page<SysBank> querySysBankPageByWrapper(Page<SysBank> page, @Param("ew") QueryWrapper<SysBank> queryWrapper);


    @Select("SELECT * FROM sys_bank WHERE cus_id = #{cusId}")
    List<SysBank> queryBanksUnderCustomer(@Param("cusId") Long cusId);
}
