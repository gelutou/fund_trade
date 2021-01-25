package com.zw.ft.modules.bdm.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.co.entity.RunRisePrice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "banks",
                    many = @Many(
                            select = "com.zw.ft.modules.sys.repository.SysBankMapper.queryBanksUnderCustomer",fetchType = FetchType.EAGER
                    )
            )
    })
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


    /**
     * 功能描述 : 查询内部客商加价信息
     * @author Oliver 2021-1-25 16:09
     */
    @Select("SELECT bct.id cusId, bct.name, ifnull(pi.rise_amount, 0) riseAmount, ifnull(pi.status, 0) riseStatus,sd.des riseStatusDesc, pcti.name area" +
            " FROM bdm_customer bct" +
            " LEFT JOIN run_rise_price pi ON bct.ID = pi.cus_id" +
            " LEFT JOIN sys_dictionary sd ON ifnull(pi.status, 0) = sd.value" +
            " LEFT JOIN province_city_town_info pcti on bct.city_id = pcti.data_id" +
            " ${ew.customSqlSegment}")
    Page<BdmCustomer> queryRunRisePrice(Page<BdmCustomer> page, @Param("ew") QueryWrapper<BdmCustomer> queryWrapper);

}
