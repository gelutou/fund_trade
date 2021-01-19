package com.zw.ft.modules.co.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.co.service.CoContractService;
import com.zw.ft.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 合同控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-12-31
 */
@RestController
@RequestMapping("/contract")
public class CoContractController extends AbstractController {

    @Resource
    CoContractService coContractService;

    /**
     * 功能描述 : 查询合同分页列表
     * @author Oliver 2021-1-18 9:32
     */
    @RequestMapping(value = "query")
    public R queryPage(@RequestBody Map<String,Object> params){
        return R.page(coContractService.queryPage(params));
    }

}

