package com.zw.ft.sys;

import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysCompanyTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/9/21 10:57
 * @Version 1.0
 **/
@SpringBootTest
public class SysCompanyTest {

    @Resource
    SysCompanyMapper sysCompanyMapper;
    @Test
    public void getFuzzy(){
        List<SysCompany> fuzzy = sysCompanyMapper.getFuzzy("admin", "sh");
        fuzzy.forEach(System.out::println);
    }

}
