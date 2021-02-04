package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.bdm.entity.BdmCargoCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * <p>
 * 货品分类表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
@Mapper
public interface BdmCargoCategoryMapper extends BaseMapper<BdmCargoCategory> {

    /**
     * 功能描述 : 查询包括价格信息的货品分类
     * @author Oliver 2021-2-2 13:43
     */
    @Select("SELECT *,bcmp.id priceId FROM bdm_cargo_category bcc LEFT JOIN bdm_cargo_month_price bcmp ON bcc.id = bcmp.cargo_category_id WHERE year = year(now()) AND bcc.deleted = 0")
    List<BdmCargoCategory> queryContainPrice();
}
