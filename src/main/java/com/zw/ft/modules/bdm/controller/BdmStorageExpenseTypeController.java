package com.zw.ft.modules.bdm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmStorageExpenseType;
import com.zw.ft.modules.bdm.service.BdmStorageExpenseTypeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @PostMapping("/query")
    public R getBdmStorageExpenseTypeTree(){
        return R.data(bdmStorageExpenseTypeService.list());
    }

    /**
     * @Author savior
     * @Description 修改仓储费用分类信息
     * @Date: 2020/12/30
     */
    @PostMapping("/update")
    public R update(@RequestBody(required = false)@Validated(BaseEntity.Update.class) BdmStorageExpenseType bdmStorageExpenseType){
        if (bdmStorageExpenseType.getName()==null && bdmStorageExpenseType.getCode()==null){
            return R.error("仓储费用类型编码或名称不能都为空");
        }
        bdmStorageExpenseTypeService.updateById(bdmStorageExpenseType);
        return R.ok();
    }

    /**
     * @Author savior
     * @Description 添加仓储费用分类信息
     * @Date: 2020/12/30
     */
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public R add(@RequestBody(required = false) @Validated(BaseEntity.Add.class)BdmStorageExpenseType bdmStorageExpenseType){
        QueryWrapper<BdmStorageExpenseType> queryWrapper = new QueryWrapper<>();
        String code = bdmStorageExpenseType.getCode();
        String name = bdmStorageExpenseType.getName();
        queryWrapper.eq("code",code).eq("name",name);
        List<BdmStorageExpenseType> list = bdmStorageExpenseTypeService.list(queryWrapper);
        for(BdmStorageExpenseType expenseType : list){
            if (code.equals(expenseType.getCode())){
                return R.error("此编码已经使用,请修改");
            }
            if (name.equals(expenseType.getName())){
                return R.error("此名称已经使用，请修改");
            }
        }
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

