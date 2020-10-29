package com.zw.ft.modules.fund.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.fund.entity.TBank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 银行信息表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-10-20
 */
@DS("fund")
public interface TBankMapper extends BaseMapper<TBank> {

}
