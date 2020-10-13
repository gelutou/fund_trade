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
    public R loadManagerLeftTreeJson(@RequestBody Map<String,Object> params) {
        JSONArray as = sysDepartmentService.getMenu(params);
        if (as != null) {
            return R.data(as);
        } else {
            return R.error("获取部门失败");
        }
    }

/**
 * @Author savior
 * @Description 添加部门信息
 * @Date: 2020/9/27
 */
    @PostMapping("/addDept")
    public R deparTementAddto(@RequestBody SysDepartment sysDepartment,ModelConfigurationController modelConfigurationController){

        if (sysDepartment != null && sysDepartment.getParentId() < 2){
           sysDepartmentService.deptAddto(sysDepartment);
            return R.ok("添加成功");
        }else {
            return modelConfigurationController.promptInformation("dept_tips_menucannotcreate");
        }
    }

    /**
     * @Author savior
     * @Description 根据id逻辑删除部门
     * @Date: 2020/9/25
     */
    @PostMapping("/delete/{id}")
    public R deleteDept(@PathVariable("id")String id) {
        int i = sysDepartmentService.deleteDept(id);
        if (i != 0){
            return R.ok("删除成功");
        }else {
            return R.error("删除失败");
        }

    }

    /**
     * @Author savior
     * @Description 根据id修改部门信息
     * @Date: 2020/9/27
     */
    @ResponseBody
    @PostMapping("/update")
    public R updaDept(@RequestBody  SysDepartment sysDepartment ){
        if(sysDepartment.getId()!=0){
            sysDepartmentService.updaDept(sysDepartment);
            return R.ok("修改成功");
        }else {
            return R.error("修改失败");
        }
    }

}





