package com.zw.ft.modules.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.repository.BdmCustomerMapper;
import com.zw.ft.modules.co.entity.RunRisePrice;
import com.zw.ft.modules.co.repository.RunRisePriceMapper;
import com.zw.ft.modules.co.service.RunRisePriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 加价档案表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
@Service
public class RunRisePriceServiceImpl extends ServiceImpl<RunRisePriceMapper, RunRisePrice> implements RunRisePriceService {

    @Resource
    RunRisePriceMapper runRisePriceMapper;

    @Resource
    BdmCustomerMapper bdmCustomerMapper;

    /**
     * @Author savior
     * @Description 当没有这条数据是会自动添加有时就修改
     * @Date: 2020/11/17
     */
    @Override
    public R getRunRise(RunRisePrice runRisePrice) {
        QueryWrapper<RunRisePrice> runWrapper = new QueryWrapper<>();
        runWrapper.eq("cus_id", runRisePrice.getCusId());
        List<RunRisePrice> runRisePrices = runRisePriceMapper.selectList(runWrapper);
        if (runRisePrices.size() == 0) {
            QueryWrapper<BdmCustomer> bdmWrapper = new QueryWrapper<>();
            bdmWrapper.eq("id", runRisePrice.getCusId());
            List<BdmCustomer> bdmCustomers = bdmCustomerMapper.selectList(bdmWrapper);
            for (BdmCustomer bdmCustomer : bdmCustomers) {
                runRisePrice.setCusId(bdmCustomer.getId());
            }
            int insert = runRisePriceMapper.insert(runRisePrice);
            if (insert!=0){
                return R.ok("添加成功");
            }else {
                return R.error("添加失败");
            }
        } else {
            int update = runRisePriceMapper.update(runRisePrice, runWrapper);
            if (update!=0){
                return R.ok("更新成功");
            }else {
                return R.error("更新失败");
            }
        }
    }

}