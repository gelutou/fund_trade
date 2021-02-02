package com.zw.ft.modules.bdm.service;

import com.zw.ft.modules.bdm.entity.BdmCargoCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 货品分类表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
public interface BdmCargoCategoryService extends IService<BdmCargoCategory> {

    /**
     * 功能描述 : 查询包括价格信息
     * @author Oliver 2021-2-2 13:39
     */
    List<BdmCargoCategory> queryContainPrice();

}
