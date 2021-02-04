package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    @Select("SELECT bw.*,bc.`name` as customerName " +
            "FROM bdm_warehouse bw " +
            "LEFT JOIN bdm_customer bc ON bw.cus_id = bc.id " +
            "WHERE bw.deleted=0 ")
    List<BdmWarehouse> getWarehouseId();
}
