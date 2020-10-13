package com.zw.ft.sys;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysPermission;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.zw.ft.modules.sys.repository.SysPermissionMapper;
import com.zw.ft.modules.sys.repository.SysRoleMapper;
import com.zw.ft.modules.sys.repository.SysUserMapper;
import com.zw.ft.modules.sys.service.SysUserService;
import com.zw.ft.modules.sys.service.SysUserTokenService;
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
    @Resource
    SysUserTokenService sysUserTokenService;
    @Test
    void selectOne(){
        System.out.println("sysUserRepository.selectById(1L) = " + sysUserMapper.selectById(1L));
    }
    @Test
    void insertUser(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("cehis");
        sysUser.setPassword("111");
        sysUser.setCreatedBy(1L);
        sysUser.setUpdatedBy(1L);
        sysUserService.save(sysUser);
    }
    @Test
    void selectOneAll(){
        QueryWrapper<SysUser> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.eq("username","admin");
        List<SysUser> mainUserListByWrapper = sysUserMapper.getUserAllMessage(entityQueryWrapper);
        mainUserListByWrapper.forEach(System.out::println);
    }
    @Test
    public void selectUserPage(){
        Page<SysUser> usersPage = new Page<>();
        QueryWrapper<SysUser> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username","admin");
        Page<SysUser> sysUserEntityPage = sysUserMapper.queryUsersPageByComAndWrapper(usersPage, 1L, userEntityQueryWrapper);
        System.out.println("R.page(sysUserEntityPage) = " + R.page(sysUserEntityPage));
    }

    @Test
    void getRootMenu(){
        List<SysPermission> rootMenu = sysPermissionMapper.getRootMenu(1L);
        rootMenu.forEach(System.out::println);
    }

    @Test
    void getChildMenu(){
        List<SysPermission> rootMenu = sysPermissionMapper.getChildMenu(1L,1L);
        rootMenu.forEach(System.out::println);
    }
    @Test
    void getUserPerms(){
        List<String> userPerms = sysUserMapper.getUserPerms(1L);
        userPerms.forEach(System.out::println);
    }

    @Test
    void getToken(){
        QueryWrapper<SysUser> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.eq("username","admin");
        SysUser one = sysUserService.getOne(entityQueryWrapper);

        String token = SecureUtil.md5(RandomUtil.randomString(16));
        //将token存进数据库
        QueryWrapper<SysUserToken> tokenQueryWrapper = new QueryWrapper<>();
        tokenQueryWrapper.eq("user_id",one.getId());
        SysUserToken userToken = sysUserTokenService.getOne(tokenQueryWrapper);
        if(userToken == null){
            userToken = new SysUserToken();
            userToken.setUserId(one.getId());
            userToken.setToken(token);
            sysUserTokenService.save(userToken);
        }else {
            SysUserToken userToken1 = new SysUserToken();
            userToken1.setId(userToken.getId());
            userToken1.setUserId(userToken.getUserId());
            userToken1.setToken(token);
            sysUserTokenService.updateById(userToken1);
        }
    }

    @Test
    void updateUserToken(){
        SysUserToken updateToke = new SysUserToken();
        updateToke.setId(1L);
        updateToke.setUserId(1L);
        updateToke.setToken("116296cba7e81d83accffaeeab3febcd");
        sysUserTokenService.updateById(updateToke);
    }

    @Test
    void getOneUserToken(){
        //将token存进数据库
        QueryWrapper<SysUserToken> tokenQueryWrapper = new QueryWrapper<>();
        tokenQueryWrapper.eq("user_id",1L);
        SysUserToken userToken = sysUserTokenService.getOne(tokenQueryWrapper);
        System.out.println("userToken = " + userToken);
    }
}
