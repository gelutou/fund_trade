package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.bdm.entity.BdmWarehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     * @Description 获取仓库档案树信息
     * @Date: 2020/12/17
     */
    @Select("SELECT bw.id,bw.PARENT_PKID AS pId,bc.name as customer_name,bw.warehouse_name,bw.warehouse_manager,bw.warehouse_phone," +
            "bw.flag_virtual,bw.remark,bw.CREATED_BY,bw.CREATED_TIME,bw.UPDATED_BY,bw.UPDATED_TIME,bw.`STATUS`,bw.DELETED,bw.com_id " +
            "FROM bdm_warehouse bw " +
            "left outer join bdm_customer bc on bw.CUSTOMER_PKID = bc.id " +
            "WHERE bw.DELETED = 0 order by bw.warehouse_name")
    List<BdmWarehouse> getWareTree();

    /**
     * @Author savior
     * @Description 根据id获取仓库信息
     * @Date: 2020/12/17
     */
    @Select("SELECT bw.id,ware.warehouse_name AS parentName,bw.parent_pkid,bw.warehouse_name,bw.customer_pkid,bc.`name` as customer_name," +
            "bw.warehouse_code,bw.warehouse_manager,bw.warehouse_phone,bw.flag_virtual,bw.remark,bw.CREATED_BY,bw.CREATED_TIME,bw.UPDATED_BY," +
            "bw.UPDATED_TIME,bw.`STATUS`,bw.DELETED,bw.com_id,bw.province,bw.city,bw.district,bw.detail_address,bw.QQ,bw.WeChat,bw.email " +
            "FROM bdm_warehouse bw " +
            "LEFT JOIN bdm_customer bc ON bw.customer_pkid = bc.id " +
            "LEFT JOIN bdm_warehouse ware ON ware.id = bw.parent_pkid " +
            "WHERE bw.id = #{id} and bw.DELETED = 0")
    BdmWarehouse getWarehouseId(@Param("id") long id);
}
