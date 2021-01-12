package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.bdm.entity.BdmStorageExpenseType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 仓储费用类型表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-12-29
 */
@Mapper
public interface BdmStorageExpenseTypeMapper extends BaseMapper<BdmStorageExpenseType> {

    @Select("SELECT bs.*,bt.`name` AS pName " +
            "FROM bdm_storage_expense_type bs " +
            "LEFT JOIN bdm_storage_expense_type bt ON bt.id=bs.p_id " +
            "${ew.customSqlSegment}")
    BdmStorageExpenseType getStorageTypeId(@Param("ew") Wrapper<BdmStorageExpenseType> queryWrapper);
}
