package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysDictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统字典表  服务类
 * </p>
 *
 * @author Oliver
 * @since 2020-12-03
 */
public interface SysDictionaryService extends IService<SysDictionary> {

    /*
     * 功能描述: <br>
     * 〈查询字典表〉
     * @Author: Oliver
     * @Date: 2020/12/3 9:23
     */

    Page<SysDictionary> getDictionaryPage(Map<String,Object> params);

}
