package com.zw.ft.modules.bdm.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.constants.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.repository.BdmCustomerMapper;
import com.zw.ft.modules.bdm.service.BdmCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
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
        queryWrapper.eq("sd.name", "CUSTOMER_TYPE").eq("bc.DELETED", 0);
        String codition = FormatUtil.isSelectKey("condition", params);
        if (Constant.TRUE.equals(codition)) {
            String cond = params.get("condition").toString();
            queryWrapper.and(i -> i
                    .like("bc.code", cond).or()
                    .like("bc.name", cond).or()
                    .like("bc.shortname", cond).or()
                    .like("bc.tax_num", cond).or()
                    .like("bc.contact_name", cond).or()
                    .like("bc.contact_phone", cond).or()
                    .like("bc.contact_email", cond).or()
                    .like("bc.contact_position", cond).or()
                    .like("bc.area", cond).or()
                    .like("sd.des", cond).or());
        }
        return R.page(this.baseMapper.queryCustomerPage(page, queryWrapper));
    }

    @Override
    public R export(Map<String, Object> params) {

        QueryWrapper<BdmCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sd.name", "CUSTOMER_TYPE").eq("bc.DELETED", 0);

        //复选ID
        String ids = FormatUtil.isSelectKey("ids", params);
        if (Constant.TRUE.equals(ids)) {
            List idList = Convert.convert(List.class, params.get("ids"));
            queryWrapper.in("bc.id", idList);
        }
        //搜索条件
        String condition = FormatUtil.isSelectKey("condition", params);
        if (Constant.TRUE.equals(condition)) {
            String cond = params.get("condition").toString();
            queryWrapper.and(i -> i
                    .like("bc.code", cond).or()
                    .like("bc.name", cond).or()
                    .like("bc.shortname", cond).or()
                    .like("bc.tax_num", cond).or()
                    .like("bc.contact_name", cond).or()
                    .like("bc.contact_phone", cond).or()
                    .like("bc.contact_email", cond).or()
                    .like("bc.contact_position", cond).or()
                    .like("bc.area", cond).or()
                    .like("sd.des", cond).or());
        }
        return R.data(this.baseMapper.queryCustomerList(queryWrapper));
    }
}
