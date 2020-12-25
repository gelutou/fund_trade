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
            "sd1.`des` as typeDes," +
            "sd2.`des` as natureDes," +
            "sd3.`des` as areaDes," +
            "sd4.`des` as belongToDes," +
            "sd5.`des` as currencyTypeDes " +
            "FROM sys_bank su " +
            "LEFT JOIN bdm_customer bc ON bc.ID = su.cus_id " +
            "LEFT JOIN sys_user us ON us.ID=su.CREATED_BY " +
            "LEFT JOIN sys_dictionary sd1 ON sd1.`value`=su.type " +
            "LEFT JOIN sys_dictionary sd2 ON sd2.`value`=su.nature " +
            "LEFT JOIN sys_dictionary sd3 ON sd3.`value`=su.area " +
            "LEFT JOIN sys_dictionary sd4 ON sd4.`value`=su.belong_to " +
            "LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'CURRENCY_TYPE' AND value IS NULL)) sd5 ON sd5.value=su.currency_type " +
            "${ew.customSqlSegment}")
    Page<SysBank> querySysBankPageByComId(Page<SysBank> page, @Param("ew") QueryWrapper<SysBank> queryWrapper);
}
