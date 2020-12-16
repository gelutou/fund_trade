package com.zw.ft.modules.bdm.controller;


import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import com.zw.ft.modules.bdm.service.BdmCustomerService;
import com.zw.ft.modules.bdm.service.BdmWarehouseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class BdmWarehouseController {

    @Resource
    BdmWarehouseService bdmWarehouseService;
    @Resource
    BdmCustomerService bdmCustomerService;

    /**
     * @Author savior
     * @Description 获取仓库档案树信息
     * @Date: 2020/12/15
     */
    @PostMapping("/getBdmWarehouseTree")
    public R getBdmWarehouseTree(){
        return R.data(bdmWarehouseService.list());
    }

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/15
     */
    @PostMapping("/query/{id}")
    public R queryId(@PathVariable("id") long id){
        BdmWarehouse byId = bdmWarehouseService.getById(id);
        //把仓库父级显示出来
        BdmWarehouse bdmWarehouseById = bdmWarehouseService.getById(byId.getParentPkid());
        byId.setParentName(bdmWarehouseById==null?"":bdmWarehouseById.getWarehouseName());
        //查询客商名称
        BdmCustomer comName = bdmCustomerService.getById(byId.getComId());
        byId.setCustomerName(bdmCustomerService==null?"":comName.getContactName());
        return R.data(byId);
    }

    @PostMapping("")
    public R addBdmWarehouse() {
        return null;
    }
}

