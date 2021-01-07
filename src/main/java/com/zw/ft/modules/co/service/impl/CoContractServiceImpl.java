package com.zw.ft.modules.co.service.impl;

import com.zw.ft.modules.co.entity.CoContract;
import com.zw.ft.modules.co.repository.CoContractMapper;
import com.zw.ft.modules.co.service.CoContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 销售合同表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-12-31
 */
@Service("contractSaleService")
public class CoContractServiceImpl extends ServiceImpl<CoContractMapper, CoContract> implements CoContractService {

}
