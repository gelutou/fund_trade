package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 银行信息表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/ft/sys-bank")
public class SysBankController {

    @Resource
    SysBankService sysBankService;

/**
 * @Author savior
 * @Description  分页查询银行基本信息
 * @Date: 2020/9/28
 */
    @PostMapping("/banckall")
    public R Banckall(@RequestBody Map<String,Object> params){
       return R.page(sysBankService.getBank(params));
    }

}
