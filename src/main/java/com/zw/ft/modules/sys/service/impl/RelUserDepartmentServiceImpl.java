package com.zw.ft.modules.sys.service.impl;

import com.zw.ft.modules.sys.entity.RelUserDepartment;
import com.zw.ft.modules.sys.repository.RelUserDepartmentMapper;
import com.zw.ft.modules.sys.service.RelUserDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员部门关系表  服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2020-11-03
 */
@Service("relUserDepartmentService")
public class RelUserDepartmentServiceImpl extends ServiceImpl<RelUserDepartmentMapper, RelUserDepartment> implements RelUserDepartmentService {

}
