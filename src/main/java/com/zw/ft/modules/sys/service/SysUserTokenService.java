package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统用户token表 服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
public interface SysUserTokenService extends IService<SysUserToken> {

    /**
     * @description: 查询token 带 user 信息
     * @author: Oliver
     * @date 2020/9/27
     */
    SysUserToken getTokenUserByToken(QueryWrapper<SysUserToken> tokenQueryWrapper);

}
