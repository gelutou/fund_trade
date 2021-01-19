package com.zw.ft.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zw.ft.common.constants.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.QueryUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import com.zw.ft.modules.sys.repository.SysUserMapper;
import com.zw.ft.modules.sys.service.SysCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
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
     *
     * @Param: [username, shortName 前台输入的公司简称]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    @Override
    public List<SysCompany> getFuzzy(Map<String, Object> params) {
        //如果是管理员，能登陆任何公司
        String username = params.get("username").toString();

        QueryWrapper<SysCompany> companyQueryWrapper = new QueryWrapper<>();
        companyQueryWrapper.eq("deleted", "0");
        String shortname = FormatUtil.isSelectKey("shortname", params);
        if (Constant.TRUE.equals(shortname)) {
            companyQueryWrapper.like("acronym", params.get("shortname")).or().like("name", params.get("shortname"));
        }
        if (Constant.ADMIN.equals(username)) {
            return sysCompanyMapper.selectList(companyQueryWrapper);
        }
        return sysCompanyMapper.getFuzzy(username, companyQueryWrapper);
    }

    @Override
    public Page<SysCompany> getComPage(Map<String, Object> params) {
        Page<SysCompany> page = new QueryUtil<SysCompany>(params).getPage();
        QueryWrapper<SysCompany> queryWrapper = new QueryWrapper<>();

        String name = FormatUtil.isSelectKey("name", params);
        if (Constant.TRUE.equals(name)) {
            queryWrapper.like("name", params.get("name"));
        } else if ("".equals(name)) {
            queryWrapper.like("name", "");
        }

        String shortName = FormatUtil.isSelectKey("shortName", params);
        if (Constant.TRUE.equals(shortName)) {
            queryWrapper.like("short_name", params.get("shortName"));
        } else if ("".equals(shortName)) {
            queryWrapper.like("short_name", "");
        }

        String code = FormatUtil.isSelectKey("acronym", params);
        if (Constant.TRUE.equals(code)) {
            queryWrapper.like("acronym", params.get("acronym"));
        } else if ("".equals(code)) {
            queryWrapper.like("acronym", "");
        }

        String startDateTime = FormatUtil.isSelectKey("startDateTime", params);
        if (Constant.TRUE.equals(startDateTime)) {
            queryWrapper.ge("created_time", params.get("startDateTime"));
        } else if ("".equals(startDateTime)) {
            queryWrapper.ge("created_time", "");
        }

        String endDateTime = FormatUtil.isSelectKey("endDateTime", params);
        if (Constant.TRUE.equals(endDateTime)) {
            queryWrapper.le("created_time", params.get("endDateTime"));
        } else if ("".equals(endDateTime)) {
            queryWrapper.le("created_time", "");
        }
        queryWrapper.eq("deleted",0);
        queryWrapper.orderByAsc("updated_time");
        return sysCompanyMapper.selectPage(page, queryWrapper);
    }
}
