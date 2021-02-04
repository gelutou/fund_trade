package com.zw.ft.modules.bdm.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCargoCategory;
import com.zw.ft.modules.bdm.entity.BdmCargoMonthPrice;
import com.zw.ft.modules.bdm.service.BdmCargoCategoryService;
import com.zw.ft.modules.bdm.service.BdmCargoMonthPriceService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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
    @Resource
    BdmCargoMonthPriceService monthPriceService;

    /**
     * 功能描述 : 查询货品分类列表
     * @author Oliver 2021-2-2 10:58
     */
    @PostMapping("/queryList")
    public R queryList() {
        return R.data(bdmCargoCategoryService.queryContainPrice());
    }

    /**
     * 功能描述 : 批量删除货品分类
     * @author Oliver 2021-2-2 10:58
     */
    @PostMapping("/delete")
    public R delete(@RequestBody BdmCargoCategory cargoCategory){
        Object[] ids = cargoCategory.getIds();
        UpdateWrapper<BdmCargoCategory> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        bdmCargoCategoryService.remove(wrapper);
        return R.ok();
    }

    /**
     * 功能描述 : 更新货品分类信息
     * @author Oliver 2021-2-2 10:58
     */
    @PostMapping("/update")
    public R update(@RequestBody(required = false) @Validated(BaseEntity.Update.class) BdmCargoCategory bdmCargoCategory) {
        if(bdmCargoCategory.getCode() == null && bdmCargoCategory.getName() == null){
            return R.error("货品分类编码或名称不能都为空");
        }
        bdmCargoCategoryService.updateById(bdmCargoCategory);
        return R.ok();
    }

    /**
     * 功能描述 : 添加货品分类信息
     * @author Oliver 2021-2-2 10:58
     */
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public R add(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmCargoCategory bdmCargoCategory) {

        try {
            bdmCargoCategoryService.save(bdmCargoCategory);
            BdmCargoMonthPrice bdmCargoPrice = new BdmCargoMonthPrice();
            bdmCargoPrice.setYear(DateUtil.year(new Date())+"");
            bdmCargoPrice.setCargoCategoryId(bdmCargoCategory.getId());
            monthPriceService.save(bdmCargoPrice);
        }catch (Exception e) {
            String message = e.getMessage();
            if(message.contains("for key 'bdm_cargo_category.category_code'")){
                return R.error("此编码已经存在，请重新输入");
            }else if (message.contains("for key 'bdm_cargo_category.category_name'")){
                return R.error("此名称已经存在，请重新输入");
            }else {
                return R.error(message);
            }
        }
        return R.ok();
    }

    /**
     * 功能描述 : 设定分类价格
     * @author Oliver 2021-2-2 10:58
     */
    @PostMapping("/updatePrice")
    public R updatePrice(@RequestBody(required = false) @Validated(BaseEntity.Update.class) BdmCargoMonthPrice monthPrice) {
        monthPrice.setYear(DateUtil.year(new Date())+"");
        monthPriceService.updateById(monthPrice);
        return R.ok();
    }
}

