package com.zw.ft.modules.sys.controller;


import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.service.SysDictionaryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 系统字典表  前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/ft/sys-dictionary")
public class SysDictionaryController {

    @Resource
    SysDictionaryService sysDictionaryService;

    /*
     * 功能描述: <br>
     * 〈获取字典表信息〉
     * @Author: Oliver
     * @Date: 2020/12/3 9:45
     */

    @RequestMapping(value = "/get_dictionary_page")
    public R getDictionaryPage(@RequestBody(required = false) Map<String,Object> params){
        if(params == null){
            params = new HashMap<>(1);
        }
        return R.page(sysDictionaryService.getDictionaryPage(params));
    }
}

