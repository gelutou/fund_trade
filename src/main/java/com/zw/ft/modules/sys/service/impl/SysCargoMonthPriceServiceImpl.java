package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.modules.sys.entity.SysCargoMonthPrice;
import com.zw.ft.modules.sys.repository.SysCargoMonthPriceMapper;
import com.zw.ft.modules.sys.service.SysCargoMonthPriceService;
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
public class SysCargoMonthPriceServiceImpl extends ServiceImpl<SysCargoMonthPriceMapper, SysCargoMonthPrice> implements SysCargoMonthPriceService {

    @Resource
    SysCargoMonthPriceMapper sysCargoMonthPriceMapper;

    /**
     * @Author savior
     * @Description 根据货品ID查询货品价格
     * @Date: 2020/12/8
     */
    @Override
    public List<SysCargoMonthPrice> selectPriceById(String cargoCategoryPkid, String year) {
        QueryWrapper<SysCargoMonthPrice> wrapper = new QueryWrapper<>();
        wrapper.eq("CARGO_CATEGORY_PKID",cargoCategoryPkid);
        wrapper.eq("year",year);
        return sysCargoMonthPriceMapper.selectList(wrapper);
    }

}
