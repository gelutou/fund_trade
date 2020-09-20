package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@description: 系统用户服务
 *@author:  Oliver
 *@date  2020/9/15
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 功能描述: <br>
     * 〈查询用户信息（包括角色）〉
     * @Param: [sysUserQueryWrapper]
     * @Return: java.util.List<com.zw.ft.modules.sys.entity.SysUserEntity>
     * @Author: Oliver
     * @Date: 2020/9/19 21:07
     */
    List<SysUserEntity> getUserAllMessage(QueryWrapper<SysUserEntity> sysUserQueryWrapper);

    /**
     * 功能描述: <br>
     * 〈查询用户的权限〉
     * @Param: [userId]
     * @Return: java.util.List<java.lang.String>
     * @Author: Oliver
     * @Date: 2020/9/20 13:13
     */
    List<String> getUserPerms(long userId);
}
