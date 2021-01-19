package com.zw.ft.sys;
import com.zw.ft.modules.sys.service.ModelConfigurationService;
import com.zw.ft.modules.sys.service.ProvinceCityTownInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

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
