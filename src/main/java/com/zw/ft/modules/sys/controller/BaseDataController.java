package com.zw.ft.modules.sys.controller;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.constants.Constant;
import com.zw.ft.common.utils.FormatUtil;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.ProvinceCityTownInfo;
import com.zw.ft.modules.sys.entity.SysDictionary;
import com.zw.ft.modules.sys.service.ProvinceCityTownInfoService;
import com.zw.ft.modules.sys.service.SysDictionaryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseDataController
 * @Author Oliver
 * @Date 2020/12/23 15:17
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/ft/sys/base-data")
public class BaseDataController {

    @Resource
    SysDictionaryService sysDictionaryService;
    @Resource
    ProvinceCityTownInfoService provinceCityTownInfoService;

    @RequestMapping(value = "/query")
    public R query(){
        String[] keys = {"COMPANY_STATUS","ACCOUNT_NATURE","NEEDS_STATUS","RUN_RISE","CARGO_UNIT","CUSTOMER_TYPE","ACCOUNT_TYPE","ACCOUNT_AREA","CURRENCY_TYPE","BELONG_BANK","IS_VIRTUAL"};
        //查询所有父描述

        QueryWrapper<SysDictionary> fatherWrapper = new QueryWrapper<>();
        fatherWrapper.in("name",keys).and(i -> i.isNull("p_id").or().eq("p_id",""));
        List<SysDictionary> fatherList = sysDictionaryService.list(fatherWrapper);
        JSONObject keyObj = new JSONObject(true);
        JSONArray array = new JSONArray();
        for(SysDictionary dictionary : fatherList){
            JSONObject dicObj = new JSONObject(2);
            dicObj.put("des",dictionary.getDes());
            dicObj.put("name",dictionary.getName());
            array.add(dicObj);
        }
        keyObj.put("key",array);

        QueryWrapper<SysDictionary> childWrapper = new QueryWrapper<>();
        childWrapper.in("name",keys).and(i -> i.isNotNull("p_id").ne("p_id",""));

        List<SysDictionary> childList = sysDictionaryService.list(childWrapper);

        for(String str : keys){
            JSONArray childArray = new JSONArray();
            for(SysDictionary dictionary : childList){
                JSONObject dicObj = new JSONObject(2);
                dicObj.put("des",dictionary.getDes());
                dicObj.put("value",dictionary.getValue());
                childArray.add(dicObj);
            }
            keyObj.put(str,childArray);
        }

        return R.data(keyObj);
    }

    /**
     * 功能描述 : 获取省市区
     * @author Oliver 2021-1-18 15:38
     */
    @RequestMapping(value = "/queryCity")
    public R queryCity(@RequestBody(required = false) Map<String,Object> params){
        QueryWrapper<ProvinceCityTownInfo> provinceWrapper = new QueryWrapper<>();

        String dataId = FormatUtil.isSelectKey("dataId", params);
        if(Constant.TRUE.equals(dataId)){
            provinceWrapper.eq("data_id",params.get("dataId"));
        }

        String depth = FormatUtil.isSelectKey("depth", params);
        if(Constant.TRUE.equals(depth)){
            provinceWrapper.eq("depth",params.get("depth"));
        }

        String parentId = FormatUtil.isSelectKey("parentId", params);
        if(Constant.TRUE.equals(parentId)){
            provinceWrapper.eq("parent_id",params.get("parentId"));
        }
        return R.data(provinceCityTownInfoService.list(provinceWrapper));
    }
}
