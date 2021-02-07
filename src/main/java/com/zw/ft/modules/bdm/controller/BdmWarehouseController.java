package com.zw.ft.modules.bdm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import com.zw.ft.modules.bdm.service.BdmWarehouseService;
import com.zw.ft.modules.sys.controller.AbstractController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Transactional(rollbackFor = Exception.class)
    public R addBdmWarehouse(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmWarehouse bdmWarehouse) {
        QueryWrapper<BdmWarehouse> queryWrapper = new QueryWrapper<>();
        String code = bdmWarehouse.getCode();
        String name = bdmWarehouse.getName();
        queryWrapper.eq("code",code).eq("name",name);
        List<BdmWarehouse> list = bdmWarehouseService.list(queryWrapper);
        for(BdmWarehouse warehouse : list){
            if (code.equals(warehouse.getCode())){
                return R.error("此编码已经使用,请修改");
            }
            if (name.equals(warehouse.getName())){
                return R.error("此名称已经使用，请修改");
            }
        }
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
        if (bdmWarehouse.getCode()==null && bdmWarehouse.getName()==null){
            return R.error("仓储费用类型编码或名称不能都为空");
        }
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

