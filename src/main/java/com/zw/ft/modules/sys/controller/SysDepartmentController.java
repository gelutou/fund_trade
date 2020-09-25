package com.zw.ft.modules.sys.controller;


import com.alibaba.fastjson.JSONArray;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.service.SysDepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 系统部门表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/ft/sys-department")
public class SysDepartmentController {

    @Resource
    SysDepartmentService sysDepartmentService;

    /**
     * @Author savior
     * @Description 根据树节点主节点公司ID,获取部门档案树信息
     * @Date: 2020/9/24
     */
    @PostMapping("/getDeptTree")
    public R loadManagerLeftTreeJson(@RequestBody Map<String,Object> params){
        JSONArray as = sysDepartmentService.getMenu(params);
        return R.data(as);
    }

    public R DeparTementAddto(SysDepartment sysDepartment){
            sysDepartmentService.DeptAddto(sysDepartment);
        return R.ok();
    }

}





