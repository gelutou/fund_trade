package com.zw.ft.modules.bdm.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCargoInfo;
import com.zw.ft.modules.bdm.service.BdmCargoInfoService;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/ft/bdm-cargo-info")
public class BdmCargoInfoController {

    @Resource
    BdmCargoInfoService bdmCargoInfoService;

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 分页查询货品档案基本信息
     * @Date: 2020/11/19
     */
    @PostMapping("/get_cargoinfo")
    public R getBdmCargoInfo(@RequestBody Map<String, Object> params) {
        return R.page(bdmCargoInfoService.getCargoInfo(params));
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 货品档案修改信息
     * @Date: 2020/11/23
     */
    @PostMapping("/update")
    public R updateCargoInfo(@RequestBody(required = false) @Validated(BaseEntity.Update.class) BdmCargoInfo bdmCargoInfo) {
        UpdateWrapper<BdmCargoInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", bdmCargoInfo.getId());
        bdmCargoInfoService.update(bdmCargoInfo, updateWrapper);
        return R.ok();
    }

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 添加货品档案信息
     * @Date: 2020/11/23
     */
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public R addCargoInfo(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmCargoInfo bdmCargoInfo) {
        try {
            bdmCargoInfoService.save(bdmCargoInfo);
        }catch (Exception e){
            String message = e.getMessage();
            if (message.contains("for key 'bdm_cargo_info.cargo_code'")){
                return R.error("此编码已经存在，请重新输入");
            }else{
                return R.error(message);
            }
        }
        return R.ok();
    }

    /**
     * 功能描述: <br>
     * @Author savior
     * @Description 根据货品信息id 批量删除
     * @Date: 2020/11/23
     */
    @PostMapping("/delete/{ids}")
    public R delCargoInfo(@PathVariable("ids") String ids) {
        return bdmCargoInfoService.delCargo(ids);
    }

}
