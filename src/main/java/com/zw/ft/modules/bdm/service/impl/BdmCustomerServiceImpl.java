package com.zw.ft.modules.bdm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.repository.BdmCustomerMapper;
import com.zw.ft.modules.bdm.service.BdmCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysNeeds;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 客商表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@Service("bdmCustomerService")
public class BdmCustomerServiceImpl extends ServiceImpl<BdmCustomerMapper, BdmCustomer> implements BdmCustomerService {

    @Override
    public R query(Map<String, Object> params) {

        Page<BdmCustomer> page = new QueryUtil<BdmCustomer>(params).getPage();
        QueryWrapper<BdmCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sd.name","CUSTOMER_TYPE").eq("bc.DELETED",0);
        //WHERE sd.name = 'CUSTOMER_TYPE' AND bc.DELETED = 0
        String codition = FormatUtil.isSelectKey("condition", params);
        if(Constant.TRUE.equals(codition)){
            queryWrapper.and(i ->  i
                    .like("bc.code",params.get("condition").toString()).or()
                    .like("bc.name",params.get("condition").toString()).or()
                    .like("bc.shortname",params.get("condition").toString()).or()
                    .like("bc.tax_num",params.get("condition").toString()).or()
                    .like("bc.contact_name",params.get("condition").toString()).or()
                    .like("bc.contact_phone",params.get("condition").toString()).or()
                    .like("bc.contact_email",params.get("condition").toString()).or()
                    .like("bc.contact_position",params.get("condition").toString()).or()
                    .like("bc.area",params.get("condition").toString()).or()
                    .like("sd.des",params.get("condition").toString()).or());
        }
        return R.page(this.baseMapper.queryCustomerPage(page, queryWrapper));
    }
}
