package com.zw.ft.modules.sys.service.impl;

import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import com.zw.ft.modules.sys.service.SysCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
