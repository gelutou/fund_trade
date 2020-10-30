package com.zw.ft.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysCompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CompanyTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/30 10:39
 * @Version 1.0
 **/
@SpringBootTest
public class CompanyTest {

    @Resource
    SysCompanyMapper companyMapper;
    @Test
    public void companyT(){
        List<SysCompany> sysCompanies = companyMapper.selectList(new QueryWrapper<>());
        sysCompanies.forEach(System.out::println);
    }

}
