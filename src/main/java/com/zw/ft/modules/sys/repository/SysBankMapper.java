package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysBank;
import org.apache.ibatis.annotations.Mapper;
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

    @Select("SELECT * FROM sys_bank su LEFT JOIN sys_company scy ON su.com_id = scy.ID")
    Page<SysBank> querySysBankPageByComId(Page<SysBank> page);

}
