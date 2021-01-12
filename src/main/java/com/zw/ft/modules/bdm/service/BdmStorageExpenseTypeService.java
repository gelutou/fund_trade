package com.zw.ft.modules.bdm.service;

import com.zw.ft.modules.bdm.entity.BdmStorageExpenseType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 仓储费用类型表 服务类
 * </p>
 *
 * @author Savior
 * @since 2020-12-29
 */
public interface BdmStorageExpenseTypeService extends IService<BdmStorageExpenseType> {

     BdmStorageExpenseType getStorageTypeId(long id);
}
