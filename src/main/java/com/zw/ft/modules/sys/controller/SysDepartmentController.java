package com.zw.ft.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.service.SysDepartmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 系统部门表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/ft/sys-department")
public class SysDepartmentController {
    @Resource
    SysDepartmentService sysDepartmentService;

    /*
     * 功能描述: <br>
     * 〈查询父部门〉
     * @Param: 公司ID
     * @Author: Oliver
     * @Date: 2020/10/16 11:08
     */

    @RequestMapping(value = "/query/{comId}")
    public R query(@PathVariable("comId") long comId){
        QueryWrapper<SysDepartment> sysDepartmentQueryWrapper = new QueryWrapper<>();
        sysDepartmentQueryWrapper.eq("com_id",comId);
        return R.data(sysDepartmentService.list(sysDepartmentQueryWrapper));
    }

    /*
     * 功能描述: <br>
     * 〈删除部门〉
     * @Param: deptId 部门ID
     * @Author: Oliver
     * @Date: 2020/10/16 11:23
     */

    @RequestMapping(value = "/delete/{id}")
    public R del(@PathVariable("id") long deptId){
        boolean b = sysDepartmentService.removeById(deptId);
        if(b){
            return R.ok("删除成功");
        }else {
            return R.error("删除失败");
        }
    }

    /*
     * 功能描述: <br>
     * 〈修改部门〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/10/16 11:32
     */

    @RequestMapping(value = "/update")
    public R update(@RequestBody(required = false) SysDepartment sysDepartment){
        UpdateWrapper<SysDepartment> departmentUpdateWrapper = new UpdateWrapper<>();
        departmentUpdateWrapper.eq("id",sysDepartment.getId());
        boolean update = sysDepartmentService.update(sysDepartment, departmentUpdateWrapper);

        if(update){
            return R.ok("修改成功");
        }else {
            return R.error("修改失败");
        }
    }

    /*
     * 功能描述: <br>
     * 〈增加部门〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/10/16 11:33
     */

    @RequestMapping(value = "/add")
    public R add(@RequestBody(required = false) SysDepartment sysDepartment){
        boolean save = sysDepartmentService.save(sysDepartment);
        if(save){
            return R.ok("添加成功");
        }else {
            return R.error("添加失败");
        }
    }

}

