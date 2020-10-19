package com.zw.ft.modules.fund.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.fund.entity.TCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 客商表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-15
 */
@DS("fund")
public interface TCustomerMapper extends BaseMapper<TCustomer> {

}
