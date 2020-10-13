package com.zw.ft.modules.trade.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.trade.entity.SysCompanyTrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 公司信息表	与客商使用相同的表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-13
 */
@DS("trade")
public interface SysCompanyTradeMapper extends BaseMapper<SysCompanyTrade> {

    @Select("SELECT * FROM sys_company")
    List<SysCompanyTrade> getAllComs();

}
