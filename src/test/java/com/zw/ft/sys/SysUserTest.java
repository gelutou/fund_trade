package com.zw.ft.sys;

import com.zw.ft.modules.sys.repository.SysUserRepository;
import com.zw.ft.modules.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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
    @Test
    void selectOne(){
        System.out.println("sysUserRepository.selectById(1L) = " + sysUserRepository.selectById(1L));
    }
}
