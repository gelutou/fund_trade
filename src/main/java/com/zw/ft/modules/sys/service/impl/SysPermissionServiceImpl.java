package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.base.Constant;
import com.zw.ft.modules.sys.entity.SysPermission;
import com.zw.ft.modules.sys.repository.SysPermissionMapper;
import com.zw.ft.modules.sys.service.SysPermissionService;
import com.zw.ft.modules.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName SysUserServiceImpl
 * @Description 系统用户的实现
 * @Author Oliver
 * @Date 2020/9/15 18:10
 * @Version 1.0
 **/
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Resource
    SysPermissionMapper sysPermissionMapper;
    @Resource
    SysUserService sysUserService;

    @Override
    public List<SysPermission> getRootMenu(long userId) {
        return sysPermissionMapper.getRootMenu(userId);
    }

    @Override
    public List<SysPermission> getChildMenu(long userId, long parentId) {
        return sysPermissionMapper.getChildMenu(userId, parentId);
    }

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;
        //当是超级管理员拥有全部权限
        if (userId == Constant.SUPER_ADMIN) {
            List<SysPermission> sysPermissionEntities = sysPermissionMapper.selectList(null);
            permsList = new ArrayList<>(sysPermissionEntities.size());
            for (SysPermission perm : sysPermissionEntities) {
                permsList.add(perm.getPerms());
            }
        } else {
            //查询用户的所有权限
            permsList = sysUserService.getUserPerms(userId);
        }
        //进行权限的拼接后返回
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }
}
