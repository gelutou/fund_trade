package com.zw.ft.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.zw.ft.modules.sys.repository.SysNeedsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

/**
 * @ClassName NeedsTest
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/30 14:50
 * @Version 1.0
 **/
@SpringBootTest
public class NeedsTest {

    @Resource
    SysNeedsMapper sysNeedsMapper;

    @Test
    public void getNeedsPage(){
        Page<SysNeeds> objectPage = new Page<>();
        objectPage.setSize(1);
        Page<SysNeeds> sysNeedsPage = sysNeedsMapper.queryNeedsPage(objectPage, new QueryWrapper<>());
        R page = R.page(sysNeedsPage);
        System.out.println("page = " + page);
    }
}
