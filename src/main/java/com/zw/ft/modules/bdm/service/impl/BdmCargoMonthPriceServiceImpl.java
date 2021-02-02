package com.zw.ft.modules.bdm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.bdm.entity.BdmCargoMonthPrice;
import com.zw.ft.modules.bdm.repository.BdmCargoMonthPriceMapper;
import com.zw.ft.modules.bdm.service.BdmCargoMonthPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 货品价格扩展信息表 服务实现类
 * </p>
 *
 * @author Savior
 * @since 2020-12-08
 */
@Service
public class BdmCargoMonthPriceServiceImpl extends ServiceImpl<BdmCargoMonthPriceMapper, BdmCargoMonthPrice> implements BdmCargoMonthPriceService {

    @Resource
    BdmCargoMonthPriceMapper bdmCargoMonthPriceMapper;

    /**
     * @Author savior
     * @Description 根据货品ID查询货品价格
     * @Date: 2020/12/8
     */
    @Override
    public List<BdmCargoMonthPrice> selectPriceById(String cargoCategoryPkid, String year) {
        QueryWrapper<BdmCargoMonthPrice> wrapper = new QueryWrapper<>();
        wrapper.eq("cargo_category_pkid",cargoCategoryPkid);
        wrapper.eq("year",year);
        return bdmCargoMonthPriceMapper.selectList(wrapper);
    }
}
