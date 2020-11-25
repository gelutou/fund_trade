package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 * 系统需求回复表  Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-11-02
 */
@Mapper
public interface SysReplyMapper extends BaseMapper<SysReply> {

    /*
     * 功能描述: <br>
     * 〈查询回复，包括创建者信息〉
     * @Param: [meedId, wrapper]
     * @Return: com.zw.ft.modules.sys.entity.SysReply
     * @Author: Oliver
     * @Date: 2020/11/3 14:50
     */
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "CREATED_BY", property = "createdBy"),
            //提出人
            @Result(column = "CREATED_BY", property = "creator",
                    one = @One(
                            select = "com.zw.ft.modules.sys.repository.SysUserMapper.selectById",
                            fetchType = FetchType.EAGER)
            )
    })
    @Select("SELECT * FROM sys_reply ${ew.customSqlSegment}")
    List<SysReply> getReply(@Param("ew") QueryWrapper<SysReply> wrapper);

}
