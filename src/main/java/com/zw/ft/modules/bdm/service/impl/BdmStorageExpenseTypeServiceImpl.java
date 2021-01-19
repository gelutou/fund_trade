package com.zw.ft.modules.bdm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.bdm.entity.BdmStorageExpenseType;
import com.zw.ft.modules.bdm.repository.BdmStorageExpenseTypeMapper;
import com.zw.ft.modules.bdm.service.BdmStorageExpenseTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 仓储费用类型表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-12-29
 */
@Service("BdmStorageExpenseTypeService")
public class BdmStorageExpenseTypeServiceImpl extends ServiceImpl<BdmStorageExpenseTypeMapper, BdmStorageExpenseType> implements BdmStorageExpenseTypeService {

    @Resource
    BdmStorageExpenseTypeMapper bdmStorageExpenseTypeMapper;

    /** 
     * @Author savior
     * @Description
     * @Date: 2020/12/30
     */
    @Override
    public BdmStorageExpenseType getStorageTypeId(long id) {
        QueryWrapper<BdmStorageExpenseType> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("bs.id",id)
                .eq("bs.deleted",0);
        return bdmStorageExpenseTypeMapper.getStorageTypeId(queryWrapper);
    }


}
