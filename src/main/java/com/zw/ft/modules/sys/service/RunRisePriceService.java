package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.RunRisePrice;

import java.util.Map;

/**
 * <p>
 * 加价档案表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-11-11
 */
public interface RunRisePriceService extends IService<RunRisePrice> {

    Page<RunRisePrice> getBank(Map<String,Object> params);
}
