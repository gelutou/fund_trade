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

    @Select("SELECT su.*,bc.`name` AS cusName,us.username," +
            "sd1.`des` as typeDes,sd2.`des` as natureDes,sd3.`des` as areaDes," +
            "sd4.`des` as belongToDes,sd5.`des` as currencyTypeDes " +
            "FROM sys_bank su " +
            "LEFT JOIN bdm_customer bc ON bc.ID = su.cus_id " +
            "LEFT JOIN sys_user us ON us.ID=su.CREATED_BY " +
            "LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'ACCOUNT_TYPE' AND value IS NULL)) sd1 ON su.type=sd1.value " +
            "LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'ACCOUNT_NATURE' AND value IS NULL)) sd2 ON su.nature=sd2.value " +
            "LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'ACCOUNT_AREA' AND value IS NULL)) sd3 ON su.area=sd3.value " +
            "LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = '' AND value IS NULL)) sd4 ON su.belong_to=sd4.value " +
            "LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = '' AND value IS NULL)) sd5 ON su.currency_type=sd5.value " +
            "${ew.customSqlSegment}")
    Page<SysBank> querySysBankPageByComId(Page<SysBank> page, @Param("ew") QueryWrapper<SysBank> queryWrapper);
}
