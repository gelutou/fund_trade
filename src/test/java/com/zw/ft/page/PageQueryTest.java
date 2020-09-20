package com.zw.ft.page;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.repository.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName PageQueryTest
 * @Description PageQueryTest
 * @Author Oliver
 * @Date 2020/9/20 11:53
 * @Version 1.0
 **/
@SpringBootTest
public class PageQueryTest {

    @Resource
    SysUserMapper sysUserMapper;
    @Test
    public void selectPage(){
        Page<SysUserEntity> page = new Page<>();
        Page<SysUserEntity> page1 = sysUserMapper.selectPage(page, null);
        System.out.println("page1.getCountId() = " + page1.getCountId());
        System.out.println("page1.getCurrent() = " + page1.getCurrent());
        System.out.println("page1.getMaxLimit() = " + page1.getMaxLimit());
        System.out.println("page1.getOrders() = " + page1.getOrders());
        System.out.println("page1.getRecords() = " + page1.getRecords());
        System.out.println("page1.getSize() = " + page1.getSize());
        System.out.println("page1.getTotal() = " + page1.getTotal());
        System.out.println("page1.getPages() = " + page1.getPages());
        System.out.println("R.page(page1) = " + R.page(page1));
    }
}
