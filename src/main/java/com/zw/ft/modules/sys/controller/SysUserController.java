package com.zw.ft.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author Oliver
 * @Date 2020/9/21 15:07
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/ft/sys/user/")
public class SysUserController {

    @Resource
    SysUserService sysUserService;
    /**
     *@description: 返回公司下所有符合条件的人员分页
     *@author:  Oliver
     *@date  2020/9/21
     */
    /*@PostMapping(value = "/com_users_page")
    public R queryUsersPageByComAndWrapper(@RequestBody Map<String,Object> params){
        QueryWrapper<SysUser> userEntityQueryWrapper = new QueryWrapper<>();
        long comId = Long.parseLong(params.get("comId").toString());
        String username = params.get("username").toString();
        String realname = params.get("realname") == null?"":params.get("realname").toString();
        String status = params.get("status") == null?"":params.get("realname").toString();
        String current = params.get("current") == null?"":params.get("current").toString();
        String size = params.get("size") == null?"":params.get("size").toString();
        if(!"".equals(username)){
            userEntityQueryWrapper.eq("username",username);
        }
        if(!"".equals(realname)){
            userEntityQueryWrapper.like("realname",realname);
        }
        if(!"".equals(status)){
            userEntityQueryWrapper.eq("status",status);
        }

        Page<SysUser> usersPage = new Page<>();
        if(!"".equals(current)){
            usersPage.setCurrent(Long.parseLong(current));
        }
        if(!"".equals(size)){
            usersPage.setSize(Long.parseLong(size));
        }
        usersPage = sysUserService.queryUsersPageByComAndWrapper(usersPage, comId, userEntityQueryWrapper);
        return R.page(usersPage);
    }*/

    /*
     * 功能描述: <br>
     * 〈获取部门下人员〉
     * @Param: [deptId 部门ID]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/11/24 10:50
     */

    @PostMapping(value = "/user_in_dept")
    public R getUserInDepartmentPage(@RequestBody Map<String,Object> params){
        return R.page(sysUserService.getUserInDepartmentPage(params));
    }
}
