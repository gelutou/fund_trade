package com.zw.ft.modules.bdm.service.impl;

import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import com.zw.ft.modules.bdm.repository.BdmWarehouseMapper;
import com.zw.ft.modules.bdm.service.BdmWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
     * @Description 获取仓库档案树信息
     * @Date: 2020/12/18
     */
    @Override
    public List<BdmWarehouse> getWarehouseTree() {
        return bdmWarehouseMapper.getWareTree();
    }

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/18
     */
    @Override
    public BdmWarehouse getWarehouseId(long id) {
        return bdmWarehouseMapper.getWarehouseId(id);
    }
}
