package com.zw.ft.modules.trade.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.trade.entity.BdmCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.trade.entity.SysCompanyTrade;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 客商表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-15
 */
@DS("trade")
public interface BdmCustomerMapper extends BaseMapper<BdmCustomer> {
}
