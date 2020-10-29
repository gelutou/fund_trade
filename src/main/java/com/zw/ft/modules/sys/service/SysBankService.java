package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.SysBank;

import java.util.Map;

/**
 * <p>
 * 银行信息表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-09-21
 */
public interface SysBankService extends IService<SysBank> {


     Page<SysBank> getBank(Map<String,Object> params);
}
