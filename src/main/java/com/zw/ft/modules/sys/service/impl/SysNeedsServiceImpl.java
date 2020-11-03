package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.zw.ft.modules.sys.repository.SysNeedsMapper;
import com.zw.ft.modules.sys.service.SysNeedsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  系统需求表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-10-29
 */
@Service("sysNeedsService")
public class SysNeedsServiceImpl extends ServiceImpl<SysNeedsMapper, SysNeeds> implements SysNeedsService {

    @Resource
    SysNeedsMapper sysNeedsMapper;

    @Override
    public Page<SysNeeds> queryPage(Map<String, Object> params) {

        Page<SysNeeds> page = new QueryUtil<SysNeeds>(params).getPage();
        QueryWrapper<SysNeeds> queryWrapper = new QueryWrapper<>();

        //搜索条件 标题
        String title = FormatUtil.isSelectKey("title", params);
        if(Constant.TRUE.equals(title)){
            queryWrapper.like("sy.title",params.get("title"));
        }

        //搜索条件 部门
        String deptId = FormatUtil.isSelectKey("deptId", params);
        if(Constant.TRUE.equals(deptId)){
            queryWrapper.eq("sy.dept_id",params.get("deptId"));
        }else if ("".equals(deptId)){
            queryWrapper.eq("sy.dept_id","");
        }

        //搜索条件 部门
        String handler = FormatUtil.isSelectKey("handler", params);
        if(Constant.TRUE.equals(handler)){
            queryWrapper.eq("sy.handler",params.get("handler"));
        }else if ("".equals(handler)){
            queryWrapper.eq("sy.handler","");
        }

        //搜索条件 状态
        String status = FormatUtil.isSelectKey("status", params);
        if(Constant.TRUE.equals(status)){
            queryWrapper.eq("sy.status",params.get("status"));
        }else if ("".equals(status)){
            queryWrapper.eq("sy.status","");
        }

        String startDateTime = FormatUtil.isSelectKey("startDateTime", params);
        if(Constant.TRUE.equals(startDateTime)){
            queryWrapper.ge("sy.created_time",params.get("startDateTime"));
        }else if("".equals(startDateTime)){
            queryWrapper.ge("sy.created_time","");
        }

        String endDateTime = FormatUtil.isSelectKey("endDateTime", params);
        if(Constant.TRUE.equals(endDateTime)){
            queryWrapper.le("sy.created_time",params.get("endDateTime"));
        }else if("".equals(endDateTime)){
            queryWrapper.le("sy.created_time","");
        }

        queryWrapper.eq("sy.DELETED","0");
        //排序
        queryWrapper.orderByDesc("sy.created_time");
        queryWrapper.orderByAsc("sy.status");
        return sysNeedsMapper.queryNeedsPage(page,queryWrapper);
    }
}
