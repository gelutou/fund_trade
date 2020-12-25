package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 仓库信息表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
@Mapper
public interface BdmWarehouseMapper extends BaseMapper<BdmWarehouse> {

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/17
     */
    @Select("SELECT bw.*,ware.`name` AS parentName,bc.`name` as customer_name,sd.des AS isVirtualName " +
            "FROM bdm_warehouse bw " +
            "LEFT JOIN bdm_customer bc ON bw.cus_id = bc.id " +
            "LEFT JOIN bdm_warehouse ware ON ware.id = bw.parent_id " +
            "LEFT JOIN sys_dictionary sd ON sd.`value`=bw.is_virtual ${ew.customSqlSegment}")
    BdmWarehouse getWarehouseId(@Param("ew") Wrapper<BdmWarehouse> queryWrapper);
}
