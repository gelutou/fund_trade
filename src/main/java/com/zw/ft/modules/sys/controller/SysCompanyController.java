package com.zw.ft.modules.sys.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.BaseController;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.service.SysCompanyService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

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
public class SysCompanyController extends BaseController {

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
    public R getFuzzy(@PathVariable("username") String username, @PathVariable("shortname")String shortName){
        return R.data(sysCompanyService.getFuzzy(username,shortName));
    }

    /**
     * 功能描述: <br>
     * 〈添加公司〉
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @PostMapping(value = "/add_update_com")
    public R addCom(@RequestBody(required = false) Map<String,Object> params){
        String addUpdate = params.get("addUpdate").toString();
        SysCompany sysCompany = Convert.convert(SysCompany.class, params);
        boolean result;
        if(Constant.DatabaseOperation.ADD.getValue().equals(addUpdate)){
            result = sysCompanyService.save(sysCompany);
        }else if(Constant.DatabaseOperation.UPDATE.getValue().equals(addUpdate)){
            result = sysCompanyService.updateById(sysCompany);
        }else {
            return R.error("未传入addUpdate参数");
        }
        if(result){
            return R.ok();
        }else {
            return R.error();
        }
    }
    /**
     * 功能描述: <br>
     * 〈查询符合条件的公司，公司基本数据菜单〉
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @PostMapping(value = "/get_by_wrapper")
    public R getByWrapper(@RequestBody(required = false) Map<String,Object> params){

        Page<SysCompany> page = new QueryUtil<SysCompany>(params).getPage();
        QueryWrapper<SysCompany> queryWrapper = new QueryWrapper<>();
        if(params.get("name") != null){
            queryWrapper.like("com_name",params.get("name"));
        }

        if(params.get("shortName") != null){
            queryWrapper.like("short_com_name",params.get("shortName"));
        }

        if(params.get("code") != null){
            queryWrapper.like("com_code",params.get("code"));
        }

        if(params.get("startDateTime") != null){
            queryWrapper.ge("created_time",params.get("startDateTime"));
        }

        if(params.get("endDateTime") != null){
            queryWrapper.le("created_time",params.get("endDateTime"));
        }

        if(params.get("mobile") != null){
            queryWrapper.like("mobile",params.get("mobile"));
        }
        queryWrapper.orderByAsc("updated_time");

        return R.page(sysCompanyService.page(page, queryWrapper));
    }
}

