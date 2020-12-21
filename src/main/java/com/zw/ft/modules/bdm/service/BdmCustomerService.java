package com.zw.ft.modules.bdm.service;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 客商表 服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
public interface BdmCustomerService extends IService<BdmCustomer> {

    /*
     * 功能描述: <br>
     * 〈客商列表〉
     * @Author: Oliver
     * @Date: 2020/12/9 15:42
     */

    R query(Map<String,Object> params);

    /*
     * 功能描述: <br>
     * 〈导出客商列表〉
     * @Author: Oliver
     * @Date: 2020/12/9 15:42
     */

    R export(Map<String,Object> params);
}
