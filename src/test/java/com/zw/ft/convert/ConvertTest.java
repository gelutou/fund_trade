package com.zw.ft.convert;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysBank;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.repository.SysBankMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    SysBankMapper sysBankMapper;

    @Test
    void Map2Bean(){
        Map<String,Object> map = new HashMap<>();
        map.put("comCode","111");

        SysCompany convert = Convert.convert(SysCompany.class, map);
        System.out.println("convert = " + convert);
    }

    @Test
    void bankbaseName(){
        String aa = "[1,2]";
        aa = aa.replace("[","").replace("]","");
        String[] convert1 = Convert.convert(String[].class, aa);
        QueryWrapper<SysBank> bankQueryWrapper = new QueryWrapper<>();
        bankQueryWrapper.in("scy.id", convert1);
        Page<SysBank> sysBankPage = sysBankMapper.querySysBankPageByWrapper(new Page<>(), bankQueryWrapper);
        List<SysBank> records = sysBankPage.getRecords();
        records.forEach(System.out::println);
    }
}
