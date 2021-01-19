package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysCompany;
import java.util.List;
import java.util.Map;

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
     *
     * @Param: [username, shortName 前台输入的公司简称]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/21 10:53
     */
    List<SysCompany> getFuzzy(Map<String, Object> params);

    /**
     * 功能描述: <br>
     * 〈查询所有公司〉
     *
     * @Param: [params 查询条件]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/23 16:00
     */
    Page<SysCompany> getComPage(Map<String, Object> params);

}
