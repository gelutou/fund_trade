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

    /**
     * 功能描述 : 将字典表格式化为选择框数据
     * @author Oliver 2021-1-27 16:24
     */
    @RequestMapping(value = "/query")
    public R query(){
        List<SysDictionary> fatherList = sysDictionaryService.list(null);
        JSONObject keyObj = new JSONObject(true);
        JSONArray array = new JSONArray();

        for(SysDictionary dictionary : fatherList){
            if (dictionary.getPId() == null) {
                JSONObject dicObj = new JSONObject(2);
                dicObj.put("des",dictionary.getDes());
                String name = dictionary.getName();
                dicObj.put("name",name);
                array.add(dicObj);
            }
        }
        keyObj.put("key",array);
        //设置实际值和描述
        for (int i=0;i<array.size();i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            String name = jsonObject.getString("name");
            JSONArray childArray = new JSONArray();
            for(SysDictionary dic : fatherList){
                String name1 = dic.getName();
                Long pId = dic.getPId();
                if(name.equals(name1) && pId != null){
                    JSONObject obj = new JSONObject(2);
                    obj.put("des",dic.getDes());
                    obj.put("value",dic.getValue());
                    childArray.add(obj);
                }
            }
            keyObj.put(name,childArray);
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
