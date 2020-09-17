package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.repository.SysUserRepository;
import com.zw.ft.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description 系统用户的实现
 * @Author Oliver
 * @Date 2020/9/15 18:10
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserRepository, SysUserEntity> implements SysUserService {
}
