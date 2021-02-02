package com.zw.ft.modules.bdm.service;

import com.zw.ft.modules.bdm.entity.BdmCargoMonthPrice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 货品价格扩展信息表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-12-08
 */
public interface BdmCargoMonthPriceService extends IService<BdmCargoMonthPrice> {

    /** 
     * @Author savior
     * @Description 根据货品ID查询货品价格
     * @Date: 2020/12/8
     */
     List<BdmCargoMonthPrice> selectPriceById(Long cargoCategoryId, String year);


}
