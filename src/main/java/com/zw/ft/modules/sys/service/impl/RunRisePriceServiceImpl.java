package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.RunRisePrice;
import com.zw.ft.modules.sys.repository.RunRisePriceMapper;
import com.zw.ft.modules.sys.service.RunRisePriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    RunRisePriceMapper runRisePriceMapper;


}
