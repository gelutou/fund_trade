package com.zw.ft.modules.bdm.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCargoMonthPrice;
import com.zw.ft.modules.bdm.service.BdmCargoMonthPriceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 货品价格扩展信息表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/ft/bdm-cargo-month-price")
public class BdmCargoMonthPriceController {

    @Resource
    BdmCargoMonthPriceService bdmCargoMonthPriceService;
    /**
     * @Author savior
     * @Description 根据货品ID查询货品价格
     * @Date: 2020/12/8
     */
    @PostMapping("/querycargo/{cargoCategoryId}")
    public R queryCargoId(@PathVariable("cargoCategoryId") Long cargoCategoryId){
        //获取当前年份
        String year = String.valueOf(DateUtil.year(new Date()));
        return R.data(bdmCargoMonthPriceService.selectPriceById(cargoCategoryId,year));
    }

    /** 
     * @Author savior
     * @Description 根据货品设定价格
     * @Date: 2020/12/9
     */
    @PostMapping("/add_monthprice")
    public R addMonthPrice(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmCargoMonthPrice bdmCargoMonthPrice){
        UpdateWrapper<BdmCargoMonthPrice> updateWrapper = new UpdateWrapper<>();
        //获取当前年份
        bdmCargoMonthPrice.setYear(String.valueOf(DateUtil.year(new Date())));
        updateWrapper.eq("year", bdmCargoMonthPrice.getYear());
        updateWrapper.eq("cargo_category_id", bdmCargoMonthPrice.getCargoCategoryId());
        bdmCargoMonthPriceService.saveOrUpdate(bdmCargoMonthPrice,updateWrapper);
        return R.ok();
    }

}

