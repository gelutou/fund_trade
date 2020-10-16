package com.zw.ft.sys;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
    public void encrypt(){
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String plaintext = new Sha256Hash("admin", salt).toHex().substring(0,8);
        System.out.println("plaintext = " + plaintext);
        String s = new Sha256Hash(plaintext, salt).toHex();
        System.out.println("s = " + s);
    }

    @Test
    public void splitTest(){
        String dis = "1,2";
        List<String> lists = new LinkedList<>();
        if(dis.contains(",")){
            String[] split = dis.split(",");
            Collections.addAll(lists, split);
        }else {
            lists.add(dis);
        }
        System.out.println("lists = " + lists);
    }
}
