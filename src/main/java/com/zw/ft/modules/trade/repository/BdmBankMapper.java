package com.zw.ft.modules.trade.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.trade.entity.BdmBank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 银行表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-10-20
 */
@DS("trade")
public interface BdmBankMapper extends BaseMapper<BdmBank> {

}
