package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.RunRisePrice;
import com.zw.ft.modules.sys.service.RunRisePriceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 加价档案表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/ft/run-rise-price")
public class RunRisePriceController {



    @Resource
    RunRisePriceService runRisePriceService;

    /**
     * @Author savior
     * @Description  分页查询加价档案基本信息
     * @Date: 2020/11/13
     */
    @PostMapping("/RunRisePricekall")
    public R RunRisePricekall(@RequestBody Map<String,Object> params){
        return R.page(runRisePriceService.getRun(params));
    }

    /**
     * @Author savior
     * @Description 修改加价金额和状态
     * @Date: 2020/11/13
     */
    @PostMapping("/updateRunRisePrice")
    public R updateRunRisePrice(@RequestBody RunRisePrice runRisePrice){
       return R.data(runRisePriceService.getRunRise(runRisePrice));
    }

}
