package com.zw.ft.modules.bdm.controller;


import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import com.zw.ft.modules.bdm.service.BdmWarehouseService;
import com.zw.ft.modules.sys.controller.AbstractController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 仓库信息表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
@RestController
@Validated
@RequestMapping("/ft/bdm-warehouse")
public class BdmWarehouseController extends AbstractController {

    @Resource
    BdmWarehouseService bdmWarehouseService;


    /**
     * @Author savior
     * @Description 获取仓库档案树信息
     * @Date: 2020/12/15
     */
    @PostMapping("/queryList")
    public R getBdmWarehouseTree(){
        return R.data(bdmWarehouseService.getWarehouseId());
    }

    /**
     * @Author savior
     * @Description 添加仓库信息
     * @Date: 2020/12/18
     */
    @PostMapping("/add")
    public R addBdmWarehouse(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmWarehouse bdmWarehouse) {
        bdmWarehouseService.save(bdmWarehouse);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 修改仓库信息
     * @Date: 2020/12/18
     */
    @PostMapping("/update")
    public R updateBdmWarehouse(@RequestBody(required = false) @Validated(BaseEntity.Update.class)BdmWarehouse bdmWarehouse){
        bdmWarehouseService.updateById(bdmWarehouse);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 删除仓库信息
     * @Date: 2020/12/18
     */
    @PostMapping("/delete/{id}")
    public R deleteBdmWarehouse (@PathVariable("id") Long id){
        bdmWarehouseService.removeById(id);
        return R.ok();
    }

}

