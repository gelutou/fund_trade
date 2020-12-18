package com.zw.ft.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCargoCategory;
import com.zw.ft.modules.sys.service.SysCargoCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @PostMapping("/get_cargotypetree")
    public R getSysCargoCategoryTree() {
        return R.data(sysCargoCategoryService.list());
    }

    /**
     * @Author savior
     * @Description 根据id获取货品分类信息
     * @Date: 2020/11/30
     */
    @PostMapping("/query/{id}")
    public R queryId(@PathVariable("id") long id){
        SysCargoCategory byId = sysCargoCategoryService.getById(id);
        SysCargoCategory serviceOne = sysCargoCategoryService.getById(byId.getParentPkid());
        byId.setParentName(serviceOne==null?"":serviceOne.getCategoryName());
        return R.data(byId);
    }

    /**
     * @Author savior
     * @Description 根据id删除货品分类信息
     * @Date: 2020/11/30
     */
    @PostMapping("/del/{id}")
    public R delCargoCategory(@PathVariable("id") long id){
        sysCargoCategoryService.removeById(id);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 修改货品分类信息
     * @Date: 2020/12/1
     */
    @PostMapping("/update_cargocategory")
    public R updateCargoCategory(@RequestBody(required = false) SysCargoCategory sysCargoCategory) {
        UpdateWrapper<SysCargoCategory> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", sysCargoCategory.getId());
        Preconditions.checkNotNull(sysCargoCategory.getId(),"请传入货品分类信息id值！");
        sysCargoCategoryService.update(sysCargoCategory, updateWrapper);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 添加货品分类信息
     * @Date: 2020/12/1
     */
    @PostMapping("/add_cargocategory")
    public R addCargoCategory(@RequestBody(required = false) SysCargoCategory sysCargoCategory) {
        Preconditions.checkNotNull(sysCargoCategory,"请传入货品分类信息！");
        sysCargoCategoryService.save(sysCargoCategory);
        return R.ok();
    }
}

