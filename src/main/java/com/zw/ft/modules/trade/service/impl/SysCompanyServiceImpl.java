package com.zw.ft.modules.trade.service.impl;

import com.zw.ft.modules.trade.entity.SysCompanyTrade;
import com.zw.ft.modules.trade.repository.SysCompanyTradeMapper;
import com.zw.ft.modules.trade.service.SysCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司信息表	与客商使用相同的表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-10-13
 */
@Service
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyTradeMapper, SysCompanyTrade> implements SysCompanyService {

}
