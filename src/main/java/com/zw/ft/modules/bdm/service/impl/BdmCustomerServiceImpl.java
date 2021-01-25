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

import java.math.BigDecimal;
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

    /**
     * @Author savior
     * @Description 各个公司加价档案列表
     * @Date: 2020/11/11
     */
    @Override
    public Page<BdmCustomer> getRun(Map<String, Object> params) {
        Page<BdmCustomer> page = new QueryUtil<BdmCustomer>(params).getPage();
        QueryWrapper<BdmCustomer> queryWrapper = new QueryWrapper<>();

        //模糊搜索公司id
        String condition = FormatUtil.isSelectKey("condition", params);
        if (Constant.TRUE.equals(condition)) {
            queryWrapper.and(i -> i.like("bct.name",params.get("condition")).or().like("pcti.name",params.get("condition")));
        }
        queryWrapper.eq("sd.name","RISE_PRICE_STATUS").eq("bct.DELETED",0).eq("bct.type",1);
        queryWrapper.orderByDesc("pi.rise_amount", "bct.updated_time");
        Page<BdmCustomer> bdmCustomerPage = this.baseMapper.queryRunRisePrice(page, queryWrapper);
        List<BdmCustomer> records = bdmCustomerPage.getRecords();
        for(BdmCustomer bdmCustomer : records){
            bdmCustomer.setRiseAmount(bdmCustomer.getRiseAmount().setScale(2, BigDecimal.ROUND_DOWN));
        }

        bdmCustomerPage.setRecords(records);
        return bdmCustomerPage;
    }
}
