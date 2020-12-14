package com.zw.ft.modules.sys.service;

import com.zw.ft.modules.sys.entity.SysCargoMonthPrice;
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
public interface SysCargoMonthPriceService extends IService<SysCargoMonthPrice> {

    /** 
     * @Author savior
     * @Description 根据货品ID查询货品价格
     * @Date: 2020/12/8
     */
     List<SysCargoMonthPrice> selectPriceById(String cargoCategoryPkid, String year);


}
