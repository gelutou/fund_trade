package com.zw.ft.modules.sys.repository;

import com.zw.ft.modules.sys.entity.SysCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysCompanyMapper extends BaseMapper<SysCompany> {

    /**
     * 功能描述: <br>
     * 〈模糊查询用户所在公司，用于登录页展示〉
     * @Param: [username, shortName 前台输入的公司简称]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @Select("SELECT *" +
            " FROM sys_company sc" +
            " LEFT JOIN sys_user_company suc ON sc.ID = suc.com_id" +
            " WHERE suc.user_id = (SELECT ID FROM sys_user WHERE username = #{username})" +
            " AND (sc.com_name LIKE CONCAT('%',#{shortname},'%') OR sc.com_code LIKE CONCAT('%',#{shortname},'%'))")
    List<SysCompany> getFuzzy(@Param("username") String username, @Param("shortname") String shortName);

    @Select("SELECT * FROM sys_company")
    List<SysCompany> getAllComs();


}
