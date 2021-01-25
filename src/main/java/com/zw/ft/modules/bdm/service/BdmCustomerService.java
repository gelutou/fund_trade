package com.zw.ft.modules.bdm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.co.entity.RunRisePrice;

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

    /**
     * 功能描述 : 查询内部客商加价信息分页
     * @author Oliver 2021-1-25 16:01
     */
    Page<BdmCustomer> getRun(Map<String, Object> params);
}
