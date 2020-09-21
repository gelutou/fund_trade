package com.zw.ft.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysPermissionEntity;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.repository.SysPermissionMapper;
import com.zw.ft.modules.sys.repository.SysRoleMapper;
import com.zw.ft.modules.sys.repository.SysUserMapper;
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
    SysUserMapper sysUserMapper;
    @Resource
    SysRoleMapper sysRoleMapper;
    @Resource
    SysPermissionMapper sysPermissionMapper;
    @Test
    void selectOne(){
        System.out.println("sysUserRepository.selectById(1L) = " + sysUserMapper.selectById(1L));
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
        List<SysUserEntity> mainUserListByWrapper = sysUserMapper.getUserAllMessage(entityQueryWrapper);
        mainUserListByWrapper.forEach(System.out::println);
    }
    @Test
    public void selectUserPage(){
        Page<SysUserEntity> usersPage = new Page<>();
        QueryWrapper<SysUserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username","admin");
        Page<SysUserEntity> sysUserEntityPage = sysUserMapper.queryUsersPageByComAndWrapper(usersPage, 1L, userEntityQueryWrapper);
        System.out.println("R.page(sysUserEntityPage) = " + R.page(sysUserEntityPage));
    }

    @Test
    void getRootMenu(){
        List<SysPermissionEntity> rootMenu = sysPermissionMapper.getRootMenu(1L);
        rootMenu.forEach(System.out::println);
    }

    @Test
    void getChildMenu(){
        List<SysPermissionEntity> rootMenu = sysPermissionMapper.getChildMenu(1L,1L);
        rootMenu.forEach(System.out::println);
    }
    @Test
    void getUserPerms(){
        List<String> userPerms = sysUserMapper.getUserPerms(1L);
        userPerms.forEach(System.out::println);
    }
}
