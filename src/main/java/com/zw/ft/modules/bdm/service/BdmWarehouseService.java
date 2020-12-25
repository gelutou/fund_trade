package com.zw.ft.modules.bdm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;

/**
 * <p>
 * 仓库信息表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
public interface BdmWarehouseService extends IService<BdmWarehouse> {

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/18
     */
    BdmWarehouse  getWarehouseId(long id);
}
