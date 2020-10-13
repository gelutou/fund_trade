package com.zw.ft.sys;

import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.TimeZone;

/**
 * @ClassName SysCompanyTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/9/21 10:57
 * @Version 1.0
 **/
@SpringBootTest
public class SysCompanyTradeTest {

    @Resource
    SysCompanyMapper sysCompanyMapper;
    @Test
    public void getFuzzy(){
        List<SysCompany> fuzzy = sysCompanyMapper.getFuzzy("admin", "sh");
        fuzzy.forEach(System.out::println);
    }

    @Test
    public void getCity(){
        // 获取当前服务器TimeZone
        String timeZoneId = TimeZone.getDefault().getID();
        // 抓取城市名称
        String[] arr = timeZoneId.split("/");
        String city = arr.length > 1 ? arr[1] : timeZoneId;
        System.out.println("city = " + city);
    }
}
