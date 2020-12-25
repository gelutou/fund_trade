package com.zw.ft.modules.bdm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import com.zw.ft.modules.bdm.repository.BdmWarehouseMapper;
import com.zw.ft.modules.bdm.service.BdmWarehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 仓库信息表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
@Service("BdmWarehouseService")
public class BdmWarehouseServiceImpl extends ServiceImpl<BdmWarehouseMapper, BdmWarehouse> implements BdmWarehouseService {

    @Resource
    BdmWarehouseMapper bdmWarehouseMapper;

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/18
     */
    @Override
    public BdmWarehouse getWarehouseId(long id) {
        QueryWrapper<BdmWarehouse> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("bw.id",id)
                .eq("sd.name","IS_VIRTUAL")
                .eq("bw.DELETED",0);
        return bdmWarehouseMapper.getWarehouseId(queryWrapper);
    }
}
