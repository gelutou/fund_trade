package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.service.SysCargoInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 货品信息表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/ft/sys-cargo-info")
public class SysCargoInfoController {

    @Resource
    SysCargoInfoService sysCargoInfoService;

    /**
     * @Author savior
     * @Description  分页查询货品档案基本信息
     * @Date: 2020/11/19
     */
    @PostMapping("/getSysCargoInfo")
    public R getSysCargoInfo(@RequestBody Map<String,Object> params){
        return R.page(sysCargoInfoService.getCargoInfo(params));
    }
}
