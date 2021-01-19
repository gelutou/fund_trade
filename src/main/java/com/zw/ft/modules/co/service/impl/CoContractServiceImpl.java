package com.zw.ft.modules.co.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.modules.co.entity.CoContract;
import com.zw.ft.modules.co.repository.CoContractMapper;
import com.zw.ft.modules.co.service.CoContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public Page<CoContract> queryPage(Map<String, Object> params) {

        //合同
        String type = params.get("type").toString();

        String condition = FormatUtil.isSelectKey("condition", params);
        return null;
    }
}
