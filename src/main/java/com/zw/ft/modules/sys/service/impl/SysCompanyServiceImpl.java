package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import com.zw.ft.modules.sys.service.SysCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公司信息表 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@Service("sysCompanyService")
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper, SysCompany> implements SysCompanyService {

    @Resource
    SysCompanyMapper sysCompanyMapper;

    /**
     * 功能描述: <br>
     * 〈模糊查询用户所在公司，用于登录页展示〉
     * @Param: [username, shortName 前台输入的公司简称]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @Override
    public List<SysCompany> getFuzzy(String username, String shortName) {
        return sysCompanyMapper.getFuzzy(username,shortName);
    }

    @Override
    public Page<SysCompany> getComPage(Map<String, Object> params) {
        Page<SysCompany> page = new QueryUtil<SysCompany>(params).getPage();
        QueryWrapper<SysCompany> queryWrapper = new QueryWrapper<>();

        String name = FormatUtil.isSelectKey("name", params);
        if(Constant.TRUE.equals(name)){
            queryWrapper.like("com_name",params.get("name"));
        }else if("".equals(name)){
            queryWrapper.like("com_name","");
        }

        String shortName = FormatUtil.isSelectKey("shortName", params);
        if(Constant.TRUE.equals(shortName)){
            queryWrapper.like("short_com_name",params.get("shortName"));
        }else if("".equals(shortName)){
            queryWrapper.like("short_com_name","");
        }

        String code = FormatUtil.isSelectKey("code", params);
        if(Constant.TRUE.equals(code)){
            queryWrapper.like("com_code",params.get("code"));
        }else if("".equals(code)){
            queryWrapper.like("com_code","");
        }

        String startDateTime = FormatUtil.isSelectKey("startDateTime", params);
        if(Constant.TRUE.equals(startDateTime)){
            queryWrapper.ge("created_time",params.get("startDateTime"));
        }else if("".equals(startDateTime)){
            queryWrapper.ge("created_time","");
        }

        String endDateTime = FormatUtil.isSelectKey("endDateTime", params);
        if(Constant.TRUE.equals(endDateTime)){
            queryWrapper.le("created_time",params.get("endDateTime"));
        }else if("".equals(endDateTime)){
            queryWrapper.le("created_time","");
        }

        String mobile = FormatUtil.isSelectKey("mobile", params);
        if(Constant.TRUE.equals(mobile)){
            queryWrapper.like("mobile",params.get("mobile"));
        }else if("".equals(mobile)){
            queryWrapper.like("mobile","");
        }
        queryWrapper.orderByAsc("updated_time");
        return sysCompanyMapper.selectPage(page,queryWrapper);
    }
}
