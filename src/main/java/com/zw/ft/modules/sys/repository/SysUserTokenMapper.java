package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  系统用户token表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {

    /**
     *@description: 查询token 带 user 信息
     *@author:  Oliver
     *@date  2020/9/27
     */
    @Select("SELECT * FROM SELECT * FROM sys_user_token WHERE ${ew.sqlSegment}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "userId",property = "user",
                    many = @Many(
                            select = "com.zw.ft.modules.sys.repository.SysUserMapper.selectById"
                    )
            )
    })
    SysUserToken getTokenUserByToken(@Param("ew")QueryWrapper<SysUserToken> tokenQueryWrapper);
}
