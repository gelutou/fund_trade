package com.zw.ft.convert;

import cn.hutool.core.convert.Convert;
import com.zw.ft.modules.sys.entity.SysCompany;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ConvertTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/9 9:41
 * @Version 1.0
 **/
@SpringBootTest
public class ConvertTest {

    @Test
    void Map2Bean(){
        Map<String,Object> map = new HashMap<>();
        map.put("comCode","111");

        SysCompany convert = Convert.convert(SysCompany.class, map);
        System.out.println("convert = " + convert);
    }
}
