package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserExpansion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 人员扩展信息
 * @author: Oliver
 * @date 2020/9/10
 */
@Repository
public interface SysUserExpansionMapper extends BaseMapper<SysUserExpansion> {

    /*
     * 功能描述: <br>
     * 〈根据userId查询详细信息〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/11/25 16:41
     */

    @Select("SELECT  mobile, office_phone, email, birthday, province, city, address, wechat, qq FROM sys_user_expansion WHERE user_id = #{userId}")
    SysUserExpansion queryUserExpansionByUserId(@Param("userId") long userId);

}
