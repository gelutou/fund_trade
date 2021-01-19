package com.zw.ft.sys;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zw.ft.modules.sys.entity.ModelConfiguration;
import com.zw.ft.modules.sys.entity.ProvinceCityTownInfo;
import com.zw.ft.modules.sys.service.ModelConfigurationService;
import com.zw.ft.modules.sys.service.ProvinceCityTownInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Oliver
 * @date 2021/1/19 9:18
 * @description
 */
@SpringBootTest
@Slf4j
public class SyncTest {

    @Resource
    ModelConfigurationService modelConfigurationService;
    @Resource
    ProvinceCityTownInfoService provinceCityTownInfoService;

    @Test
    void syncCity() {

    }
}
