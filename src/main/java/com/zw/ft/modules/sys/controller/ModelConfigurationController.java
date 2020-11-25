package com.zw.ft.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.ModelConfiguration;
import com.zw.ft.modules.sys.service.ModelConfigurationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-09-30
 */
@RestController
@RequestMapping("/ft/sys/model-configuration")
public class ModelConfigurationController {

    @Resource
    ModelConfigurationService modelConfigurationService;

    @PostMapping(value = "/promptInformation/{identification}")
    public R promptInformation(@PathVariable("identification") String identification) {
        QueryWrapper<ModelConfiguration> modelConfigurationQueryWrapper = new QueryWrapper<>();
        modelConfigurationQueryWrapper.eq("identification", identification);
        String content = modelConfigurationService.getOne(modelConfigurationQueryWrapper).getContent();
        if ("".equals(content) || content == null || "null".equals(content)) {
            return R.error();
        } else {
            return R.ok(content);
        }
    }
}

