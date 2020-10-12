package com.zw.ft.modules.sys.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.repository.SysUserMapper;
import com.zw.ft.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description 系统用户的实现
 * @Author Oliver
 * @Date 2020/9/15 18:10
 * @Version 1.0
 **/
@Service("sysUserService")
@DS("slave_1")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> getUserAllMessage(QueryWrapper<SysUser> sysUserQueryWrapper) {
        return sysUserMapper.getUserAllMessage(sysUserQueryWrapper);
    }

    @Override
    public List<String> getUserPerms(long userId) {
        return sysUserMapper.getUserPerms(userId);
    }

    @Override
    public Page<SysUser> queryUsersPageByComAndWrapper(Page<SysUser> page, long comId, QueryWrapper<SysUser> userEntityQueryWrapper) {
        return sysUserMapper.queryUsersPageByComAndWrapper(page,comId,userEntityQueryWrapper);
    }
}
