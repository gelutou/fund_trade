package com.zw.ft.sys;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName EncryptTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/9/19 23:09
 * @Version 1.0
 **/
@SpringBootTest
public class EncryptTest {

    @Test
    public void passwordEncrypt(){
        String hashAlgorithName = "MD5";
        String password = "1";
        int hashIterations = 1024;//加密次数
        Object obj = new SimpleHash(hashAlgorithName, password,null, hashIterations);
        System.out.println(obj);
    }
}
