package com.zw.ft.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCargoInfo;
import com.zw.ft.modules.sys.service.SysCargoInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Validated
@RequestMapping("/ft/sys-cargo-info")
public class SysCargoInfoController {

    @Resource
    SysCargoInfoService sysCargoInfoService;

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 分页查询货品档案基本信息
     * @Date: 2020/11/19
     */
    @PostMapping("/get_cargoinfo")
    public R getSysCargoInfo(@RequestBody Map<String, Object> params) {
        return R.page(sysCargoInfoService.getCargoInfo(params));
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 货品档案修改信息
     * @Date: 2020/11/23
     */
    @PostMapping("/update_cargoInfo")
    public R updateCargoInfo(@RequestBody(required = false) @Validated(BaseEntity.Update.class) SysCargoInfo sysCargoInfo) {
        UpdateWrapper<SysCargoInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", sysCargoInfo.getId());
        sysCargoInfoService.update(sysCargoInfo, updateWrapper);
        return R.ok();
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 添加货品档案信息
     * @Date: 2020/11/23
     */
    @PostMapping("/add_cargoinfo")
    public R addCargoInfo(@RequestBody(required = false) @Validated(BaseEntity.Add.class) SysCargoInfo sysCargoInfo) {
        sysCargoInfoService.save(sysCargoInfo);
        return R.ok();
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 根据货品信息id 批量删除
     * @Date: 2020/11/23
     */
    @PostMapping("/delete_cargoinfo/{ids}")
    public R delCargoInfo(@PathVariable("ids") String ids) {
        return sysCargoInfoService.delCargo(ids);
    }


    /**
     * @Author savior
     * @Description 查询货品表一些下拉框信息
     * @Date: 2020/11/25
     */
    @PostMapping("/getcargolist")
    public R getCargoList() {
        return R.data(sysCargoInfoService.list());
    }
}
