package com.zw.ft.common.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @ClassName BaseController
 * @Description BaseController
 * @Author Oliver
 * @Date 2020/9/19 15:29
 * @Version 1.0
 **/
@Controller
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected String getUserName() {
        SysUser sysUer = getUser();
        if(sysUer==null){
            return "admin";
        }
        return sysUer.getUsername();
    }

    protected Long getUserId() {
        SysUser sysUer = getUser();
        if(sysUer==null){
            return -1L;
        }
        return sysUer.getId();
    }

    /*protected SysCompany getCompany(){
        Long userId = getUserId();
        QueryWrapper<SysCompany> companyInfoEntityEntityWrapper = new EntityWrapper<>();
        companyInfoEntityEntityWrapper.eq("user_id",userId);
        return companyInfoService.selectOne(companyInfoEntityEntityWrapper);
    }*/
}
