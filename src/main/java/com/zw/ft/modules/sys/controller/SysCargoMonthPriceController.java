package com.zw.ft.modules.sys.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCargoMonthPrice;
import com.zw.ft.modules.sys.service.SysCargoMonthPriceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 货品价格扩展信息表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/ft/sys-cargo-month-price")
public class SysCargoMonthPriceController {

    @Resource
    SysCargoMonthPriceService sysCargoMonthPriceService;
    /**
     * @Author savior
     * @Description 根据货品ID查询货品价格
     * @Date: 2020/12/8
     */
    @PostMapping("/queryCargo/{pkId}")
    public R queryCargoId(@PathVariable("pkId") String pkId){
        //获取当前年份
        return R.data(sysCargoMonthPriceService.selectPriceById(pkId,DateUtil.today()));
    }

    /** 
     * @Author savior
     * @Description 根据货品设定价格
     * @Date: 2020/12/9
     */
    @PostMapping("/addMonthPrice")
    public R addMonthPrice(@RequestBody(required = false) SysCargoMonthPrice sysCargoMonthPrice){
        UpdateWrapper<SysCargoMonthPrice> updateWrapper = new UpdateWrapper<>();
        //获取当前年份
        int year = DateUtil.year(new Date());
        sysCargoMonthPrice.setYear(year+"");
        updateWrapper.eq("year",sysCargoMonthPrice.getYear());
        updateWrapper.eq("CARGO_CATEGORY_PKID",sysCargoMonthPrice.getCargoCategoryPkid());
        sysCargoMonthPriceService.saveOrUpdate(sysCargoMonthPrice,updateWrapper);
        return R.ok("更新成功");
    }
}

