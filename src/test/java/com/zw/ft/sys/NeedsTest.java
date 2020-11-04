package com.zw.ft.sys;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.zw.ft.modules.sys.entity.SysReply;
import com.zw.ft.modules.sys.repository.SysNeedsMapper;
import com.zw.ft.modules.sys.repository.SysReplyMapper;
import com.zw.ft.modules.sys.service.SysReplyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    SysReplyMapper sysReplyMapper;
    @Resource
    SysReplyService replyService;

    @Test
    public void getNeedsPage(){
        Page<SysNeeds> objectPage = new Page<>();
        objectPage.setSize(1);
        Page<SysNeeds> sysNeedsPage = sysNeedsMapper.queryNeedsPage(objectPage, new QueryWrapper<>());
        R page = R.page(sysNeedsPage);
        System.out.println("page = " + page);
    }


    @Test
    public void addReply(){
        LocalDateTime now = LocalDateTimeUtil.now();
        System.out.println("now = " + now);
    }
}
