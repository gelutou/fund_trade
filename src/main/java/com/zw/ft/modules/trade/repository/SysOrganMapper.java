package com.zw.ft.modules.trade.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zw.ft.modules.trade.entity.SysOrgan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 组织机构表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-14
 */
@DS("trade")
public interface SysOrganMapper extends BaseMapper<SysOrgan> {

    /*
     * 功能描述: <br>
     * 〈查询所有父部门，主要使用其公司ID和主键ID〉
     * @Author: Oliver
     * @Date: 2020/10/14 16:53
     */

    @Select("SELECT * FROM sys_organ WHERE organ_code = 'sysOrgan'")
    List<SysOrgan> selectFatherDepts();

    /*
     * 功能描述: <br>
     * 〈查询子部门〉
     * @Author: Oliver
     * @Date: 2020/10/14 17:02
     */

    @Select("SELECT * FROM sys_organ WHERE parent_pkid = #{fid}")
    List<SysOrgan> selectChildrenDepts(@Param("fid") String fid);

}
