package com.zw.ft.modules.sys.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.service.SysCompanyService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 公司信息表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/ft/sys-company")
public class SysCompanyController {

    @Resource
    SysCompanyService sysCompanyService;

    /**
     * 功能描述: <br>
     * 〈模糊查询用户所在公司，用于登录页展示〉
     * @Param: [username 员工账号, shortName 公司简称 ]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @PostMapping(value = "get_fuzzy/{username}/{shortname}")
    public R<List<SysCompany>> getFuzzy(@PathVariable("username") String username, @PathVariable("shortname")String shortName){
        return R.ok(sysCompanyService.getFuzzy(username,shortName));
    }
}

