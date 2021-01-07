package com.zw.ft.modules.co.controller;


import com.zw.ft.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 合同控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-12-31
 */
@RestController
@RequestMapping("/contract-sale")
public class CoContractController extends AbstractController {

    @PostMapping(value = "query")
    public String query(){
        return "测试swagger";
    }

}

