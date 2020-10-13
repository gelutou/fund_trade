package com.zw.ft.modules.trade.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.trade.entity.SysUserTrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-12
 */
@DS("trade")
public interface SysUserTradeMapper extends BaseMapper<SysUserTrade> {

    @Select("SELECT * FROM sys_user group by user_code")
    List<SysUserTrade> selectAllGroupByUserCode();

}
