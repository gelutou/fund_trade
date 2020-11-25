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
