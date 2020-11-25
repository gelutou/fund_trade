package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统需求表 服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-10-29
 */
public interface SysNeedsService extends IService<SysNeeds> {

    /*
     * 功能描述: <br>
     * 〈查询系统需求〉
     * @Author: Oliver
     * @Date: 2020/10/30 14:03
     */

    Page<SysNeeds> queryPage(Map<String, Object> params);

}
