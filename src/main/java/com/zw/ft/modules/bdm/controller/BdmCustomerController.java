package com.zw.ft.modules.bdm.controller;


import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.base.BaseEntity;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.service.BdmCustomerService;
import com.zw.ft.modules.sys.controller.AbstractController;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.service.SysBankService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
@Validated
@RequestMapping("/ft/bdm-customer")
public class BdmCustomerController extends AbstractController {

    @Resource
    BdmCustomerService bdmCustomerService;
    @Resource
    SysBankService bankService;

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
    public R add(@RequestBody(required = false) @Validated(BaseEntity.Add.class) BdmCustomer bdmCustomer){
        bdmCustomerService.save(bdmCustomer);

        List<SysBank> banks = bdmCustomer.getBanks();
        if(banks.size() > 0){
            //校验只能有一个默认银行
            int time = 0;
            for(SysBank bank : banks){
                Integer isCustomerDefault = bank.getIsCustomerDefault();
                if(isCustomerDefault == 1){
                    time++;
                }
            }
            if(time > 1){
                return R.error("只能设置一个默认银行");
            }
            for(SysBank bank : banks){
                bank.setCusId(bdmCustomer.getId());
                bankService.save(bank);
            }
        }

        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈更新客商〉
     * @Author: Oliver
     * @Date: 2020/12/17 11:48
     */

    @RequestMapping(value = "/update")
    @Transactional(rollbackFor = Exception.class)
    public R update(@RequestBody(required = false) @Validated(BaseEntity.Update.class) BdmCustomer bdmCustomer){
        bdmCustomerService.updateById(bdmCustomer);
        List<SysBank> banks = bdmCustomer.getBanks();
        if(banks.size() > 0){

            //校验只能有一个默认银行
            for(SysBank bank : banks){
                Integer isCustomerDefault = bank.getIsCustomerDefault();
                for(SysBank bankTemp : banks){
                    Integer isCustomerDefault1 = bankTemp.getIsCustomerDefault();
                    if(isCustomerDefault == 0 && isCustomerDefault1 == 0){
                        return R.error("只能设置一个默认银行");
                    }
                }
            }
            for(SysBank bank : banks){
                bankService.updateById(bank);
            }
        }
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈删除客商〉
     * @Author: Oliver
     * @Date: 2020/12/17 13:45
     */

    @RequestMapping(value = "/delete")
    @Transactional(rollbackFor = Exception.class)
    public R update(@RequestBody Map<String,Object> parma){
        List ids = Convert.convert(List.class, parma.get("ids"));
        bdmCustomerService.removeByIds(ids);

        for(Object id : ids){
            QueryWrapper<SysBank> bankQueryWrapper = new QueryWrapper<>();
            bankQueryWrapper.eq("com_id",id);
            bankService.remove(bankQueryWrapper);
        }
        return R.ok();
    }

    /*
     * 功能描述: <br>
     * 〈导出客商列表〉
     * @Author: Oliver
     * @Date: 2020/12/17 13:45
     */

    @RequestMapping(value = "/export")
    public R export(@RequestBody Map<String,Object> parma){
        return bdmCustomerService.export(parma);
    }
}

