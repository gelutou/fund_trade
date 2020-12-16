package com.zw.ft.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCargoInfo;
import com.zw.ft.modules.sys.service.SysCargoInfoService;
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
    @PostMapping("/getSysCargoInfo")
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
    @PostMapping("/updateCargoInfo")
    public R updateCargoInfo(@RequestBody(required = false) SysCargoInfo sysCargoInfo) {
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
    @PostMapping("/addCargoInfo")
    public R addCargoInfo(@RequestBody(required = false) SysCargoInfo sysCargoInfo) {
        boolean save = sysCargoInfoService.save(sysCargoInfo);
        if (save) {
            return R.ok("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 根据货品信息id 批量删除
     * @Date: 2020/11/23
     */
    @PostMapping("/delCargoInfo/{ids}")
    public R delCargoInfo(@PathVariable("ids") String ids) {
        return sysCargoInfoService.delCargo(ids);
    }


    /**
     * @Author savior
     * @Description 查询货品表一些下拉框信息
     * @Date: 2020/11/25
     */
    @PostMapping("/getCargoList")
    public R getCargoList() {
        return R.data(sysCargoInfoService.list());
    }
}
