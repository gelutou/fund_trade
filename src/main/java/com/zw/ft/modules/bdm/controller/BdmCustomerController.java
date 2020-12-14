package com.zw.ft.modules.bdm.controller;


import com.google.common.base.Preconditions;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.service.BdmCustomerService;
import com.zw.ft.modules.sys.controller.AbstractController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 客商表 前端控制器
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@RestController
@RequestMapping("/ft/bdm-customer")
public class BdmCustomerController extends AbstractController {

    @Resource
    BdmCustomerService bdmCustomerService;

    /*
     * 功能描述: <br>
     * 〈客商列表分页〉
     * @Author: Oliver
     * @Date: 2020/12/9 16:47
     */

    @RequestMapping(value = "/query")
    public R query(@RequestBody(required = false) Map<String,Object> params){
        if(params == null){
            params = new HashMap<>(1);
        }
        return bdmCustomerService.query(params);
    }

    /*
     * 功能描述: <br>
     * 〈添加客商〉
     * @Author: Oliver
     * @Date: 2020/12/9 16:47
     */

    @RequestMapping(value = "/add")
    @Transactional(rollbackFor = Exception.class)
    public R add(@RequestBody(required = false) BdmCustomer bdmCustomer){
        Preconditions.checkNotNull(bdmCustomer,"请传入客商信息！");
        bdmCustomerService.save(bdmCustomer);
        return R.ok();
    }
}

