package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.repository.SysUserRepository;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserRepository, SysUserEntity> implements SysUserService {

    @Resource
    SysUserRepository sysUserRepository;
    @Override
    public List<SysUserEntity> getUserAllMessage(QueryWrapper<SysUserEntity> sysUserQueryWrapper) {
        return sysUserRepository.getUserAllMessage(sysUserQueryWrapper);
    }
}
