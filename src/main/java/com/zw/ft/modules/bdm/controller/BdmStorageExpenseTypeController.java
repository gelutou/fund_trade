package com.zw.ft.modules.bdm.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmStorageExpenseType;
import com.zw.ft.modules.bdm.service.BdmStorageExpenseTypeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 仓储费用类型表 前端控制器
 * </p>
 *
 * @author Savior
 * @since 2020-12-29
 */
@RestController
@Validated
@RequestMapping("/ft/storage-expense-type")
public class BdmStorageExpenseTypeController {

    @Resource
    BdmStorageExpenseTypeService bdmStorageExpenseTypeService;

    /**
     * @Author savior
     * @Description 仓储费用类型树
     * @Date: 2020/12/29
     */
    @PostMapping("/querytree")
    public R getBdmStorageExpenseTypeTree(){
        return R.data(bdmStorageExpenseTypeService.list());
    }

    /**
     * @Author savior
     * @Description 根据id查询仓储费用类型信息
     * @Date: 2020/12/30
     */
    @PostMapping("/query/{id}")
    public R queryId(@PathVariable("id") long id){
        return R.data(bdmStorageExpenseTypeService.getStorageTypeId(id));
    }

    /**
     * @Author savior
     * @Description 修改仓储费用分类信息
     * @Date: 2020/12/30
     */
    @PostMapping("/update")
    public R update(@RequestBody(required = false)@Validated(BaseEntity.Update.class) BdmStorageExpenseType bdmStorageExpenseType){
        UpdateWrapper<BdmStorageExpenseType> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",bdmStorageExpenseType.getId());
        bdmStorageExpenseTypeService.update(bdmStorageExpenseType,wrapper);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 添加仓储费用分类信息
     * @Date: 2020/12/30
     */
    @PostMapping("/add")
    public R add(@RequestBody(required = false)@Validated(BaseEntity.Add.class)BdmStorageExpenseType bdmStorageExpenseType){
        bdmStorageExpenseTypeService.save(bdmStorageExpenseType);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 删除仓储费用类型信息
     * @Date: 2020/12/30
     */
    @PostMapping("/delete/{id}")
    public R delete(@PathVariable("id")long id){
        bdmStorageExpenseTypeService.removeById(id);
        return R.ok();
    }

}

