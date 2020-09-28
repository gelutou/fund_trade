package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.zw.ft.modules.sys.service.ShiroService;
import com.zw.ft.modules.sys.service.SysUserTokenService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 *@description: shiro服务实现
 *@author:  Oliver
 *@date  2020/9/27
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    SysUserTokenService sysUserTokenService;

    /*@Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }*/

    @Override
    public SysUserToken queryByToken(String token) {
        QueryWrapper<SysUserToken> tokenQueryWrapper = new QueryWrapper<>();
        tokenQueryWrapper.eq("token",token);
        return sysUserTokenService.getOne(tokenQueryWrapper);
    }
}
