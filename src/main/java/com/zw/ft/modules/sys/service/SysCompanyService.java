package com.zw.ft.modules.sys.service;

import com.zw.ft.modules.sys.entity.SysCompany;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 公司信息表 服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
public interface SysCompanyService extends IService<SysCompany> {

    /**
     * 功能描述: <br>
     * 〈模糊查询用户所在公司，用于登录页展示〉
     * @Param: [username, shortName 前台输入的公司简称]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    List<SysCompany> getFuzzy(String username,String shortName);
}
