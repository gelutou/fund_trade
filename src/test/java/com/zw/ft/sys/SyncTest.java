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

        //查询目前城市表数据
        List<ProvinceCityTownInfo> oldProvince = provinceCityTownInfoService.list(new QueryWrapper<>());

        QueryWrapper<ModelConfiguration> modelConfigurationQueryWrapper = new QueryWrapper<>();
        modelConfigurationQueryWrapper.like("identification", "JS_API");
        List<ModelConfiguration> list = modelConfigurationService.list(modelConfigurationQueryWrapper);
        //appkey
        String JS_API_APP_KEY = null;
        //获取省数据接口地址
        String JS_API_GET_PROVINCE_INTERFACE_ADDRESS = null;
        //获取市数据接口地址
        String JS_API_GET_CITY_INTERFACE_ADDRESS = null;
        //获取区县数据接口地址
        String JS_API_GET_TOWN_INTERFACE_ADDRESS = null;
        //同步城市记录目前同步到的ID
        String JS_API_SYNC_CITY_ID_LOG = null;
        for (ModelConfiguration configuration : list) {
            String identification = configuration.getIdentification();
            if ("JS_API_APP_KEY".equals(identification)) {
                JS_API_APP_KEY = configuration.getContent();
            }
            if ("JS_API_GET_PROVINCE_INTERFACE_ADDRESS".equals(identification)) {
                JS_API_GET_PROVINCE_INTERFACE_ADDRESS = configuration.getContent();
            }
            if ("JS_API_GET_CITY_INTERFACE_ADDRESS".equals(identification)) {
                JS_API_GET_CITY_INTERFACE_ADDRESS = configuration.getContent();
            }
            if ("JS_API_GET_TOWN_INTERFACE_ADDRESS".equals(identification)) {
                JS_API_GET_TOWN_INTERFACE_ADDRESS = configuration.getContent();
            }
            if ("JS_API_SYNC_CITY_ID_LOG".equals(identification)) {
                JS_API_SYNC_CITY_ID_LOG = configuration.getContent();
            }
        }
        log.info(StrUtil.format("JS_API_APP_KEY : {},JS_API_GET_PROVINCE_INTERFACE_ADDRESS : {},JS_API_GET_CITY_INTERFACE_ADDRESS : {},JS_API_GET_TOWN_INTERFACE_ADDRESS : {}"
                , JS_API_APP_KEY, JS_API_GET_PROVINCE_INTERFACE_ADDRESS, JS_API_GET_CITY_INTERFACE_ADDRESS, JS_API_GET_TOWN_INTERFACE_ADDRESS));

        log.info("=====>开始同步省市数据... ");
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("appkey", JS_API_APP_KEY);
        List<ProvinceCityTownInfo> provinceCityTownInfosInsert = new ArrayList<>();
        List<ProvinceCityTownInfo> provinceCityTownInfosUpdate = new ArrayList<>();
        assert JS_API_GET_PROVINCE_INTERFACE_ADDRESS != null;

        String result = HttpUtil.get(JS_API_GET_PROVINCE_INTERFACE_ADDRESS, paramMap);
        JSONObject jsonObject = JSONObject.parseObject(result);
        log.info(jsonObject.toJSONString());
        JSONArray resultArray = jsonObject.getJSONArray("result");
        for (int i = 0; i < resultArray.size(); i++) {
            boolean insert = true;
            Long updateId = null;
            JSONObject province = resultArray.getJSONObject(i);
            ProvinceCityTownInfo provinceCityTownInfo = new ProvinceCityTownInfo();
            Long provinceId = province.getLong("id");
            String name = province.getString("name");

            //不同步国外城市
            if ("国外".equals(name)) {
                continue;
            }
            for (ProvinceCityTownInfo p : oldProvince) {
                Long dataId = p.getDataId();
                if (provinceId.equals(dataId)) {
                    insert = false;
                    //updateId = p.getId();
                    break;
                }
            }

            provinceCityTownInfo.setDataId(provinceId);
            provinceCityTownInfo.setName(province.getString("name"));
            provinceCityTownInfo.setParentId(province.getLong("parentid"));
            provinceCityTownInfo.setParentName(province.getString("parentname"));
            provinceCityTownInfo.setAreacode(province.getString("areacode"));
            provinceCityTownInfo.setZipcode(province.getString("zipcode"));
            provinceCityTownInfo.setDepth(province.getString("depth"));
            if (insert) {
                provinceCityTownInfosInsert.add(provinceCityTownInfo);
            } else {
                //provinceCityTownInfo.setId(updateId);
                provinceCityTownInfosUpdate.add(provinceCityTownInfo);
            }

            paramMap.put("parentid", provinceId);
            assert JS_API_GET_CITY_INTERFACE_ADDRESS != null;
            String cityResult = HttpUtil.get(JS_API_GET_CITY_INTERFACE_ADDRESS, paramMap);
            JSONObject cityObj = JSONObject.parseObject(cityResult);
            JSONArray cityArray = cityObj.getJSONArray("result");

            for (int j = 0; j < cityArray.size(); j++) {
                boolean cityInsert = true;
                Long cityUpdateId = null;
                JSONObject city = cityArray.getJSONObject(j);
                ProvinceCityTownInfo provinceCity = new ProvinceCityTownInfo();
                Long cityId = city.getLong("id");
                for (ProvinceCityTownInfo p : oldProvince) {
                    Long dataId = p.getDataId();
                    if (cityId.equals(dataId)) {
                        cityInsert = false;
                        //cityUpdateId = p.getId();
                        break;
                    }
                }

                provinceCity.setDataId(cityId);
                provinceCity.setName(city.getString("name"));
                provinceCity.setParentId(city.getLong("parentid"));
                provinceCity.setParentName(city.getString("parentname"));
                provinceCity.setAreacode(city.getString("areacode"));
                provinceCity.setZipcode(city.getString("zipcode"));
                provinceCity.setDepth(city.getString("depth"));
                if (cityInsert) {
                    provinceCityTownInfosInsert.add(provinceCity);
                } else {
                    //provinceCityTownInfo.setId(cityUpdateId);
                    provinceCityTownInfosUpdate.add(provinceCity);
                }
            }
        }
        provinceCityTownInfoService.saveBatch(provinceCityTownInfosInsert);
        provinceCityTownInfoService.updateBatchById(provinceCityTownInfosUpdate);
    }
    @Test
    void syncDis() {

        QueryWrapper<ModelConfiguration> modelConfigurationQueryWrapper = new QueryWrapper<>();
        modelConfigurationQueryWrapper.like("identification", "JS_API");
        List<ModelConfiguration> list = modelConfigurationService.list(modelConfigurationQueryWrapper);
        //appkey
        String JS_API_APP_KEY = null;
        //获取区县数据接口地址
        String JS_API_GET_TOWN_INTERFACE_ADDRESS = null;
        //同步城市记录目前同步到的ID
        String JS_API_SYNC_CITY_ID_LOG = null;
        for (ModelConfiguration configuration : list) {
            String identification = configuration.getIdentification();
            if ("JS_API_APP_KEY".equals(identification)) {
                JS_API_APP_KEY = configuration.getContent();
            }
            if ("JS_API_GET_TOWN_INTERFACE_ADDRESS".equals(identification)) {
                JS_API_GET_TOWN_INTERFACE_ADDRESS = configuration.getContent();
            }
            if ("JS_API_SYNC_CITY_ID_LOG".equals(identification)) {
                JS_API_SYNC_CITY_ID_LOG = configuration.getContent();
            }
        }
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("appkey", JS_API_APP_KEY);

        log.info("=====>开始同步区县数据... ");
        QueryWrapper<ProvinceCityTownInfo> provinceCityTownInfoQueryWrapper = new QueryWrapper<>();
        provinceCityTownInfoQueryWrapper.eq("depth", "2");
        provinceCityTownInfoQueryWrapper.orderByAsc("data_id");
        List<ProvinceCityTownInfo> list1 = provinceCityTownInfoService.list(provinceCityTownInfoQueryWrapper);

        QueryWrapper<ProvinceCityTownInfo> wrapper02 = new QueryWrapper<>();
        provinceCityTownInfoQueryWrapper.eq("depth", "3");
        provinceCityTownInfoQueryWrapper.orderByAsc("data_id");
        List<ProvinceCityTownInfo> townList = provinceCityTownInfoService.list(wrapper02);

        //获取上次同步位置 JS_API_SYNC_CITY_ID_LOG
        assert JS_API_SYNC_CITY_ID_LOG != null;
        for (ProvinceCityTownInfo p : list1) {

            Long dataId1 = p.getDataId();

            if (dataId1 < Long.parseLong(JS_API_SYNC_CITY_ID_LOG)) {
                continue;
            }


            paramMap.put("parentid", dataId1);
            assert JS_API_GET_TOWN_INTERFACE_ADDRESS != null;

            String townResult = HttpUtil.get(JS_API_GET_TOWN_INTERFACE_ADDRESS, paramMap);
            JSONObject townObj = JSONObject.parseObject(townResult);
            //判断免费次数是否用完
            String status = townObj.getString("status");
            List<String> errorCodes = new ArrayList<>();
            errorCodes.add("201");
            errorCodes.add("203");
            errorCodes.add("101");

            errorCodes.add("102");
            errorCodes.add("103");
            errorCodes.add("104");

            errorCodes.add("105");
            errorCodes.add("106");
            errorCodes.add("107");

            errorCodes.add("108");

            if (!"104".equals(status)) {
                if(!errorCodes.contains(status)){
                    JSONArray townArray = townObj.getJSONArray("result");
                    for (int i = 0; i < townArray.size(); i++) {
                        boolean insert = true;
                        Long updateId = null;
                        JSONObject province = townArray.getJSONObject(i);
                        ProvinceCityTownInfo provinceCityTownInfo = new ProvinceCityTownInfo();
                        Long provinceId = province.getLong("id");

                        for(ProvinceCityTownInfo town : townList){
                            Long dataId = town.getDataId();
                            if (provinceId.equals(dataId)) {
                                insert = false;
                                updateId = town.getDataId();
                                break;
                            }
                        }

                        provinceCityTownInfo.setDataId(provinceId);
                        provinceCityTownInfo.setName(province.getString("name"));
                        provinceCityTownInfo.setParentId(province.getLong("parentid"));
                        provinceCityTownInfo.setParentName(province.getString("parentname"));
                        provinceCityTownInfo.setAreacode(province.getString("areacode"));
                        provinceCityTownInfo.setZipcode(province.getString("zipcode"));
                        provinceCityTownInfo.setDepth(province.getString("depth"));
                        if (insert) {
                            provinceCityTownInfoService.save(provinceCityTownInfo);
                        } else {
                            UpdateWrapper<ProvinceCityTownInfo> provinceCityTownInfoUpdateWrapper = new UpdateWrapper<>();
                            provinceCityTownInfoUpdateWrapper.eq("data_id",updateId);
                            provinceCityTownInfoService.update(provinceCityTownInfo,provinceCityTownInfoUpdateWrapper);
                        }
                    }
                }
            } else {
                log.info(StrUtil.format("免费次数用完，更新到：{}",dataId1));
                UpdateWrapper<ModelConfiguration> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("identification", "JS_API_SYNC_CITY_ID_LOG");
                ModelConfiguration modelConfiguration = new ModelConfiguration();
                modelConfiguration.setContent(dataId1.toString());
                modelConfigurationService.update(modelConfiguration, updateWrapper);
                break;
            }
        }
        log.info("同步省市区数据结束 <===== ");
    }
}
