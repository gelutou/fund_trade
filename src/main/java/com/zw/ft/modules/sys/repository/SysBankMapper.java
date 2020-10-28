package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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

    @Select("SELECT su.*,scy.com_name,us.username FROM sys_bank su " +
            "LEFT JOIN sys_company scy ON su.com_id = scy.ID " +
            "LEFT JOIN sys_user us ON us.ID=su.CREATED_BY " +
            "WHERE su.deleted=0 AND (su.BANK_NAME LIKE '%%' " +
            "AND scy.com_name LIKE '%%' AND su.BANK_ACCOUNT LIKE '%%' " +
            "AND su.ACCOUNT_STYLE LIKE '%%' AND su.ACCOUNT_TYPE LIKE '%%')")
    Page<SysBank> querySysBankPageByComId(Page<SysBank> page,@Param("ew") Wrapper<SysBank> queryWrapper);


}
