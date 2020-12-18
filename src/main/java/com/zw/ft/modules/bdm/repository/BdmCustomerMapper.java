package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 客商表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@Mapper
public interface BdmCustomerMapper extends BaseMapper<BdmCustomer> {

    /*
     * 功能描述: <br>
     * 〈查询客商列表分页〉
     * @Author: Oliver
     * @Date: 2020/12/9 15:56
     */

    @Select("SELECT bc.*, sd.des typeDes, su.realname creator" +
            " FROM bdm_customer bc" +
            " LEFT JOIN sys_dictionary sd ON bc.type = sd.value" +
            " LEFT JOIN sys_user su ON bc.CREATED_BY = su.ID ${ew.customSqlSegment}")
    Page<BdmCustomer> queryCustomerPage(Page<BdmCustomer> page, @Param("ew") Wrapper<BdmCustomer> queryWrapper);

    /*
     * 功能描述: <br>
     * 〈查询客商列表〉
     * @Author: Oliver
     * @Date: 2020/12/17 15:56
     */

    @Select("SELECT bc.*, sd.des typeDes, su.realname creator" +
            " FROM bdm_customer bc" +
            " LEFT JOIN sys_dictionary sd ON bc.type = sd.value" +
            " LEFT JOIN sys_user su ON bc.CREATED_BY = su.ID ${ew.customSqlSegment}")
    List<BdmCustomer> queryCustomerList(@Param("ew") Wrapper<BdmCustomer> queryWrapper);

}
