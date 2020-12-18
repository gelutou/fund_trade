package com.zw.ft.modules.bdm.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import com.zw.ft.modules.bdm.service.BdmWarehouseService;
import com.zw.ft.modules.sys.controller.AbstractController;
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
@RequestMapping("/ft/bdm-warehouse")
public class BdmWarehouseController extends AbstractController {

    @Resource
    BdmWarehouseService bdmWarehouseService;


    /**
     * @Author savior
     * @Description 获取仓库档案树信息
     * @Date: 2020/12/15
     */
    @PostMapping("/get_warehousetree")
    public R getBdmWarehouseTree(){
        return R.data(bdmWarehouseService.getWarehouseTree());
    }

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/15
     */
    @PostMapping("/query/{id}")
    public R queryId(@PathVariable("id") long id){
        return R.data(bdmWarehouseService.getWarehouseId(id));
    }

    /**
     * @Author savior
     * @Description 添加仓库信息
     * @Date: 2020/12/18
     */
    @PostMapping("add_warehouse")
    public R addBdmWarehouse(@RequestBody(required = false) BdmWarehouse bdmWarehouse) {
        Preconditions.checkNotNull(bdmWarehouse,"请传入仓库信息！");
        bdmWarehouseService.save(bdmWarehouse);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 修改仓库信息
     * @Date: 2020/12/18
     */
    @PostMapping("update_warehouse")
    public R updateBdmWarehouse(@RequestBody(required = false) BdmWarehouse bdmWarehouse){
        UpdateWrapper<BdmWarehouse> updateWrapper = new UpdateWrapper<>();
        Preconditions.checkNotNull(bdmWarehouse,"请传入客商信息");
        updateWrapper.eq("id",bdmWarehouse.getId());
        bdmWarehouseService.update(bdmWarehouse,updateWrapper);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 删除仓库信息
     * @Date: 2020/12/18
     */
    @PostMapping("delete_warehouse")
    public R deleteBdmWarehouse (@PathVariable("id")long id){
        bdmWarehouseService.removeById(id);
        return R.ok();
    }
}

