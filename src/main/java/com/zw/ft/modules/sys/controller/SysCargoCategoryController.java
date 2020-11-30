package com.zw.ft.modules.sys.controller;


import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCargoCategory;
import com.zw.ft.modules.sys.service.SysCargoCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/sys-cargo-category")
public class SysCargoCategoryController {

    @Resource
    SysCargoCategoryService sysCargoCategoryService;


    @PostMapping("/getSysCargoType")
    public R getSysCargoCategory() {
        List<SysCargoCategory> sysCargoCategoryList = sysCargoCategoryService.list();
        if (sysCargoCategoryList.size()!=0) {
            return R.data(sysCargoCategoryList);
        } else {
            return R.error("获取数据失败");
        }
    }
}

