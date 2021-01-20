package com.zw.ft.modules.co.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.co.entity.RunRisePrice;
import com.zw.ft.modules.co.service.RunRisePriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @Author Oliver
     * @Description 分页查询加价档案基本信息
     * @Date: 2020/11/13
     */
    @PostMapping("/queryRunRisePage")
    public R queryRunRisePage(@RequestBody Map<String, Object> params){
        return R.page(runRisePriceService.getRun(params));
    }

    /**
     * @Author savior
     * @Description 修改加价金额和状态
     * @Date: 2020/11/13
     */
    @PostMapping("/updateRunRisePrice")
    public R updateRunRisePrice(@RequestBody RunRisePrice runRisePrice){
        return runRisePriceService.getRunRise(runRisePrice);
    }
}
