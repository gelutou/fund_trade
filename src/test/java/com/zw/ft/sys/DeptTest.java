package com.zw.ft.sys;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.repository.SysDepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName DeptTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/16 9:28
 * @Version 1.0
 **/
@SpringBootTest
public class DeptTest {

    @Resource
    SysDepartmentMapper departmentMapper;

    @Test
    void deptTest(){
        SysDepartment department = new SysDepartment();
        department.setDeptName("测试修改部门22");
        department.setId(1L);
        UpdateWrapper<SysDepartment> departmentUpdateWrapper = new UpdateWrapper<>();
        departmentUpdateWrapper.eq("old_pkid_willdel","000001");
        /*sysDepartmentUpdateWrapper.eq("old_pkid_willdel","000001");
        departmentMapper.update(department,sysDepartmentUpdateWrapper);*/
        int update = departmentMapper.update(department, departmentUpdateWrapper);
    }
}
