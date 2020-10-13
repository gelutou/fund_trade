package com.zw.ft.modules.fund.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.fund.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.trade.entity.SysUserTrade;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-12
 */
@DS("fund")
public interface TUserMapper extends BaseMapper<TUser> {

    @Select("SELECT * FROM t_user group by user_code")
    List<TUser> selectAllGroupByUserCode();
}
