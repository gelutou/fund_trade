package com.zw.ft.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCargoCategory;
import com.zw.ft.modules.sys.service.SysCargoCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 货品分类表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/ft/sys-cargo-category")
public class SysCargoCategoryController {

    @Resource
    SysCargoCategoryService sysCargoCategoryService;

/**
 * @Author savior
 * @Description 获取货品分类树信息
 * @Date: 2020/11/30
 */
    @PostMapping("/getSysCargoTypeTree")
    public R getSysCargoCategoryTree() {
        List<SysCargoCategory> sysCargoCategoryList = sysCargoCategoryService.list();
        if (sysCargoCategoryList.size()!=0) {
            return R.data(sysCargoCategoryList);
        } else {
            return R.error("获取货品分类失败");
        }
    }

    /**
     * @Author savior
     * @Description 根据id获取货品分类信息
     * @Date: 2020/11/30
     */
    @PostMapping("/query/{id}")
    public R queryId(@PathVariable("id") long id){
        QueryWrapper<SysCargoCategory> wrapper = new QueryWrapper<>();
        SysCargoCategory byId = sysCargoCategoryService.getById(id);
        SysCargoCategory serviceOne = sysCargoCategoryService.getById(byId.getParentPkid());
        byId.setParentName(serviceOne==null?"":serviceOne.getCategoryName());
        return R.data(byId);
    }

    /**
     * @Author savior
     * @Descriptionc 根据id删除货品分类信息
     * @Date: 2020/11/30
     */
    @PostMapping("/del/{ids}")
    public R delCargoCategory(@PathVariable("ids") long ids){
        boolean b = sysCargoCategoryService.removeById(ids);
        if (b) return R.ok("删除成功");
        else return R.error("删除失败");
    }

    /**
     * @Author savior
     * @Description 修改货品分类信息
     * @Date: 2020/12/1
     */
    @PostMapping("/updaCargoCategory")
    public R updateCargoCategory(@RequestBody(required = false) SysCargoCategory sysCargoCategory) {
        UpdateWrapper<SysCargoCategory> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", sysCargoCategory.getId());
        boolean update = sysCargoCategoryService.update(sysCargoCategory, updateWrapper);
        if (update) {
            return R.ok("更新成功");
        } else {
            return R.error("更新失败");
        }
    }

    /**
     * @Author savior
     * @Description 添加货品分类信息
     * @Date: 2020/12/1
     */
    @PostMapping("/addCargoCategory")
    public R addCargoCategory(@RequestBody(required = false) SysCargoCategory sysCargoCategory) {
        boolean save = sysCargoCategoryService.save(sysCargoCategory);
        if (save) {
            return R.ok("添加成功");
        } else {
            return R.error("添加失败");
        }
    }
}

