package com.zw.ft.sys;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

/**
 * @ClassName JuitTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/11/4 11:09
 * @Version 1.0
 **/
public class JuitTest {

    @Test
    public void getYesterday(){
        DateTime yesterday = DateUtil.yesterday();
        String s = yesterday.toString("yyyy-MM-dd");
        System.out.println("yesterday = " + s);
    }
}
