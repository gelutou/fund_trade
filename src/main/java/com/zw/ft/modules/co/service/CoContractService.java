package com.zw.ft.modules.co.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.co.entity.CoContract;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 销售合同表 服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-12-31
 */
public interface CoContractService extends IService<CoContract> {

    /**
     * 功能描述 : 查询合同分页列表
     * @author Oliver 2021-1-18 9:32
     */
    Page<CoContract> queryPage(Map<String, Object> params);

}
