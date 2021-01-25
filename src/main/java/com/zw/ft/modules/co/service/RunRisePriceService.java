package com.zw.ft.modules.co.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.co.entity.RunRisePrice;

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

    /**
     * @Author savior
     * @Description 加价档案修改添加
     * @Date: 2020/11/17
     */
    R getRunRise(RunRisePrice runRisePrice);
}
