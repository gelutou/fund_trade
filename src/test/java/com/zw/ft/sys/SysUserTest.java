package com.zw.ft.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.repository.SysRoleRepository;
import com.zw.ft.modules.sys.repository.SysUserRepository;
import com.zw.ft.modules.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysUserTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/9/15 18:16
 * @Version 1.0
 **/
@SpringBootTest
public class SysUserTest {

    @Resource
    SysUserService sysUserService;
    @Resource
    SysUserRepository sysUserRepository;
    @Resource
    SysRoleRepository sysRoleRepository;
    @Test
    void selectOne(){
        System.out.println("sysUserRepository.selectById(1L) = " + sysUserRepository.selectById(1L));
    }
    @Test
    void insertUser(){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("cehis");
        sysUserEntity.setPassword("111");
        sysUserEntity.setCreatedBy(1L);
        sysUserEntity.setUpdatedBy(1L);
        sysUserService.save(sysUserEntity);
    }
    @Test
    void selectOneAll(){
        QueryWrapper<SysUserEntity> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.eq("username","admin");
        List<SysUserEntity> mainUserListByWrapper = sysUserRepository.getUserAllMessage(entityQueryWrapper);
        mainUserListByWrapper.forEach(System.out::println);
    }

}
