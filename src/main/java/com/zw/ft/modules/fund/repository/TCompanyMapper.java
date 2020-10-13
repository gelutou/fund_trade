package com.zw.ft.modules.fund.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.fund.entity.TCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 内部公司表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-13
 */
@DS("fund")
public interface TCompanyMapper extends BaseMapper<TCompany> {

    @Select("SELECT * FROM t_company")
    List<TCompany> getAllComs();
}
