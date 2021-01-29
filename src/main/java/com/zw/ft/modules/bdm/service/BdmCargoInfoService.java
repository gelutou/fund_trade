package com.zw.ft.modules.bdm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCargoInfo;

import java.util.Map;

/**
 * <p>
 * 货品信息表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-11-19
 */
public interface BdmCargoInfoService extends IService<BdmCargoInfo> {

    /**
     * 功能描述: <br>
     * 分页查询货品信息
     *
     * @Param: [params 查询条件]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Savior
     * @Date: 2020-11-19
     */
    Page<BdmCargoInfo> getCargoInfo(Map<String, Object> params);

    /**
     * 功能描述: <br>
     *
     * @Author savior
     * @Description 根据货品信息id 批量删除
     * @Date: 2020/11/23
     */
    R delCargo(String delIds);
}
