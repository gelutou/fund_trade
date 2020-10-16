package com.zw.ft.modules.fund.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.fund.entity.TOrgan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门档案表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-14
 */
@DS("fund")
public interface TOrganMapper extends BaseMapper<TOrgan> {

    @Select("SELECT * FROM t_organ WHERE organ_code <> 'sysOrgan' ")
    List<TOrgan> getAllEffective();

}
