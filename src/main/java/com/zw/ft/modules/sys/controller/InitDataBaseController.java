package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.service.database.InitDatabaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName InitDataBase
 * @Description 初始化数据库，整合商贸和资金
 * @Author Oliver
 * @Date 2020/10/13 9:03
 * @Version 1.0
 **/
@RestController
public class InitDataBaseController {

    @Resource
    InitDatabaseService init;
    @PostMapping(value = "/ft/init_database")
    public R init() {
        try {
            init.initSysUser();
            init.initSysCompany();
            return R.ok();
        }catch (Exception e){
            return R.error(e.getMessage());
        }
    }
}
