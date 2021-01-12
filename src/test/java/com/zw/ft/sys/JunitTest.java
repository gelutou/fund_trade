package com.zw.ft.sys;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReUtil;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName JunitTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/11/4 11:09
 * @Version 1.0
 **/
public class JunitTest {

    @Test
    public void getYesterday(){

        /*Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher("aaa中aa文aaa");
        if (m.find()) {
            System.out.println("包含中文");
        } else {
            System.out.println("不包含");
        }*/

        String[] str = {};
        String[] convert = Convert.convert(String[].class, str);
        System.out.println("convert.length = " + convert.length);
        for(String strTemp : convert){
            System.out.println("strTemp = " + strTemp);
        }
    }
}
