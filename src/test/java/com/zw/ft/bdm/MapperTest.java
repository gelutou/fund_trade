package com.zw.ft.bdm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.bdm.entity.BdmCustomer;
import com.zw.ft.modules.bdm.repository.BdmCustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName MapperTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/12/21 9:57
 * @Version 1.0
 **/
@SpringBootTest
public class MapperTest {

    @Resource
    BdmCustomerMapper bdmCustomerMapper;

    @Test
    void bdmTest(){
        bdmCustomerMapper.queryCustomerPage(new Page<>(),new QueryWrapper<BdmCustomer>());
    }

    @Test
    void ztTest() {
        String s = "12";//目标字符串
        String regex = "/\\S/";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if (m.matches()) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }
}