package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysPermissionEntity;
import org.springframework.stereotype.Repository;

/**
 *@description: 权限信息
 *@author:  Oliver
 *@date  2020/9/10
 */
@Repository
public interface SysPermissionRepository extends BaseMapper<SysPermissionEntity> {
}
