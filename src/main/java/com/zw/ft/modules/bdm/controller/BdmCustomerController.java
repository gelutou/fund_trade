package com.zw.ft.modules.bdm.controller;


import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.service.BdmCustomerService;
import com.zw.ft.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 客商表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@RestController
@RequestMapping("/ft/bdm-customer")
public class BdmCustomerController extends AbstractController {

    @Resource
    BdmCustomerService bdmCustomerService;
    @RequestMapping(value = "/query")
    public R query(@RequestBody(required = false) Map<String,Object> params){
        if(params == null){
            params = new HashMap<>(1);
        }
        return bdmCustomerService.query(params);
    }

}

