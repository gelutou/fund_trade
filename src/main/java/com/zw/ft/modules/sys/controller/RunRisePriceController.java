package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.service.SysCompanyService;
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
    SysCompanyService sysCompanyService;
    /**
     * @Author savior
     * @Description  分页查询加价档案基本信息
     * @Date: 2020/9/28
     */
    @PostMapping("/RunRisePricekall")
    public R RunRisePricekall(@RequestBody Map<String,Object> params){
        return R.page(sysCompanyService.getBank(params));
    }
}
