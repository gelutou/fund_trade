package com.zw.ft.modules.bdm.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCargoCategory;
import com.zw.ft.modules.bdm.service.BdmCargoCategoryService;
import org.springframework.validation.annotation.Validated;
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
@Validated
@RequestMapping("/ft/bdm-cargo-category")
public class BdmCargoCategoryController {

    @Resource
    BdmCargoCategoryService bdmCargoCategoryService;

/**
 * @Author savior
 * @Description 获取货品分类树信息
 * @Date: 2020/11/30
 */
    @PostMapping("/get_cargotypetree")
    public R getBdmCargoCategoryTree() {
        return R.data(bdmCargoCategoryService.list());
    }

    /**
     * @Author savior
     * @Description 根据id获取货品分类信息
     * @Date: 2020/11/30
     */
    @PostMapping("/query/{id}")
    public R queryId(@PathVariable("id") long id){
        BdmCargoCategory byId = bdmCargoCategoryService.getById(id);
        BdmCargoCategory serviceOne = bdmCargoCategoryService.getById(byId.getParentPkid());
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
        bdmCargoCategoryService.removeById(id);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 修改货品分类信息
     * @Date: 2020/12/1
     */
    @PostMapping("/update_cargocategory")
    public R updateCargoCategory(@RequestBody(required = false) @Validated(BaseEntity.Update.class) BdmCargoCategory bdmCargoCategory) {
        UpdateWrapper<BdmCargoCategory> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", bdmCargoCategory.getId());
        bdmCargoCategoryService.update(bdmCargoCategory, updateWrapper);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 添加货品分类信息
     * @Date: 2020/12/1
     */
    @PostMapping("/add_cargocategory")
    public R addCargoCategory(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmCargoCategory bdmCargoCategory) {
        bdmCargoCategoryService.save(bdmCargoCategory);
        return R.ok();
    }
}

