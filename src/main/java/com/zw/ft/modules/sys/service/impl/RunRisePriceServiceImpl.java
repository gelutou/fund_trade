package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.modules.sys.entity.RunRisePrice;
import com.zw.ft.modules.sys.repository.RunRisePriceMapper;
import com.zw.ft.modules.sys.service.RunRisePriceService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 加价档案表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@Service
public class RunRisePriceServiceImpl extends ServiceImpl<RunRisePriceMapper, RunRisePrice> implements RunRisePriceService {

    @Override
    public Page<RunRisePrice> getBank(Map<String, Object> params) {
        Page<RunRisePrice> page = new QueryUtil<RunRisePrice>(params).getPage();
        QueryWrapper wrapper = new QueryWrapper();
        return null;
    }
}
