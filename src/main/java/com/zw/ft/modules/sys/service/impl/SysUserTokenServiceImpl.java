package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.zw.ft.modules.sys.repository.SysUserTokenMapper;
import com.zw.ft.modules.sys.service.SysUserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  系统用户token表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserToken> implements SysUserTokenService {

    @Resource
    SysUserTokenMapper sysUserTokenMapper;
    @Override
    public SysUserToken getTokenUserByToken(QueryWrapper<SysUserToken> tokenQueryWrapper) {
        return sysUserTokenMapper.getTokenUserByToken(tokenQueryWrapper);
    }
}
