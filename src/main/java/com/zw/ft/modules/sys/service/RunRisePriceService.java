package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.RunRisePrice;

import java.util.List;
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
     * 功能描述: <br>
     * 查询各个公司加价档案信息
     *
     * @Param: [params 查询条件]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Savior
     * @Date: 2020/11/11
     */
    Page<RunRisePrice> getRun(Map<String, Object> params);

    /**
     * @Author savior
     * @Description 加价档案修改添加
     * @Date: 2020/11/17
     */
    List<RunRisePrice> getRunRise(RunRisePrice runRisePrice);
}
