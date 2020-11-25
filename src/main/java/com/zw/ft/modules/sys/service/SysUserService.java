package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description: 系统用户服务
 * @author: Oliver
 * @date 2020/9/15
 */
public interface SysUserService extends IService<SysUser> {

    /*
     * 功能描述: <br>
     * 〈查询部门下人员〉
     * @Author: Oliver
     * @Date: 2020/11/24 11:19
     */

    Page<SysUser> getUserInDepartmentPage(Map<String, Object> params);

    /**
     * 功能描述: <br>
     * 〈查询用户信息（包括角色）〉
     *
     * @Param: [sysUserQueryWrapper]
     * @Return: java.util.List<com.zw.ft.modules.sys.entity.SysUserEntity>
     * @Author: Oliver
     * @Date: 2020/9/19 21:07
     */
    List<SysUser> getUserAllMessage(QueryWrapper<SysUser> sysUserQueryWrapper);

    /**
     * 功能描述: <br>
     * 〈查询用户的权限〉
     *
     * @Param: [userId]
     * @Return: java.util.List<java.lang.String>
     * @Author: Oliver
     * @Date: 2020/9/20 13:13
     */
    List<String> getUserPerms(long userId);

    /**
     * @description: 返回公司下所有符合条件的人员分页
     * @author: Oliver
     * @date 2020/9/21
     */
    Page<SysUser> queryUsersPageByComAndWrapper(Page<SysUser> page, long comId, QueryWrapper<SysUser> userEntityQueryWrapper);
}
