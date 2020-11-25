package com.zw.ft.modules.sys.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysCompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 公司信息表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@Mapper
@DS("fundTrade")
public interface SysCompanyMapper extends BaseMapper<SysCompany> {

    /**
     * 功能描述: <br>
     * 〈模糊查询用户所在公司，用于登录页展示〉
     * @Param: [username, shortName 前台输入的公司简称]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
<<<<<<< HEAD
    @Select(" SELECT *" +
            " FROM sys_company" +
            " WHERE ID IN (SELECT com_id" +
            " FROM sys_department" +
            " WHERE ID IN (SELECT dept_id" +
            " FROM rel_user_department" +
            " WHERE user_id = (SELECT ID FROM sys_user WHERE username = #{username}))) AND ${ew.SqlSegment}")
    List<SysCompany> getFuzzy(@Param("username") String username,@Param("ew") QueryWrapper<SysCompany> queryWrapper);

    /**
     * @Author savior
     * @Description  各个公司加价档案列表
     * @Date: 2020/11/11
     */
    @Select("select scy.id,scy.com_name,scy.city,dice.des,pi.fixed,pi.rise_price from sys_company scy " +
            "LEFT JOIN run_rise_price pi ON scy.id=pi.com_id " +
            "LEFT JOIN (SELECT * FROM sys_dictionary " +
            "WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'RUN_RISE' AND value IS NULL)) dice ON pi.fixed = dice.value " +
            "${ew.customSqlSegment}")
    Page<SysCompany> queryRunRisePrice(Page<SysCompany> page, @Param("ew") QueryWrapper<SysCompany> queryWrapper);
=======
    @Select("SELECT *" +
            " FROM sys_company sc" +
            " LEFT JOIN sys_user_company suc ON sc.ID = suc.com_id" +
            " WHERE suc.user_id = (SELECT ID FROM sys_user WHERE username = #{username})" +
            " AND (sc.com_name LIKE CONCAT('%',#{shortname},'%') OR sc.com_code LIKE CONCAT('%',#{shortname},'%'))")
    List<SysCompany> getFuzzy(@Param("username") String username, @Param("shortname") String shortName);
>>>>>>> 331d82a7ec0f2c1c46e0f33fe1ab97d0cc3cb530
}
