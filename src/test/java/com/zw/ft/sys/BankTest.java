package com.zw.ft.sys;

import com.zw.ft.modules.sys.repository.SysBankMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName BankTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/29 9:33
 * @Version 1.0
 **/
@SpringBootTest
public class BankTest {

    @Resource
    SysBankMapper sysBankMapper;

    @Test
    void querySysBankPageByComId(String comName){
    }
}
